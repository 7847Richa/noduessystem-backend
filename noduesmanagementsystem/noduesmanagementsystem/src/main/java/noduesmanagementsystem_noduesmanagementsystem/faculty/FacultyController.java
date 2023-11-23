package noduesmanagementsystem_noduesmanagementsystem.faculty;

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
@RequestMapping("/Faculties")
public class FacultyController {
	

	
    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyController(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @GetMapping
    public ResponseEntity<List<Faculty>> getAllFaculties() {
        List<Faculty> Faculties = facultyRepository.findAll();
        return new ResponseEntity<>(Faculties, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
    	Faculty savedFaculty = facultyRepository.save(faculty);
        return new ResponseEntity<>(savedFaculty, HttpStatus.CREATED);
    }

    @PutMapping("/{registrationid}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable Long registrationid, @RequestBody Faculty updatedFaculty) {
        Optional<Faculty> optionalFaculty = facultyRepository.findById(registrationid);
        if (optionalFaculty.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Faculty existingFaculty = optionalFaculty.get();
        existingFaculty.setFirstName(updatedFaculty.getFirstName());
        existingFaculty.setLastName(updatedFaculty.getLastName());
        existingFaculty.setRegestrationid(updatedFaculty.getRegistrationid());
        existingFaculty.setEmail(updatedFaculty.getEmail());
        existingFaculty.setPassword(updatedFaculty.getPassword());
        Faculty updatedFacultyEntity = facultyRepository.save(existingFaculty);
        return new ResponseEntity<>(updatedFacultyEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{registrationid}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long registrationid) {
        Optional<Faculty> optionalFaculty = facultyRepository.findById(registrationid);
        if (optionalFaculty.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        facultyRepository.deleteById(registrationid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
        
        
    }





