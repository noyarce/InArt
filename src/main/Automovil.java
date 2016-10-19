package main;

import java.util.TimerTask;

public class Automovil extends TimerTask implements Constantes{
public Calles calle;
public Celda automovil;

public Automovil(Calles calle) {
    this.calle=calle;
    automovil=new Celda(0,car,'T');   
    calle.celdas[automovil.x][automovil.y].tipo='T';
}

public void moverAutoIzq(){
            if (automovil.x > 0 ) {
                calle.celdas[automovil.x][automovil.y].tipo='C';
                automovil.x=automovil.x-1;
                calle.celdas[automovil.x][automovil.y].tipo='T';
                }
             else{
                 calle.celdas[automovil.x][automovil.y].tipo='C';
                 automovil.x=anchoMV-1;
                 automovil.y= randomInit();
                 calle.celdas[automovil.x][automovil.y].tipo='T';
                }
           
}
public void moverAutoDer(){
            if (automovil.x > 0 ) {
                calle.celdas[automovil.x][automovil.y].tipo='C';
                automovil.x=automovil.x-1;
                calle.celdas[automovil.x][automovil.y].tipo='T';
                }
             else{
                 calle.celdas[automovil.x][automovil.y].tipo='C';
                 automovil.x=anchoMV-1;
                 automovil.y= randomInit();
                 calle.celdas[automovil.x][automovil.y].tipo='T';
                }
           
}
public void moverAutoUp(){
            if (automovil.x > 0 ) {
                calle.celdas[automovil.x][automovil.y].tipo='C';
                automovil.x=automovil.x-1;
                calle.celdas[automovil.x][automovil.y].tipo='T';
                }
             else{
                 calle.celdas[automovil.x][automovil.y].tipo='C';
                 automovil.x=anchoMV-1;
                 automovil.y= randomInit();
                 calle.celdas[automovil.x][automovil.y].tipo='T';
                }
           
}
public void moverAutoDwn(){
            if (automovil.x > 0 ) {
                calle.celdas[automovil.x][automovil.y].tipo='C';
                automovil.x=automovil.x-1;
                calle.celdas[automovil.x][automovil.y].tipo='T';
                }
             else{
                 calle.celdas[automovil.x][automovil.y].tipo='C';
                 automovil.x=anchoMV-1;
                 automovil.y= randomInit();
                 calle.celdas[automovil.x][automovil.y].tipo='T';
                }
           
}

@Override
public void run() {
    int direccion;
    
    direccion=numeroAleatorio(1,4);
    switch (direccion){
        case 1:  moverAutoIzq(); break;
        case 2:  moverAutoDer(); break;
        case 3:  moverAutoUp(); break;
        case 4:  moverAutoDwn(); break;
    }
    calle.lienzoPadre.repaint();
    }
}


/*
    char op = calle.celdas[automovil.x][automovil.y-1].tipo;
    switch (op){
        case 'A':{};
        case 'O':{}; 
        case 'J':{}; 
        case 'P':{}; 
        case 'C':{}; 
        case 'M':{}; 
        case 'X':{}; 
    }
*/

/*
if
((y%2==0)&&(y%4!=0))&& ((x%2==0)&&(x%4!=0))
mov= random (1-4) 
switch (mov)
case 1 :
case 2 : 
case 3 : 
case 4 :
*/