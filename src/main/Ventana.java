package main;
    
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Ventana extends JFrame implements Constantes{
public Lienzo lienzo;
public HiloMusica player;

public Ventana() {
    lienzo = new Lienzo();
    lienzo.setFocusable(true);
    lienzo.requestFocus();
    this.getContentPane().setLayout(new BorderLayout());
    this.getContentPane().add(lienzo);
    this.setSize(lienzo.getWidth()+60,lienzo.getHeight()+70);
    this.setResizable(false);
    player=new HiloMusica(RUTA+"/src/musica/musica.wav",3);
    player.run();
    }
}
    

