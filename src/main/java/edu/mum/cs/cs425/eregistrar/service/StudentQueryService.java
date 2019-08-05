package edu.mum.cs.cs425.eregistrar.service;

import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * The type Student query service.
 * @author nduwayofabrice
 */
@Service
public class StudentQueryService implements IStudentQueryService{

    private IStudentRepository studentRepository;

    /**
     * Instantiates a new Student query service.
     *
     * @param studentRepository the student repository
     */
    @Autowired
    public StudentQueryService(IStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findStudentById(Long studentId) {
        return this.studentRepository.getOne(studentId);
    }

    @Override
    public Page<Student> findAllStudentsPaged(int page) {
        return this.studentRepository.findAll(PageRequest.of(page, 5, Sort.by("firstName")));
    }

    @Override
    public Page<Student> findStudentsByTitle(int page, String searchParam) {
        return this.studentRepository.findStudentsByFirstNameContainsOrLastNameContains(
                PageRequest.of(page, 5, Sort.by("firstName")), searchParam, searchParam);
    }
}

