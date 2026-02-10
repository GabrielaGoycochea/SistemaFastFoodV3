package com.Sistema.FastFoodV3.Model;

import com.Sistema.FastFoodV3.Gestor.HistorialDePedidos;


/**
 *Clase para generar nombre de repartidor y requerimientos especificos.
 * Pedido de comida debe tener mochila termica.
 * Pedido de envío debe tener un vehículo adecuado al encargo para enviar.
 * Pedido expres requiere repartidor con vehículo motorizado
 * El repartidor está condicionado a cumplir el requerimiento para tomar un pedido.
 */

public class Repartidor  implements Runnable {

    private String nombre;
    private boolean mochilaTermica;
    private boolean vehiculoMotorizado;
    private boolean vehiculoCarga;
    private ZonaDeCarga zonaDeCarga;



    public Repartidor (String nombre,boolean mochilaTermica,boolean vehiculoMotorizado,boolean vehiculoCarga,ZonaDeCarga zonaDeCarga){
        this.nombre=nombre;
        this.mochilaTermica=mochilaTermica;
        this.vehiculoMotorizado=vehiculoMotorizado;
        this.vehiculoCarga=vehiculoCarga;
        this.zonaDeCarga = zonaDeCarga;
    }

    private synchronized  void imprimePedido(String mensaje){
        System.out.println(mensaje);
    }


    @Override
    public void run() {
        try {
            while (true){

                Pedido pedido = zonaDeCarga.recogerPedido();

                if(pedido==null){break;}

                imprimePedido("::::::::::::::::::::::::::::::::::::::::::::::");
                imprimePedido("Pedido "+ pedido.getIdPedido()+" estado: "+pedido.getEstadoPedido());

                if (!tomarPedido(pedido)) {
                    imprimePedido("Repartidor "+nombre+" no puede tomar el pedido "+pedido.getIdPedido()
                            +". Pedido en la zona de despacho. ");
                    zonaDeCarga.agregarPedido(pedido);
                    Thread.sleep(5000);
                    continue;
                }

                pedido.setEstadoPedido(EstadoPedido.en_reparto);
                pedido.asignarRepartidor(nombre);

                imprimePedido("Repartidor " + nombre + " recogió el pedido " + pedido.getIdPedido());
                imprimePedido("::::::::::::::::::::::::::::::::::::::::::::::::::::");

                Thread.sleep(5000);

                pedido.setEstadoPedido(EstadoPedido.entregado);
                pedido.despachar();
                imprimePedido("::::::::::::::::::::::::::::::::::::::::::::::::::::");
                imprimePedido("Repartidor " + nombre + " ha entregado el pedido " + pedido.getIdPedido());
                imprimePedido("Estado del pedido: "+pedido.getEstadoPedido());
                HistorialDePedidos.agregar(pedido);
                imprimePedido("::::::::::::::::::::::::::::::::::::::::::::::::::::");

            }


        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

        private boolean tomarPedido(Pedido pedido){
            return switch (pedido.getRequerimiento()){
                case "Mochila Térmica" -> mochilaTermica;
                case "Vehiculo de carga"-> vehiculoCarga;
                case "Vehiculo Motorizado"-> vehiculoMotorizado;
                default -> false;
            };
        }


    }



