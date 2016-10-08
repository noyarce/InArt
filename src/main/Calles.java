package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class Calles extends JComponent implements Constantes {
public int anchoCalle,altoCalle;     /*dimensiones del laberinto  */
public Celda[][] celdas;            /* define las casillas n x m */
public Celda celdaMovimiento;      /* declarada a celda a mover */
public Celda celdaMovimiento2;
public Lienzo lienzoPadre;             

public Calles(Lienzo lienzoPadre) {
    this.lienzoPadre=lienzoPadre;

celdas=new Celda[anchoMV][altoMV];

    for(int i=0; i < anchoMV; i++){
        for ( int j=0 ; j < altoMV ; j++){
            celdas[i][j]= new Celda(i+(i*dimCelda),j+(j*dimCelda),'M');
                if ((j==0 || i ==0 || i == anchoMV-1 || j == altoMV-1)){
                    celdas[i][j]= new Celda(i+(i*dimCelda),j+(j*dimCelda),'M');  
                    }
            
                if ((j%2!=0 || i%2!=0)){
                    celdas[i][j]= new Celda(i+(i*dimCelda),j+(j*dimCelda),'A');  
                }
                if((j%2==0)&&(j%4!=0)||(i%2==0)&&(i%4!=0)){
                    celdas[i][j]= new Celda(i+(i*dimCelda),j+(j*dimCelda),'C');
                    }
        }
    }

    /* iniciacion de celdas especiales Jugador y Portal */
celdas[pyr][pyr]= new Celda(pyr+(pyr*dimCelda),pyr+(pyr*dimCelda),'J');
celdas[prt][prt]= new Celda(prt+(prt*dimCelda),prt+(prt*dimCelda),'X');



celdaMovimiento=new Celda(pyr,pyr,'J');

/*se preparan las imenciones y se entregan para definir los tamaños de las calles */
this.anchoCalle =anchoMV*dimCelda;
this.altoCalle =altoMV*dimCelda;
this.setSize(anchoCalle,altoCalle);

}

@Override
public void paintComponent(Graphics g) {
update(g);
}
@Override
public void update(Graphics g){
    for(int i=0; i < anchoMV; i++){
    for ( int j=0 ; j < altoMV; j++){
        celdas[i][j].paintComponent(g);
        }
    }
}

public void moverCelda( KeyEvent evento ) {
//while (true){
//    auto();
        switch( evento.getKeyCode() ) {
            case 38:   
                moverCeldaArriba();
                break;
            case 40 :
                moverCeldaAbajo();
                break;
            case 37:
                moverCeldaIzquierda();
                break;
            case 39:
                moverCeldaDerecha();
                break;
        }
    }
//}


private void moverCeldaArriba(){
if(celdaMovimiento.y>0){   
    char op =celdas[celdaMovimiento.x][celdaMovimiento.y-1].tipo;
    switch (op){
        
    case('A'):{/*
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo ='A';
        celdaMovimiento.y=celdaMovimiento.y-1;
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
        System.out.println("Mover Arriba: "+ celdaMovimiento.y+" - "+celdaMovimiento.x);
        */
        System.out.println("Choque! No se puede mover mas hacia Arriba");  
    break;
        
    }
    case('C'): {
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo ='C';
        celdaMovimiento.y=celdaMovimiento.y-1;
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
        System.out.println("Mover Arriba: "+ celdaMovimiento.y+" - "+celdaMovimiento.x);
    break;
    }   
    case ('X'): {
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo ='C';
        celdaMovimiento.y=celdaMovimiento.y-1;
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
        System.out.println("Mover Arriba: "+ celdaMovimiento.y+" - "+celdaMovimiento.x + " Carteron en Portal ");
        
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
private void moverCeldaAbajo(){
    if(celdaMovimiento.y<altoMV-1){
    char op = celdas[celdaMovimiento.x][celdaMovimiento.y+1].tipo;
    switch(op){
        
    case('C'): {
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='C';
        celdaMovimiento.y=celdaMovimiento.y+1;
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
        System.out.println("Mover Abajo: " +celdaMovimiento.y+" - "+celdaMovimiento.x);
        break;
        }
    case ('X'): {
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='C';
        celdaMovimiento.y=celdaMovimiento.y+1;
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
        System.out.println("Mover Abajo: " +celdaMovimiento.y+" - "+celdaMovimiento.x+ " Carteron en Portal  ");
        
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
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='C';
        celdaMovimiento.y=celdaMovimiento.y+1;
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
        System.out.println("Mover Abajo: " +celdaMovimiento.y+" - "+celdaMovimiento.x);
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
private void moverCeldaIzquierda(){
 if(celdaMovimiento.x>0){
    char op = celdas[celdaMovimiento.x-1][celdaMovimiento.y].tipo ;
    switch (op){      
    case ('C'): {
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='C';
        celdaMovimiento.x=celdaMovimiento.x-1;
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
        System.out.println("Mover Izquierda: "+celdaMovimiento.y+" - "+celdaMovimiento.x);
        break;
    }
    case ('X'): {
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='C';
        celdaMovimiento.x=celdaMovimiento.x-1;
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
        System.out.println("Mover Izquierda: "+celdaMovimiento.y+" - "+celdaMovimiento.x+ " Carteron en Portal ");
        
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
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='C';
        celdaMovimiento.x=celdaMovimiento.x-1;
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
        System.out.println("Mover Izquierda: "+celdaMovimiento.y+" - "+celdaMovimiento.x);
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
private void moverCeldaDerecha(){
    if(celdaMovimiento.x<anchoMV-1){
char op = celdas[celdaMovimiento.x+1][celdaMovimiento.y].tipo;
switch (op){  
    case('C'):{
       celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='C';
       celdaMovimiento.x=celdaMovimiento.x+1;
       celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
       System.out.println("Mover Derecha: "+celdaMovimiento.y+" - "+celdaMovimiento.x);
    break;
    }
    case ('X'):{
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='C';
       celdaMovimiento.x=celdaMovimiento.x+1;
       celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
       System.out.println("Mover Derecha: "+celdaMovimiento.y+" - "+celdaMovimiento.x + " Carteron en Portal ");
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
         if(celdas[celdaMovimiento.x-1][celdaMovimiento.y].tipo=='C'){
            celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='C';
            celdaMovimiento.x=celdaMovimiento.x+1;
            celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
         }
         else{
            celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='A';
            celdaMovimiento.x=celdaMovimiento.x+1;
            celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
            }
            System.out.println("Mover Derecha: "+celdaMovimiento.y+" - "+celdaMovimiento.x);    
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
}