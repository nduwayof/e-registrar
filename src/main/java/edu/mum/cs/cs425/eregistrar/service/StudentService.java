package edu.mum.cs.cs425.eregistrar.service;

import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Student service.
 * @author nduwayofabrice
 */
@Service
public class StudentService implements IStudentService {

    private IStudentRepository studentRepository;

    /**
     * Instantiates a new Student service.
     *
     * @param studentRepository the student repository
     */
    @Autowired
    public StudentService(IStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        this.studentRepository.deleteById(studentId);
    }

}
