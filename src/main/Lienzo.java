package main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Lienzo extends Canvas implements Constantes{
public Calles calle;
public Timer lanzadorTareas;
public Graphics graficoBuffer;
public Image imagenBuffer;
public Image fondo;
public Lienzo(){
    calle =new Calles(this);
    this.setSize(calle.anchoCalle, calle.altoCalle);
    lanzadorTareas=new Timer();
    lanzadorTareas.scheduleAtFixedRate(calle.cartero.inteligencia,0,500);
    
    try {
        fondo = ImageIO.read(new File("src/imagenes/Fondo.png"));
        } catch (IOException e) {
            System.out.println("error fondo"+e.toString());
        }
    
addMouseListener(new MouseAdapter() {
@Override
    public void mouseClicked(MouseEvent evt) {
        agregarObstaculo(evt);
        repaint();
        }
});

addKeyListener(new java.awt.event.KeyAdapter() {
@Override
    public void keyPressed(KeyEvent e) {
        calle.cartero.moverCartero(e);
        repaint();
        }
});

}

@Override
public void update(Graphics g) {
calle.paintComponent(g); 
    if(graficoBuffer==null){
        imagenBuffer=createImage(this.getWidth(),this.getHeight());
        graficoBuffer=imagenBuffer.getGraphics();
    }
    graficoBuffer.setColor(getBackground());
    graficoBuffer.fillRect(0,0,this.getWidth(),this.getHeight());
    graficoBuffer.drawImage(fondo, 0, 0, null);
    calle.update(graficoBuffer);
    g.drawImage(imagenBuffer, 0, 0, null);
}

@Override
public void paint(Graphics g) {
update(g);
}

 private void agregarObstaculo(MouseEvent evt) {
    int aX=evt.getX();
    int aY=evt.getY();
    if((evt.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
        if(calle.celdas[aX/dimCelda][aY/dimCelda].tipo=='A'){
                            System.out.println("Boton Izquierdo - Poner Obstaculo");
                             calle.celdas[aX/dimCelda][aY/dimCelda].tipo='O';
            }
        }
    else {
        System.out.println("Boton Derecho - Poner Peaton");
        calle.celdas[aX/dimCelda][aY/dimCelda].tipo='P';
        }       
    }
}