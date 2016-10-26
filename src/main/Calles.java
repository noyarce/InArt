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
        }
}

for(int i=0; i < anchoMV; i++){
        for ( int j=0 ; j < altoMV ; j++){       
            if (((j%2==0)&&(j%6!=0))||((i%2==0)&&(i%6!=0))){
                celdas[i][j].tipo= 'A';  
            }
            if(((j%3==0)&&(j%6!=0))||((i%3==0)&&(i%6!=0))){
                celdas[i][j].tipo= 'C';
            }
        }
    }
   celdas[0][6].tipo= 'M';

    /* iniciacion de celdas especiales Jugador y Portal */
celdas[pyr_x][pyr_y]= new Celda(pyr_x+(pyr_x*dimCelda),pyr_y+(pyr_y*dimCelda),'J');
celdas[prt_x][prt_y]= new Celda(prt_x+(prt_x*dimCelda),prt_y+(prt_y*dimCelda),'X');



celdaMovimiento=new Celda(pyr_x,pyr_y,'J');

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
}