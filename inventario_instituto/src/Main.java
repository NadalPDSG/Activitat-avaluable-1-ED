import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = true;
        String[] inventario = {"Ordinador", "Taula", "Cadira", "Llapis", "Goma"};
        while (salir) {

            System.out.println("1) Añadir producto.");
            System.out.println("2) Eliminar producto por nombre.");
            System.out.println("3) Eliminar producto por posición.");
            System.out.println("4) Sustituir producto");

            System.out.println("6) Mostrar lista de productos");

            System.out.println("8) Salir.");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    añadirProd(inventario);
                    break;
                case 2:
                    ElimProd(inventario);
                    break;
                case 3:
                    eliminarProdPos(inventario);
                    break;
                case 4:
                    sustituirProdPos(inventario);
                    break;
                case 6:
                    mostrarListaProd(inventario);
                    break;

                case 8:
                    salir = false;
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
        System.out.println(Arrays.toString(inventario));
    }

    static void añadirProd(String[] tabla) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el producto que quiera:");
        String prod = sc.nextLine();
        tabla = Arrays.copyOf(tabla, tabla.length + 1);
        tabla[tabla.length - 1] = prod;
        System.out.println(Arrays.toString(tabla));
    }
    static void sustituirProdPos(String[] tabla) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Producto que quiere sustituir:");
        String prod = sc.nextLine();
        String newProd;
        for (int i = 0; i < tabla.length; i++) {
            if (prod.equalsIgnoreCase(tabla[i])) {
                System.out.println("¿Por cuál quiere sustituir?");
                newProd = sc.nextLine();
                tabla[i] = newProd;
            }
        }
        System.out.println(Arrays.toString(tabla));
    }



}