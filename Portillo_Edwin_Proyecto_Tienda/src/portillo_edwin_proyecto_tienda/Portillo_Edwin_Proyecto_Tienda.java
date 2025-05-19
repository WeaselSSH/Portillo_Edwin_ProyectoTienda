package portillo_edwin_proyecto_tienda;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Portillo_Edwin_Proyecto_Tienda {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n"); //se usa como delimiter \n con el fin que scanner.next() pueda leer más alla de los espacios

        // Variables relacionadas al control general del sistema
        boolean cajaAbierta = false, cajaAbiertaAntes = false;

        int opcion = 0;
        double efectivoIngresado = 0, efectivoTotal = 0, efectivoDepositado = 0;

        // Variables para operaciones de compra y venta
        String seguirComprando, nombreProducto = "", cerrarCaja;
        boolean continuarComprando;

        int codigoProducto, porcentajeDescuento, numeroFacturaVentas = 0, numeroFacturaProveedor = 0;
        double descuento, precioTotal, isv, totalCompra, cantidadKilos, precioSubtotal, precioUnitario = 0;
        double precioTotalAzucar, precioTotalAvena, precioTotalTrigo, precioTotalMaiz;
        double inventarioAzucar = 10, inventarioAvena = 0, inventarioTrigo = 0, inventarioMaiz = 0;

        //Menú de inicio
        System.out.println();
        System.out.println("+-------------------------------------+");
        System.out.println("|   BIENVENIDO A LA VICTITIENDITA!    |");
        System.out.println("+-------------------------------------+");

        // Bucle del menú principal que continua hasta que el usuario seleccione la opción 6
        while (opcion != 6) {
            Thread.sleep(500); //uso de Thread.sleep() con el fin que el usuario sea capaz de ver los outputs de una forma más amigable
            System.out.println();
            System.out.println("+-------------------------------------+");
            System.out.println("|         === MENU PRINCIPAL ===      |");
            System.out.println("+-------------------------------------+");
            System.out.println("| 1. Abrir Caja                       |");
            System.out.println("| 2. Ventas                           |");
            System.out.println("| 3. Compras                          |");
            System.out.println("| 4. Reporte                          |");
            System.out.println("| 5. Cierre de Caja                   |");
            System.out.println("| 6. Salir del Sistema                |");
            System.out.println("+-------------------------------------+");
            System.out.println();
            System.out.print(">> Seleccione una opción [1-6]: ");

            try { //Validar que el dato ingresado sea numerico 
                opcion = scanner.nextInt();

                switch (opcion) { //switch con las opciones mostradas previamente
                    case 1:
                        efectivoIngresado = 0; //reinicio de variable
                        
                        Thread.sleep(500);
                        System.out.println();
                        System.out.println("+-------------------------------------+");
                        System.out.println("|           === ABRIR CAJA ===        |");
                        System.out.println("+-------------------------------------+");
                        
                        if (cajaAbiertaAntes) { //verificar si la caja ha sido abierta previamente
                            System.out.println();
                            System.out.println(">> Caja abierta exitosamente.");
                            cajaAbiertaAntes = false;
                            cajaAbierta = true;
                            break;
                        }

                        while (efectivoIngresado <= 0) {
                            
                            if (!cajaAbierta) { //mostrar el mensaje solo si se abre caja por primera vez
                            System.out.println();
                            System.out.println(">> Caja abierta exitosamente.");
                            }
                            
                            System.out.println();
                            System.out.print(">> Ingrese la cantidad de efectivo a guardar (Lps): ");

                            try { //Validar que sea un valor de tipo númerico el ingresado
                                efectivoIngresado = scanner.nextDouble();

                                if (efectivoIngresado <= 0) {
                                    System.out.println();
                                    System.out.println(">> Error: la cantidad debe ser mayor a 0.");
                                }

                            } catch (InputMismatchException e) {
                                System.out.println();
                                System.out.println(">> Error: Solo se aceptan datos númericos. Intente nuevamente");
                                scanner.next();
                            }
                        }

                        // Actualizar el efectivo total en caja y mostrar los datos
                        efectivoTotal += efectivoIngresado;
                        Thread.sleep(500);
                        System.out.println();
                        System.out.println("+-------------------------------------+");
                        System.out.printf("| %-20s Lps.%10.2f |\n", "Usted guardó:", efectivoIngresado);
                        System.out.printf("| %-20s Lps.%10.2f |\n", "Total en caja:", efectivoTotal);
                        System.out.println("+-------------------------------------+");
                        /*se usa -20s para que exista 20 espacios de diferencia entre el texto y el valor. 
                        También se usa 10.2f con el objetivo que si el valor del efectivo ingresado es muy 
                        grande el cuadro quede simétrico de igual forma, gracias a los 10 espacios reservados.
                         */

                        efectivoIngresado = 0;
                        cajaAbierta = true;
                        break;

                    case 2:

                        //Verificación que haya inventario y que caja esta esté abierta
                        if (!cajaAbierta) {
                            System.out.println();
                            System.out.println(">> Error: No puede realizar ventas.");
                            System.out.println();
                            System.out.println(">> La caja no ha sido abierta aún.");
                            break;
                        }

                        if (inventarioAzucar <= 0 && inventarioAvena <= 0 && inventarioTrigo <= 0 && inventarioMaiz <= 0) {
                            System.out.println();
                            System.out.println(">> Error: No hay productos disponibles.");
                            System.out.println();
                            System.out.println(">> Todos los productos están agotados.");
                            break;
                        }

                        //Variables generales
                        String tipoCliente;
                        double inventarioDisponible = 0;

                        //Variables relacionadas a los datos de producto
                        double kilosAzucarVendidos = 0,
                         kilosAvenaVendidos = 0,
                         kilosTrigoVendidos = 0,
                         kilosMaizVendidos = 0,
                         precioVentaAzucar = 30,
                         precioVentaAvena = 25,
                         precioVentaTrigo = 32,
                         precioVentaMaiz = 20;

                        precioTotalAzucar = 0;
                        precioTotalAvena = 0;
                        precioTotalTrigo = 0;
                        precioTotalMaiz = 0;
                        precioSubtotal = 0;

                        Thread.sleep(500);
                        System.out.println();
                        System.out.println("+-------------------------------------+");
                        System.out.println("|             === VENTAS ===          |");
                        System.out.println("+-------------------------------------+");

                        System.out.println();
                        System.out.print(">> Ingrese el tipo de cliente (A, B, C): ");
                        tipoCliente = scanner.next().strip().toUpperCase();

                        while (!tipoCliente.equals("A") && !tipoCliente.equals("B") && !tipoCliente.equals("C")) {
                            System.out.println();
                            System.out.print(">> Tipo de cliente inválido. Ingrese 'A', 'B' o 'C': ");
                            tipoCliente = scanner.next().strip().toUpperCase();
                        }

                        //Bucle de venta de productos
                        continuarComprando = true;
                        while (continuarComprando) {
                            Thread.sleep(500);
                            System.out.println();
                            System.out.println("+-------------------------------------+");
                            System.out.println("|    === SELECCIÓN DE PRODUCTO ===    |");
                            System.out.println("+-------------------------------------+");
                            System.out.println("| 1. Azúcar                           |");
                            System.out.println("| 2. Avena                            |");
                            System.out.println("| 3. Trigo                            |");
                            System.out.println("| 4. Maíz                             |");
                            System.out.println("+-------------------------------------+");
                            System.out.println();
                            System.out.print(">> Ingrese el código del producto a comprar: ");

                            while (!scanner.hasNextInt()) {
                                Thread.sleep(500);
                                System.out.println();
                                System.out.println(">> Código de producto inválido.");

                                //Se despliega el menú nuevamente 
                                System.out.println();
                                System.out.println("+-------------------------------------+");
                                System.out.println("|    === SELECCIÓN DE PRODUCTO ===    |");
                                System.out.println("+-------------------------------------+");
                                System.out.println("| 1. Azúcar                           |");
                                System.out.println("| 2. Avena                            |");
                                System.out.println("| 3. Trigo                            |");
                                System.out.println("| 4. Maíz                             |");
                                System.out.println("+-------------------------------------+");
                                System.out.println();
                                System.out.print(">> Ingrese el código del producto a comprar: ");
                                scanner.next();
                            }
                            codigoProducto = scanner.nextInt();

                            boolean permitido = true;
                            switch (codigoProducto) {
                                case 1:
                                    if (tipoCliente.equals("C")) {
                                        System.out.println();
                                        System.out.println(">> Cliente 'C' no puede comprar azúcar.");
                                        permitido = false; //si permitido es false, no se pasa al bloque de venta de producto

                                        System.out.println();
                                        System.out.print(">> ¿Desea seguir comprando? (si/no): ");
                                        seguirComprando = scanner.next().strip();

                                        while (!seguirComprando.equalsIgnoreCase("si") && !seguirComprando.equalsIgnoreCase("no")) { //validar que el usuario ingrese una opción correcta
                                            System.out.print(">> Entrada inválida. Escriba 'si' para sí o 'no' para no: ");
                                            seguirComprando = scanner.next().strip();
                                        }

                                        continuarComprando = seguirComprando.equalsIgnoreCase("si"); //terminar el bucle de compra en caso que el usuario lo desee

                                    } else if (inventarioAzucar <= 0) {
                                        System.out.println();
                                        System.out.println(">> No hay azúcar en inventario.");
                                        permitido = false;

                                        System.out.println();
                                        System.out.print(">> ¿Desea seguir comprando? (si/no): ");
                                        seguirComprando = scanner.next().strip();

                                        while (!seguirComprando.equalsIgnoreCase("si") && !seguirComprando.equalsIgnoreCase("no")) {
                                            System.out.print(">> Entrada inválida. Escriba 'si' para sí o 'no' para no: ");
                                            seguirComprando = scanner.next().strip();
                                        }

                                        continuarComprando = seguirComprando.equalsIgnoreCase("si");

                                    } else {
                                        nombreProducto = "Azúcar";
                                        precioUnitario = precioVentaAzucar; //asignación del precio de venta del producto a la variable general precioUnitario
                                        inventarioDisponible = inventarioAzucar; //asignación del inventario disponible del producto a la variable general inventarioDisponible
                                    }
                                    break;

                                case 2:
                                    if (tipoCliente.equals("C")) {
                                        System.out.println();
                                        System.out.println(">> Cliente 'C' no puede comprar avena.");
                                        permitido = false;

                                        System.out.println();
                                        System.out.print(">> ¿Desea seguir comprando? (si/no): ");
                                        seguirComprando = scanner.next().strip();

                                        while (!seguirComprando.equalsIgnoreCase("si") && !seguirComprando.equalsIgnoreCase("no")) {
                                            System.out.print(">> Entrada inválida. Escriba 'si' para sí o 'no' para no: ");
                                            seguirComprando = scanner.next().strip();
                                        }

                                        continuarComprando = seguirComprando.equalsIgnoreCase("si");

                                    } else if (inventarioAvena <= 0) {
                                        System.out.println();
                                        System.out.println(">> No hay avena en inventario.");
                                        permitido = false;

                                        System.out.println();
                                        System.out.print(">> ¿Desea seguir comprando? (si/no): ");
                                        seguirComprando = scanner.next().strip();

                                        while (!seguirComprando.equalsIgnoreCase("si") && !seguirComprando.equalsIgnoreCase("no")) {
                                            System.out.print(">> Entrada inválida. Escriba 'si' para sí o 'no' para no: ");
                                            seguirComprando = scanner.next().strip();
                                        }

                                        continuarComprando = seguirComprando.equalsIgnoreCase("si");

                                    } else {
                                        nombreProducto = "Avena";
                                        precioUnitario = precioVentaAvena;
                                        inventarioDisponible = inventarioAvena;
                                    }
                                    break;

                                case 3:
                                    if (tipoCliente.equals("C")) {
                                        System.out.println();
                                        System.out.println(">> Cliente 'C' no puede comprar trigo.");
                                        permitido = false;

                                        System.out.println();
                                        System.out.print(">> ¿Desea seguir comprando? (si/no): ");
                                        seguirComprando = scanner.next().strip();

                                        while (!seguirComprando.equalsIgnoreCase("si") && !seguirComprando.equalsIgnoreCase("no")) {
                                            System.out.print(">> Entrada inválida. Escriba 'si' para sí o 'no' para no: ");
                                            seguirComprando = scanner.next().strip();
                                        }

                                        continuarComprando = seguirComprando.equalsIgnoreCase("si");

                                    } else if (inventarioTrigo <= 0) {
                                        System.out.println();
                                        System.out.println(">> No hay trigo en inventario.");
                                        permitido = false;

                                        System.out.println();
                                        System.out.print(">> ¿Desea seguir comprando? (si/no): ");
                                        seguirComprando = scanner.next().strip();

                                        while (!seguirComprando.equalsIgnoreCase("si") && !seguirComprando.equalsIgnoreCase("no")) {
                                            System.out.print(">> Entrada inválida. Escriba 'si' para sí o 'no' para no: ");
                                            seguirComprando = scanner.next().strip();
                                        }

                                        continuarComprando = seguirComprando.equalsIgnoreCase("si");

                                    } else {
                                        nombreProducto = "Trigo";
                                        precioUnitario = precioVentaTrigo;
                                        inventarioDisponible = inventarioTrigo;
                                    }
                                    break;

                                case 4:
                                    if (tipoCliente.equals("B")) {
                                        System.out.println();
                                        System.out.println(">> Cliente 'B' no puede comprar maíz.");
                                        permitido = false;

                                        System.out.println();
                                        System.out.print(">> ¿Desea seguir comprando? (si/no): ");
                                        seguirComprando = scanner.next().strip();

                                        while (!seguirComprando.equalsIgnoreCase("si") && !seguirComprando.equalsIgnoreCase("no")) {
                                            System.out.print(">> Entrada inválida. Escriba 'si' para sí o 'no' para no: ");
                                            seguirComprando = scanner.next().strip();
                                        }

                                        continuarComprando = seguirComprando.equalsIgnoreCase("si");

                                    } else if (inventarioMaiz <= 0) {
                                        System.out.println();
                                        System.out.println(">> No hay maíz en inventario.");
                                        permitido = false;

                                        System.out.println();
                                        System.out.print(">> ¿Desea seguir comprando? (si/no): ");
                                        seguirComprando = scanner.next().strip();

                                        while (!seguirComprando.equalsIgnoreCase("si") && !seguirComprando.equalsIgnoreCase("no")) {
                                            System.out.print(">> Entrada inválida. Escriba 'si' para sí o 'no' para no: ");
                                            seguirComprando = scanner.next().strip();
                                        }

                                        continuarComprando = seguirComprando.equalsIgnoreCase("si");

                                    } else {
                                        nombreProducto = "Maíz";
                                        precioUnitario = precioVentaMaiz;
                                        inventarioDisponible = inventarioMaiz;
                                    }
                                    break;

                                default:
                                    System.out.println();
                                    System.out.println(">> Código de producto inválido.");
                                    permitido = false;
                                    break;
                            }

                            if (permitido) {
                                System.out.println();
                                System.out.printf(">> Nombre del producto: %s\n", nombreProducto);
                                System.out.printf(">> Precio unitario (kg): Lps. %.2f\n", precioUnitario);

                                cantidadKilos = 0;

                                while (cantidadKilos <= 0 || cantidadKilos > inventarioDisponible) {
                                    System.out.println();
                                    System.out.print(">> Ingrese la cantidad de kilos a comprar: ");

                                    while (!scanner.hasNextDouble()) {
                                        System.out.println();
                                        System.out.print(">> Valor inválido. Favor ingresar datos numéricos únicamente: ");
                                        scanner.next();
                                    }
                                    cantidadKilos = scanner.nextDouble();

                                    if (cantidadKilos <= 0) {
                                        System.out.println();
                                        System.out.println(">> Error: La cantidad debe ser mayor a 0.");
                                    } else if (cantidadKilos > inventarioDisponible) {
                                        System.out.println();
                                        System.out.printf(">> No hay suficiente %s. Inventario actual: %.2f kg%n", nombreProducto, inventarioDisponible);
                                    }
                                }

                                totalCompra = cantidadKilos * precioUnitario;
                                precioSubtotal += totalCompra;

                                switch (codigoProducto) { //añadir los kilos comprados a su respectivo producto y descontarlo del inventario 
                                    case 1:
                                        kilosAzucarVendidos += cantidadKilos;
                                        precioTotalAzucar += totalCompra;
                                        inventarioAzucar -= cantidadKilos;
                                        break;
                                    case 2:
                                        kilosAvenaVendidos += cantidadKilos;
                                        precioTotalAvena += totalCompra;
                                        inventarioAvena -= cantidadKilos;
                                        break;
                                    case 3:
                                        kilosTrigoVendidos += cantidadKilos;
                                        precioTotalTrigo += totalCompra;
                                        inventarioTrigo -= cantidadKilos;
                                        break;
                                    case 4:
                                        kilosMaizVendidos += cantidadKilos;
                                        precioTotalMaiz += totalCompra;
                                        inventarioMaiz -= cantidadKilos;
                                        break;
                                }
                                System.out.println();
                                System.out.print(">> ¿Desea seguir comprando? (si/no): ");
                                seguirComprando = scanner.next().strip();

                                while (!seguirComprando.equalsIgnoreCase("si") && !seguirComprando.equalsIgnoreCase("no")) {
                                    System.out.println();
                                    System.out.print(">> Entrada inválida. Escriba 'si' para sí o 'no' para no: ");
                                    seguirComprando = scanner.next().strip();
                                }

                                continuarComprando = seguirComprando.equalsIgnoreCase("si"); // terminar bucle de compras en caso que el usuario lo desee
                            }
                        }

                        if (precioSubtotal > 0) { //verificar que el usuario haya comprado algo

                            numeroFacturaVentas++;

                            Thread.sleep(500);
                            System.out.println();
                            System.out.println("+-------------------------------------+");
                            System.out.println("|                FACTURA              |");
                            System.out.println("+-------------------------------------+");
                            System.out.printf("| No. Factura: %-22d |\n", numeroFacturaVentas); //alinear texto a la izquierda

                            //Mostrar datos de los proudctos comprados por el cliente
                            if (kilosAzucarVendidos > 0) {
                                System.out.println("+-------------------------------------+");
                                System.out.printf("| Azúcar:            KG %13.2f |\n", kilosAzucarVendidos); //alinear texto a la derechar
                                System.out.printf("| Precio Unitario:   Lps. %11.2f |\n", precioVentaAzucar);
                                System.out.printf("| Total:             Lps. %11.2f |\n", precioTotalAzucar);
                            }
                            if (kilosAvenaVendidos > 0) {
                                System.out.println("+-------------------------------------+");
                                System.out.printf("| Avena:             KG %13.2f |\n", kilosAvenaVendidos);
                                System.out.printf("| Precio Unitario:   Lps. %11.2f |\n", precioVentaAvena);
                                System.out.printf("| Total:             Lps. %11.2f |\n", precioTotalAvena);
                            }
                            if (kilosTrigoVendidos > 0) {
                                System.out.println("+-------------------------------------+");
                                System.out.printf("| Trigo:             KG %13.2f |\n", kilosTrigoVendidos);
                                System.out.printf("| Precio Unitario:   Lps. %11.2f |\n", precioVentaTrigo);
                                System.out.printf("| Total:             Lps. %11.2f |\n", precioTotalTrigo);
                            }
                            if (kilosMaizVendidos > 0) {
                                System.out.println("+-------------------------------------+");
                                System.out.printf("| Maíz:              KG %13.2f |\n", kilosMaizVendidos);
                                System.out.printf("| Precio Unitario:   Lps. %11.2f |\n", precioVentaMaiz);
                                System.out.printf("| Total:             Lps. %11.2f |\n", precioTotalMaiz);
                            }

                            System.out.println("+-------------------------------------+");
                            System.out.printf("| Subtotal:          Lps. %11.2f |\n", precioSubtotal);
                            System.out.println("+-------------------------------------+");

                            //if ternario para verificar cuanto descuento se le otorgará al usuario
                            porcentajeDescuento = (precioSubtotal > 5000) ? 10 : (precioSubtotal >= 1000) ? 5 : 0;

                            descuento = precioSubtotal * (porcentajeDescuento / 100.0);
                            precioSubtotal -= descuento;
                            isv = precioSubtotal * 0.07; //se calcula el ISV después del descuento
                            precioTotal = precioSubtotal + isv;
                            efectivoTotal += precioTotal;

                            System.out.printf("| Descuento: %d%%      Lps. %11.2f |\n", porcentajeDescuento, descuento);
                            System.out.printf("| ISV: 7%%            Lps. %11.2f |\n", isv);
                            System.out.println("+-------------------------------------+");
                            System.out.printf("| Total a pagar:     Lps. %11.2f |\n", precioTotal);
                            System.out.println("+-------------------------------------+");

                        }

                        break;

                    case 3:
                        //Verificación que haya efectivo en caja y que esta esté abierta
                        if (!cajaAbierta) {
                            System.out.println();
                            System.out.println(">> Error: No puede realizar compras.");
                            System.out.println();
                            System.out.println(">> La caja no ha sido abierta aún.");
                            break;
                        }

                        if (efectivoTotal <= 0) {
                            System.out.println();
                            System.out.println(">> Error: No hay efectivo en caja actualmente.");
                            break;
                        }

                        //Variables generales
                        String tipoProveedor;
                        cantidadKilos = 0;

                        //Variables relacionadas a los datos de producto
                        double kilosAzucarComprados = 0,
                         kilosAvenaComprados = 0,
                         kilosTrigoComprados = 0,
                         kilosMaizComprados = 0,
                         precioCompraAzucar = 25,
                         precioCompraAvenaB = 20,
                         precioCompraAvenaC = 22,
                         precioCompraTrigo = 30,
                         precioCompraMaiz = 18,
                         precioAvenaFacturar;

                        precioTotalAzucar = 0;
                        precioTotalAvena = 0;
                        precioTotalTrigo = 0;
                        precioTotalMaiz = 0;
                        precioTotal = 0;

                        Thread.sleep(300);
                        System.out.println();
                        System.out.println("+-------------------------------------+");
                        System.out.println("|            === COMPRAS ===          |");
                        System.out.println("+-------------------------------------+");

                        System.out.println();
                        System.out.println(">> Compras seleccionado.");
                        System.out.println();
                        System.out.print(">> Favor ingrese el tipo de proveedor (A, B, C): ");
                        tipoProveedor = scanner.next().strip().toUpperCase();

                        //Validación para que la letra ingresada sea la correcta
                        while (!tipoProveedor.equals("A") && !tipoProveedor.equals("B") && !tipoProveedor.equals("C")) {
                            System.out.println();
                            System.out.print(">> Tipo de proveedor inválido. Ingrese 'A', 'B' o 'C': ");
                            tipoProveedor = scanner.next().strip().toUpperCase();
                        }

                        //Bucle de compra de productos
                        continuarComprando = true;
                        while (continuarComprando) {
                            Thread.sleep(500);
                            System.out.println();
                            System.out.println("+-------------------------------------+");
                            System.out.println("|    === SELECCIÓN DE PRODUCTO ===    |");
                            System.out.println("+-------------------------------------+");
                            System.out.println("| 1. Azúcar                           |");
                            System.out.println("| 2. Avena                            |");
                            System.out.println("| 3. Trigo                            |");
                            System.out.println("| 4. Maíz                             |");
                            System.out.println("+-------------------------------------+");
                            System.out.println();
                            System.out.print(">> Ingrese el código del producto a comprar: ");

                            while (!scanner.hasNextInt()) {
                                Thread.sleep(500);
                                System.out.println();
                                System.out.println(">> Código de producto inválido.");

                                //Se despliega el menú nuevamente 
                                System.out.println();
                                System.out.println("+-------------------------------------+");
                                System.out.println("|    === SELECCIÓN DE PRODUCTO ===    |");
                                System.out.println("+-------------------------------------+");
                                System.out.println("| 1. Azúcar                           |");
                                System.out.println("| 2. Avena                            |");
                                System.out.println("| 3. Trigo                            |");
                                System.out.println("| 4. Maíz                             |");
                                System.out.println("+-------------------------------------+");
                                System.out.println();
                                System.out.print(">> Ingrese el código del producto a comprar: ");
                                scanner.next();
                            }
                            codigoProducto = scanner.nextInt();

                            boolean permitido = true;
                            switch (codigoProducto) {
                                case 1:
                                    if (tipoProveedor.equals("B") || tipoProveedor.equals("C")) {
                                        System.out.println();
                                        System.out.println(">> Proveedor no vende dicho producto.");
                                        permitido = false; //si permitido es false, no se pasa al bloque de compra de producto
                                    } else {
                                        nombreProducto = "Azúcar";
                                        precioUnitario = precioCompraAzucar;
                                    }
                                    break;

                                case 2:
                                    if (tipoProveedor.equals("A")) {
                                        System.out.println();
                                        System.out.println(">> Proveedor no vende dicho producto.");
                                        permitido = false;
                                    } else {
                                        nombreProducto = "Avena";
                                        //se verifica cual es el tipo de cliente y acorde a eso se le asigna un valor u otro al precio unitario
                                        precioUnitario = (tipoProveedor.equals("B") ? precioCompraAvenaB : precioCompraAvenaC);
                                    }
                                    break;

                                case 3:
                                    if (tipoProveedor.equals("C") || tipoProveedor.equals("A")) {
                                        System.out.println();
                                        System.out.println(">> Proveedor no vende dicho producto.");
                                        permitido = false;
                                    } else {
                                        nombreProducto = "Trigo";
                                        precioUnitario = precioCompraTrigo;
                                    }
                                    break;

                                case 4:
                                    if (tipoProveedor.equals("B") || tipoProveedor.equals("C")) {
                                        System.out.println();
                                        System.out.println(">> Proveedor no vende dicho producto.");
                                        permitido = false;
                                    } else {
                                        nombreProducto = "Maíz";
                                        precioUnitario = precioCompraMaiz;
                                    }
                                    break;

                                default:
                                    System.out.println();
                                    System.out.println(">> Código de producto inválido.");
                                    permitido = false;
                                    break;
                            }

                            if (permitido) {
                                System.out.printf(">> Nombre del producto: %s\n", nombreProducto);
                                System.out.printf(">> Precio unitario (kg): Lps. %.2f\n", precioUnitario);

                                while (cantidadKilos <= 0) {
                                    System.out.println();
                                    System.out.print(">> Ingrese la cantidad de kilos a comprar (debe ser mayor que 0): ");
                                    while (!scanner.hasNextDouble()) {
                                        System.out.println();
                                        System.out.print(">> Valor inválido. Ingrese solo datos numéricos: ");
                                        scanner.next();
                                    }

                                    cantidadKilos = scanner.nextDouble();

                                    if (cantidadKilos <= 0) {
                                        System.out.println();
                                        System.out.println(">>Error: La cantidad debe ser mayor a 0.");
                                    }
                                }

                                totalCompra = cantidadKilos * precioUnitario;
                                precioTotal += totalCompra;

                                switch (codigoProducto) { //Añadir los kilos comprados a su respectivo proudcto y añadirlos al inventario
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

                                continuarComprando = false;
                            }
                        }

                        if (precioTotal > 0) { //Validar que el usuario haya comprado algo

                            if (efectivoTotal < precioTotal) {
                                System.out.println();
                                System.out.println(">> Error: No se puede pagar compra.");
                                break;
                            }

                            // Si hay efectivo suficiente, se actualiza el inventario
                            inventarioAzucar += kilosAzucarComprados;
                            inventarioAvena += kilosAvenaComprados;
                            inventarioTrigo += kilosTrigoComprados;
                            inventarioMaiz += kilosMaizComprados;

                            efectivoTotal -= precioTotal; //se resta el efectivo en caja

                            //Acorde al tipo de cliente, se despliega un valor u otro al producto avena
                            precioAvenaFacturar = (tipoProveedor.equals("B")) ? precioCompraAvenaB : precioCompraAvenaC;

                            numeroFacturaProveedor++;
                            Thread.sleep(300);
                            System.out.println();
                            System.out.println("+-------------------------------------+");
                            System.out.println("|                FACTURA              |");
                            System.out.println("+-------------------------------------+");
                            System.out.printf("| No. Factura: %-22d |\n", numeroFacturaProveedor); //alinear texto a la izquierda

                            //Mostrar datos de los proudctos comprados por el cliente
                            if (kilosAzucarComprados > 0) {
                                System.out.println("+-------------------------------------+");
                                System.out.printf("| Azúcar:            KG %13.2f |\n", kilosAzucarComprados); //alinear texto a la derechar
                                System.out.printf("| Precio Unitario:   Lps. %11.2f |\n", precioCompraAzucar);
                                System.out.printf("| Total:             Lps. %11.2f |\n", precioTotalAzucar);
                            }
                            if (kilosAvenaComprados > 0) {
                                System.out.println("+-------------------------------------+");
                                System.out.printf("| Avena:             KG %13.2f |\n", kilosAvenaComprados);
                                System.out.printf("| Precio Unitario:   Lps. %11.2f |\n", precioAvenaFacturar);
                                System.out.printf("| Total:             Lps. %11.2f |\n", precioTotalAvena);
                            }
                            if (kilosTrigoComprados > 0) {
                                System.out.println("+-------------------------------------+");
                                System.out.printf("| Trigo:             KG %13.2f |\n", kilosTrigoComprados);
                                System.out.printf("| Precio Unitario:   Lps. %11.2f |\n", precioCompraTrigo);
                                System.out.printf("| Total:             Lps. %11.2f |\n", precioTotalTrigo);
                            }
                            if (kilosMaizComprados > 0) {
                                System.out.println("+-------------------------------------+");
                                System.out.printf("| Maíz:              KG %13.2f |\n", kilosMaizComprados);
                                System.out.printf("| Precio Unitario:   Lps. %11.2f |\n", precioCompraMaiz);
                                System.out.printf("| Total:             Lps. %11.2f |\n", precioTotalMaiz);
                            }

                            System.out.println("+-------------------------------------+");
                            System.out.printf("| Total a pagar:     Lps. %11.2f |\n", precioTotal);
                            System.out.println("+-------------------------------------+");

                        } else {
                            System.out.println();
                            System.out.println("No se realizaron compras.");
                        }

                        break;

                    case 4:
                        //Verificación que haya efectivo en caja
                        if (!cajaAbierta) {
                            System.out.println("Debe depositar efectivo en caja antes de crear un reporte.");
                            break;
                        }
                        
                        System.out.println();
                        System.out.println("+-------------------------------------+");
                        System.out.println("|       === REPORTE DEL DÍA===        |");
                        System.out.println("+-------------------------------------+");
                        
                        break;

                    case 5:
                        //Verificación que haya efectivo en caja
                        if (!cajaAbierta) {
                            System.out.println();
                            System.out.println(">> Error: Debe abrir la caja antes de cerrarla.");
                            break;
                        }

                        //Declaración de variables
                        double porcentajeMaximo = (efectivoTotal / 100) * 60; //cálculo del porcentaje máximo que se puede depositar

                        Thread.sleep(500);
                        System.out.println();
                        System.out.println("+-------------------------------------+");
                        System.out.println("|          === CERRAR CAJA ===        |");
                        System.out.println("+-------------------------------------+");

                        System.out.println();
                        System.out.print("¿Desea cerrar la caja? (si/no): ");
                        cerrarCaja = scanner.next().strip();

                        while (!cerrarCaja.equalsIgnoreCase("si") && !cerrarCaja.equalsIgnoreCase("no")) {
                            System.out.println();
                            System.out.print(">> Entrada inválida. Escriba 'si' para sí o 'no' para no: ");
                            cerrarCaja = scanner.next().strip();
                        }

                        if (cerrarCaja.equalsIgnoreCase("si")) {

                            while (true) {
                                System.out.println();
                                System.out.println(">> Efectivo total en caja: " + efectivoTotal);
                                System.out.println();
                                System.out.printf(">> Ingrese la cantidad de efectivo que desea depositar en el banco (debe ser menor al 60%% (%.2f) ): ", porcentajeMaximo);

                                try {
                                    efectivoIngresado = scanner.nextDouble();

                                    if (efectivoIngresado <= 0) {
                                        System.out.println();
                                        System.out.println(">> Error: la cantidad debe ser mayor a 0.");
                                    } else if (efectivoIngresado > porcentajeMaximo) {
                                        System.out.println();
                                        System.out.printf(">> Error: la cantidad debe ser menor al 60%% (%.2f): ", porcentajeMaximo);
                                    } else {
                                        System.out.println();
                                        System.out.println(">> Efectivo depositado exitosamente!");

                                        efectivoDepositado += efectivoIngresado;
                                        efectivoTotal -= efectivoIngresado;
                                        cajaAbiertaAntes = true;
                                        cajaAbierta = false;
                                        break;
                                    }

                                } catch (InputMismatchException e) {
                                    System.out.println();
                                    System.out.println(">> Cantidad inválida. Favor ingrese datos númericos.");
                                    scanner.next();
                                }
                            }

                        } else {
                            System.out.println();
                            System.out.println(">> Regresando al menú principal...");
                            Thread.sleep(1000);
                        }

                        break;

                    case 6:
                        Thread.sleep(500);
                        System.out.println();
                        System.out.println(">> Saliendo del sistema...");
                        Thread.sleep(1000);
                        break;

                    default:
                        System.out.println();
                        System.out.println(">> Opción inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(">> Opción inválida. Favor ingresar unicamente números enteros.");
                scanner.next();
            }
        }
    }
}
