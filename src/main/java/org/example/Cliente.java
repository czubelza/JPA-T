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
@Table(name = "cliente")
public class Cliente implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Builder.Default
    @Column(name = "nombre")
    private String nombre = "Sin nombre";

    @Builder.Default
    @Column(name = "apellido")
    private String apellido = "Sin apellido";

    @Builder.Default
    @Column(name = "dni", unique = true)
    private int dni = 0;

    @OneToOne(cascade = CascadeType.ALL) //cualquier cambio que realice en el cliente se va reflejar en el domicilio
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio ;

    @Builder.Default
    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas = new ArrayList<Factura>();



}
