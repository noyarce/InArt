package main;

import java.util.ArrayList;
import java.util.TimerTask;

class BusquedaRutaProf extends TimerTask implements Constantes{
    
    Lienzo lienzo;
    ArrayList<Estado> colaEstados;
    ArrayList<Estado> historial;
    ArrayList<Character> pasos;
    int index_pasos;
    Estado inicial;
    Estado objetivo;
    Estado temp;
    boolean exito;
    
    public BusquedaRutaProf(Lienzo lienzo) {
        
        this.lienzo=lienzo;
        colaEstados=new ArrayList<>();
        historial=new ArrayList<>();
        pasos=new ArrayList<>();
        index_pasos=0;
        //digo cual es el estado inicial y el final
        inicial=new Estado(0,1,'N',null);
        colaEstados.add(inicial);
        historial.add(inicial);
        
        objetivo=new Estado(11,6,'N',null);
        exito=false;
    }
    
    public void buscar() {
        
        if ( inicial.equals(objetivo)) exito=true;
        
        while ( !colaEstados.isEmpty() && !exito ) {
            temp=colaEstados.get(0);
            colaEstados.remove(0);
            moverArriba(temp);
            moverAbajo(temp);
            moverIzquierda(temp);
            moverDerecha(temp);
        }
        
        if ( exito ) System.out.println("Ruta calculada");
        else System.out.println("La ruta no pudo calcularse");
        
    }
    
private void moverArriba(Estado e) {
        
        if ( e.y > 0 ) {
            if ( lienzo.calle.celdas[e.x][e.y-1].tipo != 'P' ) { 
                 Estado arriba=new Estado(e.x,e.y-1,'U',e);
                 if ( !historial.contains(arriba)) {
                    colaEstados.add(0,arriba);
                    historial.add(arriba);
                    lienzo.calle.celdas[e.x][e.y-1].tipo='A';
                    if ( arriba.equals(objetivo)) {
                        lienzo.calle.celdas[e.x][e.y-1].tipo='D';
                        objetivo=arriba;
                        exito=true;
                    }
                    
                 }
            }     
        }
    }
    
    private void moverAbajo(Estado e) {
        System.out.println(e.toString());
        if ( e.y != altoMV-1 ) {
            if ( lienzo.calle.celdas[e.x][e.y+1].tipo != 'P' ) {
                 Estado abajo=new Estado(e.x,e.y+1,'D',e);   
                 if ( !historial.contains(abajo)) {
                    colaEstados.add(0,abajo);
                    historial.add(abajo);
                    lienzo.calle.celdas[e.x][e.y+1].tipo='A';
                    if ( abajo.equals(objetivo)) {
                        lienzo.calle.celdas[e.x][e.y+1].tipo='D';
                        objetivo=abajo;
                        exito=true;
                    }
                 }   
            }     
        }
    }    
    
    private void moverIzquierda(Estado e) {
        
        if ( e.x > 0 ) {
            if ( lienzo.calle.celdas[e.x-1][e.y].tipo != 'P' ) {
                Estado izquierda=new Estado(e.x-1,e.y,'L',e);
                if ( !historial.contains(izquierda)) {
                   colaEstados.add(0,izquierda);
                   historial.add(izquierda);
                   lienzo.calle.celdas[e.x-1][e.y].tipo='A';
                   if ( izquierda.equals(objetivo)) {
                       lienzo.calle.celdas[e.x-1][e.y].tipo='D';
                       objetivo=izquierda;
                       exito=true;
                   }
                }   
            }    
        }
    }    
    
    private void moverDerecha(Estado e) {
        
        if ( e.x < anchoMV-1 ) {
            if ( lienzo.calle.celdas[e.x+1][e.y].tipo != 'P' ) {
               Estado derecha=new Estado(e.x+1,e.y,'R',e); 
               if ( !historial.contains(derecha)){
                 colaEstados.add(0,derecha);
                 historial.add(derecha);
                 lienzo.calle.celdas[e.x+1][e.y].tipo='A';
                 if ( derecha.equals(objetivo)) {
                     lienzo.calle.celdas[e.x+1][e.y].tipo='D';
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
            pasos.add(predecesor.oper);
            predecesor=predecesor.predecesor;
        }while ( predecesor != null);
        index_pasos=pasos.size()-1;
        
    }

    @Override
    public void run() {
       if ( index_pasos >= 0 ) {
          switch(pasos.get(index_pasos)) {
             case 'D': lienzo.cartero.moverCrtAbajo();break;
             case 'U': lienzo.cartero.moverCrtArriba(); break;
             case 'R': lienzo.cartero.moverCrtDerecha();break;
             case 'L': lienzo.cartero.moverCrtIzquierda();break;
          }
          lienzo.repaint();  
          index_pasos--;
       }else {
          this.cancel();
       }
    }
}
