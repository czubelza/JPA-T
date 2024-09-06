package org.example;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "categoria")
public class Categoria  implements Serializable {
        private static final long serialVersionUID = 1L;

        @Builder.Default
        @Column(name = "denominacion")
        private String denominacion = "Desconocido";

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;



}
