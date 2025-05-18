package portillo_edwin_proyecto_tienda;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Portillo_Edwin_Proyecto_Tienda {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        //Declaración de variables del menú inicio y abrir caja
        int opcion = 0;
        double efectivoIngresado = 0, efectivoTotal = 0;

        //Declaración de variable compra y venta
        String seguirComprando, nombreProducto = "", confirmarCompra, cerrarCaja;
        int codigoProducto, porcentajeDescuento, numeroFacturaVentas = 0, numeroFacturaProveedor = 0;
        double stockAzucar = 10, stockAvena = 10, stockTrigo = 10, stockMaiz = 10;
        double descuento, precioTotal, isv, totalCompra, cantidadKilos, precioSubtotal, precioUnitario = 0;
        boolean continuarComprando, cajaAbierta = false;
        double precioTotalAzucar, precioTotalAvena, precioTotalTrigo, precioTotalMaiz;

        //Menú de inicio
        Thread.sleep(250);
        System.out.println();
        System.out.println("+-------------------------------------+");
        System.out.println("|   Bienvenido a la Victitiendita!    |");
        System.out.println("+-------------------------------------+");

        // Bucle del menú principal que continua hasta que el usuario seleccione la opción 6
        while (opcion != 6) {
            Thread.sleep(500);
            System.out.println();
            System.out.println("+-------------------------------------+");
            System.out.println("|         === MENU PRINCIPAL ===      |");
            System.out.println("+-------------------------------------+");
            System.out.println("| 1. Abrir Caja                       |");
            System.out.println("| 2. Ventas                           |");
            System.out.println("| 3. Compras                          |");
            System.out.println("| 4. Reportes                         |");
            System.out.println("| 5. Cierre de Caja                   |");
            System.out.println("| 6. Salir del Sistema                |");
            System.out.println("+-------------------------------------+");
            Thread.sleep(250);
            System.out.print(">> Seleccione una opción [1-6]: ");

            try { //Validar que el dato ingresado sea entero
                opcion = scanner.nextInt();

                switch (opcion) { //switch con las opciones mostradas previamente
                    case 1:
                        Thread.sleep(500);
                        System.out.println();
                        System.out.println("+-------------------------------------+");
                        System.out.println("|           === ABRIR CAJA ===        |");
                        System.out.println("+-------------------------------------+");

                        // Bucle para asegurar que la cantidad ingresada sea válida
                        while (efectivoIngresado <= 0) {
                            Thread.sleep(250);
                            System.out.println();
                            System.out.print(">> Ingrese la cantidad de efectivo a guardar (Lps): ");

                            try {
                                efectivoIngresado = scanner.nextDouble();

                                if (efectivoIngresado <= 0) {
                                    Thread.sleep(250);
                                    System.out.println();
                                    System.out.println(">> Error: la cantidad debe ser mayor a 0.");
                                }

                            } catch (InputMismatchException e) {
                                Thread.sleep(250);
                                System.out.println();
                                System.out.println(">> Opción inválida: Intente nuevamente.");
                                scanner.next();
                            }

                        }

                        // Actualizar el total y mostrar los datos
                        efectivoTotal += efectivoIngresado;
                        Thread.sleep(250);
                        System.out.println();
                        System.out.println("+-------------------------------------+");
                        System.out.printf("| %-20s Lps.%10.2f |\n", "Usted guardó:", efectivoIngresado);
                        System.out.printf("| %-20s Lps.%10.2f |\n", "Total en caja:", efectivoTotal);
                        System.out.println("+-------------------------------------+");

                        efectivoIngresado = 0;
                        cajaAbierta = true;
                        break;

                    case 2:
                        //Verificación que haya efectivo en caja
                        if (!cajaAbierta) {
                            Thread.sleep(250);
                            System.out.println();
                            System.out.println(">> Error: No puede realizar ventas.");
                            Thread.sleep(250);
                            System.out.println(">> La caja no ha sido abierta aún.");
                            break;
                        }

                        if (stockAzucar <= 0 && stockAvena <= 0 && stockTrigo <= 0 && stockMaiz <= 0) {
                            System.out.println();
                            Thread.sleep(250);
                            System.out.println(">> Error: No hay productos disponibles.");
                            Thread.sleep(250);
                            System.out.println(">> Todos los productos están agotados.");
                            break;
                        }

                        //Variables principales
                        String tipoCliente;
                        double stockDisponible = 0;

                        //Datos por producto
                        double kilosAzucarVendidos = 0,
                         kilosAvenaVendidos = 0,
                         kilosTrigoVendidos = 0,
                         kilosMaizVendidos = 0;
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

                        Thread.sleep(250);
                        System.out.print(">> Ingrese el tipo de cliente (A, B, C): ");
                        tipoCliente = scanner.next().strip().toUpperCase();

                        //Validación para que la letra ingresada sea la correcta
                        Thread.sleep(250);
                        while (!tipoCliente.equals("A") && !tipoCliente.equals("B") && !tipoCliente.equals("C")) {
                            System.out.print(">> Tipo de cliente inválido. Ingrese 'A', 'B' o 'C': ");
                            tipoCliente = scanner.next().strip().toUpperCase();
                        }

                        //Bucle de compra
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
                            System.out.print(">> Ingrese el código del producto a comprar: ");

                            //Validación para que el código seleccionado sea válido
                            while (!scanner.hasNextInt()) {
                                Thread.sleep(250);
                                System.out.print(">> Opción inválida. Ingrese un código de producto válido: ");
                                scanner.next();
                            }
                            codigoProducto = scanner.nextInt();

                            boolean permitido = true;
                            switch (codigoProducto) {
                                case 1:
                                    if (tipoCliente.equals("C")) {
                                        Thread.sleep(250);
                                        System.out.println(">> Cliente 'C' no puede comprar azúcar.");
                                        permitido = false;
                                        Thread.sleep(250);
                                        System.out.print(">> ¿Desea seguir comprando? (Presione 'N' para salir, cualquier otra tecla para continuar): ");
                                        seguirComprando = scanner.next().strip();
                                        continuarComprando = !(seguirComprando.equalsIgnoreCase("N"));
                                    } else if (stockAzucar <= 0) {
                                        Thread.sleep(250);
                                        System.out.println(">> No hay azúcar en stock.");
                                        permitido = false;
                                        Thread.sleep(250);
                                        System.out.print(">> ¿Desea seguir comprando? (Presione 'N' para salir, cualquier otra tecla para continuar): ");
                                        seguirComprando = scanner.next().strip();
                                        continuarComprando = !(seguirComprando.equalsIgnoreCase("N"));
                                    } else {
                                        nombreProducto = "Azúcar";
                                        precioUnitario = 30;
                                        stockDisponible = stockAzucar;
                                    }
                                    break;

                                case 2:
                                    if (tipoCliente.equals("C")) {
                                        Thread.sleep(250);
                                        System.out.println(">> Cliente 'C' no puede comprar avena.");
                                        permitido = false;
                                        Thread.sleep(250);
                                        System.out.print(">> ¿Desea seguir comprando? (Presione 'N' para salir, cualquier otra tecla para continuar): ");
                                        seguirComprando = scanner.next().strip();
                                        continuarComprando = !(seguirComprando.equalsIgnoreCase("N"));
                                    } else if (stockAvena <= 0) {
                                        Thread.sleep(250);
                                        System.out.println(">> No hay avena en stock.");
                                        permitido = false;
                                        Thread.sleep(250);
                                        System.out.print(">> ¿Desea seguir comprando? (Presione 'N' para salir, cualquier otra tecla para continuar): ");
                                        seguirComprando = scanner.next().strip();
                                        continuarComprando = !(seguirComprando.equalsIgnoreCase("N"));
                                    } else {
                                        nombreProducto = "Avena";
                                        precioUnitario = 25;
                                        stockDisponible = stockAvena;
                                    }
                                    break;

                                case 3:
                                    if (tipoCliente.equals("C")) {
                                        Thread.sleep(250);
                                        System.out.println(">> Cliente 'C' no puede comprar trigo.");
                                        permitido = false;
                                        Thread.sleep(250);
                                        System.out.print(">> ¿Desea seguir comprando? (Presione 'N' para salir, cualquier otra tecla para continuar): ");
                                        seguirComprando = scanner.next().strip();
                                        continuarComprando = !(seguirComprando.equalsIgnoreCase("N"));
                                    } else if (stockTrigo <= 0) {
                                        Thread.sleep(250);
                                        System.out.println(">> No hay trigo en stock.");
                                        permitido = false;
                                        Thread.sleep(250);
                                        System.out.print(">> ¿Desea seguir comprando? (Presione 'N' para salir, cualquier otra tecla para continuar): ");
                                        seguirComprando = scanner.next().strip();
                                        continuarComprando = !(seguirComprando.equalsIgnoreCase("N"));
                                    } else {
                                        nombreProducto = "Trigo";
                                        precioUnitario = 32;
                                        stockDisponible = stockTrigo;
                                    }
                                    break;

                                case 4:
                                    if (tipoCliente.equals("B")) {
                                        Thread.sleep(250);
                                        System.out.println(">> Cliente 'B' no puede comprar maíz.");
                                        permitido = false;
                                        Thread.sleep(250);
                                        System.out.print(">> ¿Desea seguir comprando? (Presione 'N' para salir, cualquier otra tecla para continuar): ");
                                        seguirComprando = scanner.next().strip();
                                        continuarComprando = !(seguirComprando.equalsIgnoreCase("N"));
                                    } else if (stockMaiz <= 0) {
                                        Thread.sleep(250);
                                        System.out.println(">> No hay maíz en stock.");
                                        permitido = false;
                                        Thread.sleep(250);
                                        System.out.print(">> ¿Desea seguir comprando? (Presione 'N' para salir, cualquier otra tecla para continuar): ");
                                        seguirComprando = scanner.next().strip();
                                        continuarComprando = !(seguirComprando.equalsIgnoreCase("N"));
                                    } else {
                                        nombreProducto = "Maíz";
                                        precioUnitario = 20;
                                        stockDisponible = stockMaiz;
                                    }
                                    break;

                                default:
                                    Thread.sleep(250);
                                    System.out.println(">> Código de producto inválido.");
                                    permitido = false;
                                    break;
                            }

                            if (permitido) {
                                Thread.sleep(250);
                                System.out.printf(">> Nombre del producto: %s\n", nombreProducto);
                                System.out.printf(">> Precio unitario (kg): Lps. %.2f\n", precioUnitario);

                                cantidadKilos = 0;
                                while (cantidadKilos <= 0 || cantidadKilos > stockDisponible) {
                                    Thread.sleep(250);
                                    System.out.print(">> Ingrese la cantidad de kilos a comprar: ");

                                    while (!scanner.hasNextDouble()) {
                                        Thread.sleep(250);
                                        System.out.print(">> Valor inválido. Favor ingresar datos numéricos únicamente: ");
                                        scanner.next();
                                    }
                                    cantidadKilos = scanner.nextDouble();

                                    if (cantidadKilos <= 0) {
                                        Thread.sleep(250);
                                        System.out.println(">> Error: La cantidad debe ser mayor a 0.");
                                    } else if (cantidadKilos > stockDisponible) {
                                        Thread.sleep(250);
                                        System.out.printf(">> No hay suficiente %s. Stock actual: %.2f kg%n", nombreProducto, stockDisponible);
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

                                Thread.sleep(250);
                                System.out.print(">> ¿Desea seguir comprando? (Presione 'N' para salir, cualquier otra tecla para continuar): ");
                                seguirComprando = scanner.next().strip();
                                continuarComprando = !(seguirComprando.equalsIgnoreCase("N"));
                            }
                        }

                        if (precioSubtotal > 0) {
                            Thread.sleep(250);

                            numeroFacturaVentas++;

                            Thread.sleep(500);
                            System.out.println("+-------------------------------------+");
                            System.out.println("|                FACTURA              |");
                            System.out.println("+-------------------------------------+");
                            System.out.printf("| No. Factura: %-22d |\n", numeroFacturaVentas);

                            if (kilosAzucarVendidos > 0) {
                                System.out.println("+-------------------------------------+");
                                System.out.printf("| Azúcar:            KG %13.2f |\n", kilosAzucarVendidos);
                                System.out.printf("| Precio Unitario:   Lps. %11.2f |\n", 30.00);
                                System.out.printf("| Total:             Lps. %11.2f |\n", precioTotalAzucar);
                            }
                            if (kilosAvenaVendidos > 0) {
                                System.out.println("+-------------------------------------+");
                                System.out.printf("| Avena:             KG %13.2f |\n", kilosAvenaVendidos);
                                System.out.printf("| Precio Unitario:   Lps. %11.2f |\n", 25.00);
                                System.out.printf("| Total:             Lps. %11.2f |\n", precioTotalAvena);
                            }
                            if (kilosTrigoVendidos > 0) {
                                System.out.println("+-------------------------------------+");
                                System.out.printf("| Trigo:             KG %13.2f |\n", kilosTrigoVendidos);
                                System.out.printf("| Precio Unitario:   Lps. %11.2f |\n", 32.00);
                                System.out.printf("| Total:             Lps. %11.2f |\n", precioTotalTrigo);
                            }
                            if (kilosMaizVendidos > 0) {
                                System.out.println("+-------------------------------------+");
                                System.out.printf("| Maíz:              KG %13.2f |\n", kilosMaizVendidos);
                                System.out.printf("| Precio Unitario:   Lps. %11.2f |\n", 20.00);
                                System.out.printf("| Total:             Lps. %11.2f |\n", precioTotalMaiz);
                            }

                            System.out.println("+-------------------------------------+");
                            System.out.printf("| Subtotal:          Lps. %11.2f |\n", precioSubtotal);
                            System.out.println("+-------------------------------------+");

                            porcentajeDescuento = (precioSubtotal > 5000) ? 10
                                    : (precioSubtotal >= 1000) ? 5 : 0;
                            descuento = precioSubtotal * (porcentajeDescuento / 100.0);
                            isv = precioSubtotal * 0.07;
                            precioTotal = precioSubtotal - descuento + isv;
                            efectivoTotal += precioTotal;

                            System.out.printf("| Descuento: %d%%      Lps. %11.2f |\n", porcentajeDescuento, descuento);
                            System.out.printf("| ISV: 7%%            Lps. %11.2f |\n", isv);
                            System.out.println("+-------------------------------------+");
                            System.out.printf("| Total a pagar:     Lps. %11.2f |\n", precioTotal);
                            System.out.println("+-------------------------------------+");

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

                        //Datos por producto
                        double kilosAzucarComprados = 0,
                         kilosAvenaComprados = 0,
                         kilosTrigoComprados = 0,
                         kilosMaizComprados = 0;
                        precioTotalAzucar = 0;
                        precioTotalAvena = 0;
                        precioTotalTrigo = 0;
                        precioTotalMaiz = 0;
                        precioTotal = 0;

                        cantidadKilos = 0;

                        System.out.println("Compras seleccionado.");
                        System.out.print("Favor ingrese el tipo de proveedor (A, B, C): ");
                        tipoProveedor = scanner.next().strip().toUpperCase();

                        //Validación para que la letra ingresada sea la correcta
                        while (!tipoProveedor.equals("A") && !tipoProveedor.equals("B") && !tipoProveedor.equals("C")) {
                            System.out.print("Tipo de proveedor inválido. Ingrese 'A', 'B' o 'C': ");
                            tipoProveedor = scanner.next().strip().toUpperCase();
                        }

                        //Bucle de compra
                        continuarComprando = true;
                        while (continuarComprando) {
                            System.out.println("1. Azúcar");
                            System.out.println("2. Avena");
                            System.out.println("3. Trigo");
                            System.out.println("4. Maíz");
                            System.out.print("Ingrese el código del producto a comprar: ");

                            //Validación para que el código seleccionado sea válido
                            while (!scanner.hasNextInt()) {
                                System.out.print("Opción inválida. Ingrese un código de producto válido: ");
                                scanner.next();
                            }
                            codigoProducto = scanner.nextInt();

                            boolean permitido = true;
                            switch (codigoProducto) {
                                case 1:
                                    if (tipoProveedor.equals("B") || tipoProveedor.equals("C")) {
                                        System.out.println("Solo el proveedor tipo 'A' puede vender azúcar.");
                                        permitido = false;
                                    } else {
                                        nombreProducto = "Azúcar";
                                        precioUnitario = 30;
                                    }
                                    break;

                                case 2:
                                    if (tipoProveedor.equals("A")) {
                                        System.out.println("Proveedor 'A' no puede comprar avena.");
                                        permitido = false;
                                    } else {
                                        nombreProducto = "Avena";
                                        precioUnitario = 25;
                                    }
                                    break;

                                case 3:
                                    if (tipoProveedor.equals("C") || tipoProveedor.equals("A")) {
                                        System.out.println("Solo el proveedor tipo 'B' puede vender trigo.");
                                        permitido = false;
                                    } else {
                                        nombreProducto = "Trigo";
                                        precioUnitario = 32;
                                    }
                                    break;

                                case 4:
                                    if (tipoProveedor.equals("B") || tipoProveedor.equals("C")) {
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

                                while (cantidadKilos <= 0) {
                                    System.out.print("Ingrese la cantidad de kilos a comprar (debe ser mayor que 0): ");
                                    while (!scanner.hasNextDouble()) {
                                        System.out.println("Valor inválido. Ingrese solo datos numéricos:");
                                        scanner.next();
                                    }

                                    cantidadKilos = scanner.nextDouble();
                                }

                                totalCompra = cantidadKilos * precioUnitario;
                                precioTotal += totalCompra;

                                switch (codigoProducto) {
                                    case 1:
                                        kilosAzucarComprados += cantidadKilos;
                                        precioTotalAzucar += totalCompra;
                                        stockAzucar += kilosAzucarComprados;
                                        break;
                                    case 2:
                                        kilosAvenaComprados += cantidadKilos;
                                        precioTotalAvena += totalCompra;
                                        stockAvena += kilosAvenaComprados;
                                        break;
                                    case 3:
                                        kilosTrigoComprados += cantidadKilos;
                                        precioTotalTrigo += totalCompra;
                                        stockTrigo += kilosTrigoComprados;
                                        break;
                                    case 4:
                                        kilosMaizComprados += cantidadKilos;
                                        precioTotalMaiz += totalCompra;
                                        stockMaiz += kilosMaizComprados;
                                        break;
                                }

                                continuarComprando = false;
                            }
                        }

                        if (precioTotal > 0) {

                            if (efectivoTotal < precioTotal) {
                                System.out.println("Error: no hay efectivo suficiente en caja.");
                                break;
                            }

                            numeroFacturaProveedor++;
                            System.out.println("-------Factura-------\n");
                            System.out.printf("No. Factura: %d\n", numeroFacturaProveedor);

                            if (kilosAzucarComprados > 0) {
                                System.out.printf("Azúcar: %.2f kg | Precio Unitario: Lps. 30.00 | Total: Lps. %.2f\n", kilosAzucarComprados, precioTotalAzucar);
                            }
                            if (kilosAvenaComprados > 0) {
                                System.out.printf("Avena: %.2f kg | Precio Unitario: Lps. 25.00 | Total: Lps. %.2f\n", kilosAvenaComprados, precioTotalAvena);
                            }
                            if (kilosTrigoComprados > 0) {
                                System.out.printf("Trigo: %.2f kg | Precio Unitario: Lps. 32.00 | Total: Lps. %.2f\n", kilosTrigoComprados, precioTotalTrigo);
                            }
                            if (kilosMaizComprados > 0) {
                                System.out.printf("Maíz: %.2f kg | Precio Unitario: Lps. 20.00 | Total: Lps. %.2f\n", kilosMaizComprados, precioTotalMaiz);
                            }

                            System.out.printf("Total a pagar: %.2f\n", precioTotal);

                            efectivoTotal -= precioTotal;

                            System.out.printf("El efectivo total en caja es de: Lps.%.2f\n", efectivoTotal);
                            System.out.println("Inventario actual:");
                            System.out.printf("1. Azúcar: %.2f \n", stockAzucar);
                            System.out.printf("2. Avena: %.2f \n", stockAvena);
                            System.out.printf("3. Trigo: %.2f \n", stockTrigo);
                            System.out.printf("4. Maíz: %.2f \n", stockMaiz);

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

                        double efectivoDepositado;
                        double porcentajeMaximo = (efectivoTotal / 100) * 60;

                        System.out.println("Cierre de caja seleccionado");

                        System.out.print("Desea cerrar la caja? (S para confirmar, cualquier otra tecla para cancelar): ");
                        cerrarCaja = scanner.next();

                        if (cerrarCaja.equalsIgnoreCase("S")) {
                            System.out.println("Efectivo total en caja: " + efectivoTotal);
                            System.out.printf("Ingrese la cantidad de efectivo que desea depositar en el banco (debe ser menor al 60%% (%.2f))\n", porcentajeMaximo);

                            try {
                                efectivoIngresado = scanner.nextDouble();

                                if (efectivoIngresado <= 0) {
                                    System.out.println("Error: la cantidad debe ser mayor a 0.");
                                } else if (efectivoIngresado > porcentajeMaximo) {
                                    System.out.printf("Error: la cantidad debe ser menor al 60%% (%.2f)\n", porcentajeMaximo);
                                } else {
                                    efectivoDepositado = efectivoIngresado;
                                    System.out.println("Efectivo depositado exitosamente!");
                                    break;
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("Cantidad inválida. Favor ingrese datos númericos.");
                                scanner.next();
                            }

                        } else {
                            System.out.println("Regresando al menú principal...");
                        }

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
