# Descripción de la Aplicación "Running Car"

La aplicación "Running Car" es un juego simple en el que controlas un coche y debes esquivar obstáculos en la carretera. El coche puede cambiar de carril  para evitar colisiones.

## Descripción detallada de la aplicación

La aplicación "Running Car" es un juego de conducción en el que debes guiar un coche a través del tráfico, evitando colisiones con otros vehículos. Algunas características clave incluyen:

- Control del coche mediante eventos de teclado.
- Obstáculos en movimiento que representan el tráfico en la carretera.
- Cambio aleatorio de carril del coche para dificultar el adelantamiento.
- El objetivo es llegar lo más lejos posible sin colisiones.

## Componentes del Juego

La aplicación "Running Car" consta de los siguientes componentes:

- Clase `Juego`: Interfaz principal del juego.
- Clase `Coche`: Representa el vehículo del jugador.
- Clase `Moto`: Representa un tipo de vehículo que puede cambiar de carril aleatoriamente.
- Clase `Camion`: Representa un tipo de vehículo que puede cambiar de carril aleatoriamente.
- Clase `Trafico`: Gestiona la posición de obstáculos en el juego y lleva un registro de puntos.
- Clase `Ventana`: Representa la ventana principal del juego.
- Clase `Player`: Representa al jugador en el juego y gestiona su movimiento.

## Uso

Para jugar a "Running Car," sigue estos pasos:

1. Ejecuta la aplicación.
2. Utiliza las teclas de dirección para controlar el coche y evitar colisiones.
3. Disfruta del juego y trata de llegar lo más lejos posible.

## Arquitectura y tecnologías

La aplicación "Running Car" está implementada en Java y utiliza la biblioteca Swing para la interfaz gráfica.

## Ejecutar el Juego

Para ejecutar el juego, puedes utilizar la clase `Main`. Ejecuta el método `main` de la siguiente manera:

```java
public class Main {
    public static void main(String[] args) {
        new Juego();
    }
}
