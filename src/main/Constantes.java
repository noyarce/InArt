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

    public final int prt = 10;  /*portal*/
    public final int pyr = 2; /*player*/
    public final int car = 6; 

default int numeroAleatorio(int minimo, int maximo) {
Random random = new Random();
int numero_aleatorio = random.nextInt((maximo - minimo) + 1) + minimo;
return numero_aleatorio;  
}
/*
 boolean flag = false;
    int y = 0;
    while (flag == false){
        y = numeroAleatorio(0,altoMV-1);
            if ((y%2==0)&&(y%4!=0)){
                flag = true;
            }
*/

}
