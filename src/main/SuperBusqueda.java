
package main;

import java.util.ArrayList;
import java.util.TimerTask;

import java.util.PriorityQueue;
import java.util.Queue;

public class SuperBusqueda extends TimerTask implements Constantes{
    public Calles calle;
    public Cartero cartero;
    
    public ArrayList<Estado> historial;
    public ArrayList<Character> pasos;
    public ArrayList<Estado> destinos;
    public int index_pasos;
    public Estado inicial;
    public Estado temp;
    public Estado objetivo;
   
    public boolean exito;
    public boolean parar;
    public ArrayList<Estado> colaEstados;
//    public Queue<Estado> colaEstados;

    public SuperBusqueda(Calles calle, Cartero cartero) {
        
        this.calle=calle;
        this.cartero=cartero;
        colaEstados = new ArrayList<>();
//        colaEstados=new PriorityQueue<>();
        historial=new ArrayList<>();
        pasos=new ArrayList<>();
        destinos=new ArrayList<>();
        index_pasos=0;
        exito=false;
        parar=false;
        
        /*define los estados objetivo*/
   for (int z=0; z<anchoMV-1;z++ ){
        for (int w=0; w<altoMV-1; w++ ){
              if (calle.celdas[z][w].tipo== 'X'){
                temp = new Estado (z,w,'N',null);
                System.out.println(temp.toString());
                destinos.add(temp);
            }
        }
    }
}  
        
int recorrer(Estado e){
int r=0;
for (int i =0; i<5; i++){
    for (int j=0;j<5;i++){
            if((e.x-4+i>=0)&&(e.y-2+j>=0)){
                if( calle.celdas[e.x-4+i][e.y-2+j].tipo=='P')
                    r=r+1;
             }
    }
    return r;
}
return r;
}
        
