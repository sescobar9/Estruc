/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author Santiago Escobar
 */
public class ListaDoble {

    DoubleNode head, tail;

    public ListaDoble() {
        head = tail = null;
    }

    private boolean isEmpty() {
        return head == null;
    }

    /**
     * Método para agregar datos al inicio Los datos anteriores se desplazan a
     * la derecha Se modifica la cabeza de la estructura el segundo nodo tendra
     * un nuevo nodo anterior = cabeza
     *
     * @param data el dato al interior del nodo
     */
    public void add(int data) {
        if (isEmpty()) {
            head = tail = new DoubleNode(null, data, null);
        } else {
            head = new DoubleNode(null, data, head);
            head.getNextNode().setPreviosNode(head);
        }
    }

    /**
     * Método para agregar datos al final 
     * Se modifica la cola de la estructura
     * el penúltimo nodo tendrá un nuevo nodo siguiente = cola
     *
     * @param data el dato al interior del nodo
     */
    public void addLast(int data) {
        if (isEmpty()) {
            head = tail = new DoubleNode(null, data, null);
        }else{
            tail = new DoubleNode(tail, data, null);
            tail.getPreviosNode().setNextNode(tail);
        }
            
    }
    /**
     * Eliminar el primer elemento de la lista
     */
    public void delete(){
        
        if(isEmpty()){
            System.out.println("No existen datos a borrar");
        }else{
            head = head.getNextNode();
            head.getNextNode().setPreviosNode(null);
        }
    }
    
    /**
     * Borrar el último nodo
     */

    public void deleteLast(){
        //modificar la cola
        tail = tail.getPreviosNode();
        tail.setNextNode(null);
    }
    
    /**
     * Buscar un dato
     */
    
    public boolean search(int d){
        //recorrer y comparar
        DoubleNode nodo = head;
        while(nodo!=null)
        {
            if(nodo.getData()==d)
            {
                return true;
            }
            nodo = nodo.getNextNode();
        }
        return false;
    }
    /**
     * Método para mostrar los datos ascendentemente 
     * Inicia desde la cabeza hasta el final
     *
     * @return Datos de la lista
     */
    public String showData() {
        String data = "";
        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else {
            DoubleNode current = head;
            while (current != null) {
                data += current.getData() + " - ";
                current = current.getNextNode();
            }
        }
        return data;
    }

    
    /**
     * Método para mostrar los datos descendentemente 
     * Inicia desde la cola hasta el inicio
     *
     * @return Datos de la lista
     */
    
    public String showDataDesc() {
        String data = "";
        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else {
            DoubleNode current = tail;
            while (current != null) {
                data += current.getData() + " - ";
                current = current.getPreviosNode();
            }
        }
        return data;
    }
    
}
