/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producto;

import Almacen.Modelo_proxy_jl;
import com.mycompany.inventariomaven.Categoria;
import com.mycompany.inventariomaven.Marca;
import com.mycompany.inventariomaven.Presentacion;
import com.mycompany.inventariomaven.Producto;
import com.mycompany.inventariomaven.ProductoJpaController;
import com.mycompany.inventariomaven.Unidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author sys515
 */
public class Producto_Controller extends ProductoBD implements  ActionListener{
    private Producto_frm view;
    private List querylist;
    private ArrayList<String> data=new ArrayList<String>();
    public Producto_Controller(Producto_frm view){
        this.view=view;
        this.querylist=consultaOpciones();
        llenarOpciones();
        addActionListener();
        System.out.println(view.getCategoria().getSelectedItem());
    }
    private void addActionListener()
    {
        view.getBtn_Crear().addActionListener(this);
        view.getCategoria().addActionListener(this);
    }
    private void llenarOpciones(){
        view.getCategoria().setModel(new Modelo_Proxy_cmb((List) querylist.get(0)));
        view.getPresentacion().setModel(new Modelo_Proxy_cmb((List) querylist.get(1)));
        view.getUnidad().setModel(new Modelo_Proxy_cmb((List) querylist.get(2)));
        view.getMarca().setModel(new Modelo_Proxy_cmb((List) querylist.get(3)));
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==view.getBtn_Crear())
        {
            data.clear();
            data.add(view.getNombre().getText());
            data.add(view.getCodigo().getText());
            data.add(view.getStock().getText());
            data.add(String.valueOf(view.getCategoria().getSelectedItem()));
            data.add(String.valueOf(view.getPresentacion().getSelectedItem()));
            data.add(String.valueOf(view.getUnidad().getSelectedItem()));
            data.add(String.valueOf(view.getMarca().getSelectedItem()));
            crearProducto(data);
        }
        if(ae.getSource()==view.getCategoria()){
            System.out.println(view.getCategoria().getSelectedItem());
            
        }
    }
    
}