 boolean buscar(Estado inicial,Estado objetivo) {
        System.out.println("Estado inicial"+inicial.toString());
        System.out.println("Estado objetivo"+objetivo.toString());
        index_pasos=0;
        colaEstados.add(inicial);
        historial.add(inicial);
        this.objetivo=objetivo;
        exito=false;
        
        if ( inicial.equals(objetivo)) exito=true;

        while ( !colaEstados.isEmpty() && !exito ){           
            temp=colaEstados.get(0);
            colaEstados.remove(0);
//            temp=colaEstados.element();
//            colaEstados.poll();
            
            moverArriba(temp);

            moverIzquierda(temp);

            moverDerecha(temp);
            moverAbajo(temp);
        }
        
        if ( exito ) {
            System.out.println("Ruta calculada");
            this.calcularRuta();
            return true;
        }
        else {
            System.out.println("La ruta no pudo calcularse");
            return false;
        }
        
    }
/*
public void buscar(int x1,int y1,int x2,int y2) {
        inicial=new Estado(x1,y1,'N',null);
//        inicial.prioridad=distancia(x1,y1,calle.lienzoPadre.peaton.peaton.x,
//                calle.lienzoPadre.peaton.peaton.y);
        objetivo=new Estado(x2,y2,'P',null);
        
        colaEstados.add(inicial);
        historial.add(inicial);
        
        if ( inicial.equals(objetivo)) exito=true;
        
        while ( !colaEstados.isEmpty() && !exito ){
            
            temp=colaEstados.poll();

            moverArriba(temp);
            moverAbajo(temp);
            moverIzquierda(temp);
            moverDerecha(temp);
        }
        
        if ( exito ) System.out.println("Ruta calculada");
        else System.out.println("La ruta no pudo calcularse");
        
    }
    
    //distancia adversario
    public double distancia(int x1,int y1, int x2, int y2) {
        double valor;
        double parte1=Math.pow(Math.abs(x1-x2),2);
        double parte2=Math.pow(Math.abs(y1-y2),2);
        parte1+=parte2;
        valor=Math.sqrt(parte1);
        return valor;
    }
*/
private void moverArriba(Estado e) {
       System.out.println(e.toString());
          if ( e.y > 0 ) {

            if ( calle.celdas[e.x][e.y-1].tipo == 'A'|| 
                 calle.celdas[e.x][e.y-1].tipo == 'C'||
                 calle.celdas[e.x][e.y-1].tipo == 'Z' ||
                 calle.celdas[e.x][e.y-1].tipo=='X') { 

                 Estado arriba=new Estado(e.x,e.y-1,'U',e);
                 if ( !historial.contains(arriba)) {
                    colaEstados.add(arriba);
                    historial.add(arriba);
                    if ( arriba.equals(objetivo)) {
                        objetivo=arriba;
                        exito=true;
                    }
                    
                 }
            }     
        }
    }
    
private void moverAbajo(Estado e) {
        System.out.println(e.toString());
        if ( e.y < altoMV-1 ) {
            if (calle.celdas[e.x][e.y+1].tipo=='Z'
               ||calle.celdas[e.x][e.y+1].tipo=='A'
               ||calle.celdas[e.x][e.y+1].tipo=='C'
               ||calle.celdas[e.x][e.y+1].tipo=='X'){
                 Estado abajo=new Estado(e.x,e.y+1,'D',e);   
                 if ( !historial.contains(abajo)) {
                    colaEstados.add(abajo);
                    historial.add(abajo);
                    if ( abajo.equals(objetivo)) {
                        objetivo=abajo;
                        exito=true;
                    }
                 }   
            }     
        }
    }    
    
private void moverIzquierda(Estado e) {
    System.out.println(e.toString());
        if ( e.x > 0 ) {
            if (calle.celdas[e.x-1][e.y].tipo=='C'||
                calle.celdas[e.x-1][e.y].tipo=='A'||
                calle.celdas[e.x-1][e.y].tipo=='X'||
                calle.celdas[e.x-1][e.y].tipo=='Z') {
                   Estado izquierda=new Estado(e.x-1,e.y,'L',e);
                if ( !historial.contains(izquierda)) {
                   colaEstados.add(izquierda);
                   historial.add(izquierda);
                   if ( izquierda.equals(objetivo)) {
                       objetivo=izquierda;
                       exito=true;
                   }
                }   
            }    
        }
    }    
    
private void moverDerecha(Estado e) {
System.out.println(e.toString());
        if ( e.x < anchoMV-1 ) {                      
            if (calle.celdas[e.x+1][e.y].tipo=='A'||
                calle.celdas[e.x+1][e.y].tipo=='Z'||
                calle.celdas[e.x+1][e.y].tipo=='C'||
                calle.celdas[e.x+1][e.y].tipo=='X') {

                Estado derecha=new Estado(e.x+1,e.y,'R',e); 
               if ( !historial.contains(derecha)){
                 colaEstados.add(derecha);
                 historial.add(derecha);
                 if ( derecha.equals(objetivo)) {
                     objetivo=derecha;
                     exito=true;
                 }
               }  
            }     
        }
    }

    
    
    public void calcularRuta() {
        Estado predecesor=objetivo;
        do{
            pasos.add(0,predecesor.oper);
            predecesor=predecesor.predecesor;
        }while ( predecesor != null);
        index_pasos=pasos.size()-1;
        
    }

    @Override
    public void run() {
       if ( ! parar ) {
          colaEstados.clear();
          historial.clear();
          pasos.clear(); 
       
          Estado subinicial,subobjetivo;
          boolean resultado;
         
          do{
              subinicial=new Estado(calle.cartero.cartero.x,calle.cartero.cartero.y,'N',null);
              subobjetivo=destinos.get(0);
              resultado=this.buscar(subinicial,subobjetivo);
              
              if ( subinicial.equals(subobjetivo) ) 
                  destinos.remove(subobjetivo);
              else 
                  if ( !resultado) {
                      colaEstados.clear();
                      historial.clear();
                      pasos.clear(); 
                      destinos.remove(subobjetivo);
                  }
              if ( destinos.isEmpty()) {
                 System.out.println("Se acabo a donde ir");
                 this.cancel();
              }
              if (calle.cartero.cartax==0){
                  destinos.clear();
                  temp= new Estado (pyr_x, pyr_y,'N',null);
                  destinos.add(temp);
                }
              
              
          }while(!resultado && !destinos.isEmpty());
          if ( pasos.size() > 1 ) {
             switch(pasos.get(1)) {
                case 'D': calle.cartero.moverCrtAbajo();break;
                case 'U': calle.cartero.moverCrtArriba(); break;
                case 'R': calle.cartero.moverCrtDerecha();break;
                case 'L': calle.cartero.moverCrtIzquierda();break;
             }
            calle.lienzoPadre.repaint();  
          }
       }
    }   
}