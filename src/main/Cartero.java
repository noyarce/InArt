package main;

import java.awt.event.KeyEvent;
import java.util.TimerTask;
import javax.swing.JOptionPane;


public class Cartero extends TimerTask implements Constantes {
    public Calles calle;
    public Celda cartero;
    public Celda cartitas;
    public int cartax ;
    public Cartas[] mCartas;
    SuperBusqueda inteligencia;

public Cartero(Calles calle) {
    this.calle=calle;
    cartero=new Celda(pyr_x, pyr_y,'J');
    calle.celdas[cartero.x][cartero.y].tipo='J';
    cartax = cartas;
    this.mCartas= new Cartas[cartas]; 
    
    for (int i = 0; i < cartax; i++){
    mCartas[i]= new Cartas((cartero.x+i+1) *dimCelda  ,( cartero.y+i+1)*dimCelda);
    }
    
    inteligencia=new SuperBusqueda(calle,this);  
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

public void moverCrtArriba(){
if(cartero.y>0 ){
char op =calle.celdas[cartero.x][cartero.y-1].tipo;
    switch (op){
    
        case('C'): {
        if(vieneAuto(calle,cartero)==false){
            calle.celdas[cartero.x][cartero.y].tipo=azocv(cartero);
            cartero.y=cartero.y-1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            break;
            }
        else{
            break;
            }
        }

    case('A'):{
        calle.celdas[cartero.x][cartero.y].tipo=azocv(cartero);               
        cartero.y=cartero.y-1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
        System.out.println("Mover Arriba: "+ cartero.y+" - "+cartero.x); 
    break;
        
    }
    case('Z'): {
        if(vieneAuto(calle,cartero)==false){
            calle.celdas[cartero.x][cartero.y].tipo =azocv(cartero);
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
        cartax= entregarCarta(cartax);
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
        for(int i=0;i<cartax;i++){
                    mCartas[i].y=(mCartas[i].y-dimCelda);
                }

}
public void moverCrtAbajo(){
    if(cartero.y<altoMV-1){
    char op = calle.celdas[cartero.x][cartero.y+1].tipo;
    switch(op){
        
    case('C'): {
        if(vieneAuto(calle,cartero)==false){
            calle.celdas[cartero.x][cartero.y].tipo=azocv(cartero);
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
        System.out.println("Mover Abajo: " +cartero.y+" - "+cartero.x+ " Cartero en Portal  ");
        cartax=entregarCarta(cartax);         
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
        calle.celdas[cartero.x][cartero.y].tipo=azocv(cartero);
        cartero.y=cartero.y+1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
System.out.println("Mover Arriba: "+ cartero.y+" - "+cartero.x); 
    break;
        
    }
    case('Z'): {
         if(vieneAuto(calle,cartero)==false){
            calle.celdas[cartero.x][cartero.y].tipo =azocv(cartero);
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
            for(int i=0;i<cartax;i++){
                    mCartas[i].y=(mCartas[i].y+dimCelda);
                }

}
public void moverCrtIzquierda(){
 if(cartero.x>0){
    char op = calle.celdas[cartero.x-1][cartero.y].tipo ;
    switch (op){    
 
    case('C'):{
            if(vieneAuto(calle,cartero)==false){
            calle.celdas[cartero.x][cartero.y].tipo=azoch(cartero);
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
        System.out.println("Mover Izquierda: "+cartero.y+" - "+cartero.x+ " Cartero en Portal ");
        cartax=entregarCarta(cartax);
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
         calle.celdas[cartero.x][cartero.y].tipo=azoch(cartero);
        cartero.x=cartero.x-1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
System.out.println("Mover Izquierda: "+ cartero.y+" - "+cartero.x); 
    break;
        
    }
    case('Z'): {
        if(vieneAuto(calle,cartero)==false){
            calle.celdas[cartero.x][cartero.y].tipo =azoch(cartero);
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
         for(int i=0;i<cartax;i++){
                    mCartas[i].x=(mCartas[i].x-dimCelda);
                }

}
public void moverCrtDerecha(){
    if((cartero.x<anchoMV-1)){
    char op = calle.celdas[cartero.x+1][cartero.y].tipo;
        switch (op){  
        case ('X'):{
            calle.celdas[cartero.x][cartero.y].tipo='A';
            cartero.x=cartero.x+1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            System.out.println("Mover Derecha: "+cartero.y+" - "+cartero.x + " Cartero en Portal ");
            cartax=entregarCarta(cartax);
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
            calle.celdas[cartero.x][cartero.y].tipo=azoch(cartero);
            cartero.x=cartero.x+1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            System.out.println("Mover Derecha: "+ cartero.y+" - "+cartero.x); 
             break;
            }
        case('Z'): {
            if(vieneAuto(calle,cartero)==false){
                calle.celdas[cartero.x][cartero.y].tipo =azoch(cartero);
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
                calle.celdas[cartero.x][cartero.y].tipo=azoch(cartero);
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
            for(int i=0;i<cartax;i++){
                    mCartas[i].x=(mCartas[i].x+dimCelda);
                }

}

private boolean vieneAuto(Calles calle , Celda cartero){
    boolean flag=false;
    for(int i=-3; i<3; i++){
        for (int j=-3; j<3;j++){
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

/*acera zebra o calle vertical */
public char azocv(Celda cartero){
char op='A';
    if(((cartero.x%3==0)&&(cartero.x%6!=0))||((cartero.y%3==0)&&(cartero.y%6!=0))){
        op='C';
    }
    if (((cartero.x%3==0)&&(cartero.x%6!=0))&&((cartero.y%2==0)&&(cartero.y%6!=0))){
       op='Z';  
    }    
    return op;
}

/* acera, zebra, o calle  horizontal */
public char azoch(Celda cartero){
char op='A';
    if(((cartero.x%3==0)&&(cartero.x%6!=0))||((cartero.y%3==0)&&(cartero.y%6!=0))){
        op='C';
    }
    if (((cartero.y%3==0)&&(cartero.y%6!=0))&&((cartero.x%2==0)&&(cartero.x%6!=0))){
       op='Z';  
    }    
    return op;
}

public int entregarCarta(int cartax){
    if (cartax > 0){
        cartax = cartax -1;
        JOptionPane.showMessageDialog(null," Carteron en Portal, quedan " +cartax +" cartas");
    }
    else{
        JOptionPane.showMessageDialog(null,"No quedan Cartas por Entregar");
    }
    return cartax;
}

@Override
    public void run() {
            calle.lienzoPadre.repaint();
    }
}