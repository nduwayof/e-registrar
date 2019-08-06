package edu.mum.cs.cs425.eregistrar.controller;

import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.service.IStudentQueryService;
import edu.mum.cs.cs425.eregistrar.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * The type Student controller.
 * @author nduwayofabrice
 */
@Controller
public class StudentController {

    private static final String STUDENTS = "redirect:/students";

    private IStudentService studentService;
    private IStudentQueryService studentQueryService;

    /**
     * Instantiates a new Student controller.
     *
     * @param studentService      the student service
     * @param studentQueryService the student query service
     */
    @Autowired
    public StudentController(IStudentService studentService, IStudentQueryService studentQueryService) {
        this.studentService = studentService;
        this.studentQueryService = studentQueryService;
    }

    /**
     * View students model and view.
     *
     * @param pageNumber the page number
     *
     * @return the model and view
     */
    @GetMapping(value = {"/students"})
    public ModelAndView viewStudents(@RequestParam(defaultValue = "0") int pageNumber) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentQueryService.findAllStudentsPaged(pageNumber));
        modelAndView.addObject("currentPageNo", pageNumber);
        modelAndView.setViewName("student/students");
        return modelAndView;
    }

    /**
     * Show student form string.
     *
     * @param model the model
     *
     * @return the string
     */
    @GetMapping(value = {"/student/new"})
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/new-student";
    }

    /**
     * Create new student string.
     *
     * @param student       the student
     * @param bindingResult the binding result
     * @param model         the model
     *
     * @return the string
     */
    @PostMapping(value = {"/student/new"})
    public String createNewStudent(@Valid @ModelAttribute("student") Student student,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/new-student";
        }
        studentService.createStudent(student);
        return STUDENTS;
    }

    /**
     * Edit student string.
     *
     * @param studentId the student id
     * @param model     the model
     *
     * @return the string
     */
    @GetMapping(value = {"/student/edit/{studentId}"})
    public String editStudent(@PathVariable Long studentId, Model model) {
        Student student = studentQueryService.findStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit-student";
        }
        return "student/students";
    }

    /**
     * Update student string.
     *
     * @param student       the student
     * @param bindingResult the binding result
     * @param model         the model
     *
     * @return the string
     */
    @PostMapping(value = {"/student/edit"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit-student";
        }
        studentService.updateStudent(student);
        return STUDENTS;
    }

    /**
     * Delete student string.
     *
     * @param studentId the student id
     *
     * @return the string
     */
    @GetMapping(value = {"/student/delete/{studentId}"})
    public String deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return STUDENTS;
    }

    /**
     * Search students model and view.
     *
     * @param pageNumber the page number
     * @param student    the student
     *
     * @return the model and view
     */
    @PostMapping(value = {"/students"})
    public ModelAndView searchStudents(@RequestParam(defaultValue = "0") int pageNumber,
                              @ModelAttribute("student") Student student){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentQueryService.findStudentsByTitle(pageNumber,
                student.getFirstName()));
        modelAndView.addObject("currentPageNo", pageNumber);
        modelAndView.setViewName("/students");
        return modelAndView;
    }

}
