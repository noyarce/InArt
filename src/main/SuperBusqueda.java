
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
    public Queue<Estado> colaEstados;

 public SuperBusqueda(Calles calle, Cartero cartero) {
        
        this.calle=calle;
        this.cartero=cartero;
        colaEstados=new PriorityQueue<>();
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
                temp = new Estado (z,w,'N',null,calle.celdas[z][w].priori);
                destinos.add(temp);
                temp.toString();
                }
            }
        }
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
            temp=colaEstados.element();
            colaEstados.poll();
            
            moverArriba(temp, objetivo);
            moverIzquierda(temp,objetivo);
            moverDerecha(temp,objetivo);
            moverAbajo(temp,objetivo);
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

 public double distancia(Estado a, Estado b) {
        double valor;
        double parte1=Math.pow(Math.abs(b.x-a.x),2);
        double parte2=Math.pow(Math.abs(b.y-a.y),2);
        parte1+=parte2;
        valor=(int) Math.sqrt(parte1);
        return valor;
    }

private void moverArriba(Estado e, Estado x) {
       System.out.println(e.toString());
          if ( e.y > 0 ) {
            if ( calle.celdas[e.x][e.y-1].tipo == 'A'|| 
                 calle.celdas[e.x][e.y-1].tipo == 'C'||
                 calle.celdas[e.x][e.y-1].tipo == 'Z'||
                 calle.celdas[e.x][e.y-1].tipo=='X') {
                    double priori = distancia (e,x)+ calle.celdas[x.x][x.y].priori;
                    Estado arriba=new Estado(e.x,e.y-1,'U',e, priori);
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
    
private void moverAbajo(Estado e, Estado x) {
        System.out.println(e.toString());
        if ( e.y < altoMV-1 ) {
            if (calle.celdas[e.x][e.y+1].tipo=='Z'
               ||calle.celdas[e.x][e.y+1].tipo=='A'
               ||calle.celdas[e.x][e.y+1].tipo=='C'
               ||calle.celdas[e.x][e.y+1].tipo=='X'){
                double priori = distancia (e,x)+ calle.celdas[x.x][x.y].priori;
                Estado abajo=new Estado(e.x,e.y+1,'D',e,priori);
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
        
private void moverIzquierda(Estado e, Estado x) {
    System.out.println(e.toString());
        if ( e.x > 0 ) {
            if (calle.celdas[e.x-1][e.y].tipo=='A'||
                calle.celdas[e.x-1][e.y].tipo=='C'||
                calle.celdas[e.x-1][e.y].tipo=='X'||
                calle.celdas[e.x-1][e.y].tipo=='Z') {
                    double priori = distancia (e,x)+ calle.celdas[x.x][x.y].priori;
                Estado izquierda=new Estado(e.x-1,e.y,'L',e, priori);
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
    
private void moverDerecha(Estado e, Estado x) {
System.out.println(e.toString());
        if ( e.x < anchoMV-1 ) {                      
            if (calle.celdas[e.x+1][e.y].tipo=='A'||
                calle.celdas[e.x+1][e.y].tipo=='Z'||
                calle.celdas[e.x+1][e.y].tipo=='C'||
                calle.celdas[e.x+1][e.y].tipo=='X') {
                    double priori = distancia (e,x)+ calle.celdas[x.x][x.y].priori;
                Estado derecha=new Estado(e.x+1,e.y,'R',e, priori); 
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
              subinicial=new Estado(calle.cartero.cartero.x,calle.cartero.cartero.y,'N',null,0);
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
                  temp= new Estado (pyr_x, pyr_y,'N',null,0);
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