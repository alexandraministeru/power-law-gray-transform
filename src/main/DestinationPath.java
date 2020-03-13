package main;

public class DestinationPath extends Path{
    
    protected String destinationPath;

    public DestinationPath(String destinationPath) {        
        this.destinationPath = "resources\\outputs\\" + destinationPath;
    }       
    
    @Override
    public String createPath(String source) {
        return "resources\\outputs\\" + source;
    }

    public String getDestinationPath() {
        return destinationPath;
    }

    public void setDestinationPath(String destinationPath) {
        this.destinationPath = destinationPath;
    }    
    
}
