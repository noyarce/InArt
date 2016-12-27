/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import java.util.ArrayList;
import java.util.TimerTask;



public class SuperLadron extends TimerTask implements Constantes{
    public Calles calle;
    public Ladron ladron;
       
    public ArrayList<Estado> colaEstados;
    public ArrayList<Estado> historial;
    public ArrayList<Character> pasos;
    public int index_pasos;
    public Estado inicial;
    public Estado objetivo;
    public Estado temp;
    public boolean exito;
    public boolean parar;

 public SuperLadron(Calles calle, Ladron ladron) {
        this.calle=calle;
        this.ladron=ladron;
         colaEstados=new ArrayList<>();
        historial=new ArrayList<>();
        pasos=new ArrayList<>();
        index_pasos=0;
        exito=false;
        parar=false;
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
            movArriba(temp);
            movAbajo(temp);
            movIzquierda(temp);
            movDerecha(temp);
        }
        
       return exito;
    }



private void movArriba(Estado e) {
       System.out.println(e.toString());
          if ( e.y > 0 ) {
            if ( calle.celdas[e.x][e.y-1].tipo == 'A'|| 
                 calle.celdas[e.x][e.y-1].tipo == 'C'||
                 calle.celdas[e.x][e.y-1].tipo == 'Z'||
                 calle.celdas[e.x][e.y-1].tipo=='J') {
                    Estado arriba=new Estado(e.x,e.y-1,'U',e, 0);
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
    
private void movAbajo(Estado e) {
        System.out.println(e.toString());
        if ( e.y < altoMV-1 ) {
            if (calle.celdas[e.x][e.y+1].tipo=='Z'
               ||calle.celdas[e.x][e.y+1].tipo=='A'
               ||calle.celdas[e.x][e.y+1].tipo=='C'
               ||calle.celdas[e.x][e.y+1].tipo=='J'){
                Estado abajo=new Estado(e.x,e.y+1,'D',e,0);
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
        
private void movIzquierda(Estado e) {
    System.out.println(e.toString());
        if ( e.x > 0 ) {
            if (calle.celdas[e.x-1][e.y].tipo=='A'||
                calle.celdas[e.x-1][e.y].tipo=='C'||
                calle.celdas[e.x-1][e.y].tipo=='J'||
                calle.celdas[e.x-1][e.y].tipo=='Z') {
                Estado izquierda=new Estado(e.x-1,e.y,'L',e,0);
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
    
private void movDerecha(Estado e) {
System.out.println(e.toString());
        if ( e.x < anchoMV-1 ) {                      
            if (calle.celdas[e.x+1][e.y].tipo=='A'||
                calle.celdas[e.x+1][e.y].tipo=='Z'||
                calle.celdas[e.x+1][e.y].tipo=='C'||
                calle.celdas[e.x+1][e.y].tipo=='J') {
                Estado derecha=new Estado(e.x+1,e.y,'R',e, 0); 
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
              subinicial=new Estado(calle.ladron.ladron.x,calle.ladron.ladron.y,'N',null,0);
              subobjetivo=new Estado(calle.cartero.cartero.x,calle.cartero.cartero.y,'N',null,0);
              resultado=this.buscar(subinicial,subobjetivo);
              if ( subinicial.equals(subobjetivo) ) {
                  parar=true;
                  this.cancel();
              }
          }while(!resultado);
          if ( pasos.size() > 1 ) {
             switch(pasos.get(1)) {
                case 'D': calle.ladron.moverLdrAbajo();break;
                case 'U': calle.ladron.moverLdrArriba(); break;
                case 'R': calle.ladron.moverLdrDerecha();break;
                case 'L': calle.ladron.moverLdrIzquierda();break;
             }
            calle.lienzoPadre.repaint();  
          }
       }
    }   
}