![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# 🧠 Evaluación Sumativa 2 Semana 5 – Desarrollo Orientado a Objetos II

## 👤 Autor del proyecto
- **Nombre completo:** Gabriela Goycochea
- **Sección:** 002A
- **Carrera:** Analista Programador Computacional
- **Sede:** Duoc Online

---

## 📘 Descripción general del sistema

El sistema FastFoodV3 (Version3). Es un menu donde es posible ver historial de pedidos despachados.
Cancelar pedidos e iniciar los trabajos para el despacho de los pedidos. Permite 3 tipos diferentes de pedidos,
los cuales los repartidores deben cumplir los requerimientos antes de recoger alguno para repartir

---

## 🧱 Estructura general del proyecto

```plaintext

 FastFoodV3/
 ├── .idea/
 ├── out
 ├── src/
 │    └── com.Sistema.FastFoodV3
 │        ├── Gestor
 │        │     └── HistoriaDePedidos.java
 │        │
 │        ├── Model
 │        │     └──Cancelable.java
 │        │     └──Despachable.java
 │        │     └──EstadoPedido.java
 │        │     └──Informaciones.java
 │        │     └──Pedido.java
 │        │     └──PedidoComida.java
 │        │     └──PedidoEnvio.java
 │        │     └──PedidoExpress.java
 │        │     └──Rastreable.java
 │        │     └──Repartidor.java
 │        │     └──ZonaDeCarga.java
 │        │       
 │        ├──UI                  
 │            └── Main.java            
 │                          
 ├──  README.md                  
 └──  .gitignore
   

````

# ccom.Sistema.FastFoodV3

El sistema contiene 3 paquetes Gestor - Model - UI

En gestor especificamente se ingresan los pedidos despachados al historial, si no esta despachado no cuenta dentro de la lista
Model contiene la gran parte del programa con clases como Pedido, Repartidor, ZonaDeCarga las cuales son las clases "principales".
Van primero la clase padre pedido para la discriminación de los pedidos de comida / envio/ express.

La clase Repartidor toma los datos y caracteristicas para que cada repartidor puede tomar solo pedidos con sus caracteristicas.
Y ZonaDeCarga que es donde se hace el pick up del pedido o se recoge el despacho de corresponder.

Luego tenemos los tipos de pedidos que cada uno tiene sus caracteristicas y las interfaces para un mejor control
Se agrego EstadoPedido para priorizar las colas o enumerar los estados.

---

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/GabrielaGoycochea/SistemaFastFoodV3.git
```

2. Abre el proyecto en IntelliJ IDEA.

3. Ejecuta el archivo `Main.java` desde el paquete `UI` para resultados en consola.

4. Sigue las instrucciones en consola o en la interfaz gráfica (si corresponde).


---

**Repositorio GitHub:** https://github.com/GabrielaGoycochea/SistemaFastFoodV3.git
**Fecha de entrega:** 09/02/2026

---

© Duoc UC | Escuela de Informática y Telecomunicaciones |  