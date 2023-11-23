package noduesmanagementsystem_noduesmanagementsystem.librarian;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;




public interface LibrarianService {
	
	public static final JpaRepository<Librarian, Long> librarianRepository = null;
	    

	    public default List<Librarian> getAllLibrarians() {
	        return librarianRepository.findAll();
	    }

	    public default Librarian getStudentById(Long registrationid) {
	        return librarianRepository.findById(registrationid)
	                .orElseThrow();
	    }

	    public default Librarian createLibrarian(Librarian librarian) {
	        return librarianRepository.save(librarian);
	    }

	    public default void deleteLibrarian(Long registrationid) {
	        librarianRepository.deleteById(registrationid);
	    }

		Librarian saveLibrarian(Librarian librarian);

		List<Librarian> getALLLibrarian();

		Librarian getLibrarianById(long registrationid);

		Librarian updateLibrarian(Long registrationid, Librarian updatedLibrarian);

		Librarian save(Librarian librarian);}
