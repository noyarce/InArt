
package main;

import java.util.TimerTask;

public class Peaton extends TimerTask implements Constantes{
public Calles calle;
public Celda peaton;

    public Peaton(Calles calle){
        this.calle=calle;
        int ptn_x= randomPeaton();
        int ptn_y= randomPeaton();
    peaton=new Celda(ptn_x, ptn_y,'P',0);   
    calle.celdas[peaton.x][peaton.y].tipo='P';
    }
    
public void moverPeatonIzq(){
            if (peaton.x > 0 ){
                if (calle.celdas[peaton.x-1][peaton.y].tipo=='A'||
                    calle.celdas[peaton.x-1][peaton.y].tipo=='Z') {
                    if ((peaton.x%3==0)&&(peaton.x%6!=0)){
                        calle.celdas[peaton.x][peaton.y].tipo='Z';
                    }
                    else{
                        calle.celdas[peaton.x][peaton.y].tipo='A'; 
                    }
                peaton.x=peaton.x-1;
                calle.celdas[peaton.x][peaton.y].tipo='P';
                }
            }
            else{
                if ((peaton.x%3==0)&&(peaton.x%6!=0)){
                        calle.celdas[peaton.x][peaton.y].tipo='Z';
                    }
                    else{
                        calle.celdas[peaton.x][peaton.y].tipo='A'; 
                    } 
                peaton.x=anchoMV-1;
                    calle.celdas[peaton.x][peaton.y].tipo='P';
                }
}
public void moverPeatonDer(){
    if (peaton.x < anchoMV-1 ){
                if (calle.celdas[peaton.x+1][peaton.y].tipo=='A'||
                    calle.celdas[peaton.x+1][peaton.y].tipo=='Z') {
                    if ((peaton.x%3==0)&&(peaton.x%6!=0)){
                        calle.celdas[peaton.x][peaton.y].tipo='Z';
                    }
                    else{
                        calle.celdas[peaton.x][peaton.y].tipo='A'; 
                    }
                peaton.x=peaton.x+1;
                calle.celdas[peaton.x][peaton.y].tipo='P';
                }
            }
            else{
        moverPeatonIzq();
        moverPeatonIzq();
    }    
}
public void moverPeatonUp(){
           if (peaton.y > 0){
               if(calle.celdas[peaton.x][peaton.y-1].tipo=='A'||
                calle.celdas[peaton.x][peaton.y-1].tipo=='Z') {
                if ((peaton.y%3==0)&&(peaton.y%6!=0)){
                    calle.celdas[peaton.x][peaton.y].tipo='Z';
                }
                else{
                   calle.celdas[peaton.x][peaton.y].tipo='A';
                }
                peaton.y=peaton.y-1;
                calle.celdas[peaton.x][peaton.y].tipo='P';
            }
           }
           else{
               
           moverPeatonDwn();
           moverPeatonDwn();
           }
}
public void moverPeatonDwn(){
            if (peaton.y != altoMV-1){
                    if(calle.celdas[peaton.x][peaton.y+1].tipo=='A'||
                       calle.celdas[peaton.x][peaton.y+1].tipo=='Z') {
                            if ((peaton.y%3==0)&&(peaton.y%6!=0)){
                                calle.celdas[peaton.x][peaton.y].tipo='Z';
                            }
                            else{
                            calle.celdas[peaton.x][peaton.y].tipo='A';
                            }
                    peaton.y=peaton.y+1;
                    calle.celdas[peaton.x][peaton.y].tipo='P';    
                    }
            }
            else{
            moverPeatonUp();     
            moverPeatonUp();     
            }            
}

@Override
public void run() {
    int direccion;
    
    direccion=numeroAleatorio(1,4);
    switch (direccion){
        case 1:  moverPeatonIzq(); break;
        case 2:  moverPeatonDer(); break;
        case 3:  moverPeatonUp(); break;
        case 4:  moverPeatonDwn(); break;
    }
    calle.lienzoPadre.repaint();
    }
}
