package noduesmanagementsystem_noduesmanagementsystem.accountsectionstaff;

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
@RequestMapping("/accountsectionstaffs")
public class AccountsectionstaffController {
	
		
		
	    private final AccountsectionstaffRepository accountsectionstaffRepository;

	    public AccountsectionstaffController(AccountsectionstaffRepository accountsectionstaffRepository) {
	        this.accountsectionstaffRepository = accountsectionstaffRepository;
	    }

	    @GetMapping
	    public ResponseEntity<List<Accountsectionstaff>> getAllAccountsrectionstaffs() {
	        List<Accountsectionstaff> accountsectionstaffs = accountsectionstaffRepository.findAll();
	        return new ResponseEntity<>(accountsectionstaffs, HttpStatus.OK);
	    }

	    @PostMapping
	    public ResponseEntity<Accountsectionstaff> createAccountsectionstaff(@RequestBody Accountsectionstaff accountsectionstaff) {
	    	Accountsectionstaff savedAccountsectionstaff = accountsectionstaffRepository.save(accountsectionstaff);
	        return new ResponseEntity<>(savedAccountsectionstaff, HttpStatus.CREATED);
	    }

	    @PutMapping("/{registrationid}")
	    public ResponseEntity<Accountsectionstaff> updateAccountsectionstaff(@PathVariable Long registrationid, @RequestBody Accountsectionstaff updatedAccountsectionstaff) {
	        Optional<Accountsectionstaff> optionalAccountsectionstaff = accountsectionstaffRepository.findById(registrationid);
	        if (optionalAccountsectionstaff.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        Accountsectionstaff existingAccountsectionstaff = optionalAccountsectionstaff.get();
	        existingAccountsectionstaff.setFirstName(updatedAccountsectionstaff.getFirstName());
	        existingAccountsectionstaff.setLastName(updatedAccountsectionstaff.getLastName());
	        existingAccountsectionstaff.setRegestrationid(updatedAccountsectionstaff.getRegistrationid());
	        existingAccountsectionstaff.setEmail(updatedAccountsectionstaff.getEmail());
	        existingAccountsectionstaff.setPassword(updatedAccountsectionstaff.getPassword());
	        Accountsectionstaff updatedAccountsectionstaffEntity = accountsectionstaffRepository.save(existingAccountsectionstaff);
	        return new ResponseEntity<>(updatedAccountsectionstaffEntity, HttpStatus.OK);
	    }

	    @DeleteMapping("/{registrationid}")
	    public ResponseEntity<Void> deleteAccountsectionstaff(@PathVariable Long registrationid) {
	        Optional<Accountsectionstaff> optionalAccountsectionstaff = accountsectionstaffRepository.findById(registrationid);
	        if (optionalAccountsectionstaff.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        accountsectionstaffRepository.deleteById(registrationid);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
	        
	        
	    }
