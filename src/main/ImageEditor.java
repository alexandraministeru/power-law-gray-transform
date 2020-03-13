package main;

import java.awt.image.BufferedImage;

public class ImageEditor {
    private BufferedImage image;
    private double gamma;

    public ImageEditor(BufferedImage image, double gamma) {
        this.image = image;
        this.gamma = gamma;
    }
    
    public void powelLawGrayLevelTransform() {
        int width = image.getWidth();
        int height = image.getHeight();
                
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                
                //extragere caracteristici pixel
                int p = image.getRGB(j, i);
                
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                
                //trecere imagine in Grayscale
                int avg = (r + b + g) / 3;                       
                
                //transformare Power-Law : r = c*p^gamma
                int color = (int) (255*(Math.pow((double)avg/(double)255, gamma)));
                
                //refacere pixel 
                p = (a<<24) | (color<<16) | (color<<8) | color;
                
                //setare pixel rezultat
                image.setRGB(j, i, p);
            }
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public double getGamma() {
        return gamma;
    }

    public void setGamma(double gamma) {
        this.gamma = gamma;
    }    
    
}
