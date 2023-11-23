package noduesmanagementsystem_noduesmanagementsystem.faculty;

import java.util.List;



public interface FacultyService {
	
	public static final FacultyRepository facultyRepository = null;
    

    public default List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public default Faculty getFacultyById(Long registrationid) {
        return facultyRepository.findById(registrationid)
                .orElseThrow();
    }

    public default Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public default void deleteFaculty(Long registrationid) {
    	facultyRepository.deleteById(registrationid);
    }

    Faculty save(Faculty faculty);

	Faculty saveFaculty(Faculty faculty);

	List<Faculty> getALLFaculty();

	Faculty getFacultyById(long registrationid);

	Faculty updateFaculty(Long registrationid, Faculty updatedFaculty);

	
	
	
	

}
