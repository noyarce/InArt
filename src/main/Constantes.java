package main;

import java.util.Random;
import javax.swing.JOptionPane;

public interface Constantes {
    public final int dimCelda = 32;
    public final int anchoMV = 36;
    public final int altoMV = 21;
       
    public final int pyr_x = 1; /* cartero vertical */
    public final int pyr_y = 0;  /*cartero horizontal*/
  
    public final int bus_x = 0;
    public final int bus_y = 3;
    
    public int cartas = 4;
    public int nPasajeros = 3; 
    public int nPeatones = 5;
    public int nAutos = 5;
    
    public int nBuzones = 15;
    
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

default int randomCarta(int cartas){
boolean flag = false;
        int y = 0;
        while (flag == false){
        y = numeroAleatorio(1,3);
            if (cartas>=y){
                flag = true;
            }
    }
    return y;
}

default int randomAuto(){
        boolean flag = false;
        int y = 0;
        while (flag == false){
        y = numeroAleatorio(0,anchoMV-1);
            if ((y%3==0)&&(y%6!=0)){
                flag = true;
            }
    }
    return y;
 }

}
