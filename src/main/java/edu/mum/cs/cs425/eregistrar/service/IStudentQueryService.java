package edu.mum.cs.cs425.eregistrar.service;

import edu.mum.cs.cs425.eregistrar.model.Student;
import org.springframework.data.domain.Page;

/**
 * The interface Student query service.
 * @author nduwayofabrice
 */
public interface IStudentQueryService {
    /**
     * Find student by id student.
     *
     * @param studentId the student id
     *
     * @return the student
     */
    Student findStudentById(Long studentId);

    /**
     * Find all students paged page.
     *
     * @param page the page
     *
     * @return the page
     */
    Page<Student> findAllStudentsPaged(int page);

    /**
     * Find students by title page.
     *
     * @param page        the page
     * @param searchParam the search param
     *
     * @return the page
     */
    Page<Student> findStudentsByTitle(int page, String searchParam);
}
