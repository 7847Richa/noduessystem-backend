package noduesmanagementsystem_noduesmanagementsystem.faculty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService {
    private FacultyRepository facultyRepository;
	

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty saveFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public List<Faculty> getALLFaculty() {
        return facultyRepository.findAll();
    }

    @Override
    public  Faculty getFacultyById(long registrationid) {
        return facultyRepository.findById(registrationid).orElseThrow(()-> new ResourceNotFoundException("faculty not found with registrationid",registrationid," "));
    }

	@Override
	public Faculty updateFaculty(Long registrationid, Faculty updatedFaculty) {
		// TODO Auto-generated method stub
		return null;
		
	
	
	}

	@Override
	public Faculty save(Faculty faculty) {
		// TODO Auto-generated method stub
		return null;
	}
}

	




