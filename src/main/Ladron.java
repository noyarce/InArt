/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.awt.event.KeyEvent;
import java.util.TimerTask;

public class Ladron extends TimerTask implements Constantes {
    public Calles calle;
    public Celda ladron;

    SuperLadron inteligencia;

public Ladron(Calles calle) {
    this.calle=calle;
    int ldr_x= randomPeaton();
    int ldr_y= randomPeaton();
    ladron=new Celda(ldr_x, ldr_y,'L');
    calle.celdas[ladron.x][ladron.y].tipo='L';
        inteligencia=new SuperLadron(calle,this);  

   }
   
     
public void moverLadron( KeyEvent evento ) {

        switch( evento.getKeyCode() ) {
            case 38:   
                moverLdrArriba();
                break;
            case 40 :
                moverLdrAbajo();
                break;
            case 37:
                moverLdrIzquierda();
                break;
            case 39:
                moverLdrDerecha();
                break;
        }
    }

public void moverLdrArriba(){
if(ladron.y>0 ){
char op =calle.celdas[ladron.x][ladron.y-1].tipo;
    switch (op){
        case('J'): {
            calle.cartero.cartax = 0;
            calle.cartero.robo= true;
            break;
        }
        case('C'): {
        if(vieneAuto(calle,ladron)==false){
            calle.celdas[ladron.x][ladron.y].tipo=azocv(ladron);
            ladron.y=ladron.y-1;
            calle.celdas[ladron.x][ladron.y].tipo='L';
            break;
        }
        else{
            
            
        }
        }
        

    case('A'):{
        calle.celdas[ladron.x][ladron.y].tipo=azoch(ladron);               
        ladron.y=ladron.y-1;
        calle.celdas[ladron.x][ladron.y].tipo='L';
        System.out.println("Mover Arriba: "+ ladron.y+" - "+ladron.x); 
    break;
        
    }
    case('Z'): {
        if(vieneAuto(calle,ladron)==false){
            calle.celdas[ladron.x][ladron.y].tipo =azocv(ladron);
            ladron.y=ladron.y-1;
            calle.celdas[ladron.x][ladron.y].tipo='L';
            System.out.println("Mover Arriba: "+ ladron.y+" - "+ladron.x);
            
            break;
        }
        else{
            break;
        }
    }
   
    case ('M'):{
        break;
    }
    case ('P'):{
       break;
    }
    case ('T'):{
       break;
    }
    }
}
}
public void moverLdrAbajo(){
    if(ladron.y<altoMV-1){
    char op = calle.celdas[ladron.x][ladron.y+1].tipo;
    switch(op){
        case('J'): {
            calle.cartero.cartax = 0;
            calle.cartero.robo= true;
            break;
        }
    case('C'): {
        if(vieneAuto(calle,ladron)==false){
            calle.celdas[ladron.x][ladron.y].tipo=azocv(ladron);
            ladron.y=ladron.y+1;
            calle.celdas[ladron.x][ladron.y].tipo='L';
           
            break;
        }
        else{
            break;
        }
    }
        
    case('P'):{
        break;
        }
    case('M'):{
        break;
        }
   case('A'):{
        calle.celdas[ladron.x][ladron.y].tipo=azoch(ladron);
        ladron.y=ladron.y+1;
        calle.celdas[ladron.x][ladron.y].tipo='L';

    break;
        
    }
    case('Z'): {
         if(vieneAuto(calle,ladron)==false){
            calle.celdas[ladron.x][ladron.y].tipo =azoch(ladron);
            ladron.y=ladron.y+1;
            calle.celdas[ladron.x][ladron.y].tipo='L';
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
public void moverLdrIzquierda(){
 if(ladron.x>0){
    char op = calle.celdas[ladron.x-1][ladron.y].tipo ;
    switch (op){    
 case('J'): {
            calle.cartero.cartax = 0;
            calle.cartero.robo=true;
            break;
        }
    case('C'):{
            if(vieneAuto(calle,ladron)==false){
            calle.celdas[ladron.x][ladron.y].tipo=azoch(ladron);
            ladron.x=ladron.x-1;
            calle.celdas[ladron.x][ladron.y].tipo='L';
            
            break;
            }
            else{
                 
            break;
            }
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
         calle.celdas[ladron.x][ladron.y].tipo=azocv(ladron);
        ladron.x=ladron.x-1;
        calle.celdas[ladron.x][ladron.y].tipo='L';
       
    break;
        
    }
    case('Z'): {
        if(vieneAuto(calle,ladron)==false){
            calle.celdas[ladron.x][ladron.y].tipo =azocv(ladron);
            ladron.x=ladron.x-1;
            calle.celdas[ladron.x][ladron.y].tipo='L';
 
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
public void moverLdrDerecha(){
    if((ladron.x<anchoMV-1)){
    char op = calle.celdas[ladron.x+1][ladron.y].tipo;
        switch (op){  
            case('J'): {
            calle.cartero.cartax = 0;
            calle.cartero.robo = true;
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
            calle.celdas[ladron.x][ladron.y].tipo=azocv(ladron);
            ladron.x=ladron.x+1;
            calle.celdas[ladron.x][ladron.y].tipo='L';
                        break;
            }
        case('Z'): {
            if(vieneAuto(calle,ladron)==false){
                calle.celdas[ladron.x][ladron.y].tipo =azoch(ladron);
                ladron.x=ladron.x+1;
                calle.celdas[ladron.x][ladron.y].tipo='L';
            
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
            if(vieneAuto(calle,ladron)==false){
                calle.celdas[ladron.x][ladron.y].tipo=azoch(ladron);
                ladron.x=ladron.x+1;
                calle.celdas[ladron.x][ladron.y].tipo='L';
                
                break;
            }
            else{
                break;
            }
        }
      }
    }
}
private boolean vieneAuto(Calles calle , Celda ladron){
    boolean flag=false;
    for(int i=-3; i<3; i++){
        for (int j=-3; j<3;j++){
                if(((ladron.x+i>0)&&(ladron.y+j>0))&&((ladron.x+i<anchoMV-1)&&(ladron.y+j<altoMV-1))){
                    if((calle.celdas[ladron.x+i][ladron.y+j].tipo== 'T'|| calle.celdas[ladron.x+i][ladron.y+j].tipo== 'B')){
                        flag=true;
                        break;
                    }
                }
        }
    }    
    return flag;
}

/*acera zebra o calle vertical */
public char azocv(Celda ladron){
char op='A';
    if(((ladron.x%3==0)&&(ladron.x%6!=0))||((ladron.y%3==0)&&(ladron.y%6!=0))){
        op='C';
    }
    if (((ladron.x%3==0)&&(ladron.x%6!=0))&&((ladron.y%2==0)&&(ladron.y%6!=0))){
       op='Z';  
    }    
    return op;
}

/* acera, zebra, o calle  horizontal */
public char azoch(Celda ladron){
char op='A';
    if(((ladron.x%3==0)&&(ladron.x%6!=0))||((ladron.y%3==0)&&(ladron.y%6!=0))){
        op='C';
    }
    if (((ladron.y%3==0)&&(ladron.y%6!=0))&&((ladron.x%2==0)&&(ladron.x%6!=0))){
       op='Z';  
    }    
    return op;
}

@Override
    public void run() {
            calle.lienzoPadre.repaint();
    }
}
