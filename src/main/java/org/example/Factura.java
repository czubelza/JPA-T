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
@Table(name = "factura")
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Builder.Default
    @Column(name = "fecha")
    private String fecha = "-/-/-";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Builder.Default
    @Column(name = "numero")
    private int numero = 0;

    @Builder.Default
    @Column(name = "total")
    private int total = 0;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalle = new ArrayList<DetalleFactura>();



}
