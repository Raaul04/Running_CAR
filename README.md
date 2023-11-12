# README - Aplicación "Running Car"

## Descripción de la Aplicación:

La aplicación "Running Car" es un juego sencillo que te pone al volante de un coche, desafiándote a esquivar obstáculos en la carretera. El objetivo es guiar el coche a través del tráfico, evitando colisiones con otros vehículos que se desplazan en la misma dirección. El coche tiene la capacidad de cambiar de carril, lo que añade un elemento estratégico al juego.

## BOCETO:
![BOCETO](https://github.com/Raaul04/Trabajo_carrera/assets/144156038/2d51e55a-6705-468f-91e1-5a4d97012adc)

## Descripción detallada de la aplicación:

La aplicación utiliza un esquema de clases implementado en Java y hace uso de la biblioteca Swing para la interfaz gráfica. El juego incluye las siguientes características clave:

- Control del coche mediante eventos de teclado.
- Obstáculos en movimiento que representan el tráfico en la carretera.
- Cambio aleatorio de carril del coche para dificultar el adelantamiento.
- El objetivo es avanzar lo más lejos posible sin colisiones.

## UML:
![UML](https://github.com/Raaul04/Trabajo_carrera/assets/144156038/b27e75db-fb37-4541-91fd-b55790418635)

## Componentes del Juego:

La aplicación "Running Car" consta de las siguientes clases principales:

1. **Clase Juego:** Interfaz principal del juego.
2. **Clase Coche:** Representa el vehículo del jugador.
3. **Clase Moto:** Representa un tipo de vehículo que puede cambiar de carril aleatoriamente.
4. **Clase Camión:** Representa un tipo de vehículo que puede cambiar de carril aleatoriamente.
5. **Clase Tráfico:** Gestiona la posición de obstáculos en el juego y lleva un registro de puntos.
6. **Clase Ventana:** Representa la ventana principal del juego.
7. **Clase Player:** Representa al jugador en el juego y gestiona su movimiento.
8. **Clase Title:** Representa la pantalla de inicio del juego con un botón de inicio.
9. **Clase TitleManagement:** Gestiona la pantalla de inicio y la transición al juego principal.

## Uso:

1. Ejecuta la aplicación.
2. Utiliza las teclas de dirección para controlar el coche y evitar colisiones.
3. Disfruta del juego y trata de llegar lo más lejos posible.

## Arquitectura y Tecnologías:

La aplicación está implementada en Java y utiliza la biblioteca Swing para la interfaz gráfica.

## Ejecutar el Juego:

Para ejecutar el juego, utiliza la clase `Main` y ejecuta el método `main`:

```java
package Juego;
import Title.TitleManagement;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TitleManagement titleManagement = new TitleManagement();
                titleManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                titleManagement.setSize(400, 400);
                titleManagement.setVisible(true);
            }
        });
    }
}
