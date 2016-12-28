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
    
    public int ds_x;
    public int ds_y;
    
    
    public Cartas(int x, int y, int ds_x, int ds_y ) {
        this.x = x;
        this.y = y;  
        this.ds_x = ds_x ;
        this.ds_y = ds_y;
        try {
            carta = ImageIO.read(new File("src/imagenes/cartita.png"));
        } catch (IOException e) {
            System.out.println("error en las cartas"+e.toString());
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
