package edu.mum.cs.cs425.eregistrar.service;

import edu.mum.cs.cs425.eregistrar.model.Student;

/**
 * The interface Student service.
 * @author nduwayofabrice
 */
public interface IStudentService {
    /**
     * Create student.
     *
     * @param student the student
     */
    void createStudent(Student student);

    /**
     * Update student.
     *
     * @param student the student
     */
    void updateStudent(Student student);

    /**
     * Delete student.
     *
     * @param studentId the student id
     */
    void deleteStudent(Long studentId);
}
