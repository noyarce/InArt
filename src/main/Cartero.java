package main;

import java.awt.event.KeyEvent;
import java.util.TimerTask;
import javax.swing.JOptionPane;


public class Cartero extends TimerTask implements Constantes {
    public Calles calle;
public Celda cartero;

public Cartero(Calles calle) {
    this.calle=calle;
    cartero=new Celda(pyr_x, pyr_y,'J');   
    calle.celdas[cartero.x][cartero.y].tipo='J';
    }
     
public void moverCartero( KeyEvent evento ) {

        switch( evento.getKeyCode() ) {
            case 38:   
                moverCrtArriba();
                break;
            case 40 :
                moverCrtAbajo();
                break;
            case 37:
                moverCrtIzquierda();
                break;
            case 39:
                moverCrtDerecha();
                break;
        }
    }

private void moverCrtArriba(){
if(cartero.y>0){   
    char op =calle.celdas[cartero.x][cartero.y-1].tipo;
    switch (op){
        
    case('A'):{/*
        calle.celdas[cartero.x][cartero.y].tipo ='A';
        cartero.y=cartero.y-1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
        System.out.println("Mover Arriba: "+ cartero.y+" - "+cartero.x);
        */
        System.out.println("Choque! No se puede mover mas hacia Arriba");  
    break;
        
    }
    case('C'): {
        calle.celdas[cartero.x][cartero.y].tipo ='C';
        cartero.y=cartero.y-1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
        System.out.println("Mover Arriba: "+ cartero.y+" - "+cartero.x);
    break;
    }   
    case ('X'): {
        calle.celdas[cartero.x][cartero.y].tipo ='C';
        cartero.y=cartero.y-1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
        System.out.println("Mover Arriba: "+ cartero.y+" - "+cartero.x + " Carteron en Portal ");
        
        JOptionPane.showMessageDialog(null,"Carteron en Portal ");
        
        break;
    }
    case ('M'):{
        System.out.println("Choque! No se puede mover mas hacia Arriba");
        break;
    }
    case ('P'):{
       System.out.println("Choque! No se puede mover mas hacia Arriba");
       break;
    }
    case ('T'):{
       System.out.println("Atropello! No se puede mover mas hacia Arriba");
       break;
    }

    }
}
}
private void moverCrtAbajo(){
    if(cartero.y<altoMV-1){
    char op = calle.celdas[cartero.x][cartero.y+1].tipo;
    switch(op){
        
    case('C'): {
        calle.celdas[cartero.x][cartero.y].tipo='C';
        cartero.y=cartero.y+1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
        System.out.println("Mover Abajo: " +cartero.y+" - "+cartero.x);
        break;
        }
    case ('X'): {
        calle.celdas[cartero.x][cartero.y].tipo='C';
        cartero.y=cartero.y+1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
        System.out.println("Mover Abajo: " +cartero.y+" - "+cartero.x+ " Carteron en Portal  ");
        
        JOptionPane.showMessageDialog(null," Carteron en Portal");
        break;
        }
    case('P'):{
        System.out.println("Choque! No se puede mover mas hacia Abajo!");
        break;
        }
    case('M'):{
        System.out.println("Choque! No se puede mover mas hacia Abajo!");
        break;
        }
    case('A'):{
    /*
        calle.celdas[cartero.x][cartero.y].tipo='C';
        cartero.y=cartero.y+1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
        System.out.println("Mover Abajo: " +cartero.y+" - "+cartero.x);
        break;
    */    
        System.out.println("Choque! No se puede mover mas hacia Abajo!");
        }
        case ('T'):{
       System.out.println("Atropello! No se puede mover mas hacia Abajo");
       break;
    }

    
    }
}
}
private void moverCrtIzquierda(){
 if(cartero.x>0){
    char op = calle.celdas[cartero.x-1][cartero.y].tipo ;
    switch (op){      
    case ('C'): {
        calle.celdas[cartero.x][cartero.y].tipo='C';
        cartero.x=cartero.x-1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
        System.out.println("Mover Izquierda: "+cartero.y+" - "+cartero.x);
        break;
    }
    case ('X'): {
        calle.celdas[cartero.x][cartero.y].tipo='C';
        cartero.x=cartero.x-1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
        System.out.println("Mover Izquierda: "+cartero.y+" - "+cartero.x+ " Carteron en Portal ");
        
        JOptionPane.showMessageDialog(null,"Carteron en Portal");
     break;   
    }
    case ('M'):{
        System.out.println("Choque! No se puede mover mas a la Izquierda!");
        break;
    }
    case 'P':{
        System.out.println("Choque! No se puede mover mas a la Izquierda!");
        break;
        }
    case('A'):{/*
        calle.celdas[cartero.x][cartero.y].tipo='C';
        cartero.x=cartero.x-1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
        System.out.println("Mover Izquierda: "+cartero.y+" - "+cartero.x);
    */   
        System.out.println("Choque! No se puede mover mas a la Izquierda!");
        break;
        }
        case ('T'):{
       System.out.println("Atropello! No se puede mover mas hacia a la Izquierda");
       break;
    }

    }
}
}
private void moverCrtDerecha(){
    if(cartero.x<anchoMV-1){
char op = calle.celdas[cartero.x+1][cartero.y].tipo;
switch (op){  
    case('C'):{
       calle.celdas[cartero.x][cartero.y].tipo='C';
       cartero.x=cartero.x+1;
       calle.celdas[cartero.x][cartero.y].tipo='J';
       System.out.println("Mover Derecha: "+cartero.y+" - "+cartero.x);
    break;
    }
    case ('X'):{
        calle.celdas[cartero.x][cartero.y].tipo='C';
       cartero.x=cartero.x+1;
       calle.celdas[cartero.x][cartero.y].tipo='J';
       System.out.println("Mover Derecha: "+cartero.y+" - "+cartero.x + " Carteron en Portal ");
       JOptionPane.showMessageDialog(null,"Cartero en Portal ");
    break;
    }
    case ('M'):{
         System.out.println("Choque! No se puede mover mas a la Derecha!");
        break;
    }
    case ('P'):{
        System.out.println("Choque! No se puede mover mas a la Derecha!");
        break;
    }
     case('A'):{/*
         if(calle.celdas[cartero.x-1][cartero.y].tipo=='C'){
            calle.celdas[cartero.x][cartero.y].tipo='C';
            cartero.x=cartero.x+1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
         }
         else{
            calle.celdas[cartero.x][cartero.y].tipo='A';
            cartero.x=cartero.x+1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            }
            System.out.println("Mover Derecha: "+cartero.y+" - "+cartero.x);    
*/
        System.out.println("Choque! No se puede mover mas a la Derecha!");
        break;
    }
    case ('T'):{
       System.out.println("Atropello! No se puede mover mas hacia la Derecha");
       break;
    }

    }
}
}
    
@Override
    public void run() {
            calle.lienzoPadre.repaint();

    }
}