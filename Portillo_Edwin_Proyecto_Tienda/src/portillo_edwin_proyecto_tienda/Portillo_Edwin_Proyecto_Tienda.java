package Portillo_Edwin_Proyecto_Tienda;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Portillo_Edwin_Proyecto_Tienda {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        //Declaración de variables del menú inicio y abrir caja
        int opcion = 0;
        double efectivoIngresado = 0, efectivoTotal = 0;

        //Declaración de variable compra y venta
        String seguirComprando, nombreProducto = "";
        int codigoProducto, porcentajeDescuento;
        double stockAzucar = 5, stockAvena = 0, stockTrigo = 0, stockMaiz = 0;
        double descuento, precioTotal, isv, totalCompra, cantidadKilos = 0, precioSubtotal = 0, precioUnitario = 0;
        boolean continuarComprando, cajaAbierta = false;
        double precioTotalAzucar = 0, precioTotalAvena = 0, precioTotalTrigo = 0, precioTotalMaiz = 0;

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
                            System.out.println("Favor ingrese la cantidad de efectivo en Lempiras que desea guardar en la caja (debe ser mayor que 0):");

                            try{
                                efectivoIngresado = scanner.nextDouble();
                            } catch (InputMismatchException e) {
                                System.out.println("Opción inválida.");
                                scanner.next();
                            }

                        }

                        // Actualizar el total y mostrar los datos
                        efectivoTotal += efectivoIngresado;
                        System.out.printf("Usted guardó Lps.%.2f\n", efectivoIngresado);
                        System.out.printf("El efectivo total en caja es de Lps.%.2f\n", efectivoTotal);
                        efectivoIngresado = 0;
                        cajaAbierta = true;
                        break;

                    case 2:
                        //Verificación que haya efectivo en caja
                        if (!cajaAbierta) {
                            System.out.println("Debe depositar efectivo en caja antes de realizar ventas.");
                            break;
                        }
                        
                        if (stockAzucar <= 0 && stockAvena <= 0 && stockTrigo <= 0 && stockMaiz <= 0) {
                            System.out.println("No hay productos en stock.");
                            break;
                        }

                        //Variables principales
                        String tipoCliente;
                        int numeroFacturaVentas = 0;
                        double stockDisponible = 0;

                        //Datos por producto
                        double kilosAzucarVendidos = 0, kilosAvenaVendidos = 0, kilosTrigoVendidos = 0, kilosMaizVendidos = 0;

                        System.out.println("Ventas seleccionado.");
                        System.out.println("Favor ingrese el tipo de cliente (A, B, C):");
                        tipoCliente = scanner.next().strip().toUpperCase();

                        //Validación para que la letra ingresada sea la correcta
                        while (!tipoCliente.equals("A") && !tipoCliente.equals("B") && !tipoCliente.equals("C")) {
                            System.out.println("Tipo de cliente inválido. Ingrese 'A', 'B' o 'C':");
                            tipoCliente = scanner.next().strip().toUpperCase();
                        }

                        //Bucle de compra
                        continuarComprando = true;
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
                                    if (tipoCliente.equals("C")) {
                                        System.out.println("Cliente 'C' no puede comprar azúcar.");
                                        permitido = false;
                                    } else if (stockAzucar <= 0) {
                                        System.out.println("No hay azúcar en stock.");
                                        permitido = false;
                                    } else {
                                        nombreProducto = "Azúcar";
                                        precioUnitario = 30;
                                        stockDisponible = stockAzucar;
                                    }
                                    break;

                                case 2:
                                    if (tipoCliente.equals("C")) {
                                        System.out.println("Cliente 'C' no puede comprar avena.");
                                        permitido = false;
                                    } else if (stockAvena <= 0) {
                                        System.out.println("No hay avena en stock.");
                                        permitido = false;
                                    } else {
                                        nombreProducto = "Avena";
                                        precioUnitario = 25;
                                        stockDisponible = stockAvena;
                                    }
                                    break;

                                case 3:
                                    if (tipoCliente.equals("C")) {
                                        System.out.println("Cliente 'C' no puede comprar trigo.");
                                        permitido = false;
                                    } else if (stockTrigo <= 0) {
                                        System.out.println("No hay trigo en stock.");
                                        permitido = false;
                                    } else {
                                        nombreProducto = "Trigo";
                                        precioUnitario = 32;
                                        stockDisponible = stockTrigo;
                                    }
                                    break;

                                case 4:
                                    if (tipoCliente.equals("B")) {
                                        System.out.println("Cliente 'B' no puede comprar maíz.");
                                        permitido = false;
                                    } else if (stockAvena <= 0) {
                                        System.out.println("No hay maíz en stock.");
                                        permitido = false;
                                    } else {
                                        nombreProducto = "Maíz";
                                        precioUnitario = 20;
                                        stockDisponible = stockMaiz;
                                    }
                                    break;
                                default:
                                    System.out.println("Código de producto inválido.");
                                    permitido = false;
                                    break;
                            }

                            if (permitido) {
                                System.out.printf("Nombre del producto: %s\n", nombreProducto);
                                System.out.printf("Precio unitario (kg): Lps. %.2f\n", precioUnitario);

                                while (cantidadKilos <= 0 || cantidadKilos > stockDisponible){
                                    System.out.println("Ingrese la cantidad de kilos a comprar:");
                                    
                                    while (!scanner.hasNextDouble()) {
                                        System.out.println("Valor inválido. Favor ingrese solo datos numéricos:");
                                        scanner.next();
                                    }
                                    cantidadKilos = scanner.nextDouble();
                                    
                                    if (cantidadKilos <= 0) {
                                        System.out.println("Error: La cantidad debe ser mayor a 0.");
                                    } else if (cantidadKilos > stockDisponible) {
                                        System.out.println(String.format("No hay suficiente %s. Stock actual: %.2f kg", nombreProducto, stockDisponible));
                                    }
                                }

                                totalCompra = cantidadKilos * precioUnitario;
                                precioSubtotal += totalCompra;

                                switch (codigoProducto) {
                                    case 1:
                                        kilosAzucarVendidos += cantidadKilos;
                                        precioTotalAzucar += totalCompra;
                                        stockAzucar -= cantidadKilos;
                                        break;
                                    case 2:
                                        kilosAvenaVendidos += cantidadKilos;
                                        precioTotalAvena += totalCompra;
                                        stockAvena -= cantidadKilos;
                                        break;
                                    case 3:
                                        kilosTrigoVendidos += cantidadKilos;
                                        precioTotalTrigo += totalCompra;
                                        stockTrigo -= cantidadKilos;
                                        break;
                                    case 4:
                                        kilosMaizVendidos += cantidadKilos;
                                        precioTotalMaiz += totalCompra;
                                        stockMaiz -= cantidadKilos;
                                        break;
                                }

                                cantidadKilos = 0;
                                System.out.println("¿Desea seguir comprando? (Presione 'N' para salir, cualquier otra tecla para continuar):");
                                seguirComprando = scanner.next().strip();
                                if (seguirComprando.equalsIgnoreCase("N")) continuarComprando = false;
                            }
                        }

                        if (precioSubtotal > 0) {
                            numeroFacturaVentas ++;
                            System.out.println("-------Factura-------\n");
                            System.out.printf("No. Factura: %d\n", numeroFacturaVentas);

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
                            efectivoTotal += precioTotal;

                            System.out.printf("Descuento: %d%% (Lps. %.2f)\n", porcentajeDescuento, descuento);
                            System.out.printf("ISV: 7%% (Lps. %.2f)\n", isv);
                            System.out.printf("Total a pagar: %.2f\n", precioTotal);
                        } else {
                            System.out.println("No se realizaron compras.");
                        }

                        break;

                    case 3:
                        //Verificación que haya efectivo en caja
                        if (!cajaAbierta) {
                            System.out.println("Debe depositar efectivo en caja antes de realizar compras.");
                            break;
                        }
                        
                        if (efectivoTotal <= 0) {
                            System.out.println("No hay efectivo en caja.");
                            break;
                        }
                        //Variables principales
                        String tipoProveedor;
                        int numeroFacturaProveedor = 0;

                        //Datos por producto
                        double kilosAzucarComprados = 0, kilosAvenaComprados = 0, kilosTrigoComprados = 0, kilosMaizComprados = 0;

                        System.out.println("Compras seleccionado.");
                        System.out.println("Favor ingrese el tipo de proveedor (A, B, C):");
                        tipoProveedor = scanner.next().strip().toUpperCase();

                        //Validación para que la letra ingresada sea la correcta
                        while (!tipoProveedor.equals("A") && !tipoProveedor.equals("B") && !tipoProveedor.equals("C")) {
                            System.out.println("Tipo de proveedor inválido. Ingrese 'A', 'B' o 'C':");
                            tipoProveedor = scanner.next().strip().toUpperCase();
                        }

                        //Bucle de compra
                        continuarComprando = true;
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
                                    if(tipoProveedor.equals("B") || tipoProveedor.equals("C")) {
                                        System.out.println("Solo el proveedor tipo 'A' puede vender azúcar.");
                                        permitido = false;
                                    } else {
                                        nombreProducto = "Azúcar";
                                        precioUnitario = 30;
                                    }
                                    break;

                                case 2:
                                    if(tipoProveedor.equals("A")) {
                                        System.out.println("Proveedor 'A' no puede comprar avena.");
                                        permitido = false;
                                    } else {
                                        nombreProducto = "Avena";
                                        precioUnitario = 25;
                                    }
                                    break;

                                case 3:
                                    if(tipoProveedor.equals("C") || tipoProveedor.equals("A")) {
                                        System.out.println("Solo el proveedor tipo 'B' puede vender trigo.");
                                        permitido = false;
                                    } else {
                                        nombreProducto = "Trigo";
                                        precioUnitario = 32;
                                    }
                                    break;

                                case 4:
                                    if(tipoProveedor.equals("B") || tipoProveedor.equals("C")) {
                                        System.out.println("Solo el proveedor tipo 'A' puede vender maíz.");
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
                                        kilosAzucarComprados += cantidadKilos;
                                        precioTotalAzucar += totalCompra;
                                        break;
                                    case 2:
                                        kilosAvenaComprados += cantidadKilos;
                                        precioTotalAvena += totalCompra;
                                        break;
                                    case 3:
                                        kilosTrigoComprados += cantidadKilos;
                                        precioTotalTrigo += totalCompra;
                                        break;
                                    case 4:
                                        kilosMaizComprados += cantidadKilos;
                                        precioTotalMaiz += totalCompra;
                                        break;
                                }

                                cantidadKilos = 0;
                                continuarComprando = false;
                            }
                        }

                        if (precioSubtotal > 0) {                          
                            isv = precioSubtotal * 0.07;
                            precioTotal = precioSubtotal + isv;
                            
                            if (efectivoTotal < precioTotal) {
                                System.out.println("Error: no hay efectivo suficiento en caja.");
                                break;
                            }
                            
                            numeroFacturaProveedor ++;
                            System.out.println("-------Factura-------\n");
                            System.out.printf("No. Factura: %d\n", numeroFacturaProveedor);

                            if (kilosAzucarComprados > 0)
                                System.out.printf("Azúcar: %.2f kg | Precio Unitario: Lps. 30.00 | Total: Lps. %.2f\n", kilosAzucarComprados, precioTotalAzucar);
                            if (kilosAvenaComprados > 0)
                                System.out.printf("Avena: %.2f kg | Precio Unitario: Lps. 25.00 | Total: Lps. %.2f\n", kilosAvenaComprados, precioTotalAvena);
                            if (kilosTrigoComprados > 0)
                                System.out.printf("Trigo: %.2f kg | Precio Unitario: Lps. 32.00 | Total: Lps. %.2f\n", kilosTrigoComprados, precioTotalTrigo);
                            if (kilosMaizComprados > 0)
                                System.out.printf("Maíz: %.2f kg | Precio Unitario: Lps. 20.00 | Total: Lps. %.2f\n", kilosMaizComprados, precioTotalMaiz);

                            System.out.printf("Subtotal: Lps. %.2f\n", precioSubtotal);
                            System.out.printf("ISV: 7%% (Lps. %.2f)\n", isv);
                            System.out.printf("Total a pagar: %.2f\n", precioTotal);
                            
                            efectivoTotal -= precioTotal;
                            
                        } else {
                            System.out.println("No se realizaron compras.");
                        }

                        break;

                    case 4:
                        //Verificación que haya efectivo en caja
                        if (!cajaAbierta) {
                            System.out.println("Debe depositar efectivo en caja antes de crear un reporte.");
                            break;
                        }
                        System.out.println("Reportes seleccionado");
                        break;

                    case 5:
                        //Verificación que haya efectivo en caja
                        if (!cajaAbierta) {
                            System.out.println("Debe depositar efectivo en caja antes de cerrar caja.");
                            break;
                        }
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
