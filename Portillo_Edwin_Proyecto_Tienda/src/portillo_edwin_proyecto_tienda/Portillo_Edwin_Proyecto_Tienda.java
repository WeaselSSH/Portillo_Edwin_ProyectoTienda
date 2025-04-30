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
                        String tipoCliente, seguirComprando;
                        int codigoProducto, porcentajeDescuento, numeroFactura = 0, porcentajeISV = 7;
                        double descuento, precioTotal, isv, cantidadKilos = 0, precioSubtotal = 0;
                        
                        //Datos por producto
                        double kilosAzucarVendidos = 0, kilosAvenaVendidos = 0, kilosTrigoVendidos = 0, kilosMaizVendidos = 0;
                        double precioVentaAzucar = 30, precioVentaAvena = 25, precioVentaTrigo = 32, precioVentaMaiz = 20;
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
                        boolean continuarComprando = true;
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
                            
                            switch (codigoProducto){
                                case 1:
                                    if (tipoCliente.equals("C")) {
                                        System.out.println("El cliente tipo 'C' no puede comprar Azúcar");
                                    } else {
                                        System.out.println("Nombre del producto: Azúcar.");
                                        System.out.println("Precio unitario (kg): Lps." + precioVentaAzucar);
                                        //Pedir la cantidad de kilos a comprar y validar que sea mayor a 0
                                        while (cantidadKilos <= 0) {
                                            System.out.println("Ingrese la cantidad de kilos a comprar (debe ser mayor que 0):"); 
                                            while (!scanner.hasNextDouble()) {
                                                System.out.println("Opción inválida. Ingrese un número válido para los kilos:");
                                                scanner.next();
                                            }
                                            
                                            cantidadKilos = scanner.nextDouble();   
                                        }
                                        //Realizar cálculo de los precios y devolver la variable kilos a 0
                                        precioTotalAzucar += (cantidadKilos * precioVentaAzucar);
                                        kilosAzucarVendidos += cantidadKilos;
                                        precioSubtotal += (cantidadKilos * precioVentaAzucar);
                                        cantidadKilos = 0;
                                        //Preguntar si el cliente desea seguir comprando o no
                                        System.out.println("Si desea dejar de comprar productos presione 'N', de lo contrario presione cualquier otra tecla.");
                                        seguirComprando = scanner.next().strip();
                                        if(seguirComprando.equalsIgnoreCase("N")) {
                                            continuarComprando = false;
                                        }
                                    }  
                                    break;
                                
                                case 2:
                                    if (tipoCliente.equals("C")) {
                                        System.out.println("El cliente tipo 'C' no puede comprar Avena");
                                    } else {
                                        System.out.println("Nombre del producto: Avena.");
                                        System.out.println("Precio unitario (kg): Lps." + precioVentaAvena);
                                        //Pedir la cantidad de kilos a comprar y validar que sea mayor a 0
                                        while (cantidadKilos <= 0) {
                                            System.out.println("Ingrese la cantidad de kilos a comprar (debe ser mayor que 0):"); 
                                            while (!scanner.hasNextDouble()) {
                                                System.out.println("Opción inválida. Ingrese un número válido para los kilos:");
                                                scanner.next();
                                            }
                                            
                                            cantidadKilos = scanner.nextDouble();   
                                        }
                                        //Realizar cálculo de los precios y devolver la variable kilos a 0
                                        precioTotalAvena += (cantidadKilos * precioVentaAvena);
                                        kilosAvenaVendidos += cantidadKilos;
                                        precioSubtotal += (cantidadKilos * precioVentaAvena);
                                        cantidadKilos = 0;
                                        //Preguntar si el cliente desea seguir comprando o no
                                        System.out.println("Si desea dejar de comprar productos presione 'N', de lo contrario presione cualquier otra tecla.");
                                        seguirComprando = scanner.next().strip();
                                        if(seguirComprando.equalsIgnoreCase("N")) {
                                            continuarComprando = false;
                                        }
                                    }  
                                    break;
                                
                                case 3: 
                                    if (tipoCliente.equals("C")) {
                                        System.out.println("El cliente tipo 'C' no puede comprar Trigo");
                                    } else {
                                        System.out.println("Nombre del producto: Trigo.");
                                        System.out.println("Precio unitario (kg): Lps." + precioVentaTrigo);
                                        //Pedir la cantidad de kilos a comprar y validar que sea mayor a 0
                                        while (cantidadKilos <= 0) {
                                            System.out.println("Ingrese la cantidad de kilos a comprar (debe ser mayor que 0):"); 
                                            while (!scanner.hasNextDouble()) {
                                                System.out.println("Opción inválida. Ingrese un número válido para los kilos:");
                                                scanner.next();
                                            }
                                            
                                            cantidadKilos = scanner.nextDouble();   
                                        }
                                        //Realizar cálculo de los precios y devolver la variable kilos a 0
                                        precioTotalTrigo += (cantidadKilos * precioVentaTrigo);
                                        kilosTrigoVendidos += cantidadKilos;
                                        precioSubtotal += (cantidadKilos * precioVentaTrigo);
                                        cantidadKilos = 0;
                                        //Preguntar si el cliente desea seguir comprando o no
                                        System.out.println("Si desea dejar de comprar productos presione 'N', de lo contrario presione cualquier otra tecla.");
                                        seguirComprando = scanner.next().strip();
                                        if(seguirComprando.equalsIgnoreCase("N")) {
                                            continuarComprando = false;
                                        }
                                    }  
                                    break;
                                
                                case 4:
                                    if (tipoCliente.equals("B")) {
                                        System.out.println("El cliente tipo 'B' no puede comprar Maíz");
                                    } else {
                                        System.out.println("Nombre del producto: Maíz.");
                                        System.out.println("Precio unitario (kg): Lps." + precioVentaMaiz);
                                        //Pedir la cantidad de kilos a comprar y validar que sea mayor a 0
                                        while (cantidadKilos <= 0) {
                                            System.out.println("Ingrese la cantidad de kilos a comprar (debe ser mayor que 0):"); 
                                            while (!scanner.hasNextDouble()) {
                                                System.out.println("Opción inválida. Ingrese un número válido para los kilos:");
                                                scanner.next();
                                            }
                                            
                                            cantidadKilos = scanner.nextDouble();   
                                        }
                                        //Realizar cálculo de los precios y devolver la variable kilos a 0
                                        precioTotalMaiz += (cantidadKilos * precioVentaMaiz);
                                        kilosMaizVendidos += cantidadKilos;
                                        precioSubtotal += (cantidadKilos * precioVentaMaiz);
                                        cantidadKilos = 0;
                                        //Preguntar si el cliente desea seguir comprando o no
                                        System.out.println("Si desea dejar de comprar productos presione 'N', de lo contrario presione cualquier otra tecla.");
                                        seguirComprando = scanner.next().strip();
                                        if(seguirComprando.equalsIgnoreCase("N")) {
                                            continuarComprando = false;
                                        }
                                    }  
                                    break;
                                    
                                default:
                                    System.out.println("Código de producto inválido.");
                                    break;
                            }
                            
                            //Proceso de Facturación
                            if (!continuarComprando) {
                                numeroFactura += 1; 
                                System.out.println("-----Factura-----");
                                System.out.printf("Número de factura: %d\n", numeroFactura);
                                System.out.println("Productos comprados:" );

                                //Se verifica si el usuario compró dicho producto y en caso de haberlo comprado se despliega los datos.
                                if (kilosAzucarVendidos > 0) {
                                    System.out.printf("Azúcar: %.2f kg. | Precio unitario: Lps. %.2f | Precio total: Lps. %.2f\n", 
                                                    kilosAzucarVendidos, precioVentaAzucar, precioTotalAzucar);
                                }

                                if (kilosAvenaVendidos > 0) {
                                    System.out.printf("Avena: %.2f kg. | Precio unitario: Lps. %.2f | Precio total: Lps. %.2f\n", 
                                                    kilosAvenaVendidos, precioVentaAvena, precioTotalAvena);
                                }

                                if (kilosTrigoVendidos > 0) {
                                    System.out.printf("Trigo: %.2f kg. | Precio unitario: Lps. %.2f | Precio total: Lps. %.2f\n", 
                                                    kilosTrigoVendidos, precioVentaTrigo, precioTotalTrigo);
                                }

                                if (kilosMaizVendidos > 0) {
                                    System.out.printf("Maíz: %.2f kg. | Precio unitario: Lps. %.2f | Precio total: Lps. %.2f\n", 
                                                    kilosMaizVendidos, precioVentaMaiz, precioTotalMaiz);
                                }

                                System.out.printf("Subtotal a pagar: Lps. %.2f\n", precioSubtotal);

                                //Calculo del descuento, ISV y total a pagar
                                porcentajeDescuento = (precioSubtotal > 5000) ? 10 :
                                                      (precioSubtotal >= 1000) ? 5 : 0;

                                descuento = precioSubtotal * (porcentajeDescuento / 100.0);
                                isv = precioSubtotal * (porcentajeISV/100.0);
                                precioTotal = precioSubtotal - descuento + isv;

                                System.out.printf("Descuento aplicado: %d%% (Lps. %.2f)\n", porcentajeDescuento, descuento);
                                System.out.printf("ISV aplicado: %d%% (Lps. %.2f)\n", porcentajeISV, isv);
                                System.out.printf("Total a pagar: Lps. %.2f\n", precioTotal);
                                System.out.println("");

                                efectivoTotal += precioTotal; //Incremento del dinero en caja   

                            }
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
