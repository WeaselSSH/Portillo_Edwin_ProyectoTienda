package portillo_edwin_proyecto_tienda;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Portillo_Edwin_Proyecto_Tienda {

    public static void main(String[] args) {
        
        //Declaración de variables del menú inicio y abrir caja.
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        int opcion = 0;
        double efectivoIngresado = 0, efectivoTotal = 0;
        
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
            
            try { //Validar que el dato ingresado sea entero
                opcion = scanner.nextInt();
                
                switch(opcion) { //switch con las opciones mostradas previamente
                    case 1:
                        System.out.println("Abrir caja seleccionado.");             

                        // Bucle para asegurar que la cantidad ingresada sea válida
                        while (efectivoIngresado <= 0) {
                            System.out.println("Ingrese la cantidad de efectivo en Lempiras que desea guardar en la caja (debe ser mayor que 0):");

                            while (!scanner.hasNextDouble()){
                                System.out.println("Opción inválida. Ingrese un dato númerico:");
                                scanner.next();
                            }

                            efectivoIngresado = scanner.nextDouble();
                        }

                        // Actualizar el total y mostrar los datos
                        efectivoTotal += efectivoIngresado;
                        System.out.printf("Usted guardó Lps.%.2f\n", efectivoIngresado);
                        System.out.printf("El efectivo total en caja es de Lps.%.2f\n", efectivoTotal);
                        efectivoIngresado = 0;
                        break;

                    case 2:
                        //Variables principales
                        String tipoCliente, seguirComprando, nombreProducto = "";
                        int codigoProducto, porcentajeDescuento, numeroFactura = 0;
                        double descuento, precioTotal, isv, totalCompra, cantidadKilos = 0, precioSubtotal = 0, precioUnitario = 0;
                        boolean continuarComprando = true;
                        
                        //Datos por producto
                        double kilosAzucarVendidos = 0, kilosAvenaVendidos = 0, kilosTrigoVendidos = 0, kilosMaizVendidos = 0;
                        double precioTotalAzucar = 0, precioTotalAvena = 0, precioTotalTrigo = 0, precioTotalMaiz = 0;

                        System.out.println("Ventas seleccionado.");
                        System.out.println("Favor ingrese el tipo de cliente (A, B, C):");
                        tipoCliente = scanner.next().strip().toUpperCase();

                        //Validación para que la letra ingresada sea la correcta
                        while (!tipoCliente.equals("A") && !tipoCliente.equals("B") && !tipoCliente.equals("C")) {
                            System.out.println("Tipo de cliente inválido. Ingrese 'A', 'B' o 'C':");
                            tipoCliente = scanner.next().strip().toUpperCase();
                        }

                        //Bucle de compra
                        while (continuarComprando) {
                            System.out.println("Ingrese el código del producto a comprar:");
                            System.out.println("1. Azúcar");
                            System.out.println("2. Avena");
                            System.out.println("3. Trigo");
                            System.out.println("4. Maíz");

                            //Validación para que el código seleccionado sea válido
                            while (!scanner.hasNextInt()) {
                                System.out.println("Opción inválida. Ingrese un código de producto válido:");
                                scanner.next();
                            }
                            codigoProducto = scanner.nextInt();
                            
                            boolean permitido = true;
                            switch (codigoProducto){
                                case 1:
                                    if(tipoCliente.equals("C")) {
                                        System.out.println("Cliente 'C' no puede comprar azúcar.");
                                        permitido = false;
                                    } else {
                                        nombreProducto = "Azúcar";
                                        precioUnitario = 30;
                                    }
                                    break;
                                
                                case 2:
                                    if(tipoCliente.equals("C")) {
                                        System.out.println("Cliente 'C' no puede comprar avena.");
                                        permitido = false;
                                    } else {
                                        nombreProducto = "Avena";
                                        precioUnitario = 25;
                                    }
                                    break;
                                
                                case 3: 
                                    if(tipoCliente.equals("C")) {
                                        System.out.println("Cliente 'C' no puede comprar trigo.");
                                        permitido = false;
                                    } else {
                                        nombreProducto = "Trigo";
                                        precioUnitario = 32;
                                    }
                                    break;
                                
                                case 4:
                                    if(tipoCliente.equals("B")) {
                                        System.out.println("Cliente 'B' no puede comprar maíz.");
                                        permitido = false;
                                    } else {
                                        nombreProducto = "Maíz";
                                        precioUnitario = 20;
                                    }
                                    break; 
                                    
                                default:
                                    System.out.println("Código de producto inválido.");
                                    permitido = false;
                                    break;
                            }
                            
                            //Proceso de Facturación
                            if (permitido) {
                                System.out.printf("Nombre del producto: %s\n", nombreProducto);
                                System.out.printf("Precio unitario (kg): Lps. %.2f\n", precioUnitario);
                                
                                while (cantidadKilos <= 0){
                                    System.out.println("Ingrese la cantidad de kilos a comprar (debe ser mayor que 0):\n");
                                    while (!scanner.hasNextDouble()) {
                                        System.out.println("Valor inválido. Ingrese solo datos numéricos:");
                                        scanner.next();
                                    }
                                    
                                    cantidadKilos = scanner.nextDouble();                                   
                                }
                                
                                totalCompra = cantidadKilos * precioUnitario;
                                precioSubtotal += totalCompra;
                                
                                switch (codigoProducto) {
                                    case 1: 
                                        kilosAzucarVendidos += cantidadKilos;
                                        precioTotalAzucar += totalCompra;
                                        break;
                                    case 2: 
                                        kilosAvenaVendidos += cantidadKilos;
                                        precioTotalAvena += totalCompra;
                                        break;
                                    case 3: 
                                        kilosTrigoVendidos += cantidadKilos;
                                        precioTotalTrigo += totalCompra;
                                        break;
                                    case 4: 
                                        kilosTrigoVendidos += cantidadKilos;
                                        precioTotalTrigo += totalCompra;
                                        break;
                                }
                                
                                cantidadKilos = 0;
                                System.out.println("¿Desea seguir comprando? (Presione 'N' para salir, cualquier otra tecla para continuar):");
                                seguirComprando = scanner.next().strip();
                                if (seguirComprando.equalsIgnoreCase("N")) continuarComprando = false;       
                            }                            
                        }
                        
                        if (precioSubtotal > 0) {
                            numeroFactura ++;
                            System.out.println("-------Factura-------\n");
                            System.out.printf("No. Factura: %d\n", numeroFactura);
                            
                            if (kilosAzucarVendidos > 0)
                                System.out.printf("Azúcar: %.2f kg | Precio Unitario: Lps. 30.00 | Total: Lps. %.2f\n", kilosAzucarVendidos, precioTotalAzucar);
                            if (kilosAvenaVendidos > 0)
                                System.out.printf("Avena: %.2f kg | Precio Unitario: Lps. 25.00 | Total: Lps. %.2f\n", kilosAvenaVendidos, precioTotalAvena);
                            if (kilosTrigoVendidos > 0)
                                System.out.printf("Trigo: %.2f kg | Precio Unitario: Lps. 32.00 | Total: Lps. %.2f\n", kilosTrigoVendidos, precioTotalTrigo);
                            if (kilosMaizVendidos > 0)
                                    System.out.printf("Maíz: %.2f kg | Precio Unitario: Lps. 20.00 | Total: Lps. %.2f\n", kilosMaizVendidos, precioTotalMaiz);
                            
                            System.out.printf("Subtotal: Lps. %.2f\n", precioSubtotal);
                            
                            porcentajeDescuento = (precioSubtotal > 5000) ? 10 : 
                                                  (precioSubtotal >= 1000) ? 5 : 0;
                            descuento = precioSubtotal * (porcentajeDescuento / 100.0);
                            isv = precioSubtotal * 0.07;
                            precioTotal = precioSubtotal - descuento + isv;
                            
                            System.out.printf("Descuento: %d%% (Lps. %.2f)\n", porcentajeDescuento, descuento);
                            System.out.printf("ISV: 7%% (Lps. %.2f)\n", isv);
                            System.out.printf("Total a pagar: %.2f\n", precioTotal);
                        } else {
                            System.out.println("No se realizaron compras.");
                        }

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
            } catch (InputMismatchException e) {
                System.out.println("Opción inválida. Favor ingresar unicamente números enteros.");
                scanner.next();
            }
        }    
    }
}