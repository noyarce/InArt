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
            celdas[i][j]= new Celda(i+(i*dimCelda),j+(j*dimCelda),i,j,'M');
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
            if (((i%3==0)&&(i%6!=0))&&((j%2==0)&&(j%6!=0))){
                celdas[i][j].tipo= 'Z';  
            }
            
            if (((j%3==0)&&(j%6!=0))&&((i%2==0)&&(i%6!=0))){
                celdas[i][j].tipo= 'Z';  
            }
        }
    }
   celdas[0][6].tipo= 'M';
/*
   celdas[3][2].tipo= 'Z';
   celdas[3][4].tipo= 'Z';
   celdas[3][8].tipo= 'Z';
   celdas[3][10].tipo= 'Z';
   celdas[3][14].tipo= 'Z';
   celdas[3][16].tipo= 'Z';

    celdas[9][2].tipo= 'Z';
   celdas[9][4].tipo= 'Z';
   celdas[9][8].tipo= 'Z';
   celdas[9][10].tipo= 'Z';
   celdas[9][14].tipo= 'Z';
   celdas[9][16].tipo= 'Z';

   celdas[15][2].tipo= 'Z';
   celdas[15][4].tipo= 'Z';
   celdas[15][8].tipo= 'Z';
   celdas[15][10].tipo= 'Z';
   celdas[15][14].tipo= 'Z';
   celdas[15][16].tipo= 'Z';
*/
   
    /* iniciacion de celdas especiales Jugador y Portal */
celdas[pyr_x][pyr_y].tipo= 'J';
celdas[prt_x][prt_y].tipo= 'X';


celdaMovimiento=new Celda(pyr_x,pyr_y,pyr_x,pyr_y,'J');

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