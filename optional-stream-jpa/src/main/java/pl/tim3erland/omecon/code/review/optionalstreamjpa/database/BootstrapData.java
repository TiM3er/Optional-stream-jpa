package pl.tim3erland.omecon.code.review.optionalstreamjpa.database;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import pl.tim3erland.omecon.code.review.optionalstreamjpa.database.dao.StudentDao;
import pl.tim3erland.omecon.code.review.optionalstreamjpa.database.repository.StudentRepository;

import java.util.UUID;

@Slf4j
@Service
public class BootstrapData implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public BootstrapData(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        StudentDao studentDao = new StudentDao(UUID.randomUUID(), "Kuba", "Nitecki");
        studentRepository.save(studentDao);
        studentDao = new StudentDao(UUID.fromString("a2cda82b-4bee-46f9-86a7-db56b7b11d74"), "Dario", "Nie do mnie tak, nie do mnie");
        studentRepository.save(studentDao);
        studentDao = new StudentDao(UUID.randomUUID(), "Dario", "Napił by się herbatki");
        studentRepository.save(studentDao);
        studentDao = new StudentDao(UUID.randomUUID(), "Jacek", "Powinno być inaczej");
        studentRepository.save(studentDao);
        studentDao = new StudentDao(UUID.randomUUID(), "Władek", "Stryj");
        studentRepository.save(studentDao);
        studentDao = new StudentDao(UUID.randomUUID(), "Paulina", "Dupa");
        studentRepository.save(studentDao);
        studentDao = new StudentDao(UUID.randomUUID(), "Maria", "Pazińska");
        studentRepository.save(studentDao);
        studentDao = new StudentDao(UUID.randomUUID(), "Mariusz", "Fajkowski");
        studentRepository.save(studentDao);
        studentDao = new StudentDao(UUID.randomUUID(), "Marek", "Żakowski");
        studentRepository.save(studentDao);
        studentRepository.findAll().forEach(studentDao1 -> log.info("{}", studentDao1.printClass()));
    }
}
