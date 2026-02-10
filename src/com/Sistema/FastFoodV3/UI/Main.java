package com.Sistema.FastFoodV3.UI;
import com.Sistema.FastFoodV3.Gestor.HistorialDePedidos;
import com.Sistema.FastFoodV3.Model.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Se genera un menú interactivo con el usuario.
 * El cual le permite ver el historial de pedidos.
 * Le permite cancelar el pedido solo de estar pendiente (despachado no es posible)
 * Y permite iniciar despachos, solo los despachos iniciados permiten agregarse al historial
 */

public class Main {
    public static void main(String[] args) {

        Scanner tc = new Scanner(System.in);
        ArrayList<Pedido> pedidos = new ArrayList<>();
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();


        Pedido pedido1 = new PedidoComida(1,"San pablo 1920, depto 21",2);
        Pedido pedido2 = new PedidoEnvio(2,"Pje Uno 0402",3,8);
        Pedido pedido3 = new PedidoExpress(3,"Av Molina 234",6);
        Pedido pedido4 = new PedidoComida(4,"Matucana 100",10);
        Pedido pedido5 = new PedidoEnvio(5,"Calle Azocar 2101",1.5,2);
        Pedido pedido6 = new PedidoExpress(6,"Manuel Montt 021",5);
        Pedido pedido7 = new PedidoComida(7,"General Jofre 3040",16);
        Pedido pedido8 = new PedidoEnvio(8,"Luis Hermosilla 100",20,30);
        Pedido pedido9 = new PedidoExpress(9,"Lautaro 355",7);

        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);
        pedidos.add(pedido4);
        pedidos.add(pedido5);
        pedidos.add(pedido6);
        pedidos.add(pedido7);
        pedidos.add(pedido8);
        pedidos.add(pedido9);

        zonaDeCarga.agregarPedido(pedido1);
        zonaDeCarga.agregarPedido(pedido2);
        zonaDeCarga.agregarPedido(pedido3);
        zonaDeCarga.agregarPedido(pedido4);
        zonaDeCarga.agregarPedido(pedido5);
        zonaDeCarga.agregarPedido(pedido6);
        zonaDeCarga.agregarPedido(pedido7);
        zonaDeCarga.agregarPedido(pedido8);
        zonaDeCarga.agregarPedido(pedido9);


        ExecutorService executorService = null;

        //Inicia despachos cuando se elige en el menú
        boolean iniciarDespachos = false;


        int opcion;
        do{
            System.out.println("\n..::MENÚ GESTIÓN DE PEDIDO::..");
            System.out.println("1. Ver historial");
            System.out.println("2. Cancelar pedido");
            System.out.println("3. Iniciar despachos");
            System.out.println("0. Salir.");

            System.out.println("Ingresa una opción: ");
            opcion = tc.nextInt();

            switch (opcion) {
                case 1:
                    HistorialDePedidos.mostrar();
                    break;

                case 2:
                    System.out.println("Ingrese ID de pedido para cancelar: ");
                    int id = tc.nextInt();
                    boolean encontrado = false;

                    for (Pedido p : pedidos) {
                        if (p.getIdPedido() == id) {
                            p.cancelar();
                            encontrado = true;
                            HistorialDePedidos.agregar(p);
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontró pedido con ID " + id);
                    }
                    break;

                case 3:
                    if (!iniciarDespachos) {
                        System.out.println("Iniciando despachos...");
                        //Genera hilos
                        executorService = Executors.newFixedThreadPool(3);

                        executorService.execute(new Repartidor("Jose", true, false, false, zonaDeCarga));
                        executorService.execute(new Repartidor("Juan", false, true, true, zonaDeCarga));
                        executorService.execute(new Repartidor("Monica", true, true, false, zonaDeCarga));

                        iniciarDespachos = true;

                        executorService.shutdown();

                        try {
                            executorService.awaitTermination(2, TimeUnit.MINUTES);
                        } catch (InterruptedException exception) {
                            Thread.currentThread().interrupt();
                        }
                        System.out.println("Todos los despachos fueron completados.");

                    } else {
                        System.out.println("Los despachos ya fueron iniciados.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida, intente nuevamente");

            }

        }while(opcion!=0);



        tc.close();
        System.out.println("Haz salido del sistema.");

    }


}