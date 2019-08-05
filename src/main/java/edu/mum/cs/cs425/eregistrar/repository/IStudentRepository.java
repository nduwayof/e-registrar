package edu.mum.cs.cs425.eregistrar.repository;

import edu.mum.cs.cs425.eregistrar.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Student repository.
 * @author nduwayofabrice
 */
@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    /**
     * Find students by first name contains or last name contains page.
     *
     * @param pageable       the pageable
     * @param searchParam    the search param
     * @param searchParamObj the search param obj
     *
     * @return the page
     */
    Page<Student> findStudentsByFirstNameContainsOrLastNameContains(Pageable pageable, String searchParam, String searchParamObj);
}
