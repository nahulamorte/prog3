package practico5.ejercicio2;

public class Celda {
    private int valor;
    private boolean right;
    private boolean left;
    private boolean down;
    private boolean up;

    public Celda(int valor, boolean right, boolean left, boolean down, boolean up) {
        this.valor = valor;
        this.right = right;
        this.left = left;
        this.down = down;
        this.up = up;
    }

    public int getValor() {
        return valor;
    }

    public boolean haveRight() {
        return right;
    }

    public boolean haveLeft() {
        return left;
    }

    public boolean haveDown() {
        return down;
    }

    public boolean haveUp() {
        return up;
    }
}
