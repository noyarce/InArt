    package main;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Celda extends JComponent implements Constantes {

public int x;
public int y;

public boolean rectCelda;
public char tipo;
public BufferedImage cartero,pared,camino, peaton, portal;

public Celda(int x,int y, char tipo) {
this.x=x;
this.y=y;
// rectCelda= new Rectangle (x,y,dimCelda,dimCelda);

this.tipo=tipo;
try {
    cartero  = ImageIO.read(new File("src/imagenes/jugador.png"));
    pared    = ImageIO.read(new File("src/imagenes/pared.png"));
    camino   = ImageIO.read(new File("src/imagenes/camino.png"));
    portal   = ImageIO.read(new File("src/imagenes/portal.png"));
    peaton   = ImageIO.read(new File("src/imagenes/peaton.png"));
    }
catch (IOException e) {
    System.out.println(e.toString());
    }

}
/**/
@Override
    public void paintComponent(Graphics g) {
    switch(tipo) {
        case 'J': g.drawImage(cartero,x,y, null); break;
        case 'P': g.drawImage(peaton,x,y, this); break;
        case 'C': g.drawImage(camino,x,y, this); break;
        case 'M': g.drawImage(pared,x,y, this); break;
        case 'X': g.drawImage(portal,x,y, this); break;
         }
    }

    public boolean celdaSeleccionada(int xp,int yp) { 
//    boolean x = rectCelda.contains(new Point(xp,yp));   
//    return rectCelda.contains(new Point(xp,yp));   
        return true;
  /*
  if (x==false){
  return true;
  }else{
  return false;
  }
  */
    }

}   