public class Main {
    static void mostrarListaProd(String[] inventario) {
        for (int i = 0; i < inventario.length; i++) {
            System.out.println(inventario[i]);
        }
    }
    public static void main(String[] args) {
        String[] inventario = {"Ordinador", "Taula", "Cadira", "Llapis", "Goma"};
        mostrarListaProd(inventario);
        
    }
}