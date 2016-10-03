package main;
    
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**/
public class Ventana extends JFrame {
public Lienzo lienzo;

public Ventana() {
    lienzo = new Lienzo();
    lienzo.setFocusable(true);
    lienzo.requestFocus();
    this.getContentPane().setLayout(new BorderLayout());
    this.getContentPane().add(lienzo);
    this.setSize(lienzo.getWidth()+60,lienzo.getHeight()+70);
    this.setResizable(false);
    }
}
    

