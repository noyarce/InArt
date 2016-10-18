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

public void moverAutomovil(){
if (automovil.x > 0 ) {
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
    calle.celdas[automovil.x][automovil.y].tipo='C';
    automovil.x=automovil.x-1;
    calle.celdas[automovil.x][automovil.y].tipo='T';
    }
else{   
    boolean flag = false;
    int y = 0;
    while (flag == false){
        y = numeroAleatorio(0,altoMV-1);
            if ((y%2==0)&&(y%4!=0)){
                flag = true;
            }
    }
    calle.celdas[automovil.x][automovil.y].tipo='C';
    automovil.x=anchoMV-1;
    automovil.y=y;
    calle.celdas[automovil.x][automovil.y].tipo='T';
    }
}

@Override
public void run() {
    moverAutomovil();
    calle.lienzoPadre.repaint();
    }
}
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