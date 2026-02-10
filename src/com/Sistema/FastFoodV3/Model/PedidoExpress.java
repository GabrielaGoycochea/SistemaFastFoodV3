package com.Sistema.FastFoodV3.Model;

public class PedidoExpress extends Pedido{

    /**
     * Subclase especificamente para pedidos para envios de compras express, se verifica (solo por texto) al repartidor más cercano.
     * Como es pedido expres se verifica que repartidor tenga un vehículo motorizado
     * @param idPedido número de pedido que genera la aplicación
     * @param direccion donde se dirige el envío
     */

    public PedidoExpress(int idPedido, String direccion,double distanciaPedido) {
        super(idPedido, direccion, distanciaPedido ,"Compra Express");
    }

    @Override
    public String getTipoPedido(){return "Pedido Express";}

    @Override
    public String getRequerimiento(){return "Vehiculo Motorizado";}

    @Override
    public int calcularTiempoEntrega(){
        int tiempo = 10;
        if (distanciaPedido > 5){tiempo +=5;}
        return tiempo;
    }

    @Override
    public void asignarRepartidor(){
    this.nombreRepartidor="Monica Godoy.";
    this.datoRepartidor="Repartidor con vehiculo motorizado.";


    }

    @Override
    public void asignarRepartidor(String nombreRepartidor){
        this.nombreRepartidor=nombreRepartidor;
        this.datoRepartidor="Repartidor con vehiculo motorizado.";
    }

    @Override
    public boolean informacionPedido() {
        return false;
    }
}

