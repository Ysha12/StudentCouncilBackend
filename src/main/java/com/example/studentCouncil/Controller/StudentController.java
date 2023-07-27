package com.example.studentCouncil.Controller;
import com.example.studentCouncil.Controller.Api.StudentApi;
import com.example.studentCouncil.Dto.StudentReqDto;
import com.example.studentCouncil.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController implements StudentApi {
    @Autowired
    private StudentService studentService;
    public StudentController (StudentService studentService)
    {
        this.studentService=studentService;
    }
    public ResponseEntity getAllStudent(int page, int size){
        return ResponseEntity.ok().body(studentService.getAllStudent(page,size));
    }
    public ResponseEntity getStudentById(Long userID) {

        return ResponseEntity.ok().body(studentService.getStudentById(userID));
    }

    public ResponseEntity addNewStudent(StudentReqDto stu) {

        return ResponseEntity.ok().body(studentService.addNewStudent(stu));
    }
    public ResponseEntity editStudent(Long ID, StudentReqDto stureq) {
        return  ResponseEntity.ok().body(studentService.editStudent(ID, stureq));
    }
    public ResponseEntity deleteStudent(Long stuId){

        return ResponseEntity.ok().body(studentService.deleteStudent(stuId));
    }
    public ResponseEntity viewStudentId(Long stuID) {

        return ResponseEntity.ok().body(studentService.viewStudentId(stuID));
    }
//    s

    @Override
    public ResponseEntity addStudent(StudentReqDto student) {
        return ResponseEntity.ok().body(studentService.addNewStudent(student));
    }
}
