/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producto;

import com.mycompany.inventariomaven.Marca;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author sys515
 */
public class Marca_es implements strategy {

    @Override
    public Object realizarOperacion(String descripcion) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyecto");
        EntityManager em = emf.createEntityManager();//

        System.out.println(descripcion);
        TypedQuery<Marca> query_cat = em.createNamedQuery("Marca.findByMarca",Marca.class);
        query_cat.setParameter("marca", descripcion);
        List<Marca> listamarca = query_cat.getResultList();//List es una interfaz
        System.out.println("Lista");
        System.out.println(listamarca);
        System.out.println(listamarca.get(0).getId());

        /*TypedQuery<Presentacion> query_pres = em.createNamedQuery("Presentacion.findAll", Presentacion.class);
        List<Presentacion> listaPresentacion = query_pres.getResultList();//List es una interfaz
        TypedQuery<Unidad> query_unidad = em.createNamedQuery("Unidad.findAll", Unidad.class);
        List<Unidad> listaUnidad = query_unidad.getResultList();//List es una interfaz
        TypedQuery<Marca> query_marca = em.createNamedQuery("Marca.findAll", Marca.class);
        List<Marca> listaMarca = query_marca.getResultList();//List es una interfaz/*/
        //modelo_proxy_jl mc=new modelo_proxy_jl(listaCategoria);
        em.close();
        emf.close();
        return listamarca.get(0);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
