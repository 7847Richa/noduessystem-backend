package noduesmanagementsystem_noduesmanagementsystem.student;

import java.util.List;


public interface StudentService {
	

	 public static final StudentRepository studentRepository = null;
	    

	    public default List<Student> getAllStudents() {
	        return studentRepository.findAll();
	    }

	    public default Student getStudentById(Long registrationid) {
	        return studentRepository.findById(registrationid)
	                .orElseThrow();
	    }

	    public default Student createStudent(Student student) {
	        return studentRepository.save(student);
	    }

	    public default void deleteStudent(Long registrationid) {
	        studentRepository.deleteById(registrationid);
	    }

		Student saveStudent(Student student);

		List<Student> getALLStudent();

		Student getStudentById(long registrationid);

		Student updateStudent(Long registrationid, Student updatedStudent);

		
}