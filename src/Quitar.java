
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jorge
 */
public class Quitar extends Canvas implements MouseListener, MouseMotionListener {

    private BufferedImage ImagenFinal;
    String Hex;
    private Graphics2D FG;
    private int R, G, B;
    Color colorQuitar;
    Graphics g;

    public void pImagen(Image foto/*,Graphics g*/) {
        g = getGraphics();
        addMouseListener(this);
        ImagenFinal = new BufferedImage(foto.getWidth(null), foto.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        FG = ImagenFinal.createGraphics();
        System.out.println("Tamaño de imagen: "+ImagenFinal.getWidth());
        Graphics2D g2 = (Graphics2D) g;
        FG.drawImage(foto, 0, 0, null);
        g2.drawImage(foto, 0, 0, null);
    }
    
    private void repintar(){
        g.clearRect(0, 0,400,300);
        g.drawImage(ImagenFinal,0,0,null);
    }

    public BufferedImage Guardar() {
        return ImagenFinal;
    }

    //--------------------------código funcional--------------------------------
    private void getcolor(int x, int y) {
        Hex = Integer.toHexString(ImagenFinal.getRGB(x, y));
        while (Hex.length() < 8) {
            Hex = "0" + Hex;
        }
        R = Integer.parseInt(Hex.substring(2, 4), 16);
        G = Integer.parseInt(Hex.substring(4, 6), 16);
        B = Integer.parseInt(Hex.substring(6, 8), 16);
    }

    private void quitarFondo(int PX, int PY) {
        getcolor(PX, PY);
        colorQuitar = new Color(R, G, B);
        if (Color.black.getRed() == colorQuitar.getRed() && Color.black.getGreen() == colorQuitar.getGreen() && Color.black.getBlue() == colorQuitar.getBlue()) {
            System.out.println("negro");
        } else if(Color.white.getRed() == colorQuitar.getRed() && Color.white.getGreen() == colorQuitar.getGreen() && Color.white.getBlue() == colorQuitar.getBlue()){
            System.out.println("blanco");
        }
        for (int x = 0; x < ImagenFinal.getWidth(); x++) {
            for (int y = 0; y < ImagenFinal.getHeight(); y++) {
                getcolor(x, y);
                if (R == colorQuitar.getRed() && G == colorQuitar.getGreen() && B == colorQuitar.getBlue()) {
                    ImagenFinal.setRGB(x, y, 256 * 256 * 256 * 256);
                } else {
                    //ImagenFinal.setRGB(x, y, 256 * 16777216 - 16777216 + Integer.parseInt(Hex.substring(2, 8), 16));
                }
            }
        }
        repintar();
    }
    //--------------------------código funcional--------------------------------
    //--------------------------prueba------------------------------------------
//    private void getcolor(int x, int y) {
//        Hex = Integer.toHexString(ImagenFinal.getRGB(x, y));
//        while (Hex.length() < 8) {
//            Hex = "0" + Hex;
//        }
//        R = Integer.parseInt(Hex.substring(2, 4), 16);
//        G = Integer.parseInt(Hex.substring(4, 6), 16);
//        B = Integer.parseInt(Hex.substring(6, 8), 16);
//    }
//
//    private void quitarFondo(int PX, int PY) {
//        getcolor(PX, PY);
//        colorQuitar = new Color(R, G, B);
//        System.out.println("Rojo quitar: "+colorQuitar.getRed()+" Verde quitar: "+colorQuitar.getGreen()+" Azul quitar: "+colorQuitar.getBlue());
//        for (int x = PX; (x >= 0 && x < ImagenFinal.getWidth()); x--) {
//            for (int y = PY; (y >= 0 && y < ImagenFinal.getHeight()); y++) {
//                getcolor(x, y);
//                if (R == colorQuitar.getRed() && G == colorQuitar.getGreen() && B == colorQuitar.getBlue()) {
//                    ImagenFinal.setRGB(x, y, 256 * 256 * 256 * 256);
//                } else {
//                    break;
//                }
//            }
//            //-----------------------------------------segunda Y
//            for (int y = PY; y >= 0; y--) {
//                getcolor(x, y);
//                if (R == colorQuitar.getRed() && G == colorQuitar.getGreen() && B == colorQuitar.getBlue()) {
//                    ImagenFinal.setRGB(x, y, 256 * 256 * 256 * 256);
//                } else {
//                    break;
//                }
//            }
//            getcolor(x, PY);
//            if (R != colorQuitar.getRed() && G != colorQuitar.getGreen() && B != colorQuitar.getBlue()) {
//                break;
//            }
//        }
//        //-----x2
//        for (int x = PX; x < ImagenFinal.getWidth(); x++) {
//            for (int y = PY; (y >= 0 && y < ImagenFinal.getHeight()); y++) {
//                getcolor(x, y);
//                if (R == colorQuitar.getRed() && G == colorQuitar.getGreen() && B == colorQuitar.getBlue()) {
//                    ImagenFinal.setRGB(x, y, 256 * 256 * 256 * 256);
//                } else {
//                    break;
//                }
//            }
//            //-----------------------------------------segunda Y
//            for (int y = PY; y >= 0; y--) {
//                getcolor(x, y);
//                if (R == colorQuitar.getRed() && G == colorQuitar.getGreen() && B == colorQuitar.getBlue()) {
//                    ImagenFinal.setRGB(x, y, 256 * 256 * 256 * 256);
//                } else {
//                    break;
//                }
//            }
//            getcolor(x, PY);
//            if (R != colorQuitar.getRed() && G != colorQuitar.getGreen() && B != colorQuitar.getBlue()) {
//                break;
//            }
//        }
//        repintar();
//    }
    @Override
    public void mouseClicked(MouseEvent me) {
        quitarFondo(me.getX(), me.getY());
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }
}
