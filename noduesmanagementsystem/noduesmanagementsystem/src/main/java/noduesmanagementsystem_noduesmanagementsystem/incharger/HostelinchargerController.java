package noduesmanagementsystem_noduesmanagementsystem.incharger;

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
	@RequestMapping("/Hostelinchargers")
	public class HostelinchargerController{
		
	    private final HostelinchargerRepository hostelinchargerRepository;
		private Hostelincharger updatedHostelincharger;

	    @Autowired
	    public HostelinchargerController(HostelinchargerRepository hostelinchargerRepository) {
	        this.hostelinchargerRepository = hostelinchargerRepository;
	    }

	    @GetMapping
	    public ResponseEntity<List<Hostelincharger>> getAllHostelinchargers() {
	        List<Hostelincharger> hostelincharger = hostelinchargerRepository.findAll();
	        return new ResponseEntity<>(hostelincharger, HttpStatus.OK);
	    }

	    @PostMapping
	    public ResponseEntity<Hostelincharger> createHostelincharger(@RequestBody Hostelincharger hostelincharger) {
	    	Hostelincharger savedHostelincharger = hostelinchargerRepository.save(hostelincharger);
	        return new ResponseEntity<>(savedHostelincharger, HttpStatus.CREATED);
	    }

	    @PutMapping("/{registrationid}")
	    public ResponseEntity<Hostelincharger> updateHostelincharger(@PathVariable Long registrationid, @RequestBody Hostelincharger updateHostelincharger) {
	        Optional<Hostelincharger> optionalHostelincharger = hostelinchargerRepository.findById(registrationid);
	        if (optionalHostelincharger.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        Hostelincharger existingHostelincharger = optionalHostelincharger.get();
	        existingHostelincharger.setFirstName(updatedHostelincharger.getFirstName());
	        existingHostelincharger.setLastName(updatedHostelincharger.getLastName());
	        existingHostelincharger.setRegestrationid(updatedHostelincharger.getRegistrationid());
	        existingHostelincharger.setEmail(updatedHostelincharger.getEmail());
	        existingHostelincharger.setPassword(updatedHostelincharger.getPassword());
	        Hostelincharger updatedHostelinchargerEntity = hostelinchargerRepository.save(existingHostelincharger);
	        return new ResponseEntity<>(updatedHostelinchargerEntity, HttpStatus.OK);
	    }

	    @DeleteMapping("/{registrationid}")
	    public ResponseEntity<Void> deleteHostelincharger(@PathVariable Long registrationid) {
	        Optional<Hostelincharger> optionalHostelincharger = hostelinchargerRepository.findById(registrationid);
	        if (optionalHostelincharger.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        hostelinchargerRepository.deleteById(registrationid);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
	        
	        
	    }





