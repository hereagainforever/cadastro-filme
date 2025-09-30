package com.cti.cadastro_filme.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "filme")
@Entity

public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "titulo", unique = true)
    private String titulo;

    @Column(name = "diretor")
    private String diretor;
}
