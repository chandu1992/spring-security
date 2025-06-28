package com.jarvis.security.controller;


import java.util.List;

import com.jarvis.security.entity.Student;
import com.jarvis.security.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public Student createStudent( @RequestBody Student student) {

        return studentService.createStudent(student);
    }

    @GetMapping("/getById/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudebtById(id);
    }

    @GetMapping("/all")
    public List<Student> getAllStudent(){

        System.out.println("===> controller");
        return studentService.getAllStudent();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);

    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("studentByName/{name}")
    public List<Student> studentsByName(@PathVariable String name){
        return studentService.getStdentByName(name);
    }

    @GetMapping("/studentsByNameAndMail")
    public List<Student> studentsByNameAndMail(@RequestParam String name, @RequestParam String email){
        return studentService.studentsByNameAndMail(name,email);
    }

    //return type is student so it will return only one record but if you passing name or email having multiple record you need to write return type is List<Student>
    //http://localhost:8080/api/student/studentsByNameOrMail?name=vinayak Dange&email=vinu@gmail.com
    /*
     * @GetMapping("/studentsByNameOrMail") public Student
     * studentsByNameOrMail(@RequestParam String name, @RequestParam String email){
     * return studentService.studentsByNameOrMail(name,email); }
     */

    @GetMapping("/studentsByNameOrMail")
    public List<Student> studentsByNameOrMail(@RequestParam String name, @RequestParam String email){
        return studentService.studentsByNameOrMail(name,email);
    }

    @GetMapping("/allWithPagination")
    public List<Student> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        return studentService.getAllWithPagination(pageNo,pageSize);
    }

    @GetMapping("/allStudentWithSort")
    public List<Student> getStudentWithSortingByName(){
        return studentService.getStudentBySorting();
    }

    @GetMapping("/byDepartmentName")
    public List<Student> getStudentByDeptName(@RequestParam String deptName){
        return studentService.getStudentByDeptName(deptName);
    }

    @GetMapping("/bySubjectName")
    public List<Student> getStudentBySubjectName(@RequestParam String subName){
        return studentService.getStudentBySubjectName(subName);
    }

    @GetMapping("/emailLike")
    public List<Student> emailLike(@RequestParam String mail){
        return studentService.emailLike(mail);
    }

    @GetMapping("/startWithName")
    public List<Student> getStudentSatrtWith(@RequestParam String name){
        return studentService.getStudentByStartWithName(name);
    }
}
