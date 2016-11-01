package main;

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Automovil extends TimerTask implements Constantes{
public Calles calle;
public Celda automovil;

public Automovil(Calles calle) {
    this.calle=calle;
    automovil=new Celda(0,car,0,0,'T');   
    calle.celdas[automovil.x][automovil.y].tipo='T';
}

public void moverAutoIzq(){
            if (automovil.x > 0 && (calle.celdas[automovil.x-1][automovil.y].tipo=='Z' ||calle.celdas[automovil.x-1][automovil.y].tipo=='C')) {
                if ((automovil.x%2==0)&&(automovil.x%6!=0)){
                    calle.celdas[automovil.x][automovil.y].tipo='Z';
                    automovil.x=automovil.x-1;
                    automovil.i=automovil.x;    
                    automovil.j=automovil.y;
                    calle.celdas[automovil.x][automovil.y].tipo='T';
                    }
                else{
                calle.celdas[automovil.x][automovil.y].tipo='C';
                automovil.x=automovil.x-1;
                automovil.i=automovil.x;    
                automovil.j=automovil.y;
                calle.celdas[automovil.x][automovil.y].tipo='T';
                } 
            }
            else{
                 calle.celdas[automovil.x][automovil.y].tipo='C';
                 automovil.x=anchoMV-1;
                 automovil.y=randomInit();
                 automovil.i=automovil.x;    
                 automovil.j=automovil.y;
                 calle.celdas[automovil.x][automovil.y].tipo='T';
                }    
}
public void moverAutoDer(){
            if (automovil.x < anchoMV-1 && (calle.celdas[automovil.x+1][automovil.y].tipo=='Z' || calle.celdas[automovil.x+1][automovil.y].tipo=='C')) {
               if ((automovil.x%2==0)&&(automovil.x%6!=0)){
                    calle.celdas[automovil.x][automovil.y].tipo='Z';
                }
                else{
                    calle.celdas[automovil.x][automovil.y].tipo='C';
                }
            automovil.x=automovil.x+1;
            automovil.i=automovil.x;    
            automovil.j=automovil.y;
            calle.celdas[automovil.x][automovil.y].tipo='T';
            }
             else{               
                 calle.celdas[automovil.x][automovil.y].tipo='C';
                 automovil.y=altoMV-1;
                 automovil.x= randomInit();
                 automovil.i=automovil.x;    
                 automovil.j=automovil.y;
                 calle.celdas[automovil.x][automovil.y].tipo='T';
                } 
}
public void moverAutoUp(){
            if (automovil.y > 0 && (calle.celdas[automovil.x][automovil.y-1].tipo=='Z' || calle.celdas[automovil.x][automovil.y-1].tipo=='C')) {
                if ((automovil.y%3==0)&&(automovil.y%6!=0)){
                    calle.celdas[automovil.x][automovil.y].tipo='Z';
                    automovil.y=automovil.y-1;
                    automovil.i=automovil.x;    
                    automovil.j=automovil.y;
                    calle.celdas[automovil.x][automovil.y].tipo='T';
                }
                else{
                calle.celdas[automovil.x][automovil.y].tipo='C';
                automovil.y=automovil.y-1;
                automovil.i=automovil.x;    
                automovil.j=automovil.y;
                calle.celdas[automovil.x][automovil.y].tipo='T';
                }
            }
             else{
                 calle.celdas[automovil.x][automovil.y].tipo='C';
                 automovil.x=anchoMV-1;
                 automovil.y= randomInit();
                 automovil.i=automovil.x;    
                 automovil.j=automovil.y;
                 calle.celdas[automovil.x][automovil.y].tipo='T';
                }      
}
public void moverAutoDwn(){
            if (automovil.y < altoMV-1 && (calle.celdas[automovil.x][automovil.y+1].tipo=='Z' || calle.celdas[automovil.x][automovil.y+1].tipo=='C')) {
                if ((automovil.y%3==0)&&(automovil.y%6!=0)){
                    calle.celdas[automovil.x][automovil.y].tipo='Z';
                    automovil.y=automovil.y+1;
                    automovil.i=automovil.x;    
                    automovil.j=automovil.y;
                    calle.celdas[automovil.x][automovil.y].tipo='T';
                }
                else{
                calle.celdas[automovil.x][automovil.y].tipo='C';
                automovil.y=automovil.y+1;
                automovil.i=automovil.x;    
                automovil.j=automovil.y;
                calle.celdas[automovil.x][automovil.y].tipo='T';
                }
            }
             else{
                 calle.celdas[automovil.x][automovil.y].tipo='C';
                 automovil.x=anchoMV-1;
                 automovil.y= randomInit();
                 automovil.i=automovil.x;    
                 automovil.j=automovil.y;
                 calle.celdas[automovil.x][automovil.y].tipo='T';
                }      
}

@Override
public void run() {
    int direccion;
    direccion=numeroAleatorio(1,4);
    int contador=0;
    while (true){
    if(contador==9){
        contador=0;
        direccion=numeroAleatorio(1,4);
        }
    switch (direccion){
            case 1:  moverAutoIzq(); break;
            case 2:  moverAutoDer(); break;
            case 3:  moverAutoUp(); break;
            case 4:  moverAutoDwn(); break;
        }
        try {
            Thread.sleep(400);
        } catch (InterruptedException ex) {
            Logger.getLogger(Automovil.class.getName()).log(Level.SEVERE, null, ex);
        }
        calle.lienzoPadre.repaint();
        contador++;
        
    }
    }
}


