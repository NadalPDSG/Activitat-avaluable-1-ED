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
            System.out.println("4) Sustituir producto.");
            System.out.println("5) Modificar nombre producto.");
            System.out.println("6) Mostrar lista de productos.");
            System.out.println("7) Mostrar resumen del inventario.");
            System.out.println("8) Salir.");
            System.out.print("Elige una opción: ");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    inventario = añadirProd(inventario);
                    break;
                case 2:
                    inventario = eliminarProd(inventario);
                    break;
                case 3:
                    inventario = eliminarProdPos(inventario);
                    break;
                case 4:
                    inventario = sustituirProdPos(inventario);
                    break;
                case 5:
                    inventario = modificarNomProducte(inventario);
                    break;
                case 6:
                    mostrarListaProd(inventario);
                    break;
                case 7:
                    resumInventari(inventario);
                    break;
                case 8:
                    salir = false;
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        }
    }

    public static void mostrarListaProd(String[] inventario) {
        System.out.println(Arrays.toString(inventario));
    }

    public static String[] eliminarProd(String[] inventario) {
        Scanner sc = new Scanner(System.in);
        int posicionProducto = -1;
        System.out.print("Introduce el producto que deseas eliminar: ");
        String nombre = sc.nextLine();

        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i].equalsIgnoreCase(nombre)) {
                posicionProducto = i;
                break;
            }
        }

        if (posicionProducto != -1) {
            String[] copiaInventario = new String[inventario.length - 1];
            int j = 0;
            for (int i = 0; i < inventario.length; i++) {
                if (i != posicionProducto) {
                    copiaInventario[j] = inventario[i];
                    j++;
                }
            }
            System.out.println("Producto eliminado correctamente.");
            return copiaInventario;
        } else {
            System.out.println("No se encontro '" + nombre + "' en inventario.");
            return inventario;
        }
    }

    public static String[] eliminarProdPos(String[] inventario) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Que posición deseaas eliminar? ");
        int pos = sc.nextInt();
    
        if (pos >= 0 && pos < inventario.length) {
            String[] copiaInventario = new String[inventario.length - 1];
            int j = 0;
            for (int i = 0; i < inventario.length; i++) {
                if (i != pos) {
                    copiaInventario[j] = inventario[i];
                    j++;
                }
            }
            System.out.println("Producto eliminado correctamente.");
            return copiaInventario;
        } else {
            System.out.println("Posicion invalida.");
            return inventario;
        }
    }    

    public static String[] añadirProd(String[] tabla) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el producto que quiera: ");
        String prod = sc.nextLine();
        tabla = Arrays.copyOf(tabla, tabla.length + 1);
        tabla[tabla.length - 1] = prod;
        return tabla;
    }

    public static String[] sustituirProdPos(String[] tabla) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Producto que quiere sustituir: ");
        String prod = sc.nextLine();

        for (int i = 0; i < tabla.length; i++) {
            if (prod.equalsIgnoreCase(tabla[i])) {
                System.out.println("¿Por cuál quiere sustituir?");
                String newProd = sc.nextLine();
                tabla[i] = newProd;
                return tabla;
            }
        }
        System.out.println("No se encontro '" + prod + "' en inventario.");
        return tabla;
    }

    public static String[] modificarNomProducte(String[] inventario) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el nombre que desea cambiar: ");
        String anticNom = sc.nextLine();
        System.out.print("Introduzca el nuevo nombre: ");
        String nouNom = sc.nextLine();
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i].equalsIgnoreCase(anticNom)) {
                inventario[i] = nouNom;
                return inventario;
            }
        }
        System.out.println("No se encontro '" + anticNom + "' en inventario.");
        return inventario;
    }

    public static void resumInventari(String[] inventario) {
        String[] productosUnicos = new String[inventario.length];
        int[] cantidades = new int[inventario.length];
        int numProductosUnicos = 0;
    
        for (int i = 0; i < inventario.length; i++) {
            boolean encontrado = false;
            for (int j = 0; j < numProductosUnicos; j++) {
                if (inventario[i].equalsIgnoreCase(productosUnicos[j])) {
                    cantidades[j]++;
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                productosUnicos[numProductosUnicos] = inventario[i];
                cantidades[numProductosUnicos] = 1;
                numProductosUnicos++;
            }
        }
    
        for (int i = 0; i < numProductosUnicos; i++) {
            System.out.println(productosUnicos[i] + " x" + cantidades[i]);
        }
    }    
}