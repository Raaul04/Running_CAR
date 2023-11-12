package Title;

import Juego.Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase Title representa la pantalla de inicio del juego.
 * Contiene un botón de inicio que, cuando se presiona, notifica a
 * la clase TitleManagement para iniciar el juego principal.
 */
public class Title extends JPanel {
    private JButton startButton;
    private TitleManagement titleManagement;

    /**
     * Constructor de la clase Title.
     *
     * @param titleManagement La instancia de TitleManagement para manejar eventos.
     */
    public Title(TitleManagement titleManagement) {
        this.titleManagement = titleManagement;

        setLayout(new BorderLayout());

        // Configurar el botón de inicio
        startButton = new JButton("Empieza");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titleManagement.startGame();
            }
        });

        // Agregar componentes a la pantalla de título
        add(startButton, BorderLayout.CENTER);
    }
}
