package pl.tim3erland.omecon.code.review.optionalstreamjpa.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.tim3erland.omecon.code.review.optionalstreamjpa.database.dao.StudentDao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface StudentRepository extends JpaRepository<StudentDao, UUID> {
    List<StudentDao> findAllByStudentName(Optional<String> name);
    @Query("select sd from StudentDao sd where (:name is null or sd.studentName =:name)")
    List<StudentDao> findAllByStudentNamev2(@Param("name") Optional<String> name);

    Optional<StudentDao> findAllByStudentUid(UUID uid);


    @Query("select sd from StudentDao sd ")
    Stream<StudentDao> getAllStudent();

}
