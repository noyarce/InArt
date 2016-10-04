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
public Lienzo lienzo;             

public Calles(Lienzo lienzo) {
celdas=new Celda[anchoMV][altoMV];

    for(int i=0; i < anchoMV; i++){
        for ( int j=0 ; j < altoMV ; j++){
            celdas[i][j]= new Celda(i+(i*dimCelda),j+(j*dimCelda),'M');
                if ((j==0 || i ==0 || i == anchoMV-1 || j == altoMV-1)){
                    celdas[i][j]= new Celda(i+(i*dimCelda),j+(j*dimCelda),'M');  
                    }
            
                if ((j==1||j==3||j==5||j==7||j==9||j==11||j==13||j==15||j==17||j==19||j==21)
                        ||(i==1||i==3||i==5||i==7||i==9||i==11||i==13||i==15||i==17||i==19||i==21||
                        i==23||i==25||i==27||i==29||i==31||i==33||i==35)){
                    celdas[i][j]= new Celda(i+(i*dimCelda),j+(j*dimCelda),'A');  
                }
            
                if((j==2||j==6||j==10||j==14||j==18||j==22)||(i==2|i==6||i==10||i==14||i==18||i==22||i==26||i==30||i==34)){
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
for(int i=0; i < anchoMV; i++){
    for ( int j=0 ; j < altoMV; j++){
        celdas[i][j].paintComponent(g);
        }
    }

}

public void moverCelda( KeyEvent evento ) {
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
/*
private void ultraPaint(Graphics g){
    int fontSize = 20;
    g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));   
    g.setColor(Color.white);
    g.drawString("Portal Capturado! ", 10, 20);
}
*/

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
        System.out.println("Mover Arriba: "+ celdaMovimiento.y+" - "+celdaMovimiento.x + " Portal Capturado! ");
        
        JOptionPane.showMessageDialog(null,"Portal Capturado!");
        
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
        System.out.println("Mover Abajo: " +celdaMovimiento.y+" - "+celdaMovimiento.x+ " Portal Capturado! ");
        JOptionPane.showMessageDialog(null,"Portal Capturado!");
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
        System.out.println("Mover Izquierda: "+celdaMovimiento.y+" - "+celdaMovimiento.x+ " Portal Capturado! ");
        JOptionPane.showMessageDialog(null,"Portal Capturado!");
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
       System.out.println("Mover Derecha: "+celdaMovimiento.y+" - "+celdaMovimiento.x + " Portal Capturado! ");
       JOptionPane.showMessageDialog(null,"Portal Capturado!");
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
  /* celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='C';
       celdaMovimiento.x=celdaMovimiento.x+1;
       celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
       System.out.println("Mover Derecha: "+celdaMovimiento.y+" - "+celdaMovimiento.x);    
*/    
    System.out.println("Choque! No se puede mover mas a la Derecha!");
    break;
    }
    }
}
}
}