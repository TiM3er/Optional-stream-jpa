package pl.tim3erland.omecon.code.review.optionalstreamjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String name;
    private String author;
    private int yearPublished;
}
