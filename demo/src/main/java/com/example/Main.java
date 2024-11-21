package com.example;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.Entidad.Producto;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        // crearProducto("Gaseosa", 1000, 100);

        Producto producto = leerProducto(1L);
        if (producto != null) {
            System.out.println("Producto encontrado: " + producto.getNombre());
        }

        em.close();
        emf.close();
    }

    // public static void crearProducto (String nombre, double precio, int cantidad){
    //     EntityManager em = emf.createEntityManager();
    //     em.getTransaction().begin();

    //     Producto productoUno = new Producto();
    //     productoUno.setNombre(nombre);
    //     productoUno.setPrecio(precio);
    //     productoUno.setCantidad(cantidad);

    //     em.persist(productoUno);

    //     em.getTransaction().commit();
    //     em.close();
    // }

    public static Producto leerProducto(long id){
        EntityManager em = emf.createEntityManager();
        Producto cliente = em.find(Producto.class, id);
        em.close();
        return cliente;
    }
}