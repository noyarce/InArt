    package main;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Celda extends JComponent implements Constantes {

public int x;
public int y;
public int priori;
public boolean rectCelda;
public char tipo;
public BufferedImage cartero,casa,camino, peaton, portal, obstaculo,acera, automovil,
        ladron,cebra, bus, paradero, pasajero, correos, tolis;

public Celda(int x,int y,char tipo, int priori) {
this.x=x;
this.y=y;
this.priori=priori;

this.tipo=tipo;
try {
    paradero = ImageIO.read(new File("src/imagenes/paradero.png"));
    automovil  = ImageIO.read(new File("src/imagenes/automovil.png"));
    obstaculo  = ImageIO.read(new File("src/imagenes/obstaculo.png"));
    cartero  = ImageIO.read(new File("src/imagenes/jugador.png"));
    casa    = ImageIO.read(new File("src/imagenes/casa.png"));
    camino   = ImageIO.read(new File("src/imagenes/camino.png"));
    portal   = ImageIO.read(new File("src/imagenes/portalx.png"));
    peaton   = ImageIO.read(new File("src/imagenes/peaton.png"));
    acera   = ImageIO.read(new File("src/imagenes/acera.png"));
    cebra   = ImageIO.read(new File("src/imagenes/paso peatonal.png"));
    bus  = ImageIO.read(new File("src/imagenes/bus.png"));
    correos= ImageIO.read(new File("src/imagenes/correos.png"));
    ladron= ImageIO.read(new File("src/imagenes/ladron.png"));
    tolis= ImageIO.read(new File("src/imagenes/Portale.png"));

    }
catch (IOException e) {
    System.out.println("error aca "+e.toString());
    }

}

@Override
    public void update(Graphics g) {
    switch(tipo) {
        case 'T': g.drawImage(automovil,x,y, null); break;
        case 'O': g.drawImage(obstaculo,x,y, null); break;
        case 'J': g.drawImage(cartero,x,y, null); break;
        case 'P': g.drawImage(peaton,x,y, this); break;
        case 'C': g.drawImage(camino,x,y, this); break;
        case 'M': g.drawImage(casa,x,y, this); break;
        case 'X': g.drawImage(portal,x,y, this); break;
        case 'A': g.drawImage(acera,x,y, this); break;
        case 'Z': g.drawImage(cebra,x,y, this); break;
        case 'B': g.drawImage(bus,x,y,this); break;
        case 'S': g.drawImage(paradero,x,y,this); break;
        case 'G': g.drawImage(correos,x,y,this); break;
        case 'L': g.drawImage(ladron,x,y,this); break;
        case 'Y': g.drawImage(tolis,x,y,this); break;

        }
    }

    @Override
    public void paintComponent (Graphics g){
        update (g);
        }
    
}

