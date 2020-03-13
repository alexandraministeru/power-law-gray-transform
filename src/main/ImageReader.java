package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageReader extends SourcePath {
    
    private File fileSourcePath;
    private BufferedImage image;

    public ImageReader(String sourcePath) {
        super(sourcePath); //concatenat
        fileSourcePath = new File(this.sourcePath);        
    }
    
    public BufferedImage readImage() {
        try {
            
            image = ImageIO.read(fileSourcePath);
            return image;
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public File getFileSourcePath() {
        return fileSourcePath;
    }

    public void setFileSourcePath(File fileSourcePath) {
        this.fileSourcePath = fileSourcePath;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    
}
