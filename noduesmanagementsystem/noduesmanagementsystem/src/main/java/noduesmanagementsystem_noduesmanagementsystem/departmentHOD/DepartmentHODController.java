package noduesmanagementsystem_noduesmanagementsystem.departmentHOD;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/DepartmentHODs")
public class DepartmentHODController {
	

	
    private final DepartmentHODRepository departmentHODRepository;

    @Autowired
    public DepartmentHODController(DepartmentHODRepository departmentHODRepository) {
        this.departmentHODRepository = departmentHODRepository;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentHOD>> getAllDepartmentHODs() {
        List<DepartmentHOD> DepartmentHODs = departmentHODRepository.findAll();
        return new ResponseEntity<>(DepartmentHODs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DepartmentHOD> createDepartmentHOD(@RequestBody DepartmentHOD departmentHOD) {
    	DepartmentHOD savedDepartmentHOD = departmentHODRepository.save(departmentHOD);
        return new ResponseEntity<>(savedDepartmentHOD, HttpStatus.CREATED);
    }

    @PutMapping("/{registrationid}")
    public ResponseEntity<DepartmentHOD> updateDepartmentHOD(@PathVariable Long registrationid, @RequestBody DepartmentHOD updatedDepartmentHOD) {
        Optional<DepartmentHOD> optionalDepartmentHOD = departmentHODRepository.findById(registrationid);
        if (optionalDepartmentHOD.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        DepartmentHOD existingDepartmentHOD = optionalDepartmentHOD.get();
        existingDepartmentHOD.setFirstName(updatedDepartmentHOD.getFirstName());
        existingDepartmentHOD.setLastName(updatedDepartmentHOD.getLastName());
        existingDepartmentHOD.setRegestrationid(updatedDepartmentHOD.getRegistrationid());
        existingDepartmentHOD.setEmail(updatedDepartmentHOD.getEmail());
        existingDepartmentHOD.setPassword(updatedDepartmentHOD.getPassword());
        DepartmentHOD updatedDepartmentHODEntity = departmentHODRepository.save(existingDepartmentHOD);
        return new ResponseEntity<>(updatedDepartmentHODEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{registrationid}")
    public ResponseEntity<Void> deleteDepartmentHOD(@PathVariable Long registrationid) {
        Optional<DepartmentHOD> optionalDepartmentHOD = departmentHODRepository.findById(registrationid);
        if (optionalDepartmentHOD.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        departmentHODRepository.deleteById(registrationid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
        
        
    }





