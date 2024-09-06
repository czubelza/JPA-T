package org.example;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "domicilio")
public class Domicilio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Builder.Default
    @Column(name = "nombreCalle")
    private String nombreCalle = "No NombreCalle";

    @Builder.Default
    @Column(name = "numero")
    private int numero = 0;

}
