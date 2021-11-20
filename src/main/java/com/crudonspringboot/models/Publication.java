package com.crudonspringboot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String header;
    private String theme;
    private String date;

    @Lob
    @Column(length = Integer.MAX_VALUE)
    private byte[] publicationText;

    @Lob
    @Column(length = Integer.MAX_VALUE)
    private byte [] publicationImage;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;

}