package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageWriter extends DestinationPath {
    
    private File fileDestinationPath;
    

    public ImageWriter(String destinationPath) {
        super(destinationPath);
        fileDestinationPath = new File(this.destinationPath);        
    }
    
    public void writeImage(BufferedImage image) {
        
        try {
            ImageIO.write(image, "png", fileDestinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFileDestinationPath() {
        return fileDestinationPath;
    }

    public void setFileDestinationPath(File fileDestinationPath) {
        this.fileDestinationPath = fileDestinationPath;
    }
    
    
}
