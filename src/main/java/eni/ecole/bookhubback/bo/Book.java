package eni.ecole.bookhubback.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;
    private String coverUrl;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

}
