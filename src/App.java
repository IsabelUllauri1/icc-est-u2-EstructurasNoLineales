import materia.controllers.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Nombre: Isabel Ullauri");
        
        ArbolBinario aB = new ArbolBinario();
        aB.insert(50);
        aB.insert(17);
        aB.insert(76);
        aB.insert(9);
        aB.insert(23);
        aB.insert(54);
        aB.insert(14);
        aB.insert(19);
        System.out.println("La altura es= "+aB.getHeight());
        System.out.println("El peso es: "+ aB.getPeso());
        aB.imprimirArbol();
        
        System.out.println(aB.buscar(1));
        System.out.println(aB.buscar(19));
        aB.imprimirInOrderConAltura();
        aB.imprimirFactorDeEquilibrio();

        System.out.println("El arbol esta quilibrado: "+ aB.arbolBalanceado());
        System.out.println("agregamos valor: 15");
        aB.insert(15);
        aB.imprimirFactorDeEquilibrio();
        //System.out.println("nodos desequilibrados: " + aB.nodosDes();
        aB.nodosDes();
    }
}
