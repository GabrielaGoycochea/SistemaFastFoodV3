package com.Sistema.FastFoodV3.Gestor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase para gestionar los pedidos, al despacharse se agregan al historial, antes no.
 * Según la lista de pedidos se "sincroniza" para evitar que el pedido sea asignado a 2 repartidores diferentes.
 */
import com.Sistema.FastFoodV3.Model.Pedido;


public class HistorialDePedidos {

    private static final List<Pedido> historialPedido = Collections.synchronizedList(new ArrayList<>());

    public synchronized static void agregar(Pedido pedido) {
        if(!historialPedido.contains(pedido)){
        historialPedido.add(pedido);
        }
    }

    public synchronized static void mostrar() {
        System.out.println("..::HISTORIAL DE PEDIDOS::..");

        if (historialPedido.isEmpty()) {
            System.out.println("No hay pedidos registrados");
            return;
        }

        for (Pedido pedido : historialPedido){
        pedido.mostrarResumen();
            System.out.println("Estado: "+pedido.getEstadoPedido());
            System.out.println(":::::::::::::::::::::::::::::::\n");
        }

            }

        }



