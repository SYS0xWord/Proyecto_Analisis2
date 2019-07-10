/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventario;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author sys515
 */
public class ProxyTableModel implements TableModel{

    private List productos;
    private DefaultTableModel realSubject = new DefaultTableModel();
    public ProxyTableModel(List nombres,List productos){
        nombresDeColumnas(nombres);
        this.productos=productos;
        agregarFila();
    }
    private void nombresDeColumnas(List nombres)
    {
        for (Object objeto : nombres) {
            realSubject.addColumn(objeto);
            System.out.println(objeto);
        }
    }
    private void agregarFila()
    {
        Object[] datosFilas = new Object[productos.size()];
        
        int cont = 0;
        for (Object objeto : productos) 
        {
            datosFilas[cont] = objeto;
            cont++;
        }
        realSubject.addRow(datosFilas);
    }
    @Override
    public int getRowCount() {
        return realSubject.getRowCount();
    }

    @Override
    public int getColumnCount() {
        return realSubject.getColumnCount();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return realSubject.getColumnName(columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return realSubject.getColumnClass(columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return realSubject.isCellEditable(rowIndex, columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return realSubject.getValueAt(rowIndex, columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        realSubject.setValueAt(aValue, rowIndex, columnIndex);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        realSubject.addTableModelListener(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        realSubject.removeTableModelListener(l);
    }
    
}
