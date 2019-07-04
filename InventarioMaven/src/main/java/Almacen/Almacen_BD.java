/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Almacen;

import com.mycompany.inventariomaven.Categoria;
import com.mycompany.inventariomaven.CategoriaJpaController;
import com.mycompany.inventariomaven.Marca;
import com.mycompany.inventariomaven.MarcaJpaController;
import com.mycompany.inventariomaven.Presentacion;
import com.mycompany.inventariomaven.PresentacionJpaController;
import com.mycompany.inventariomaven.Unidad;
import com.mycompany.inventariomaven.UnidadJpaController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import main.Main;

/**
 *
 * @author sys515
 */
public class Almacen_BD {
    private List querylist=new ArrayList();
    
    public List listas(){
        
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("proyecto");        
        EntityManager em = emf.createEntityManager();//
        TypedQuery<Categoria> query_cat = em.createNamedQuery("Categoria.findAll", Categoria.class);
        List<Categoria> listaCategoria = query_cat.getResultList();//List es una interfaz
        TypedQuery<Presentacion> query_pres = em.createNamedQuery("Presentacion.findAll", Presentacion.class);
        List<Presentacion> listaPresentacion = query_pres.getResultList();//List es una interfaz
        TypedQuery<Unidad> query_unidad = em.createNamedQuery("Unidad.findAll", Unidad.class);
        List<Unidad> listaUnidad = query_unidad.getResultList();//List es una interfaz
        TypedQuery<Marca> query_marca = em.createNamedQuery("Marca.findAll", Marca.class);
        List<Marca> listaMarca = query_marca.getResultList();//List es una interfaz
        //modelo_proxy_jl mc=new modelo_proxy_jl(listaCategoria);
        querylist.add(listaCategoria);
        querylist.add(listaPresentacion);
        querylist.add(listaUnidad);
        querylist.add(listaMarca);
        System.out.println("Query");
        em.close();
        emf.close();
        return querylist;
    }
     public void create(int tipo,String descripcion){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("proyecto");        
        EntityManager em = emf.createEntityManager();//
        
        if(tipo == 1) {
            CategoriaJpaController categoriaController = new CategoriaJpaController(em);
            Categoria c = new Categoria();
            
            c.setCategoria(descripcion);
            try {
                categoriaController.create(c);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                em.close();
                emf.close();
            }
            
        }
        if(tipo == 2) {
            PresentacionJpaController presetnacioncontroller=new PresentacionJpaController(em);
            Presentacion p = new Presentacion();
            
            p.setPresentacion(descripcion);
            try {
                presetnacioncontroller.create(p);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                em.close();
                emf.close();
            }
            
        }
        if(tipo == 3) {
            UnidadJpaController unidadcontroller=new UnidadJpaController(em);
            Unidad u = new Unidad();
            u.setUnidad(descripcion);
            try {
                unidadcontroller.create(u);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                em.close();
                emf.close();
            }
            
        }
        if(tipo == 4) {
            MarcaJpaController marcacontroller=new MarcaJpaController(em);
            Marca m = new Marca();
            m.setMarca(descripcion);
            try {
                marcacontroller.create(m);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                em.close();
                emf.close();
            }
            
        }
        //em.close();
        
        
    
        
    }
}
