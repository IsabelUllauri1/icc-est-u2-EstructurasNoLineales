package materia.controllers;

import materia.models.Node;
// va preguntando si va a la derecha o izquierda. pE: LE DICEN DERECHA, entonces pregunta si es nullo. si no 
//es nullo, pregunta si tiene hijos, y de nuevo derecha o izquierda

public class ArbolBinario {
    private Node root;

    public ArbolBinario(){
        this.root= null;

    }

    public void insert(int value){
        root = insertRec(root,value);      
        //root es la referencia de nodo  
    }

    private Node insertRec(Node padre, int value){
        if(padre==null){
            return new Node(value);
        }
        

        //segunda situcion
        if(value<padre.getValue()){
            //me voy a la izqu
            //digamos que viene un num menor. enrtonces se va a la iz. hay que setear la izquierda
            padre.setLeft(insertRec(padre.getLeft(), value));

        }else if(value>padre.getValue()){
            //me voy a la derecha
            //digamos que viene un num mayor. enrtonces se va a la der. hay que setear la derecha

            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;//se retorna padre: 1. poruqe si se ingresa el valor de padre
        //2. en el insetRec se necesita el valor de padre **metodo recursivo**
    }

    public void imprimirArbol(){
        imprimirRec(root);

    }

    private void imprimirRec(Node nodo){

        if(nodo!=null){
            System.out.println(nodo.getValue()+",");
            imprimirRec(nodo.getLeft());            
            imprimirRec(nodo.getRight());
            
        }

    }

    public boolean buscar(int value){
        return buscarRec(root,value);

    }

    private boolean buscarRec(Node root , int value){
        if(root==null){
            return false;
        }
        if (value==root.getValue()){
            return true;
        }
        if(value<root.getValue()){
            return buscarRec(root.getLeft(), value);
        }else{
            return buscarRec(root.getRight(), value);
        }

        

        
        
    }


    
}
