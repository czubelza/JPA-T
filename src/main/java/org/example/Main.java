package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("en marcha Alberto");

        try {
            entityManager.getTransaction().begin();

            Factura factura1 = new Factura();
            factura1.setFecha("12/08/2024");
            factura1.setNumero(33243);

            Domicilio domic1 = new Domicilio();
            domic1.setNombreCalle("Calle Mitre ");
            domic1.setNumero(7890);
            Cliente cliente1 =  Cliente.builder()
                    .nombre("Ana")
                    .apellido("García")
                    .dni(36789012)
                    .domicilio(domic1)
                    .build();
            domic1.setCliente(cliente1);
            factura1.setCliente(cliente1);

            Categoria beb = new Categoria();
            beb.setDenominacion("Bebidas");
            //Categoria lac = new Categoria();
            //lac.setDenominacion("Lacteos");
            Categoria sna = new Categoria();
            sna.setDenominacion("Snacks & Golosinas");
           // Categoria per = new Categoria();
            //per.setDenominacion("No Perecedero");
            Articulo art1 = Articulo.builder()
                    .cantidad(130)
                    .denominacion("Vino Nalbec Catena Zapata")
                    .precio(3600)
                    .build();
            Articulo art2 = Articulo.builder()
                    .cantidad(800)
                    .denominacion("Alfajor Havana")
                    .precio(3500)
                    .build();
            /*Articulo art3 = Articulo.builder()
                    .cantidad(700)
                    .denominacion("Queso untable Sancor x 100gr")
                    .precio(1500)
                    .build();
            Articulo art4 = Articulo.builder()
                    .cantidad(1200)
                    .denominacion("Arror Tio Carlos")
                    .precio(2000)
                    .build();
            Articulo art5 = Articulo.builder()
                    .cantidad(12000)
                    .denominacion("Cerveza Quilmes 750ml")
                    .precio(3900)
                    .build();
            Articulo art6 = Articulo.builder()
                    .cantidad(22000)
                    .denominacion("Azúcar Ledesma")
                    .precio(2000)
                    .build(); */
            art1.getCategorias().add(beb);
            beb.getArticulos().add(art1);
            art2.getCategorias().add(sna);
            sna.getArticulos().add(art2);
            DetalleFactura detalleF1 = new DetalleFactura();
            DetalleFactura detalleF2 = new DetalleFactura();
            detalleF1.setArticulo(art1);
            detalleF1.setCantidad(5);
            detalleF1.setSubtotal(18000);
            detalleF2.setArticulo(art2);
            detalleF2.setCantidad(9);
            detalleF2.setSubtotal(31500);
            art1.getDetalles().add(detalleF1);
            factura1.getDetalles().add(detalleF1);
            detalleF1.setFactura(factura1);
            art2.getDetalles().add(detalleF2);
            factura1.getDetalles().add(detalleF2);
            detalleF2.setFactura(factura1);
            factura1.setTotal(49500);




            entityManager.persist(factura1);


            entityManager.getTransaction().commit();


        }catch (Exception e) {

            entityManager.getTransaction().rollback();

            // Cerrar el EntityManager y el EntityManagerFactory
        }
        entityManager.close();
        entityManagerFactory.close();

    }
}
