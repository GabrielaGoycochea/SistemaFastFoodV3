package com.Sistema.FastFoodV3.Model;

public class PedidoComida extends Pedido {
    /**
     * Subclase especificamente para pedidos de comida, se verifica (solo por texto) una mochila termica para el transporte.
     * @param idPedido corresponde al número de pedido dentro de la aplicación
     * @param direccion es la información correspondiente de hacia donde va el envio.
     */


    public PedidoComida(int idPedido, String direccion,double distanciaPedido) {
        super(idPedido, direccion,distanciaPedido,"comida");
    }

    @Override
    public String getTipoPedido(){return "Pedido de Comida";}

    @Override
    public String getRequerimiento(){return "Mochila Térmica";}

    @Override
    public int calcularTiempoEntrega(){
        return (int)(15 +(2*distanciaPedido));

    }

    @Override
    public void asignarRepartidor(){
        this.nombreRepartidor="Jose Tapia";
        this.datoRepartidor = "Repartidor con mochila térmica.";

    }

    @Override
    public void asignarRepartidor(String nombreRepartidor){
        this.nombreRepartidor=nombreRepartidor;
        this.datoRepartidor = "Repartidor con mochila térmica.";
    }


    @Override
    public boolean informacionPedido() {
        return false;
    }
}
