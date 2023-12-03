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



 **Juego en Progreso:**
=======
1. *Clase Juego:* Interfaz principal del juego.
2. *Clase GameLoop:* representa el bucle principal del juego
3. *Clase Title:* Representa la pantalla de inicio del juego con un botón de inicio.
4. *Clase TitleManagement:* Gestiona la pantalla de inicio y la transición al juego principal.
5. *Clase Mecanica*: Clase que implementa KeyListener para gestionar los controles del jugador en el juego.
6. *Clase Singleton:* garantiza la existencia de una unica instancia de la clase Juego.


## Pantalla de Inicio - TitleManagement:
 
<img width="135" alt="Captura de pantalla 2023-11-17 165142" src="https://github.com/Raaul04/Running_CAR/assets/144156038/757d3c02-c6b7-416d-9116-8be50eddc9a2">

## Juego en Progreso:

 
<img width="598" alt="JUEGO" src="https://github.com/Raaul04/Running_CAR/assets/144156038/ff321899-f8a9-491d-97d8-5bf07984fdde">


 ## Puntuacion:
 

<img width="601" alt="puntos" src="https://github.com/Raaul04/Running_CAR/assets/144156038/36c63708-64b5-4d1f-9f7a-f2f873f9fac6">



 ## Ganador:
 

<img width="594" alt="GANAR" src="https://github.com/Raaul04/Running_CAR/assets/144156038/85aa5ce7-5b5b-426f-b5fe-cd9d6fc46829">



 ## Termina:
 

<img width="605" alt="termina" src="https://github.com/Raaul04/Running_CAR/assets/144156038/1b8ade73-89ff-45bf-aa47-79f507d6ad55">

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

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase Main contiene el metodo principal que inicia la aplicacion del videojuego.
 */
public class Main {

    /**
     * El metodo principal que inicia la aplicacion del videojuego.
     *
     * @param args Los argumentos de la linea de comandos.
     */
    public static void main(String[] args) {
        // SwingUtilities.invokeLater se utiliza para asegurarse de que la interfaz de usuario se actualice en el Event Dispatch Thread (EDT),
        // Se necesita para operaciones relacionadas con la interfaz grafica en Swing.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Creamos una instancia de TitleManagement para gestionar la transicion entre la pantalla de titulo y el juego
                TitleManagement titleManagement = new TitleManagement();

                // Configurar y mostrar la ventana principal
                titleManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                titleManagement.setSize(200, 200);
                titleManagement.setVisible(true);

                // Agregar un ActionListener al botón "Iniciar juego" en TitleManagement
                titleManagement.addStartButtonActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Cuando se hace clic en "Iniciar juego", ocultar la pantalla de titulo y mostrar el juego
                        titleManagement.setVisible(false);

                        // Crear e iniciar el juego
                        Juego juego;
                        juego = Singleton.getJuego();
                        juego.starGameThread();
                    }
                });
            }
        });
    }
}

