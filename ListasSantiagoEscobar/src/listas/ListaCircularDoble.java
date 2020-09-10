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
public class ListaCircularDoble {

    private DoubleNode head;

    public ListaCircularDoble() {
        head = null;
    }

    private boolean isEmpty() {
        return head == null;
    }

    /**
     * Agregar un dato al inicio de la lista
     *
     * @param d Dato
     */
    public void add(int d) {
        DoubleNode newNode = new DoubleNode(d);

        if (isEmpty()) {
            newNode.setPreviosNode(newNode);
            newNode.setNextNode(newNode);
            head = newNode;
        } else {
            newNode.setPreviosNode(head.getPreviosNode());
            newNode.setNextNode(head);
            //configuración último elemento de la lista
            head.getPreviosNode().setNextNode(newNode);
            head.setPreviosNode(newNode);            
            head = newNode;
        }
    }
    
    /**
     * ELiminar el último nodo
     */
    public void deleteLast(){
        //modificar el anterior de la cabeza
        head.setPreviosNode(head.getPreviosNode());
        head.getPreviosNode().getPreviosNode().setNextNode(head);
    }
    
    /**
     * Mostrar los datos de la lista desde el primero al último
     * @return 
     */
    public String showData() {
        return "";
    }
    
    /**
     * Mostrar los datos de la lista desde el último al primero
     * @return 
     */
    public String showDataDesc() {
        
        DoubleNode actual = head.getPreviosNode();
        String data = "";
        while(actual != head)
        {
            actual = actual.getPreviosNode();
            data += actual.getData() + " - ";
        }
        
        return data;
    }
    
     public String showDataAsc() {       
        DoubleNode actual = head;
        DoubleNode ultimo = actual.getPreviosNode();
        String Data = "";
        while(actual!=ultimo){
            System.out.println(actual.getData());
            Data += actual.getData()+ " - ";
            actual = actual.getNextNode();
        }
       
        return Data;
    }

}
