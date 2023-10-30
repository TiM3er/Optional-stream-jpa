package pl.tim3erland.omecon.code.review.optionalstreamjpa.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.tim3erland.omecon.code.review.optionalstreamjpa.dto.StudentDto;
import pl.tim3erland.omecon.code.review.optionalstreamjpa.service.StudentService;

import java.util.List;

@Slf4j
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> allStudents = studentService.getAllStudents();
        return ResponseEntity.ok(allStudents);
    }

    @GetMapping("/student/v2")
    public ResponseEntity<List<StudentDto>> getAllStudentsV2() {
        List<StudentDto> allStudents = studentService.getAllStudentsV2();
        return ResponseEntity.ok(allStudents);
    }

    @GetMapping("/student/name")
    public ResponseEntity<List<StudentDto>> getAllStudentsByName(@RequestParam(name = "name", required = false) String name) {
        List<StudentDto> allStudents = studentService.getAllStudentsByName(name);
        return ResponseEntity.ok(allStudents);
    }

    @GetMapping("/student/name/v2")
    public ResponseEntity<List<StudentDto>> getAllStudentsByNameV2(@RequestParam(name = "name", required = false) String name) {
        List<StudentDto> allStudents = studentService.getAllStudentsByNameV2(name);
        return ResponseEntity.ok(allStudents);
    }


    @GetMapping("/student/uid")
    public ResponseEntity<StudentDto> getAllStudentsByUid(@RequestParam(name = "uid", required = true) String uid) {
        var studentDto = studentService.getAllStudentsByUid(uid);
        return ResponseEntity.ok(studentDto);
    }
}
