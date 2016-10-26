package main;

import java.util.Random;

public interface Constantes {
/**/
    public final int dimCelda = 32;
    public final int anchoMV = 35;
    public final int altoMV = 21;
    
    public final char CARTERO ='J';
    public final char CAMINO ='C';
    public final char PEATONES ='P';
    public final char CASA ='M';
    public final char PORTAL = 'X';
    public final char OBSTACULO = 'O';

    public final int prt_x = 31;  /*portal horizontal*/
    public final int prt_y = 20; /* portal vertical */
    public final int pyr_x = 1; /* cartero vertical */
    public final int pyr_y = 0;  /*cartero horizontal*/
    public final int car = 6; 

default int numeroAleatorio(int minimo, int maximo) {
Random random = new Random();
int numero_aleatorio = random.nextInt((maximo - minimo) + 1) + minimo;
return numero_aleatorio;  
}
default int randomPeaton(){
boolean flag = false;
        int y = 0;
        while (flag == false){
        y = numeroAleatorio(0,altoMV-1);
            if ((y%2==0)&&(y%6!=0)){
                flag = true;
            }
    }
return y;
}

default int randomInit(){
        boolean flag = false;
        int y = 0;
        while (flag == false){
        y = numeroAleatorio(0,altoMV-1);
            if ((y%3==0)&&(y%6!=0)){
                flag = true;
            }
    }
return y;
}
}
