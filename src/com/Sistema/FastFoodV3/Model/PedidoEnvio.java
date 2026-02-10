package com.Sistema.FastFoodV3.Model;

public class PedidoEnvio extends Pedido {

    /**
     * Subclase especificamente para pedidos para envios de encomienda, se verifica (solo por texto) el peso del paquete enviado.
     * Y también permite verificar el vehículo adecuado para la entrega (según peso)
     * @param idPedido número de pedido que genera la aplicación
     * @param direccion donde se dirige el envío
     */

    private double peso;


    public PedidoEnvio(int idPedido, String direccion, double distanciaPedido ,double peso) {
        super(idPedido, direccion, distanciaPedido ,"Encomienda");
        this.peso = peso;
    }

    @Override
    public String getTipoPedido(){return "Pedido de Envio";}

    @Override
    public String getRequerimiento(){return "Vehiculo de carga";}

    @Override
    public int calcularTiempoEntrega(){
        return (int)(20+(1.5*distanciaPedido));
    }

    @Override
    public void asignarRepartidor(){
        this.nombreRepartidor = "Juan Perez";
        this.datoRepartidor="Vehiculo adecuado para entrega.";
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor){
        this.nombreRepartidor=nombreRepartidor;
        this.datoRepartidor="Vehiculo adecuado para entrega.";
    }

    @Override
    public boolean informacionPedido() {
        return false;
    }
}
