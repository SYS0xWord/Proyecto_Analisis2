/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producto;

/**
 *
 * @author sys515
 */
public class Contexto {
     private strategy estrategia;
     public Contexto(strategy estrategia){
         this.estrategia=estrategia;
     }
     public Object id(String descripcion){
          return estrategia.realizarOperacion(descripcion);
     }
}
