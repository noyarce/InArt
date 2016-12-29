 package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;
import javax.swing.JComponent;

public class Calles extends JComponent implements Constantes {
public int anchoCalle,altoCalle;     /*dimensiones del laberinto  */
public Celda[][] celdas;            /* define las casillas n x m */
public Lienzo lienzoPadre;    
public Cartero cartero;
public Bus bus;

public Peaton peatones[];
public Automovil auto[];
public Timer temporizador;
int portales;
public ArrayList<Celda> buzon;


public Calles(Lienzo lienzoPadre) {
 celdas=new Celda[anchoMV][altoMV];
 generarMapa();
 this.portales = nBuzones;
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
            celdas[i][j]= new Celda(i+(i*dimCelda),j+(j*dimCelda),'M',0);
            if(i % 6==0 && j % 6 == 0 )
            celdas[i][j]= new Celda(i+(i*dimCelda),j+(j*dimCelda),'M', numeroAleatorio(1,100));
            
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

int contador = 0;
for (int a=0; a<anchoMV-1;a++ ){
    for (int w=0; w<altoMV-1; w++ ){
        if ((a%6==0 && a > 0) && ((w==7)||(w==13)|| w==19)){
            if (contador < nBuzones){
                celdas[a][w].tipo= 'X';
                celdas[a][w].priori= numeroAleatorio(1,100);
                contador = contador +1;
            }
        }
    }
}

for (int z=0; z<anchoMV-1;z++ ){
    for (int w=0; w<altoMV-1; w++ ){
        if((z%6==0 && z>0) && ((w==5)||(w==11)|| w==17)){
                celdas[z][w].tipo= 'S';
        }
    }
}
celdas [0][0].tipo='G';

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
    int fontSize = 20;
    g.setFont(new Font("Arial", Font.PLAIN, fontSize));
    g.setColor(Color.red);
    
    
    
    for(int i=0; i < anchoMV; i++){
    for ( int j=0 ; j < altoMV; j++){
            celdas[i][j].paintComponent(g);
            }
        }

    for(int i=0; i < anchoMV; i++){
        for ( int j=0 ; j < altoMV; j++){
             if(celdas[i][j].tipo== 'X'){
                g.drawString(""+celdas[i][j].priori, (i+1)*dimCelda, j*dimCelda);
            } 
        }
    }
    
        if(cartero.cartax >0){
                for (int i = 0; i < cartero.cartax; i++) {
                cartero.mCartas[i].update(g);
            }
        }
        
           if( cartero.portal == true){
                if(cartero.cartax==0 ){
                    g.drawString(" se acabaron las cartas, Volviendo a la central ", cartero.cartero.x *dimCelda, cartero.cartero.y*dimCelda);
                }
                else{
                    g.drawString("Cartero en el Portal, quedan "+cartero.cartax+" cartas", cartero.cartero.x *dimCelda, (cartero.cartero.y+2)*dimCelda);
                }
           }
           if(cartero.cartero.x == pyr_x && cartero.cartero.y == pyr_y && cartero.cartax ==0 ){
               if (cartero.robo == false){
                g.drawString("Cartero en correos. Todas las cartas han sido entregadas" , cartero.cartero.x+2 *dimCelda, cartero.cartero.y+2*dimCelda);
               }else{
               g.drawString("Cartero en correos. Todas las cartas han sido robadas" , cartero.cartero.x+2 *dimCelda, cartero.cartero.y+2*dimCelda);
               }
               }
    
           
        if(bus.pasajerosInt>0){
            for (int i = 0; i < bus.pasajerosInt; i++) {
                bus.pasajeros[i].update(g);
            }
        } 
    }
}
    