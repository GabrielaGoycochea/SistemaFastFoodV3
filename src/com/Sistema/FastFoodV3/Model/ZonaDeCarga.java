package com.Sistema.FastFoodV3.Model;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Clase donde los repartidos pueden "entrar" tomar su pedido (si cumple las caracteristicas)
 * y salir a reparto.
 *
 */

public class ZonaDeCarga {

    private final BlockingDeque<Pedido> pedidos = new LinkedBlockingDeque<>();

    public void agregarPedido(Pedido pedido){
        if(!pedido.informacion()){
            System.out.println("Pedido "+pedido.getIdPedido()+" ingresado para reparto.");
            pedido.pedidoInformado();

        }

        pedidos.add(pedido);

    }

    public Pedido recogerPedido() throws InterruptedException{
        return pedidos.poll(5, TimeUnit.SECONDS);
    }




}
