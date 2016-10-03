package main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lienzo extends Canvas implements Constantes{

//para pintar el lienzo
public Calles calle;
public Lienzo(){
    calle =new Calles(this);
    this.setSize(calle.anchoCalle, calle.altoCalle);
/*setea las dimenciones de calle */


addMouseListener(new MouseAdapter() {
@Override

public void mouseClicked(MouseEvent evt) {
activarCelda(evt);
repaint();
}
});

addKeyListener(new java.awt.event.KeyAdapter() {
@Override
public void keyPressed(KeyEvent e) {
        calle.moverCelda(e);
        repaint();
        }
    });
}

@Override
public void paint(Graphics g) {
calle.paintComponent(g);
}
 
private void activarCelda(MouseEvent evt) {
    int aX=evt.getX();
    int aY=evt.getY();
    for(int i=0; i < anchoMV; i++){
        for ( int j=0 ; j < altoMV ; j++){
            if (calle.celdas[i][j].celdaSeleccionada(aX,aY)){
                if((evt.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
                    System.out.println("Boton derecho - Poner Pared");
                    calle.celdas[i][j].tipo='M';
                }
                else {
                System.out.println("Boton izquierdo - Poner Peaton");
                calle.celdas[i][j].tipo='P';
                }
             /*   
            calle.celdas[i][j].celdaSeleccionada(aX,aY);                       
            calle.celdaMovimiento.x=aX/dimCelda;
            calle.celdaMovimiento.y=aY/dimCelda;
            */
           }
        }
    }
    /*
calle.celdas[2][2].tipo ='J';
*/
}
}

/*

if ( laberinto.celdas[i][j].celdaSeleccionada(evt.getX(),evt.getY()) ) {
//Para saber si se pulso
}
}
}
}
*/