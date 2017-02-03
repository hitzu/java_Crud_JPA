/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entidades.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author roberto
 */
public class PruebaAgregar {
    
    static EntityManager em = null;
    static EntityTransaction ex = null;
    static EntityManagerFactory emf = null;
    
    public static void main(String[] a)
    {
        PruebaAgregar pc = new PruebaAgregar();
        System.out.println(pc.registrar("juan", "peres", "244886", "juan@hotmail.com","jupe","Ro250693"));
    }
    
    public boolean registrar(String nombre, String apellido, String telefono, String email, String nickname, String password)
    {
        System.out.println("Se creara la prueba de persitencia");
        Usuario UP = new Usuario(nombre,apellido,telefono,email,nickname,password);
        System.out.println("Objeto a persistir: " + UP);
        emf = Persistence.createEntityManagerFactory("MapeoUP");
        em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(UP);
        tx.commit();
        System.out.println("Objeto persistido" + UP);
        
        return UP.getIdUsuario()!=null;
    }
    
}
