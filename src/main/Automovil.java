
package main;

import java.util.TimerTask;

public class Automovil extends TimerTask implements Constantes{
public Calles calle;
public Celda automovil;
public Automovil(Calles calle) {
    this.calle=calle;
    automovil=new Celda(anchoMV-1,numeroAleatorio(0,altoMV-1),'C');
    calle.celdas[automovil.x][automovil.y].tipo='C';
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
    calle.celdas[automovil.x][automovil.y].tipo='C';
    automovil.x=anchoMV-1;
    automovil.y=numeroAleatorio(0,altoMV-1);
    calle.celdas[automovil.x][automovil.y].tipo='T';
    }
}

@Override
public void run() {
    moverAutomovil();
    calle.lienzoPadre.repaint();
    }
}