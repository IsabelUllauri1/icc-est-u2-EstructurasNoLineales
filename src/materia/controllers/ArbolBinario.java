package materia.controllers;

import java.util.ArrayList;
import java.util.List;

import materia.models.Node;
// va preguntando si va a la derecha o izquierda. pE: LE DICEN DERECHA, entonces pregunta si es nullo. si no 
//es nullo, pregunta si tiene hijos, y de nuevo derecha o izquierda

public class ArbolBinario {
    private int peso;
    private Node root;

    public int getPeso(){
        return peso;
    }

    public Node getRoot() {
        return root;
    }

    public ArbolBinario(){
        this.root= null;

    }

    public void insert(int value){
        root = insertRec(root,value);      
        //root es la referencia de nodo  
    }

    private Node insertRec(Node padre, int value){
        if(padre==null){
            peso++;
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
        System.out.println();

    }

    private void imprimirRec(Node nodo){

        if(nodo!=null){
            imprimirRec(nodo.getLeft()); 
            System.out.print(nodo.getValue()+",");
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

    public int getHeight(){
        return getHeightRec(root);
    }

    private int getHeightRec(Node node){
        if(node==null){
            return 0;
        }
        int  leftHeight= getHeightRec(node.getLeft());
        int rightHeight= getHeightRec(node.getRight());
        return Math.max(leftHeight, rightHeight)+1;            
    }

    public void imprimirInOrderConAltura(){

        imprimirInOrderConAlturaRec(root);

    }    


    private void imprimirInOrderConAlturaRec(Node nodo){
        if (nodo!= null){
            imprimirInOrderConAlturaRec(nodo.getLeft());
            int height= getHeightRec(nodo);
            System.out.print(nodo.getValue() + " (h= "+ height+ ")");
            imprimirInOrderConAlturaRec(nodo.getRight());

        }
        
    }
    private int getBalance(Node nodo){
        if(nodo==null)return 0;
        return getHeightRec(nodo.getLeft())-getHeightRec(nodo.getRight());
    }

    public void imprimirFactorDeEquilibrio(){
        imprimirFactorDeEquilibrioRec(root);
    }

    private void imprimirFactorDeEquilibrioRec(Node nodo){
        if(nodo != null){
            imprimirFactorDeEquilibrioRec(nodo.getLeft());
            int balance= getBalance(nodo);
            System.out.println("nodo: " + nodo.getValue()+ " |Balance: "+ balance);
            imprimirFactorDeEquilibrioRec(nodo.getRight());

        }

    }
    
    public boolean arbolBalanceado(){
        return arbolBalanceadoRec(root);
    }

    private boolean arbolBalanceadoRec(Node nodo){
        if(nodo == null )return true;
        int balanceado= Math.abs(getBalance(nodo));
        if(balanceado>1 )return false;

        return arbolBalanceadoRec(nodo.getLeft()) && arbolBalanceadoRec(nodo.getRight());

    }
    public void nodosDes (){
        List<Node> bad =new ArrayList<>();
        nodosDesRec(root, bad);

        if(bad.isEmpty()){
            System.out.println(" no hay nada");

        }else{
            System.out.print("noods desbalanceados: ");
            for(int i=0; i< bad.size(); i++){
                Node n = bad.get(i);
                int bf = getBalance(n);
                System.out.print(n.getValue()+bf);
                if(i< bad.size()-1); System.out.print(" y ");
            }
            System.out.println();
        }

    }

    private void nodosDesRec(Node nodo, List<Node> dest){
        if(nodo != null){
            if(Math.abs(getBalance(nodo))>1) dest.add(nodo);
            nodosDesRec(nodo.getLeft(), dest);
            nodosDesRec(nodo.getRight(), dest);
        } 
    }

    

    

    



    
}
