

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BildGenerator {

    BasicStroke THICK = new BasicStroke(5f);
    BasicStroke THIN = new BasicStroke(2f);

    public String getPath_bild() {
        return path_bild;
    }

    private String path_bild = "./bild_gen.png";
    private static Font font_small = new Font("Arial", Font.PLAIN, 30);
    private static Font font_big = new Font("Arial", Font.PLAIN, 50);

    public BildGenerator(Router router) throws IOException {

        int fakt = 2;
        int width = fakt * 539;
        int height = fakt * 119;

        // Constructs a BufferedImage of one of the predefined image types.
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Create a graphics which can be used to draw into the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setStroke(THICK);
        // fill all the image with white
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);

        // create Main Rectangle Box
        g2d.setColor(Color.black);
        g2d.fillRect(fakt * 2, fakt * 2, fakt * 535, fakt * 115);
        g2d.setColor(Color.white);
        g2d.fillRect(fakt * 20, fakt * 4, fakt * 530, fakt * 110);

        // create 2 small left Rectangle Box
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(fakt * 2));
        g2d.drawRect(fakt * 19, fakt * 60, fakt * 30, fakt * 55);
        g2d.drawRect(fakt * 19, fakt * 4, fakt * 30, fakt * 55);

        // create 3 middle left Rectangle Box
        g2d.drawRect(fakt * 49, fakt * 4, fakt * 20, fakt * 90);
        g2d.drawRect(fakt * 69, fakt * 4, fakt * 20, fakt * 90);
        g2d.drawRect(fakt * 49, fakt * 94, fakt * 40, fakt * 20);


        // create 4 big left Rectangle Box
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(fakt * 89, fakt * 4, fakt * 2 * 223, fakt * 27);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(fakt * 89, fakt * 4, fakt * 223, fakt * 27);


        g2d.drawRect(fakt * 89, fakt * 31, fakt * 223, fakt * 28);
        g2d.drawRect(fakt * 89, fakt * 59, fakt * 223, fakt * 27);
        g2d.drawRect(fakt * 89, fakt * 86, fakt * 223, fakt * 28);

        // create 4 big right Rectangle Box
        g2d.drawRect(fakt * 312, fakt * 4, fakt * 223, fakt * 27);
        g2d.drawRect(fakt * 312, fakt * 31, fakt * 223, fakt * 28);
        g2d.drawRect(fakt * 312, fakt * 59, fakt * 223, fakt * 27);
        g2d.drawRect(fakt * 312, fakt * 86, fakt * 223, fakt * 28);

        g2d.setFont(new Font("Arial", Font.PLAIN, 20));

        //Texte befüllen
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(270), 0, 0);
        g2d.setTransform(affineTransform);

        g2d.setColor(Color.WHITE);

        g2d.drawString(router.getBezeichnung(), fakt * -110, fakt * 15);


        g2d.setColor(Color.BLACK);

        g2d.drawString("Power", fakt * -50, fakt * 35);
        g2d.drawString("Unit", fakt * -50, fakt * 45);

        g2d.drawString("Power", fakt * -110, fakt * 35);
        g2d.drawString("Unit", fakt * -110, fakt * 45);

        g2d.setColor(Color.BLUE);

        g2d.drawString("xxx79xxxx", fakt * -80, fakt * 65);

        affineTransform.rotate(Math.toRadians(-270), 0, 0);
        g2d.setTransform(affineTransform);

        g2d.setColor(Color.BLACK);
        g2d.drawString("FAN", fakt * 57, fakt * 110);

        g2d.setFont(new Font("Arial", Font.PLAIN, 30));

        g2d.drawString("CXP Controller", fakt * 155, fakt * 24);
        g2d.drawString("CXP Controller", fakt * 155 + fakt * 223, fakt * 24);
        // Disposes of this graphics context and releases any system resources that it is using.

        slots_befüllen(router.getKarten(), g2d, fakt);

        g2d.dispose();

        // Save as PNG
        File file = new File(path_bild);
        ImageIO.write(bufferedImage, "png", file);

    }


    private void slots_befüllen(ArrayList<Karte> kartes, Graphics2D g2d, int fakt) {


        for (Karte karte : kartes) {
            if (karte.getBezeichnung() == null) {
                g2d.setFont(new Font("Arial", Font.PLAIN, 30));
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.drawString("SLOT" + karte.getSlot(),
                        getSlot_x(karte.getSlot(), fakt), getSlot_y(karte.getSlot(), fakt));
            } else {
                g2d.setFont(new Font("Arial", Font.PLAIN, 20));
                g2d.setColor(Color.BLACK);
                g2d.drawString(karte.getBezeichnung(),
                        getSlot_x(karte.getSlot(), fakt), getSlot_y(karte.getSlot(), fakt));
            }


        }

    }

    private int getSlot_x(int slot, int fakt) {
        int x_ret = 0;
        switch (slot) {
            case 1:
            case 5:
            case 3:
                x_ret = fakt * 110;
                break;
            case 2:
            case 4:
            case 6:
                x_ret = fakt * 110 + fakt * 223;
                break;
            default:
        }
        return x_ret;
    }

    private int getSlot_y(int slot, int fakt) {
        int y_ret = 0;
        switch (slot) {
            case 1:
            case 2:
                y_ret = fakt * 110;
                break;
            case 3:
            case 4:
                y_ret = fakt * 80;
                break;
            case 5:
            case 6:
                y_ret = fakt * 50;
                break;
            default:
        }
        return y_ret;
    }

}