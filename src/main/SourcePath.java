package main;

public class SourcePath extends Path {
    
    protected String sourcePath;

    public SourcePath(String sourcePath) {
        this.sourcePath = "resources\\inputs\\" + sourcePath; 
    }    
    
    @Override
    public String createPath(String source) {
        return "resources\\inputs\\" + source;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }  
}
