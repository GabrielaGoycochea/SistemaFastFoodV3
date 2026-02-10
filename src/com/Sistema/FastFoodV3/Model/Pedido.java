package com.Sistema.FastFoodV3.Model;


public abstract class Pedido implements Despachable,Cancelable,Rastreable,Informaciones{

    /**
     * Clase padre se piden los datos generales que heredaran las subclases principales.
     * Sistema permite saber nombre de repartidor, distancia, tiempo de pedido, tipo de pedido,estado
     * permite ver si está reservado, despachado o cancelado. Dentro de un detalle "de pedido"
     */

    protected int idPedido;
    protected String direccion;
    protected String tipoPedido;
    protected double distanciaPedido;
    protected String nombreRepartidor;
    protected boolean cancelarPedido;
    protected boolean pedidoDespachado;
    protected String datoRepartidor;
    protected EstadoPedido estadoPedido;

    private boolean informacionPedido;


    public Pedido (int idPedido, String direccion, double distanciaPedido,String tipoPedido){
        this.idPedido = idPedido;
        this.direccion = direccion;
        this.distanciaPedido= distanciaPedido;
        this.tipoPedido = tipoPedido;
        this.cancelarPedido=false;
        this.pedidoDespachado=false;
        this.estadoPedido= EstadoPedido.pendiente;
        this.informacionPedido=false;
    }

    public void asignarRepartidor(){
    }

    public void asignarRepartidor(String nombreRepartidor){
        this.nombreRepartidor = nombreRepartidor;

    }

    public abstract String getRequerimiento();
    public abstract int calcularTiempoEntrega();

    public int getIdPedido(){return idPedido;}
    public String getTipoPedido(){return "Pedido";}
    public EstadoPedido getEstadoPedido() {return estadoPedido;}
    public synchronized void setEstadoPedido(EstadoPedido nuevoEstado){
        this.estadoPedido = nuevoEstado;
    }

    public void mostrarEstado(){
        System.out.println("Pedido "+idPedido+ " estado actual "+estadoPedido);
    }


    public synchronized boolean informacion(){return informacionPedido;}
    public synchronized void pedidoInformado(){this.informacionPedido=true;}

    public void mostrarResumen(){
        System.out.println("ID Pedido: "+ idPedido);
        System.out.println("Tipo: "+ tipoPedido);
        System.out.println("Dirección: "+direccion);
        System.out.println("Repartidor: "+(nombreRepartidor != null ? nombreRepartidor : "No asignado"));
        System.out.println("Requerimiento: "+getRequerimiento());
        System.out.println("Distancia: "+distanciaPedido+ " km.");
    }

    //Evita despachar pedidos cancelados.
    @Override
    public synchronized void despachar() {
        if(cancelarPedido){
            System.out.println("El pedido "+idPedido+" fue cancelado y no puede despacharse");
            return;
        }
        if(pedidoDespachado){return;}

        pedidoDespachado=true;
    }

    //Se evita cancelar pedidos despachados.
    @Override
    public synchronized void cancelar(){
            if (pedidoDespachado) {
                System.out.println("No es posible cancelar el pedido " + idPedido + " ya fue despachado.");
                return;
            }

             if(cancelarPedido){
                 System.out.println("El pedido "+idPedido+ " ya se encuentra cancelado.");
                 return;
             }

             cancelarPedido=true;
            System.out.println("Pedido "+idPedido+" fue cancelado de manera exitosa.");

            }

    @Override
    public String verEstado(){return estadoPedido.toString();}



        }








