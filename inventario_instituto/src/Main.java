import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static void mostrarListaProd(String[] inventario) {
        for (int i = 0; i < inventario.length; i++) {
            System.out.println(inventario[i]);
        }
    }
    public static void main(String[] args) {
        String[] inventario = {"Ordinador", "Taula", "Cadira", "Llapis", "Goma"};
        mostrarListaProd(inventario);
        ElimProd(inventario);
        mostrarListaProd(inventario);

    }
    public static void ElimProd(String[] inventario) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el elemento que quieres eliminar: ");
        String EleEliminar = sc.nextLine();
        for (int i = 0; i < inventario.length; i++) {
            if (EleEliminar.equals(inventario[i])){
                inventario[i] = "";
            }
        }

    }
}