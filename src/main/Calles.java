package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Timer;
import javax.swing.JComponent;

public class Calles extends JComponent implements Constantes {
public int anchoCalle,altoCalle;     /*dimensiones del laberinto  */
public Celda[][] celdas;            /* define las casillas n x m */
public Celda celdaMovimiento;      /* declarada a celda a mover */
public Lienzo lienzoPadre;    
public Cartero cartero;
public Bus bus;

public Peaton peatones[];
public Automovil auto[];
public Timer temporizador;


public Calles(Lienzo lienzoPadre) {
 celdas=new Celda[anchoMV][altoMV];
 generarMapa();
 this.lienzoPadre=lienzoPadre;
this.peatones= new Peaton[nPeatones];
this.auto = new Automovil [nAutos];
    cartero= new Cartero(this);
    bus= new Bus(this);
 
    temporizador = new Timer(); 
    for (int i =0; i < nPeatones; i++){
     peatones[i] = new Peaton(this);
     temporizador.scheduleAtFixedRate( peatones[i] , 0 ,800);
}   
    for (int i =0; i < nPeatones; i++){
        auto[i]=new Automovil(this);  
         temporizador.scheduleAtFixedRate( auto[i] , 0 , 500);
    }
    temporizador.scheduleAtFixedRate(bus,0,600);
}

public final void generarMapa(){
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

celdas[pyr_x][pyr_y].tipo= 'J';


for (int z=0; z<anchoMV-1;z++ ){
    for (int w=0; w<altoMV-1; w++ ){
        if ((z%6==0) && ((w==1)||(w==5)||(w==11)|| w==17)){
        celdas[z][w].tipo= 'X';
        }
        if((z%12==0) && ((w==5)||(w==11)|| w==17)){
                celdas[z][w].tipo= 'S';
        }
        
    }
}
celdas [0][0].tipo='G';

celdaMovimiento=new Celda(pyr_x,pyr_y,'J');

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
        if(cartero.cartax >0){
                for (int i = 0; i < cartero.cartax; i++) {
                cartero.mCartas[i].update(g);
            }
        }
            
            // Si el cartero esta en el portal, se pinta mensaje
           if( cartero.portal == true){
                int fontSize = 15;
                g.setFont(new Font("Arial", Font.PLAIN, fontSize));
                g.setColor(Color.blue);
                g.drawString("El cartero en el Portal", 20, 50);
           } 
        
        
        if(bus.pasajerosInt>0){
            for (int i = 0; i < bus.pasajerosInt; i++) {
                bus.pasajeros[i].update(g);
            }
        } 
    }
    
}
    