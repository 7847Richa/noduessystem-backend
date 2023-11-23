package noduesmanagementsystem_noduesmanagementsystem.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
	

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getALLStudent() {
        return studentRepository.findAll();
    }

    @Override
    public  Student getStudentById(long registrationid) {
        return studentRepository.findById(registrationid).orElseThrow(()-> new ResourceNotFoundException("student not found with registrationid",registrationid," "));
    }

	@Override
	public Student updateStudent(Long registrationid, Student updatedStudent) {

		return null;
		
	
	
	}

	
	
	
}


