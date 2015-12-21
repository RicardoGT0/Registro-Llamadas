/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contador.llamadas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Thunder
 */
public class ContadorLlamadas extends JApplet {

    private static final int JFXPANEL_WIDTH_INT = 300;
    private static final int JFXPANEL_HEIGHT_INT = 250;
    private static JFXPanel fxContainer;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                }

                JFrame frame = new JFrame("JavaFX 2 in Swing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JApplet applet = new ContadorLlamadas();
                applet.init();

                frame.setContentPane(applet.getContentPane());

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                applet.start();
            }
        });
    }

    @Override
    public void init() {
        fxContainer = new JFXPanel();
        fxContainer.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT));
        add(fxContainer, BorderLayout.CENTER);
        // create JavaFX scene
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                createScene();
            }
        });
    }

    Tiempo t = new Tiempo();
    int state = 0;
    Respaldo r = new Respaldo("Backup.txt");
    
    List<llamada> memoria = new ArrayList<llamada>();
    String empresa = "";
    String e_s = "";
    String fecha = "";
    String h_inicial = "";
    String duracion = "";
    String h_final = "";

    private void createScene() {
        Button btn = new Button();
        btn.setText("Inicia llamada");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if (state == 0) {
                    h_inicial = t.getHora(); //Hora inicial 
                    fecha = t.getFecha();
                    t.Contar();//empieza contador
                    btn.setText(t.getHora());
                    state = 1;
                } else {
                    h_final = t.getHora();
                    btn.setText("Duracion = " + String.valueOf(t.getDuracion()));
                    duracion = String.valueOf(t.getDuracion());
                    t.Detener();//Detiene contador
                    state = 0;
                    llamada l = new llamada(empresa, e_s, fecha, h_inicial, duracion, h_final);
                    memoria.add(l);
                    r.escribir(memoria);
                }

            }
        }
        );
        StackPane root = new StackPane();

        root.getChildren()
                .add(btn);
        fxContainer.setScene(
                new Scene(root));
    }

}
