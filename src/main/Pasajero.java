
package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Pasajero extends JComponent implements Constantes {
  public int x;
    public int y;
    public BufferedImage pasajero;
    
    public Pasajero(int x, int y) {
        this.x = x;
        this.y = y;       
        try {
            pasajero = ImageIO.read(new File("src/imagenes/pasajero.png"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    
    @Override
    public void update(Graphics g) {
        g.drawImage(pasajero, x, y, null);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        update(g);
    }   
}
