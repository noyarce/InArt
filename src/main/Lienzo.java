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
public Bus bus;
public Peaton peaton, peaton2, peaton3;
public Automovil auto, auto2, auto3, auto4, auto5;
public Timer temporizador;

public Lienzo(){
    
    calle =new Calles(this);
    auto=new Automovil(calle);
    auto2=new Automovil(calle);
    auto3=new Automovil(calle);
    auto4=new Automovil(calle);
    
    peaton = new Peaton(calle);
    peaton2 = new Peaton(calle);
    peaton3 = new Peaton(calle);
    bus = new Bus (calle);
    cartero=new Cartero(calle);
    
    this.setSize(calle.anchoCalle, calle.altoCalle);

    temporizador = new Timer(); 
    
    /*
        BusquedaRutaAmp buscador=new BusquedaRutaAmp(this);
        buscador.buscar();
        buscador.calcularRuta();
        temporizador.scheduleAtFixedRate(buscador, 0, 500); 
      */   
    
    /*declaracion de automoviles*/
    temporizador.scheduleAtFixedRate( auto , 0 , 200);
    temporizador.scheduleAtFixedRate( auto2 , 0 , 100);
    temporizador.scheduleAtFixedRate( auto3 , 0 , 500);
    temporizador.scheduleAtFixedRate( auto4 ,0 , 300);
    
    temporizador.scheduleAtFixedRate( bus, 0 , 400);

    
    /*iniciacion de peatones*/
    temporizador.scheduleAtFixedRate( peaton , 0 ,800);
    temporizador.scheduleAtFixedRate( peaton2 , 0 ,800);
    temporizador.scheduleAtFixedRate( peaton3 , 0 ,800);
    
    
    
    
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