package com.jarvis.security.service;

import com.jarvis.security.entity.Student;
import com.jarvis.security.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student createStudent(Student student) {
        // TODO Auto-generated method stub

        Logger logger=(Logger) LoggerFactory.getLogger(this.getClass());
        System.out.println("====>"+logger);
        return studentRepository.save(student);
    }

    public Student getStudebtById(String id) {
        return studentRepository.findById(id).get(); //return the student object thats why .get()
    }

    public List<Student> getAllStudent() {
        // TODO Auto-generated method stub
        System.out.println("service===>");
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        // TODO Auto-generated method stub
        return studentRepository.save(student);
    }

    public String deleteStudent(String id) {
        // TODO Auto-generated method stub
        studentRepository.deleteById(id);
        return "Student has been deleted";
    }

    public List<Student> getStdentByName(String name) {
        // TODO Auto-generated method stub
        return studentRepository.findByName(name);
    }

    public List<Student> studentsByNameAndMail(String name, String email) {
        // TODO Auto-generated method stub
        return studentRepository.findByNameAndEmail(name, email);
    }

    /*
     * public Student studentsByNameOrMail(String name, String email) { // TODO
     * Auto-generated method stub return studentRepository.findByNameOrEmail(name,
     * email); }
     */

    public List<Student> studentsByNameOrMail(String name, String email) {
        // TODO Auto-generated method stub
        return studentRepository.findByNameOrEmail(name, email);
    }

    public List<Student> getAllWithPagination(int pageNo, int pageSize) {
        // TODO Auto-generated method stub
        Pageable pageble=PageRequest.of(pageNo-1, pageSize);	//@param page zero based pageindex, not be negative pageNo-1
        return studentRepository.findAll(pageble).getContent(); // findAll(pageble return student object not list thats why we place , .getContent()
    }

    public List<Student> getStudentBySorting() {
        // TODO Auto-generated method stub
        //Sort sort=Sort.by(Sort.Direction.ASC, "name");  //Ascending order
        Sort sort=Sort.by(Sort.Direction.DESC, "name");	//Descending order
        return studentRepository.findAll(sort);
    }

    public List<Student> getStudentByDeptName(String deptName) {
        // TODO Auto-generated method stub
        return studentRepository.findByDeparmentDepartmentName(deptName);
    }

    public List<Student> getStudentBySubjectName(String subName) {
        // TODO Auto-generated method stub
        return studentRepository.findBySubjectsSubjectName(subName);
    }

    public List<Student> emailLike(String mail) {
        // TODO Auto-generated method stub
        return studentRepository.findByEmailIsLike(mail);
    }

    public List<Student> getStudentByStartWithName(String name) {
        // TODO Auto-generated method stub
        return studentRepository.findByNameStartsWith(name);
    }
}