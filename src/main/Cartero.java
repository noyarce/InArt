package main;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import static java.util.Collections.sort;
import java.util.TimerTask;


public class Cartero extends TimerTask implements Constantes {
    public Calles calle;
    public Celda cartero;
    public Celda cartitas;
    public int cartax ;
    public Cartas[] mCartas;
    SuperBusqueda inteligencia;
    public boolean portal;
    public int ultima;
    public boolean robo;
    public ArrayList <Estado> estado;

public Cartero(Calles calle) {
    this.calle=calle;
    cartero=new Celda(pyr_x, pyr_y,'J',0);
    calle.celdas[cartero.x][cartero.y].tipo='J';
    cartax = cartas;
    inteligencia=new SuperBusqueda(calle,this);  
    estado = new ArrayList<>();
    this.mCartas= new Cartas[cartas]; 
      
    int i = 0; 
        for (int ds_x=0 ; ds_x < anchoMV; ds_x ++){
            for (int ds_y=0 ; ds_y< altoMV; ds_y++){
                if( calle.celdas[ds_x][ds_y].tipo=='X' && i < cartax){  
                        mCartas[i]= new Cartas(((cartero.x*dimCelda+(i*16))-(cartax*16)), ((cartero.y*dimCelda)-(dimCelda/4)),ds_x,ds_y);
                        estado.add(new Estado(ds_x,ds_y,'N',null,calle.celdas[ds_x][ds_y].priori)); 
                        i++;
                        }
                    }
                }
        sort(estado);
        
        do{
        inteligencia.destinos.add(estado.get(0));
        estado.remove(0);
        }while(!estado.isEmpty());
                
        this.portal = false;
    robo = false;
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
        
        case ('L'):{
        moverCrtAbajo();
        break;
        }
        
        case('C'): {
        if(vieneAuto(calle,cartero)==false){
            calle.celdas[cartero.x][cartero.y].tipo=azocvp(cartero);
            cartero.y=cartero.y-1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            for(int i=0;i<cartax;i++){
                    mCartas[i].y=(mCartas[i].y-dimCelda);
                }
            break;
            }
        else{
            break;
            }
        }

    case('A'):{
        calle.celdas[cartero.x][cartero.y].tipo=azochp(cartero);               
        cartero.y=cartero.y-1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
        System.out.println("Mover Arriba: "+ cartero.y+" - "+cartero.x); 
        for(int i=0;i<cartax;i++){
                    mCartas[i].y=(mCartas[i].y-dimCelda);
                }
    break;
        
    }
    case('Z'): {
        if(vieneAuto(calle,cartero)==false){
            calle.celdas[cartero.x][cartero.y].tipo =azocvp(cartero);
            cartero.y=cartero.y-1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            System.out.println("Mover Arriba: "+ cartero.y+" - "+cartero.x);
            for(int i=0;i<cartax;i++){
                    mCartas[i].y=(mCartas[i].y-dimCelda);
                }
            break;
        }
        else{
            break;
        }
    }
    case ('X'): {
        if(cartax>0){
        calle.celdas[cartero.x][cartero.y].tipo ='A';
        cartero.y=cartero.y-1;
        calle.celdas[cartero.x][cartero.y].tipo='J';   
        calle.celdas[cartero.x][cartero.y].priori=0;
        
      cartax= entregarCarta(mCartas,cartax, cartero.x,cartero.y);
    
            for(int i=0;i<cartax;i++){
                    mCartas[i].y=(mCartas[i].y-dimCelda);
                }
        portal= true;
        try
        {
            Thread.sleep(1000);
        portal = false;
        }catch(InterruptedException e){}
        break;
    }}
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
public void moverCrtAbajo(){
    if(cartero.y<altoMV-1){
    char op = calle.celdas[cartero.x][cartero.y+1].tipo;
    switch(op){
         case ('L'):{
        moverCrtArriba();
        break;
        }
    case('C'): {
        if(vieneAuto(calle,cartero)==false){
            calle.celdas[cartero.x][cartero.y].tipo=azocvp(cartero);
            cartero.y=cartero.y+1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            for(int i=0;i<cartax;i++){
                    mCartas[i].y=(mCartas[i].y+dimCelda);
                }
            break;
        }
        else{
            break;
        }
    }
        
    case ('X'): {
        if(cartax>0){
        calle.celdas[cartero.x][cartero.y].tipo='A';
        cartero.y=cartero.y+1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
        calle.celdas[cartero.x][cartero.y].priori=0;
        System.out.println("Mover Abajo: " +cartero.y+" - "+cartero.x+ " Cartero en Portal  ");
//        cartax= entregarCarta(mCartas,cartax, cartero.x,cartero.y);
        
        for (int i =0; i < cartax; i++){
        if(( mCartas[i].ds_y == cartero.y ) &&(mCartas[i].ds_x == cartero.x)){
            cartax = cartax-1 ;
            }
        }
for(int i=0;i<cartax;i++){
                    mCartas[i].y=(mCartas[i].y+dimCelda);
                }
        portal= true;
        try
        {
            Thread.sleep(1000);
        portal = false;
        }catch(InterruptedException e){}
        break;
        }
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
        calle.celdas[cartero.x][cartero.y].tipo=azochp(cartero);
        cartero.y=cartero.y+1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
System.out.println("Mover Arriba: "+ cartero.y+" - "+cartero.x);
for(int i=0;i<cartax;i++){
                    mCartas[i].y=(mCartas[i].y+dimCelda);
                }
    break;
        
    }
    case('Z'): {
         if(vieneAuto(calle,cartero)==false){
            calle.celdas[cartero.x][cartero.y].tipo =azochp(cartero);
            cartero.y=cartero.y+1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            System.out.println("Mover Arriba: "+ cartero.y+" - "+cartero.x);
            for(int i=0;i<cartax;i++){
                    mCartas[i].y=(mCartas[i].y+dimCelda);
                }
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
public void moverCrtIzquierda(){
 if(cartero.x>0){
    char op = calle.celdas[cartero.x-1][cartero.y].tipo ;
    switch (op){    
  case ('L'):{
        moverCrtDerecha();
        break;
        }
    case('C'):{
            if(vieneAuto(calle,cartero)==false){
            calle.celdas[cartero.x][cartero.y].tipo=azochp(cartero);
            cartero.x=cartero.x-1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            for(int i=0;i<cartax;i++){
                    mCartas[i].x=(mCartas[i].x-dimCelda);
                }
            break;
            }
            else{
                 
            break;
            }
    }
  
    case ('X'): {
        if(cartax>0){
        calle.celdas[cartero.x][cartero.y].tipo='A';
        cartero.x=cartero.x-1;            
        calle.celdas[cartero.x][cartero.y].tipo='J';
        calle.celdas[cartero.x][cartero.y].priori=0;
        System.out.println("Mover Izquierda: "+cartero.y+" - "+cartero.x+ " Cartero en Portal ");
       cartax= entregarCarta(mCartas,cartax, cartero.x,cartero.y);
        for(int i=0;i<cartax;i++){
                    mCartas[i].x=(mCartas[i].x-dimCelda);
                }
        portal= true;
        try
        {
            Thread.sleep(1000);
        portal = false;
        }catch(InterruptedException e){}
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
         calle.celdas[cartero.x][cartero.y].tipo=azocvp(cartero);
        cartero.x=cartero.x-1;
        calle.celdas[cartero.x][cartero.y].tipo='J';
        System.out.println("Mover Izquierda: "+ cartero.y+" - "+cartero.x); 
        for(int i=0;i<cartax;i++){
                    mCartas[i].x=(mCartas[i].x-dimCelda);
                }
    break;
        
    }
    case('Z'): {
        if(vieneAuto(calle,cartero)==false){
            calle.celdas[cartero.x][cartero.y].tipo =azocvp(cartero);
            cartero.x=cartero.x-1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            System.out.println("Mover Izquierda: "+ cartero.y+" - "+cartero.x);
            for(int i=0;i<cartax;i++){
                    mCartas[i].x=(mCartas[i].x-dimCelda);
                }
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
public void moverCrtDerecha(){
    if((cartero.x<anchoMV-1)){
    char op = calle.celdas[cartero.x+1][cartero.y].tipo;
        switch (op){  
        case ('L'):{
            moverCrtIzquierda();
            break;
        }
        case ('X'):{
            if(cartax>0){
            calle.celdas[cartero.x][cartero.y].tipo='A';
            cartero.x=cartero.x+1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            System.out.println("Mover Derecha: "+cartero.y+" - "+cartero.x + " Cartero en Portal ");
            calle.celdas[cartero.x][cartero.y].priori=0;
            
            cartax= entregarCarta(mCartas,cartax, cartero.x,cartero.y);
            for(int i=0;i<cartax;i++){
                   mCartas[i].x=(mCartas[i].x+dimCelda);
            }
            portal= true;
        try
        {
            Thread.sleep(1000);
        portal = false;
        }catch(InterruptedException e){}
            break;
            }
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
            calle.celdas[cartero.x][cartero.y].tipo=azocvp(cartero);
            cartero.x=cartero.x+1;
            calle.celdas[cartero.x][cartero.y].tipo='J';
            System.out.println("Mover Derecha: "+ cartero.y+" - "+cartero.x); 
            for(int i=0;i<cartax;i++){
                    mCartas[i].x=(mCartas[i].x+dimCelda);
                }
             break;
            }
        case('Z'): {
            if(vieneAuto(calle,cartero)==false){
                calle.celdas[cartero.x][cartero.y].tipo =azochp(cartero);
                cartero.x=cartero.x+1;
                calle.celdas[cartero.x][cartero.y].tipo='J';
                System.out.println("Mover Derecha: "+ cartero.y+" - "+cartero.x);
                for(int i=0;i<cartax;i++){
                    mCartas[i].x=(mCartas[i].x+dimCelda);
                }
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
                calle.celdas[cartero.x][cartero.y].tipo=azochp(cartero);
                cartero.x=cartero.x+1;
                calle.celdas[cartero.x][cartero.y].tipo='J';
                for(int i=0;i<cartax;i++){
                    mCartas[i].x=(mCartas[i].x+dimCelda);
                }
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
    for(int i=-3; i<3; i++){
        for (int j=-3; j<3;j++){
                if(((cartero.x+i>0)&&(cartero.y+j>0))&&((cartero.x+i<anchoMV-1)&&(cartero.y+j<altoMV-1))){
                    if((calle.celdas[cartero.x+i][cartero.y+j].tipo== 'T'|| calle.celdas[cartero.x+i][cartero.y+j].tipo== 'B')){
                        flag=true;
                        break;
                    }
                }
        }
    }    
    return flag;
}

/*acera zebra o calle vertical */
public char azocvp(Celda cartero){
char op='A';

    if ((cartero.x%6==0) && ((cartero.y==7)||(cartero.y==13)||cartero.y==19)){
        op='Y';
    }
    if(((cartero.x%3==0)&&(cartero.x%6!=0))||((cartero.y%3==0)&&(cartero.y%6!=0))){
        op='C';
    }
    if (((cartero.x%3==0)&&(cartero.x%6!=0))&&((cartero.y%2==0)&&(cartero.y%6!=0))){
       op='Z';  
    }    
    return op;
}

/* acera, zebra, o calle  horizontal */
public char azochp(Celda cartero){
char op='A';
    if ((cartero.x%6==0) && ((cartero.y==7)||(cartero.y==13)||cartero.y==19)){
        op='Y';
    }
    if(((cartero.x%3==0)&&(cartero.x%6!=0))||((cartero.y%3==0)&&(cartero.y%6!=0))){
        op='C';
    }
    if (((cartero.y%3==0)&&(cartero.y%6!=0))&&((cartero.x%2==0)&&(cartero.x%6!=0))){
       op='Z';  
    }    
    return op;
}

public int entregarCarta(Cartas mCartas[], int cartax, int x, int y){
    if (cartax !=0){
            cartax = cartax-1 ;
            
        }
    
    return cartax;
}

@Override
    public void run() {
            calle.lienzoPadre.repaint();
    }
}