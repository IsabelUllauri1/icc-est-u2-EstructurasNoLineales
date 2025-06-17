import materia.controllers.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {
        ArbolBinario aB = new ArbolBinario();
        aB.insert(50);
        aB.insert(17);
        aB.insert(76);
        aB.insert(9);
        aB.insert(23);
        aB.insert(54);
        aB.insert(14);
        aB.insert(19);

        aB.imprimirArbol();

        
        System.out.println(aB.buscar(1));
        System.out.println(aB.buscar(19));

    }
}
