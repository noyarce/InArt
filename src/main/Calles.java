package main;

import java.awt.Graphics;
import javax.swing.JComponent;

public class Calles extends JComponent implements Constantes {
public int anchoCalle,altoCalle;     /*dimensiones del laberinto  */
public Celda[][] celdas;            /* define las casillas n x m */
public Celda celdaMovimiento;      /* declarada a celda a mover */
public Celda cartas;
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
            if (((i%3==0)&&(i%6!=0))&&((j%2==0)&&(j%6!=0))){
                celdas[i][j].tipo= 'Z';  
            }
            
            if (((j%3==0)&&(j%6!=0))&&((i%2==0)&&(i%6!=0))){
                celdas[i][j].tipo= 'Z';  
            }
        }
    }

    /* iniciacion de celdas especiales Jugador y Portal */
celdas[pyr_x][pyr_y].tipo= 'J';

celdas [5][4].tipo='P';
celdas [14][6].tipo='P';
celdas [8][12].tipo='P';
celdas [22][2].tipo='P';

celdas [0][3].tipo='B';

for (int z=0; z<anchoMV-1;z++ ){
    for (int w=0; w<altoMV-1; w++ ){
        if ((z%6==0) && ((w==1)||(w==5)||(w==11)|| w==17)){
        celdas[z][w].tipo= 'X';
        }
    }
}


celdaMovimiento=new Celda(pyr_x,pyr_y,'J');
cartas= new Celda(pyr_x,pyr_y,'Q');
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