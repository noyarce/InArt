package main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;

public class Lienzo extends Canvas implements Constantes{
public Cartero cartero;
public Calles calle;
public Peaton peaton;
public Automovil auto, auto2;
public Timer temporizador;

public Lienzo(){
    
    calle =new Calles(this);
    auto=new Automovil(calle);
    auto2=new Automovil(calle);
    peaton = new Peaton(calle);
    cartero=new Cartero(calle);
    
    this.setSize(calle.anchoCalle, calle.altoCalle);

    temporizador = new Timer(); 
    
    temporizador.scheduleAtFixedRate( auto , 0 , 400);
    temporizador.scheduleAtFixedRate( auto2 ,0 , 300);
    temporizador.scheduleAtFixedRate( peaton , 0 ,900);
        
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
        cartero.moverCartero(e);
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
        if(calle.celdas[aX/dimCelda][aY/dimCelda].tipo!='J'
           && calle.celdas[aX/dimCelda][aY/dimCelda].tipo!='X' 
           && calle.celdas[aX/dimCelda][aY/dimCelda].tipo!='T' 
           &&calle.celdas[aX/dimCelda][aY/dimCelda].tipo!='M' ){
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
        
    
