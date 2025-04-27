package portillo_edwin_proyecto_tienda;
import java.util.Scanner;

public class Portillo_Edwin_Proyecto_Tienda {

    public static void main(String[] args) {
        
        //Declaración de variables y cambio del delimiter en la función scanner.next()
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        int opcion = 0;
        double efectivoIngresado = 0;
        double efectivoTotal = 0;
        
        //Menú de inicio
        System.out.println("Bienvenido a la Victitiendita :D!!!");

        // Bucle del menú principal que continua hasta que el usuario seleccione la opción 6
        while (opcion != 6) {
            System.out.println("Favor ingrese el número de la opción que desee elegir:");
            System.out.println("1. Abrir Caja");
            System.out.println("2. Ventas");
            System.out.println("3. Compras");
            System.out.println("4. Reportes");
            System.out.println("5. Cierre de Caja");
            System.out.println("6. Salir del Sistema");

            //Bucle de validación del dato ingresado por el usuario
            while (!scanner.hasNextInt()){
                System.out.println("Opción inválida. Ingrese un número entero:");
                scanner.next();
            }
            opcion = scanner.nextInt();

            //Opciones del menú mostrado previamente
            switch(opcion) {
                case 1:
                    System.out.println("Abrir caja seleccionado.");             
                    System.out.println("Ingrese la cantidad de efectivo en Lempiras que desea guardar en la caja:");
                    efectivoIngresado = scanner.nextDouble();
                    
                    // Bucle para asegurar que la cantidad ingresada sea válida
                    while (efectivoIngresado <= 0) {
                        System.out.println("Favor ingrese una cantidad de dinero válida (debe ser mayor que 0).");
                        efectivoIngresado = scanner.nextDouble();
                    }
                    
                    // Actualizar el total y mostrar los datos
                    efectivoTotal += efectivoIngresado;
                    System.out.println("Usted guardó Lps." + efectivoIngresado);
                    System.out.println("El efectivo total en caja es de Lps." + efectivoTotal);
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
                    System.out.println("Opción inválida.");
            }
        }
    }
}
