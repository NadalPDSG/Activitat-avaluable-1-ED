import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = true;
        String[] inventario = {"Ordinador", "Taula", "Cadira", "Llapis", "Goma"};
        while (salir) {
            System.out.println("1) Mostrar lista de productos.");
            System.out.println("2) Eliminar producto por posición.");
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
            }
        }
    }

    static void mostrarListaProd(String[] inventario) {
        for (int i = 0; i < inventario.length; i++) {
            System.out.println(inventario[i]);
        }
    }

    static void eliminarProdPos(String[] inventario) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Que posición deseaas eliminar? ");
        int pos = sc.nextInt();
        inventario[pos] = "";
    }
}