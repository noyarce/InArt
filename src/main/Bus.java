package main;

import java.util.TimerTask;



public class Bus extends TimerTask implements Constantes{
public Calles calle;
public Celda bus;
public Pasajero[] pasajeros;
public int pasajerosInt;

public Bus(Calles calle) {
    this.calle=calle;
    bus=new Celda(bus_x,bus_y,'B');   
    calle.celdas[bus.x][bus.y].tipo='B';
    this.pasajeros = new Pasajero[nPasajeros]; 
    pasajerosInt = nPasajeros;
  for (int i = 0; i < nPasajeros ;i++){
  pasajeros [i]= new Pasajero(((bus.x*dimCelda+i)-nPasajeros)*8, (bus.y*dimCelda)-(dimCelda/4));
  }
    
}

public void moverBusIzq(){
    if (bus.x > 0 ){
        if (calle.celdas[bus.x-1][bus.y].tipo=='C'||
            calle.celdas[bus.x-1][bus.y].tipo=='Z') {
                if ((bus.x%2==0)&&(bus.x%6!=0)){
                    calle.celdas[bus.x][bus.y].tipo='Z';
                }
                else{
                    calle.celdas[bus.x][bus.y].tipo='C'; 
                }
                bus.x=bus.x-1;
                calle.celdas[bus.x][bus.y].tipo='B';
                for (int i =0 ; i< pasajerosInt; i++){
                    pasajeros [i].x = pasajeros [i].x + dimCelda; 
                }         
        }
    }
    else{
        if ((bus.x%2==0)&&(bus.x%6!=0)){
            calle.celdas[bus.x][bus.y].tipo='Z';
        }
        else{
            calle.celdas[bus.x][bus.y].tipo='C'; 
        }
        bus.x = anchoMV-1;
        calle.celdas[bus.x][bus.y].tipo='B';
        for (int i =0 ; i< pasajerosInt; i++){
            pasajeros [i].x = pasajeros [i].x + dimCelda; 
        } 
    }    
}
public void moverBusDer(){
    if (bus.x < anchoMV-1 ){
        if (calle.celdas[bus.x][bus.y+2].tipo=='S' && pasajerosInt>0){
            calle.celdas[bus.x][bus.y+2].tipo='P';
            pasajerosInt=pasajerosInt-1;
        }
        if (calle.celdas[bus.x+1][bus.y].tipo=='C'||
            calle.celdas[bus.x+1][bus.y].tipo=='Z') {
                if ((bus.x%2==0)&&(bus.x%6!=0)){
                    calle.celdas[bus.x][bus.y].tipo='Z';
                }
                else{
                    calle.celdas[bus.x][bus.y].tipo='C'; 
                }
                bus.x=bus.x+1;
                calle.celdas[bus.x][bus.y].tipo='B';
                for (int i =0 ; i< pasajerosInt; i++){
                    pasajeros [i].x = pasajeros [i].x + dimCelda; 
                }       
        }
    }
    else{
        if ((bus.x%2==0)&&(bus.x%6!=0)){
            calle.celdas[bus.x][bus.y].tipo='Z';
            }
        else{
            calle.celdas[bus.x][bus.y].tipo='C'; 
        }        
        bus.x=0;
        calle.celdas[bus.x][bus.y].tipo='B';
        for (int i =0 ; i< pasajerosInt; i++){
             pasajeros[i].x = 0;
            pasajeros [i].x = pasajeros [i].x + dimCelda; 
        }
    }
}
public void moverBusUp(){
    if (bus.y > 0){
        if(calle.celdas[bus.x][bus.y-1].tipo=='C'||
           calle.celdas[bus.x][bus.y-1].tipo=='Z') {
            if ((bus.y%2==0)&&(bus.y%6!=0)){
                calle.celdas[bus.x][bus.y].tipo='Z';
            }
            else{
                calle.celdas[bus.x][bus.y].tipo='C';
            }
            bus.y=bus.y-1;
            calle.celdas[bus.x][bus.y].tipo='B';
            for (int i =0 ; i< pasajerosInt; i++){
                pasajeros [i].y = pasajeros [i].y + dimCelda; 
            }     
        }
    }
    else{
        if ((bus.y%3==0)&&(bus.y%6!=0)){
            calle.celdas[bus.x][bus.y].tipo='Z';
        }
        else{
            calle.celdas[bus.x][bus.y].tipo='C'; 
        }
        bus.y=altoMV-1;
        calle.celdas[bus.x][bus.y].tipo='B';
        for (int i =0 ; i< pasajerosInt; i++){
            pasajeros [i].y = pasajeros [i].y + dimCelda; 
        }
    }  
}
public void moverBusDwn(){   
if (bus.y < altoMV-1){  
    if(calle.celdas[bus.x][bus.y+1].tipo=='C'||
       calle.celdas[bus.x][bus.y+1].tipo=='Z') {
       if ((bus.y%2==0)&&(bus.y%6!=0)){
           calle.celdas[bus.x][bus.y].tipo='Z';
        }
        else{
            calle.celdas[bus.x][bus.y].tipo='C';
        }
        bus.y=bus.y+1;
        calle.celdas[bus.x][bus.y].tipo='B';    
        for (int i =0 ; i< pasajerosInt; i++){
             pasajeros [i].y = pasajeros [i].y + dimCelda; 
        }    
    }                    
}
 else{
        if ((bus.y%3!=0)&&(bus.y%6==0)){
            calle.celdas[bus.x][bus.y].tipo='Z';
        }
        else{
            calle.celdas[bus.x][bus.y].tipo='C'; 
            }                    
        calle.celdas[bus.x][bus.y].tipo='C';
        bus.y=0;
        calle.celdas[bus.x][bus.y].tipo='B';
        for (int i =0 ; i< pasajerosInt; i++){
            pasajeros [i].y = pasajeros [i].y + dimCelda; 
        }    
    }
  }

@Override
public void run() {
    int direccion;
    direccion = 3;
    switch (direccion){
            case 1:  moverBusIzq(); break;
            case 2:  moverBusUp(); break;
            case 3: moverBusDer();break;
            case 4: moverBusDwn();break;
    }
        calle.lienzoPadre.repaint();
        }
}
