# README - Aplicación "Running Car"

## Descripción de la Aplicación:

La aplicación "Running Car" es un juego sencillo que te pone al volante de un coche, desafiándote a esquivar obstáculos en la carretera. El objetivo es guiar el coche a través del tráfico, evitando colisiones con otros vehículos que se desplazan en distinta dirección. El coche tiene la capacidad de cambiar de carril, lo que añade un elemento estratégico al juego.

## BOCETO:
![BOCETO](https://github.com/Raaul04/Trabajo_carrera/assets/144156038/2d51e55a-6705-468f-91e1-5a4d97012adc)

## Descripción detallada de la aplicación:

La aplicación utiliza un esquema de clases implementado en Java y hace uso de la biblioteca Swing para la interfaz gráfica. El juego incluye las siguientes características clave:

- Control del coche mediante eventos de teclado.
- Obstáculos en movimiento que representan el tráfico en la carretera.
- El objetivo es avanzar lo más lejos posible sin colisiones.

## UML:
<img width="501" alt="UML_PRACTICA_4" src="https://github.com/Raaul04/Running_CAR/assets/144156038/08c8c9df-01e6-42aa-8b44-157ef9bda391">

## Componentes del Juego:

La aplicación "Running Car" consta de las siguientes clases principales:

1. **Clase Juego:** Interfaz principal del juego.
2. **Clase GameLoop:** representa el bucle principal del juego
3. **Clase Title:** Representa la pantalla de inicio del juego con un botón de inicio.
4. **Clase TitleManagement:** Gestiona la pantalla de inicio y la transición al juego principal.
5. **Clase Mecanica**: Clase que implementa KeyListener para gestionar los controles del jugador en el juego.
6. **Clase Singleton:** garantiza la existencia de una unica instancia de la clase Juego.



**Pantalla de Inicio - TitleManagement:**
   - <img width="135" alt="TITLE" 
      src="https://github.com/Raaul04/Running_CAR/assets/144156038/bd379008-db69-4716-a20d-bf07fe59ef59">


 **Juego en Progreso:**

  ![JUEGO.png](..%2F..%2F..%2F..%2FSynologyDrive1%2FNEBRIJA%2F2%BA%20A%D1O%2F1%BA%20CUATRIMESTRE%2FTECNICAS%20DE%20PROGRAMACION%2FJUEGO.png)

 **Puntuación:**

![puntos.png](..%2F..%2F..%2F..%2FSynologyDrive1%2FNEBRIJA%2F2%BA%20A%D1O%2F1%BA%20CUATRIMESTRE%2FTECNICAS%20DE%20PROGRAMACION%2Fpuntos.png)

 **Ganador**

![GANAR.png](..%2F..%2F..%2F..%2FSynologyDrive1%2FNEBRIJA%2F2%BA%20A%D1O%2F1%BA%20CUATRIMESTRE%2FTECNICAS%20DE%20PROGRAMACION%2FGANAR.png)

 **Termina**

  ![termina.png](..%2F..%2F..%2F..%2FSynologyDrive1%2FNEBRIJA%2F2%BA%20A%D1O%2F1%BA%20CUATRIMESTRE%2FTECNICAS%20DE%20PROGRAMACION%2Ftermina.png)

   
## Uso:
1. Ejecuta la aplicación.
2. Utiliza las teclas de dirección para controlar el coche y evitar colisiones.
3. Disfruta del juego y trata de llegar lo más lejos posible.

## Arquitectura y Tecnologías:

La aplicación está implementada en Java y utiliza la biblioteca Swing para la interfaz gráfica.

## Ejecutar el Juego:

Para ejecutar el juego, utiliza la clase `Main` y ejecuta el método `main`:

```java
package VideoJuego;

import Title.TitleManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // SwingUtilities.invokeLater se utiliza para asegurarse de que la interfaz de usuario se actualice en el Event Dispatch Thread (EDT),
        // Se necesita para operaciones relacionadas con la interfaz gráfica en Swing.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Creamos una instancia de TitleManagement para gestionar la transición entre la pantalla de título y el juego
                TitleManagement titleManagement = new TitleManagement();

                // Configurar y mostrar la ventana principal
                titleManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                titleManagement.setSize(200, 200);
                titleManagement.setVisible(true);

                // Agregar un ActionListener al botón "Iniciar juego" en TitleManagement
                titleManagement.addStartButtonActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Cuando se hace clic en "Iniciar juego", ocultar la pantalla de título y mostrar el juego
                        titleManagement.setVisible(false);

                        // Crear e iniciar el juego
                        Juego juego = new Juego();
                    }
                });
            }
        });
    }
}

