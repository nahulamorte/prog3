package practico3;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void add(Integer value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.add(this.root,value);
    }

    private void add(TreeNode actual, Integer value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(),value);
            }
        } else if (actual.getValue() < value) {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(),value);
            }
        }
    }

    //O(1);
    public boolean isEmpty(){
        return root == null;
    }

    public int getRoot(){
        return this.root.getValue();
    }

    //O(n)
    public int getHeight(){
        return getHeight(this.root);
    }

    private int getHeight(TreeNode root){
        if (root == null){
            return -1;
        }

        int heightLeft = getHeight(root.getLeft());
        int heightRight = getHeight(root.getRight());

        return 1 + maxHeight(heightLeft, heightRight);

    }

    private int maxHeight(int maxLeft, int maxRight){
        if (maxLeft > maxRight){
            return maxLeft;
        }

        return maxRight;
    }



    //RECORREN DE MANERA RECURSIVA EL ARBOL
    //O(n)
    private void printPreOrder(TreeNode node)  {
        if (node == null)
            return;
        System.out.print(node.getValue() + " "); //Imprime el valor
        printPreOrder(node.getLeft()); //Imprime el izquierdo
        printPreOrder(node.getRight()); //Imprime el derecho
    }

    //O(n)
    private void printPosOrder(TreeNode node){
        if (node == null){
            ;
        }

        printPosOrder(node.getLeft());
        printPosOrder(node.getRight());
        System.out.println(node.getValue() + " ");
    }

    //O(n)
    private void printInOrder(TreeNode node){
        if (node == null){
            return;
        }

        printInOrder(node.getLeft());
        System.out.println(node.getValue() + " ");
        printInOrder(node.getLeft());
    }

    public void recorrerArbol(){
        this.printInOrder(this.root);
    }

    //Devuelve el elemento mas grande dentro del arbol
    public int getMaxElem(){
        return this.getMaxElem(this.root);
    }

    private int getMaxElem(TreeNode root) {
        if (root.getRight() == null) {
            return root.getValue();
        }

        int maxElem = getMaxElem(root.getRight());

        return maxElem;
    }

    public int getMinElem(){
        return this.getMinElem(this.root);
    }

    private int getMinElem(TreeNode root){
        if (root.getLeft() == null){
            return root.getValue();
        }

        int minElem = getMinElem(root.getLeft());

        return minElem;
    }

    public boolean hasElem(Integer elem){
        return hasElem(this.root, elem);
    }

    private boolean hasElem(TreeNode root, Integer elem){
        if (root == null){
            return false;
        }

        if (root.getValue() == elem)
            return true;

        if (root.getValue() > elem){
            return hasElem(root.getLeft(), elem);
        }

        return hasElem(root.getRight(), elem);
    }

    public List<Integer> getLongestBranch(){
        return getLongestBranch(this.root);
    }


    //[50,70,80,85,98]
    private List<Integer> getLongestBranch(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }


        List<Integer> letfBrach = getLongestBranch(root.getLeft());
        List<Integer> rightBrach = getLongestBranch(root.getRight());

        if (letfBrach.size() > rightBrach.size()){
            letfBrach.add(0, root.getValue());
            return letfBrach;
        }

        rightBrach.add(0, root.getValue());
        return rightBrach;
    }

    public List<Integer> getFrontera(){
        List<Integer> frontera = new ArrayList<>();
        getFrontera(this.root, frontera);
        return frontera;
    }

    private void getFrontera(TreeNode root, List<Integer> lista){
        if (root == null){
            return;
        }

        if (root.getRight() == null && root.getLeft() == null){
            lista.add(root.getValue());
        }

        getFrontera(root.getLeft(), lista);
        getFrontera(root.getRight(), lista);


    }

    public List<Integer> getElemAtLevel(int level){
        List<Integer> lista = new ArrayList<>();
        getElemAtLevel(this.root, level,lista, 0);
        return lista;
    }

    private void getElemAtLevel(TreeNode root, int level,List<Integer> lista, int cont){
        if (level > this.getHeight()){
            System.out.println("El árbol no cuenta con tantos niveles");
            return;
        }

        if (root == null || cont > level){
            return;
        }

        if (cont == level)
            lista.add(0, root.getValue());


        getElemAtLevel(root.getLeft(),level,lista, cont+1);
        getElemAtLevel(root.getRight(),level,lista, cont+1);
    }

    //EJERCICIO 2
    public int getSum(){
        return getSum(this.root);
    }

    private int getSum(TreeNode root){
        if (root == null){
            return 0;
        }

        if (root.getRight() != null || root.getLeft() != null){//Si tiene al menos un hijo
            return root.getValue() + getSum(root.getRight()) + getSum(root.getLeft());
        }

        return 0;
    }

    //Ejercicio 3
    public List<Integer> getHigherValues(int k){
        List<Integer> lista = new ArrayList<>();
        getHigherValues(this.root,lista, k);
        return lista;
    }

    private void getHigherValues(TreeNode root, List<Integer> lista, int k) {
        if (root == null) {
            return;
        }

        if ((root.getRight() == null && root.getLeft() == null) && root.getValue() > k) {
            lista.add(0, root.getValue());
        }

        getHigherValues(root.getRight(), lista, k);
        getHigherValues(root.getLeft(), lista, k);
    }



    public boolean delete(int elem){
        if (!hasElem(elem))
            return false;

        TreeNode nodoBorrado = delete(this.root, elem);
        return true;
    }

    private TreeNode delete(TreeNode root, int elem){
        if (root == null){ //O(1)
            return null;
        }

        if (elem < root.getValue()) {
            root.setLeft(delete(root.getLeft(), elem));
        } else if (elem > root.getValue()) {
            root.setRight(delete(root.getRight(), elem));
        }


        //1er caso, es hoja. Caso del 98:
        if (root.getLeft() == null && root.getRight() == null){
            return null;
        }


        //2do caso, el nodo tiene un solo hijo.
        if (root.getRight() == null){
            return root.getLeft();
        } else if (root.getLeft() == null){
            return root.getRight();
        }

        //3er caso
        TreeNode sucesor = encontrarMin(root.getRight());
        root.setValue(sucesor.getValue());
        root.setRight(delete(root.getRight(), sucesor.getValue()));

        return root;
    }

    private TreeNode encontrarMin(TreeNode root){
        while (root.getLeft() != null){
            root = root.getLeft();
        }
        return root;
    }

    public String getWorldByVowels(int vowels){
        String palabra = " ";
        return getWorldByVowels(this.root, 0, vowels, palabra);
    }

    private String getWorldByVowels(TreeNode root, int counter, int vowels, String palabra){
        if (root == null)
            return null;

        if (root.getValue() == 'a' || root.getValue() == 'e' ||
            root.getValue() == 'i' || root.getValue() == 'o' ||
            root.getValue() == 'u' || root.getValue() == 'A' ||
            root.getValue() == 'E' || root.getValue() == 'I' ||
            root.getValue() == 'O' || root.getValue() == 'U') {

            counter++;

        }

        palabra += root.getValue();

        getWorldByVowels(root.getLeft(), counter, vowels, palabra);
        getWorldByVowels(root.getRight(), counter, vowels, palabra);

        if (vowels < counter){
            return null;
        }

        return palabra;
    }



}


