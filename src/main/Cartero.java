package main;

import java.awt.event.KeyEvent;
import java.util.TimerTask;
import javax.swing.JOptionPane;


public class Cartero extends TimerTask implements Constantes {
    public Calles calle;
    public Celda cartero;

public Cartero(Calles calle) {
    this.calle=calle;
    cartero=new Celda(pyr_x, pyr_y,pyr_x, pyr_y,'J');   
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
if(cartero.y>0 ){
char op =calle.celdas[cartero.x][cartero.y-1].tipo;
    switch (op){
    
        case('C'): {
        if(vieneAuto(calle,cartero)==false){
            calle.celdas[cartero.x][cartero.y].tipo=vcozv(cartero);
            cartero.y=cartero.y-1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            break;
            }
        else{
            break;
            }
        }

    case('A'):{
        if ((cartero.y%3==0)&&(cartero.y%6!=0)){
                    calle.celdas[cartero.x][cartero.y].tipo='Z';
                }
                else{
                   calle.celdas[cartero.x][cartero.y].tipo='A';
                }
                
        cartero.y=cartero.y-1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
        System.out.println("Mover Arriba: "+ cartero.y+" - "+cartero.x); 
    break;
        
    }
    case('Z'): {
        if(vieneAuto(calle,cartero)==false){
            calle.celdas[cartero.x][cartero.y].tipo ='A';
            cartero.y=cartero.y-1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            System.out.println("Mover Arriba: "+ cartero.y+" - "+cartero.x);
            break;
        }
        else{
            break;
        }
    }
    case ('X'): {
        calle.celdas[cartero.x][cartero.y].tipo ='A';
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
       System.out.println("Auto! No se puede mover mas hacia Arriba");
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
        if(vieneAuto(calle,cartero)==false){
            calle.celdas[cartero.x][cartero.y].tipo=vcozv(cartero);
            cartero.y=cartero.y+1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            break;
        }
        else{
            break;
        }
    }
        
    case ('X'): {
        calle.celdas[cartero.x][cartero.y].tipo='A';
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
        if ((cartero.y%3==0)&&(cartero.y%6!=0)){
            calle.celdas[cartero.x][cartero.y].tipo='Z';
        }
       else{
             calle.celdas[cartero.x][cartero.y].tipo='A';
        }
        cartero.y=cartero.y+1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
        System.out.println("Mover Arriba: "+ cartero.y+" - "+cartero.x); 
    break;
        
    }
    case('Z'): {
         if(vieneAuto(calle,cartero)==false){
            calle.celdas[cartero.x][cartero.y].tipo ='A';
            cartero.y=cartero.y+1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            System.out.println("Mover Arriba: "+ cartero.y+" - "+cartero.x);   
            break;
         }
         else{
            break;
         }
    }  
    case ('T'):{
       break;
     }  
   }
 }
}
private void moverCrtIzquierda(){
 if(cartero.x>0){
    char op = calle.celdas[cartero.x-1][cartero.y].tipo ;
    switch (op){    
 
    case('C'):{
            if(vieneAuto(calle,cartero)==false){
            calle.celdas[cartero.x][cartero.y].tipo=vcozh(cartero);
            cartero.x=cartero.x-1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            break;
            }
            else{
                 
            break;
            }
    }
  
    case ('X'): {
        calle.celdas[cartero.x][cartero.y].tipo='A';
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
    case('A'):{
        if ((cartero.x%3==0)&&(cartero.x%6!=0)){
                    calle.celdas[cartero.x][cartero.y].tipo='Z';
                }
                else{
                   calle.celdas[cartero.x][cartero.y].tipo='A';
                }
        cartero.x=cartero.x-1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
        System.out.println("Mover Izquierda: "+ cartero.y+" - "+cartero.x); 
    break;
        
    }
    case('Z'): {
        if(vieneAuto(calle,cartero)==false){
            calle.celdas[cartero.x][cartero.y].tipo ='A';
            cartero.x=cartero.x-1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            System.out.println("Mover Izquierda: "+ cartero.y+" - "+cartero.x);
            break;
        }
        else{
            break;
        }
    }  
        case ('T'):{
            break;
        }
    }
}
}
private void moverCrtDerecha(){
    if((cartero.x<anchoMV-1)){
    char op = calle.celdas[cartero.x+1][cartero.y].tipo;
        switch (op){  
        case ('X'):{
            calle.celdas[cartero.x][cartero.y].tipo='A';
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
        case('A'):{
            if ((cartero.x%3==0)&&(cartero.x%6!=0)){
                calle.celdas[cartero.x][cartero.y].tipo='Z';
                }
            else{
                calle.celdas[cartero.x][cartero.y].tipo='A';
                }   
            cartero.x=cartero.x+1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            System.out.println("Mover Derecha: "+ cartero.y+" - "+cartero.x); 
            break;
            }
        case('Z'): {
            if(vieneAuto(calle,cartero)==false){
                calle.celdas[cartero.x][cartero.y].tipo ='A';
                cartero.x=cartero.x+1;
                calle.celdas[cartero.x][cartero.y].tipo='J';
                System.out.println("Mover Derecha: "+ cartero.y+" - "+cartero.x);
                break;
            }
            else{
                break;
            }
        }
        case ('T'):{
            break;
            }
        
        case('C'): {
            if(vieneAuto(calle,cartero)==false){
                calle.celdas[cartero.x][cartero.y].tipo=vcozh(cartero);
                cartero.x=cartero.x+1;
                calle.celdas[cartero.x][cartero.y].tipo='J';
                break;
            }
            else{
                break;
            }
        }
      }
    }
}


private boolean vieneAuto(Calles calle , Celda cartero){
    boolean flag=false;
    for(int i=-4; i<4; i++){
        for (int j=-4; j<4;j++){
                if(((cartero.x+i>0)&&(cartero.y+j>0))&&((cartero.x+i<anchoMV-1)&&(cartero.y+j<altoMV-1))){
                    if((calle.celdas[cartero.x+i][cartero.y+j].tipo== 'T')){
                        flag=true;
                        break;
                    }
                }
        }
    }    
    return flag;
}

/*vereda, calle o p. cebra vertical */
public char vcozv(Celda cartero){
char op='C';

    if(((cartero.x%2==0)&&(cartero.x%6!=0))||((cartero.y%2==0)&&(cartero.y%6!=0))){
    op = 'A';
    }
    if(((cartero.j%3==0)&&(cartero.j%6!=0))||((cartero.i%3==0)&&(cartero.i%6!=0))){
    op = 'C';
    }
    
    if(((cartero.i%3==0)&&(cartero.i%6!=0))&&((cartero.j%2==0)&&(cartero.j%6!=0))){
    op = 'Z';
     }
    return op;
    
}
/*vereda, calle o p. cebra horizontal */
public char vcozh(Celda cartero){
char op='C';
    if(((cartero.x%2==0)&&(cartero.x%6!=0))&&((cartero.y%2==0)&&(cartero.y%6!=0))){
    op = 'A';
    }
    if(((cartero.x%3==0)&&(cartero.x%6!=0))&&((cartero.y%3==0)&&(cartero.y%6!=0))){
    op = 'C';
    }
    if (((cartero.x%3==0)&&(cartero.x%6!=0))&&((cartero.y%2==0)&&(cartero.y%6!=0))){
    op = 'Z';
     }
    return op;
    
}




@Override
    public void run() {
            calle.lienzoPadre.repaint();

    }

    
   
}