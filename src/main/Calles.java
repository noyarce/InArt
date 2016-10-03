package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;

public class Calles extends JComponent implements Constantes {
public int anchoCalle,altoCalle;     /*dimensiones del laberinto  */
public Celda[][] celdas;            /* define las casillas n x m */
public Celda celdaMovimiento;      /* declarada a celda a mover */
public Lienzo lienzo;             

public Calles(Lienzo lienzo) {
celdas=new Celda[anchoMV][altoMV];

    for(int i=0; i < anchoMV; i++){
        for ( int j=0 ; j < altoMV ; j++){
            if (j==0 || i ==0 || i == anchoMV-1 || j == altoMV-1){
                celdas[i][j]= new Celda(i+(i*dimCelda),j+(j*dimCelda),'M');  
                }      
            else{
                celdas[i][j]= new Celda(i+(i*dimCelda),j+(j*dimCelda),'C');
            }
        }
    }
celdas[1][1]= new Celda(1+(1*dimCelda),1+(1*dimCelda),'J');
 
celdaMovimiento=new Celda(1,1,'J');

/*se preparan las imenciones y se entregan para definir los tamaños de las calles */
this.anchoCalle =anchoMV*dimCelda;
this.altoCalle =altoMV*dimCelda;

this.setSize(anchoCalle,altoCalle);

}
@Override
public void paintComponent(Graphics g) {
for(int i=0; i < anchoMV; i++)
    for ( int j=0 ; j < altoMV; j++)
        celdas[i][j].paintComponent(g);
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


private void moverCeldaArriba(){
    if (celdaMovimiento.y > 0 || celdas[celdaMovimiento.x][celdaMovimiento.y].tipo != 'C' ) {
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo ='C';
        celdaMovimiento.y=celdaMovimiento.y-1;
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
        System.out.println("Mover Arriba: "+ celdaMovimiento.y+" - "+celdaMovimiento.x);
    }
}
private void moverCeldaAbajo(){
    if ( celdaMovimiento.y< altoMV-1 ) {
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='C';
        celdaMovimiento.y=celdaMovimiento.y+1;
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
        System.out.println("Mover Abajo: " +celdaMovimiento.y+" - "+celdaMovimiento.x);
    }
}
private void moverCeldaIzquierda(){
    if (celdaMovimiento.x > 0 ) {
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='C';
        celdaMovimiento.x=celdaMovimiento.x-1;
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
        System.out.println("Mover Izquierda: "+celdaMovimiento.y+" - "+celdaMovimiento.x);
    }
}
private void moverCeldaDerecha(){
    if ( celdaMovimiento.x < anchoMV-1 ){
       celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='C';
       celdaMovimiento.x=celdaMovimiento.x+1;
       celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
       System.out.println("Mover Derecha: "+celdaMovimiento.y+" - "+celdaMovimiento.x);
    }
}

}