/*
    Get root nos devuelve el valor de la raiz, no el nodo HECHO
    IsEmpty el de toda la vida. HECHO
    Insert HECHO
    getHeight me da la altura del arbol, desde la raiz hasta las hojas mas lejanas. HECHO
    los preOrder, posOrder estan en las filminas, unicamente agregar los "-"
    GetMaxElem devuelve el elemento mas grande del arbol entero. HECHO
    HasElem es un contains, me da true o false si tiene o no un valor. Recorro el arbol e informo HECHO
    GetLongestBranch, devuelve la lista de valores mas largas de manera ordenada tal como estan en el arbol. HECHO
     getFrontera de izquierda a derecha todos los valores de la hoja en una lista, puede ser que las hojas no esten en el mismo nivel. HECHO
    GetElemAtLevel le paso un nivel al arbol y hay que listar todos los valores que tengan ese nivel. HECHO
    delete Borra un elemento del arbol, devuelve verdadero si lo busco y lo encontro o falso sino la encontro. (Dejar para el final)






    private boolean delete(TreeNode root, Integer elem){
        if (root == null || !hasElem(elem)){
            return false;
        }

        if (elem < root.getValue()){
            return delete(root.getLeft(), elem);
        } else if (elem > root.getValue()){
            return delete(root.getRight(), elem);
        }

        //Si llego hasta aca es porque el elemento que queremos borrar es igual al valor del nodo.

        //1er caso, el nodo NO TIENE HIJOS
//        if (root.getLeft() == null && root.getRight() == null){
                root.setValue(null);
                return true;
//        }

        //2do caso: El nodo tiene un solo hijo:
        //if

        // let value = 29;
        //return false;
    }

*/
