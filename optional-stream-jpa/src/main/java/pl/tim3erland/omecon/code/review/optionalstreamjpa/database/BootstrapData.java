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
        StudentDao studentDao = new StudentDao(UUID.randomUUID(), "Kuba", "Nitecki", false);
        studentRepository.save(studentDao);
        studentDao = new StudentDao(UUID.fromString("a2cda82b-4bee-46f9-86a7-db56b7b11d74"), "Dario", "Nie do mnie tak, nie do mnie", true);
        studentRepository.save(studentDao);
        studentDao = new StudentDao(UUID.randomUUID(), "Dario", "Napił by się herbatki", true);
        studentRepository.save(studentDao);
        studentDao = new StudentDao(UUID.randomUUID(), "Jacek", "Powinno być inaczej", false);
        studentRepository.save(studentDao);
        studentDao = new StudentDao(UUID.randomUUID(), "Władek", "Stryj", false);
        studentRepository.save(studentDao);
        studentDao = new StudentDao(UUID.randomUUID(), "Paulina", "Dupa", true);
        studentRepository.save(studentDao);
        studentDao = new StudentDao(UUID.randomUUID(), "Maria", "Pazińska", true);
        studentRepository.save(studentDao);
        studentDao = new StudentDao(UUID.randomUUID(), "Mariusz", "Fajkowski", true);
        studentRepository.save(studentDao);
        studentDao = new StudentDao(UUID.randomUUID(), "Marek", "Żakowski", true);
        studentRepository.save(studentDao);
        studentRepository.findAll().forEach(studentDao1 -> log.info("{}", studentDao1.printClass()));
    }
}
