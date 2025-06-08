package practico1;

public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> lista1 = new MySimpleLinkedList<>();
        MySimpleLinkedList<Integer> lista2 = new MySimpleLinkedList<>();
        MySimpleLinkedList<Integer> listaOr = new MySimpleLinkedList<>();

        lista1.insertFront(1);
        lista1.insertFront(4);
        lista1.insertFront(6);
        lista1.insertFront(12);
        lista1.insertFront(28);
        lista1.insertFront(400);


        lista2.insertFront(28);
        lista2.insertFront(4);
        lista2.insertFront(5);
        lista2.insertFront(400);
        lista2.insertFront(500);
        lista2.insertFront(28);
        lista2.insertFront(10);

//        listaOr.insertSort(3);
//        listaOr.insertSort(1);
//        listaOr.insertSort(8);
//        listaOr.insertSort(10);
//        listaOr.insertSort(2);


        System.out.println(listaOr);

        Ordenador<Integer> o = new Ordenador<>();
        System.out.println(o.noRepetidos(lista1, lista2));
        System.out.println(o.ordenar(lista1, lista2));

    }
}
