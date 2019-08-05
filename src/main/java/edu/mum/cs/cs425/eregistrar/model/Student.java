package edu.mum.cs.cs425.eregistrar.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

/**
 * The type Student.
 * @author nduwayofabrice
 */
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "student_number", nullable = false, unique = true)
    private String studentNumber;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "cgpa")
    private Double cgpa;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "enrollment_date", nullable = false)
    private LocalDate enrollmentDate;

    @Column(name = "is_international", nullable = false)
    private Boolean isInternational = Boolean.FALSE;

    /**
     * Gets student id.
     *
     * @return the student id
     */
    public Long getStudentId() {
        return studentId;
    }

    /**
     * Sets student id.
     *
     * @param studentId the student id
     */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    /**
     * Gets student number.searchParamObj
     *
     * @return the student number
     */
    public String getStudentNumber() {
        return studentNumber;
    }

    /**
     * Sets student number.
     *
     * @param studentNumber the student number
     */
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets middle name.
     *
     * @return the middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets middle name.
     *
     * @param middleName the middle name
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets cgpa.
     *
     * @return the cgpa
     */
    public Double getCgpa() {
        return cgpa;
    }

    /**
     * Sets cgpa.
     *
     * @param cgpa the cgpa
     */
    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    /**
     * Gets enrollment date.
     *
     * @return the enrollment date
     */
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    /**
     * Sets enrollment date.
     *
     * @param enrollmentDate the enrollment date
     */
    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    /**
     * Gets international.
     *
     * @return the international
     */
    public Boolean getInternational() {
        return isInternational;
    }

    /**
     * Sets international.
     *
     * @param international the international
     */
    public void setInternational(Boolean international) {
        isInternational = international;
    }
}
