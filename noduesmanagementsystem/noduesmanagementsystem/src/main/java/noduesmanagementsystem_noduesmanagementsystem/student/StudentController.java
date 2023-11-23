package noduesmanagementsystem_noduesmanagementsystem.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3030")
@RestController
@RequestMapping("/students")
public class StudentController {
	
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @PutMapping("/{registrationid}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long registrationid, @RequestBody Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(registrationid);
        if (optionalStudent.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Student existingStudent = optionalStudent.get();
        existingStudent.setFirstName(updatedStudent.getFirstName());
        existingStudent.setLastName(updatedStudent.getLastName());
        existingStudent.setRegestrationid(updatedStudent.getRegistrationid());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setPassword(updatedStudent.getPassword());
        Student updatedStudentEntity = studentRepository.save(existingStudent);
        return new ResponseEntity<>(updatedStudentEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{registrationid}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long registrationid) {
        Optional<Student> optionalStudent = studentRepository.findById(registrationid);
        if (optionalStudent.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentRepository.deleteById(registrationid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
        
        
    }


