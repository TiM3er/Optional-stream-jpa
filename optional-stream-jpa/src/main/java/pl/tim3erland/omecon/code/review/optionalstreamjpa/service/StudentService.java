package pl.tim3erland.omecon.code.review.optionalstreamjpa.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.tim3erland.omecon.code.review.optionalstreamjpa.database.dao.StudentDao;
import pl.tim3erland.omecon.code.review.optionalstreamjpa.database.repository.StudentRepository;
import pl.tim3erland.omecon.code.review.optionalstreamjpa.dto.StudentDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> getAllStudents() {

        List<StudentDao> all = studentRepository.findAll();
        return all.stream()
                .filter(studentDao -> studentDao.isStudentActivity())
                .map(studentDao -> mapStudentDaoToDto(studentDao)
                ).collect(Collectors.toList());
    }

    private static StudentDto mapStudentDaoToDto(StudentDao studentDao) {
        return StudentDto.builder()
                .studentSurname(studentDao.getStudentSurname())
                .studentName(studentDao.getStudentName())
                .studentUid(studentDao.getStudentUid())
                .build();
    }

    public List<StudentDto> getAllStudentsByName(String name) {
        List<StudentDao> allByStudentName = studentRepository.findAllByStudentName(Optional.ofNullable(name));
        return allByStudentName.stream().map(studentDao -> mapStudentDaoToDto(studentDao)).collect(Collectors.toList());
    }

    public List<StudentDto> getAllStudentsByNameV2(String name) {
        List<StudentDao> allByStudentName = studentRepository.findAllByStudentNamev2(Optional.ofNullable(name));
        return allByStudentName.stream().map(studentDao -> mapStudentDaoToDto(studentDao)).collect(Collectors.toList());
    }

    public StudentDto getAllStudentsByUid(String uid) {
        var studentDao = studentRepository.findAllByStudentUid(UUID.fromString(uid));
        Optional<StudentDao> studentDao2 = studentDao.filter(studentDao1 -> studentDao1.isStudentActivity());
        if (studentDao2.isEmpty()) {
            return null;
        }
        return studentDao2.map(StudentService::mapStudentDaoToDto).get();
    }


    @Transactional
    public List<StudentDto> getAllStudentsV2() {
        var studentDaoStream = studentRepository.getAllStudent();
        return studentDaoStream.map(studentDao -> mapStudentDaoToDto(studentDao)).collect(Collectors.toList());
    }
}





