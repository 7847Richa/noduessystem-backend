package noduesmanagementsystem_noduesmanagementsystem.librarian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

	
	@Service
	public class LibrarianServiceImpl implements LibrarianService {
	    private LibrarianRepository librarianRepository;
		

	    @Autowired
	    public LibrarianServiceImpl(LibrarianRepository librarianRepository) {
	        this.librarianRepository = librarianRepository;
	    }

	    @Override
	    public Librarian saveLibrarian(Librarian librarian) {
	        return librarianRepository.save(librarian);
	    }

	    @Override
	    public List<Librarian> getALLLibrarian() {
	        return librarianRepository.findAll();
	    }

	    @Override
	    public  Librarian getLibrarianById(long registrationid) {
	        return librarianRepository.findById(registrationid).orElseThrow(()-> new ResourceNotFoundException("Librarian not found with registrationid",registrationid," "));
	    }

		@Override
		public Librarian updateLibrarian(Long registrationid,Librarian updatedLibrarian) {
			// TODO Auto-generated method stub
			return null;
			
		
		
		}

		@Override
		public Librarian save(Librarian librarian) {
			// TODO Auto-generated method stub
			return null;
		}
	}

