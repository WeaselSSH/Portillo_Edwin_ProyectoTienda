package portillo_edwin_proyecto_tienda;
import java.util.Scanner;

public class Portillo_Edwin_Proyecto_Tienda {

    public static void main(String[] args) {
        //Declaración de variables
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        
        //Página de inicio
        System.out.println("Bienvenido a la Victitiendita :D!!!");
        
        while (opcion != 6) {
            System.out.println("Favor ingrese el número de la opción que desee elegir:");
            System.out.println("1. Abrir Caja");
            System.out.println("2. Ventas");
            System.out.println("3. Compras");
            System.out.println("4. Reportes");
            System.out.println("5. Cierre de Caja");
            System.out.println("6. Salir del Sistema");
            
            opcion = scanner.nextInt();
            
            switch(opcion) {
                case 1:
                    System.out.println("Abrir caja seleccionado");
                    break;
                case 2:
                    System.out.println("Ventas seleccionado");
                    break;
                case 3:
                    System.out.println("Compras seleccionado");
                    break;
                case 4:
                    System.out.println("Reportes seleccionado");
                    break;
                case 5: 
                    System.out.println("Cierre de caja seleccionado");
                    break;
                case 6: 
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Favor intente de nuevo.");
            }
        }
        
    }
}
