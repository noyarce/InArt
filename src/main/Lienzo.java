package main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;

public class Lienzo extends Canvas implements Constantes{
public Calles calle;

public Lienzo(){
    
    calle =new Calles(this);
    
    
    this.setSize(calle.anchoCalle, calle.altoCalle);

    
    
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
}

@Override
public void paint(Graphics g) {
update(g);
}

 private void agregarObstaculo(MouseEvent evt) {
    int aX=evt.getX();
    int aY=evt.getY();
    if((evt.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
        if(calle.celdas[aX/dimCelda][aY/dimCelda].tipo!='A'){
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