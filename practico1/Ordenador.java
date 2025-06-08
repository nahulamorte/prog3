package practico1;

public class Ordenador<T extends Comparable<T>> {

    public MySimpleLinkedList<T> ordenar(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2){
        MySimpleLinkedList<T> salida = new MySimpleLinkedList<T>();
        if (l1.isEmpty() && l2.isEmpty()){
            return null;
        }

        //
        for (T aux1 : l1){
            for (T aux2 : l2){
                if (aux1.equals(aux2)){
                    salida.insertSort(aux1);
                }
            }
        }
        return salida;
    }



    public MySimpleLinkedList<T> noRepetidos (MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2){
        MySimpleLinkedList<T> retorno = new MySimpleLinkedList<>();
        if (l1.isEmpty() && l2.isEmpty()){
            return null;
        }


        for (T elem_l1 : l1){
            for (T elem_l2 : l2){
                if (!elem_l1.equals(elem_l2))
                    retorno.insertSort(elem_l1);
            }
        }
        return retorno;
    }
}
