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
@Table(name = "detalleFactura")
public class DetalleFactura implements Serializable {
    @Builder.Default
    @Column(name = "cantidad")
    private int cantidad = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Builder.Default
    @Column(name = "subtotal")
    private int subtotal = 0;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_articulo")
    private Articulo articulo;


}
