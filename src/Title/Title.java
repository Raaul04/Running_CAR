package Title;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase Title representa la pantalla de inicio del juego.
 * Contiene un boton de inicio que, cuando se presiona, notifica a
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
        setBackground(new Color(135, 206, 250));  // Fondo de color cielo azul claro

        // Configurar el boton de inicio
        startButton = new JButton("¡Comienza!");
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setForeground(Color.BLACK);
        startButton.setBackground(new Color(60, 179, 113));  // Fondo de color verde pastel
        startButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titleManagement.startGame();
            }
        });

        // Agregar componentes a la pantalla de título
        add(startButton, BorderLayout.CENTER);
    }

    /**
     * Agrega un ActionListener al boton de inicio en la pantalla de titulo.
     *
     * @param listener ActionListener a agregar.
     */
    public void addStartButtonActionListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }
}
