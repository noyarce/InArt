
package main;

import java.util.TimerTask;

public class Peaton extends TimerTask implements Constantes{
public Calles calle;
public Celda peaton;

    public Peaton(Calles calle){
        this.calle=calle;
        int ptn_x= numeroAleatorio(0,altoMV);
        int ptn_y= numeroAleatorio(0,anchoMV);
    peaton=new Celda(ptn_x, ptn_y,'P');   
    calle.celdas[peaton.x][peaton.y].tipo='P';
    }
@Override
    public void run() {
    }
}
