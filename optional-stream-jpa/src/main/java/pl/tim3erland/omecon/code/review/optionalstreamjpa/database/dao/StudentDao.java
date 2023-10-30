package pl.tim3erland.omecon.code.review.optionalstreamjpa.database.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
public class StudentDao implements BasicDao {

    @Id
    private UUID studentUid;

    private String studentName;
    private String studentSurname;

    public StudentDao() {
        this.studentUid = UUID.randomUUID();
    }

    @Override
    public String printClass() {
        return "Uid: " + this.studentUid + " name: " + this.studentName + " surname: " + this.studentSurname;
    }

}
