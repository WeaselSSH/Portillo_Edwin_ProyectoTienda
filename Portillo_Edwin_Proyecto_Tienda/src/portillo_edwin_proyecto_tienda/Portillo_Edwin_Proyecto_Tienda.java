package portillo_edwin_proyecto_tienda;
import java.util.Scanner;

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
                    System.out.println("Usted guardó Lps." + efectivoIngresado);
                    System.out.println("El efectivo total en caja es de Lps." + efectivoTotal);
                    efectivoIngresado = 0;
                    break;
                
                case 2:
                    //Declaración de variables para venta de productos
                    String tipoCliente, seguirComprando;
                    int codigoProducto = 0, numeroFactura = 0, porcentajeDescuento = 0, porcentajeISV = 7;
                    double cantidadKilos = 0, precioTotal = 0, precioSubtotal = 0, descuento = 0, isv = 0;
                    double kilosAzucarComprados = 0, kilosAvenaComprados = 0, kilosTrigoComprados = 0, kilosMaizComprados = 0;
                    double precioVentaAzucar = 30, precioVentaAvena = 25, precioVentaTrigo = 32, precioVentaMaiz = 20;
                    double precioTotalAzucar = 0, precioTotalAvena = 0, precioTotalTrigo = 0, precioTotalMaiz = 0;
                    
                    
                    System.out.println("Ventas seleccionado.");
                    
                    System.out.println("Favor ingrese el tipo de cliente (A, B, C):");
                    tipoCliente = scanner.next().strip();
                    
                    //Validación para que la letra ingresada sea la correcta
                    while (!tipoCliente.equalsIgnoreCase("A") && !tipoCliente.equalsIgnoreCase("B") && !tipoCliente.equalsIgnoreCase("C")) {
                        System.out.println("Tipo de cliente inválido. Ingrese 'A', 'B' o 'C':");
                        tipoCliente = scanner.next().strip();
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
                        
                        //Switch-case acorde al tipo del cliente
                        switch (tipoCliente) {
                            case "A":
                                switch (codigoProducto) {
                                    case 1: 
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
                                        kilosAzucarComprados += cantidadKilos;
                                        precioSubtotal += (cantidadKilos * precioVentaAzucar);
                                        cantidadKilos = 0;
                                        
                                        //Preguntar si el cliente desea seguir comprando o no
                                        System.out.println("Si desea dejar de comprar productos presione 'N', de lo contrario presione cualquier otra tecla.");
                                        seguirComprando = scanner.next().strip();
                                        
                                        if(seguirComprando.equalsIgnoreCase("N")) {
                                            continuarComprando = false;
                                        } 
                                        
                                        break;
                                        
                                    case 2: 
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
                                        kilosAvenaComprados += cantidadKilos;
                                        precioSubtotal += (cantidadKilos * precioVentaAvena);
                                        cantidadKilos = 0;
                                        
                                        //Preguntar si el cliente desea seguir comprando o no
                                        System.out.println("Si desea dejar de comprar productos presione 'N', de lo contrario presione cualquier otra tecla.");
                                        seguirComprando = scanner.next().strip();
                                        
                                        if(seguirComprando.equalsIgnoreCase("N")) {
                                            continuarComprando = false;
                                        } 
                                        
                                        break;
                                    
                                    case 3: 
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
                                        kilosTrigoComprados += cantidadKilos;
                                        precioSubtotal += (cantidadKilos * precioVentaTrigo);
                                        cantidadKilos = 0;
                                        
                                        //Preguntar si el cliente desea seguir comprando o no
                                        System.out.println("Si desea dejar de comprar productos presione 'N', de lo contrario presione cualquier otra tecla.");
                                        seguirComprando = scanner.next().strip();
                                        
                                        if(seguirComprando.equalsIgnoreCase("N")) {
                                            continuarComprando = false;
                                        } 
                                        
                                        break;
                                    
                                    case 4: 
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
                                        kilosMaizComprados += cantidadKilos;
                                        precioSubtotal += (cantidadKilos * precioVentaMaiz);
                                        cantidadKilos = 0;
                                        
                                        //Preguntar si el cliente desea seguir comprando o no
                                        System.out.println("Si desea dejar de comprar productos presione 'N', de lo contrario presione cualquier otra tecla.");
                                        seguirComprando = scanner.next().strip();
                                        
                                        if(seguirComprando.equalsIgnoreCase("N")) {
                                            continuarComprando = false;
                                        } 
                                        
                                        break;
                                        
                                    default: 
                                        System.out.println("Producto no encontrado.");
                                }
                                break;
                            
                            case "B":
                                switch (codigoProducto) {
                                    case 1: 
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
                                        kilosAzucarComprados += cantidadKilos;
                                        precioSubtotal += (cantidadKilos * precioVentaAzucar);
                                        cantidadKilos = 0;
                                        
                                        //Preguntar si el cliente desea seguir comprando o no
                                        System.out.println("Si desea dejar de comprar productos presione 'N', de lo contrario presione cualquier otra tecla.");
                                        seguirComprando = scanner.next().strip();
                                        
                                        if(seguirComprando.equalsIgnoreCase("N")) {
                                            continuarComprando = false;
                                        } 
                                        
                                        break;
                                        
                                    case 2: 
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
                                        kilosAvenaComprados += cantidadKilos;
                                        precioSubtotal += (cantidadKilos * precioVentaAvena);
                                        cantidadKilos = 0;
                                        
                                        //Preguntar si el cliente desea seguir comprando o no
                                        System.out.println("Si desea dejar de comprar productos presione 'N', de lo contrario presione cualquier otra tecla.");
                                        seguirComprando = scanner.next().strip();
                                        
                                        if(seguirComprando.equalsIgnoreCase("N")) {
                                            continuarComprando = false;
                                        } 
                                        
                                        break;
                                    
                                    case 3: 
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
                                        kilosTrigoComprados += cantidadKilos;
                                        precioSubtotal += (cantidadKilos * precioVentaTrigo);
                                        cantidadKilos = 0;
                                        
                                        //Preguntar si el cliente desea seguir comprando o no
                                        System.out.println("Si desea dejar de comprar productos presione 'N', de lo contrario presione cualquier otra tecla.");
                                        seguirComprando = scanner.next().strip();
                                        
                                        if(seguirComprando.equalsIgnoreCase("N")) {
                                            continuarComprando = false;
                                        } 
                                        
                                        break;
                                    
                                    case 4:
                                        System.out.println("El cliente tipo B no puede comprar maíz.");
                                        break;
                                        
                                    default: 
                                        System.out.println("Producto no encontrado.");
                                }
                                break;
                            
                            case "C":
                                switch (codigoProducto) {
                                    case 1: 
                                        System.out.println("El cliente tipo C no puede comprar azúcar.");
                                        break;
                                        
                                    case 2:
                                        System.out.println("El cliente tipo C no puede comprar avena.");
                                        break;
                                    
                                    case 3:
                                        System.out.println("El cliente tipo C no puede comprar trigo.");
                                        break;
                                    
                                    case 4: 
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
                                        kilosMaizComprados += cantidadKilos;
                                        precioSubtotal += (cantidadKilos * precioVentaMaiz);
                                        cantidadKilos = 0;
                                        
                                        //Preguntar si el cliente desea seguir comprando o no
                                        System.out.println("Si desea dejar de comprar productos presione 'N', de lo contrario presione cualquier otra tecla.");
                                        seguirComprando = scanner.next().strip();
                                        
                                        if(seguirComprando.equalsIgnoreCase("N")) {
                                            continuarComprando = false;
                                        } 
                                        
                                        break;
                                        
                                    default: 
                                        System.out.println("Producto no encontrado.");
                                }
                                break;
                            
                        }
                        
                        //Proceso de Facturación
                        if (!continuarComprando) {
                            numeroFactura += 1; 
                            System.out.println("-----Factura-----");
                            System.out.printf("Número de factura: %d\n", numeroFactura);
                            System.out.println("Productos comprados:" );
                        
                            //Se verifica si el usuario compró dicho producto y en caso de haberlo comprado se despliega los datos.
                            if (kilosAzucarComprados > 0) {
                                System.out.printf("Azúcar: %.2f kg. | Precio unitario: Lps. %.2f | Precio total: Lps. %.2f\n", 
                                                kilosAzucarComprados, precioVentaAzucar, precioTotalAzucar);
                            }
                        
                            if (kilosAvenaComprados > 0) {
                                System.out.printf("Avena: %.2f kg. | Precio unitario: Lps. %.2f | Precio total: Lps. %.2f\n", 
                                                kilosAvenaComprados, precioVentaAvena, precioTotalAvena);
                            }
                        
                            if (kilosTrigoComprados > 0) {
                                System.out.printf("Trigo: %.2f kg. | Precio unitario: Lps. %.2f | Precio total: Lps. %.2f\n", 
                                                kilosTrigoComprados, precioVentaTrigo, precioTotalTrigo);
                            }
                        
                            if (kilosMaizComprados > 0) {
                                System.out.printf("Maíz: %.2f kg. | Precio unitario: Lps. %.2f | Precio total: Lps. %.2f\n", 
                                                kilosMaizComprados, precioVentaMaiz, precioTotalMaiz);
                            }
                        
                            System.out.printf("Subtotal a pagar: Lps. %.2f\n", precioSubtotal);
                        
                            //Calculo del descuento, ISV y total a pagar
                            if (precioSubtotal > 5000){
                                porcentajeDescuento = 10;
                            } else if (precioSubtotal >= 1000) {
                                porcentajeDescuento = 5;
                            } else {
                                porcentajeDescuento = 0;
                            }
                        
                            descuento = precioSubtotal * (porcentajeDescuento / 100.0);
                            isv = precioSubtotal * (porcentajeISV/100.0);
                            precioTotal = precioSubtotal - descuento + isv;
                        
                            System.out.printf("Descuento aplicado: %d%% (Lps. %.2f)\n", porcentajeDescuento, descuento);
                            System.out.printf("ISV aplicado: %d%% (Lps. %.2f)\n", porcentajeISV, isv);
                            System.out.printf("Total a pagar: Lps. %.2f\n", precioTotal);
                        
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
        }
    }
}
