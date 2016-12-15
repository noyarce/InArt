package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;


public class Cartas extends JComponent implements Constantes {
    public int x;
    public int y;
    public BufferedImage carta;
    
    public Cartas(int x, int y) {
        this.x = x;
        this.y = y;       
        try {
            carta = ImageIO.read(new File("src/imagenes/cartita.png"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    
    @Override
    public void update(Graphics g) {
        g.drawImage(carta, x, y, null);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        update(g);
    }
}
