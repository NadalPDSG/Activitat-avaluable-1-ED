import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = true;
        String[] inventario = {"Ordinador", "Taula", "Cadira", "Llapis", "Goma"};
        while (salir) {
            System.out.println("1) Mostrar lista de productos.");
            System.out.println("2) Eliminar producto por posición.");
            System.out.println("3) Eliminar producto por nombre.");
            System.out.println("4) Añadir producto al inventario.");
            System.out.println("0) Salir.");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 0:
                    salir = false;
                    break;
                case 1:
                    mostrarListaProd(inventario);
                    break;
                case 2:
                    eliminarProdPos(inventario);
                    break;
                case 3:
                    ElimProd(inventario);
                    break;
                case 4:
                    añadirProd(inventario);
                    break;
            }
        }
    }

    static void mostrarListaProd(String[] inventario) {
        for (int i = 0; i < inventario.length; i++) {
            System.out.println(inventario[i]);
        }
    }

    public static void ElimProd(String[] inventario) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el elemento que quieres eliminar: ");
        String EleEliminar = sc.nextLine();
        for (int i = 0; i < inventario.length; i++) {
            if (EleEliminar.equals(inventario[i])) {
                inventario[i] = "";
            }
        }
    }

    public static void eliminarProdPos(String[] inventario) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Que posición deseaas eliminar? ");
        int pos = sc.nextInt();
        inventario[pos] = "";
    }

    static void añadirProd(String[] tabla) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el producto que quiera:");
        String prod = sc.nextLine();
        tabla = Arrays.copyOf(tabla, tabla.length + 1);
        tabla[tabla.length - 1] = prod;
        System.out.println(Arrays.toString(tabla));

    }
}