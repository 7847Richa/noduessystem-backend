package noduesmanagementsystem_noduesmanagementsystem.librarian;

	
	import java.util.List;

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

	import java.util.Optional;

	@RestController
	@RequestMapping("/librarians")
	public class LibrarianController {
		
	    private final LibrarianRepository librarianRepository;
		private Optional<Librarian> optional;

	    @Autowired
	    public LibrarianController(LibrarianRepository librarianRepository) {
	        this.librarianRepository = librarianRepository;
	    }

	    @GetMapping
	    public ResponseEntity<List<Librarian>> getAllLibrarians() {
	        List<Librarian> librarians = librarianRepository.findAll();
	        return new ResponseEntity<>(librarians, HttpStatus.OK);
	    }

	    @PostMapping
	    public ResponseEntity<Librarian> createLibrarian(@RequestBody Librarian librarian) {
	    	Librarian savedLibrarian = librarianRepository.save(librarian);
	        return new ResponseEntity<>(savedLibrarian, HttpStatus.CREATED);
	    }

	    @PutMapping("/{registrationid}")
	    public ResponseEntity<Librarian> updateStudent(@PathVariable Long registrationid, @RequestBody Librarian updatedLibrarian) {
	        Optional<Librarian> optionalLibrarian = librarianRepository.findById(registrationid);
	        if (optionalLibrarian.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        Librarian existingLibrarian = optional.get();
	        existingLibrarian.setFirstName(updatedLibrarian.getFirstName());
	        existingLibrarian.setLastName(updatedLibrarian.getLastName());
	        existingLibrarian.setRegestrationid(updatedLibrarian.getRegistrationid());
	        existingLibrarian.setEmail(updatedLibrarian.getEmail());
	        existingLibrarian.setPassword(updatedLibrarian.getPassword());
	        Librarian updatedLibrarianEntity = librarianRepository.save(existingLibrarian);
	        return new ResponseEntity<>(updatedLibrarianEntity, HttpStatus.OK);
	    }

	    @DeleteMapping("/{registrationid}")
	    public ResponseEntity<Void> deleteLibrarian(@PathVariable Long registrationid) {
	        Optional<Librarian> optionalLibrarian = librarianRepository.findById(registrationid);
	        if (optionalLibrarian.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        librarianRepository.deleteById(registrationid);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);}

}
