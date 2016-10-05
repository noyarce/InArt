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
    /*  
    for(int i=0; i < anchoMV; i++){
            for ( int j=0 ; j < altoMV ; j++){
               if (calle.celdas[i][j].celdaSeleccionada(aX,aY)){               
      
                    }
            }*/
               if((evt.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
                        if(calle.celdas[aX/dimCelda][aY/dimCelda].tipo!='J' && calle.celdas[aX/dimCelda][aY/dimCelda].tipo!='X' ){
                            System.out.println("Boton Izquierdo - Poner Obstaculo");
                            calle.celdas[aX/dimCelda][aY/dimCelda].tipo='O';
                        }
                    }
                    else {
                           System.out.println("Boton Derecho - Poner Peaton");
                           calle.celdas[aX/dimCelda][aY/dimCelda].tipo='P';
                        }       
             /*   
            calle.celdas[i][j].celdaSeleccionada(aX,aY);                       
            calle.celdaMovimiento.x=aX/dimCelda;
            calle.celdaMovimiento.y=aY/dimCelda;
            */
                }
            }
        
    
