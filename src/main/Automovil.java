package main;

import java.util.ArrayList;
import java.util.TimerTask;



public class Automovil extends TimerTask implements Constantes{
public Calles calle;
public Celda automovil;
public ArrayList<Character> movs;

public Automovil(Calles calle) {
    this.calle=calle;
    automovil=new Celda(randomAuto(),altoMV-1,'T',0);   
    calle.celdas[automovil.x][automovil.y].tipo='T';
    movs=new ArrayList<>();
    
    int dir= 0;
    for (int i = 0; i < 10000; i++){
        for (int j =0; j< 6; j++){
            if (dir == 0){
            movs.add('U');
            }
            if (dir == 1){
            movs.add('L');
            }
            if(dir == 2){
            movs.add('U');
            }
            
        }
        dir= dir+1;
        if(dir ==3){
        dir = 0;
        }
    }
    
    
}

public void moverAutoIzq(){
               if (automovil.x > 0 ){
                   if (calle.celdas[automovil.x-1][automovil.y].tipo=='C'||calle.celdas[automovil.x-1][automovil.y].tipo=='Z') {
                                if ((automovil.x%2==0)&&(automovil.x%6!=0)){
                                    calle.celdas[automovil.x][automovil.y].tipo='Z';
                                }
                                else{
                                    calle.celdas[automovil.x][automovil.y].tipo='C'; 
                                }
                                automovil.x=automovil.x-1;
                                calle.celdas[automovil.x][automovil.y].tipo='T';
                    }
                    else{
                        moverAutoDer();
                    }
               }
                else{
                    if ((automovil.x%2==0)&&(automovil.x%6!=0)){
                        calle.celdas[automovil.x][automovil.y].tipo='Z';
                    }
                    else{
                        calle.celdas[automovil.x][automovil.y].tipo='C'; 
                    }
                automovil.x = anchoMV-1;
                calle.celdas[automovil.x][automovil.y].tipo='T';
                }    
}
public void moverAutoDer(){
            if (automovil.x < anchoMV-1 ){
                if (calle.celdas[automovil.x+1][automovil.y].tipo=='C'||
                    calle.celdas[automovil.x+1][automovil.y].tipo=='Z') {
                    if ((automovil.x%2==0)&&(automovil.x%6!=0)){
                        calle.celdas[automovil.x][automovil.y].tipo='Z';
                    }
                    else{
                        calle.celdas[automovil.x][automovil.y].tipo='C'; 
                    }
                automovil.x=automovil.x+1;
                calle.celdas[automovil.x][automovil.y].tipo='T';
                }
                
            }
            else{
                if ((automovil.x%2==0)&&(automovil.x%6!=0)){
                    calle.celdas[automovil.x][automovil.y].tipo='Z';
                    }
                    else{
                    calle.celdas[automovil.x][automovil.y].tipo='C'; 
                }        
                automovil.x=0;
                calle.celdas[automovil.x][automovil.y].tipo='T';
                }     
}
public void moverAutoUp(){
            if (automovil.y > 0){
               if(calle.celdas[automovil.x][automovil.y-1].tipo=='C'||
                calle.celdas[automovil.x][automovil.y-1].tipo=='Z') {
                if ((automovil.y%2==0)&&(automovil.y%6!=0)){
                    calle.celdas[automovil.x][automovil.y].tipo='Z';
                }
                else{
                   calle.celdas[automovil.x][automovil.y].tipo='C';
                }
                automovil.y=automovil.y-1;
                calle.celdas[automovil.x][automovil.y].tipo='T';
            }else{
                moverAutoIzq();
                }
           }
           else{
              if ((automovil.y%3==0)&&(automovil.y%6!=0)){
                        calle.celdas[automovil.x][automovil.y].tipo='Z';
                    }
                    else{
                        calle.celdas[automovil.x][automovil.y].tipo='C'; 
                    }
                automovil.y=altoMV-1;
                 calle.celdas[automovil.x][automovil.y].tipo='T';
                }    
}
public void moverAutoDwn(){   
if (automovil.y != altoMV-1){
                    if(calle.celdas[automovil.x][automovil.y+1].tipo=='C'||
                       calle.celdas[automovil.x][automovil.y+1].tipo=='Z') {
                            if ((automovil.y%2==0)&&(automovil.y%6!=0)){
                                calle.celdas[automovil.x][automovil.y].tipo='Z';
                            }
                            else{
                            calle.celdas[automovil.x][automovil.y].tipo='C';
                            }
                    automovil.y=automovil.y+1;
                    calle.celdas[automovil.x][automovil.y].tipo='T';    
                    }
            }
            else{
                 if ((automovil.y%3!=0)&&(automovil.y%6==0)){
                        calle.celdas[automovil.x][automovil.y].tipo='Z';
                    }
                    else{
                        calle.celdas[automovil.x][automovil.y].tipo='C'; 
                    }                    
                    calle.celdas[automovil.x][automovil.y].tipo='C';
                    automovil.x=randomAuto();
                    automovil.y=0;
                   
                    calle.celdas[automovil.x][automovil.y].tipo='T';
                }
}

@Override
public void run() {
    switch (movs.get(0)){
            case 'L':  moverAutoIzq(); break;
            case 'U':  moverAutoUp(); break;

        }
        movs.remove(0);
        calle.lienzoPadre.repaint();
        }
}
