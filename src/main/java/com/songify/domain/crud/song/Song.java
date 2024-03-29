package com.songify.domain.crud.song;

import com.songify.domain.crud.util.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Builder
@Getter
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Song extends BaseEntity {

    @Id
    @GeneratedValue(generator = "song_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "song_id_seq",
            sequenceName = "song_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false)
    private String name;

    private Instant releaseDate;

    private Long duration;

    @OneToOne
    private Genre genre;

    @Enumerated(EnumType.STRING)
    private SongLanguage language;

    public Song(String name) {
        this.name = name;
    }
}
