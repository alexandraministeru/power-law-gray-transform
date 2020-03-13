package main;

import java.io.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;


public class Main {

    public static void main(String[] args) {
        
        BufferedImage img = null;
        String sourcePic;
        
        //default output file
        String destinationPic = "Output.png";
        double gamma = 1.8;
        
        TimeCounter timeCounter = new TimeCounter();
        long elapsedTimeRead;
        long elapsedTimeProcessing;
        long elapsedTimeWrite;         
                
        timeCounter.start();
        
        try (
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader cons = new BufferedReader(isr);) {                                   
            
            System.out.print("Sursa: ");
            sourcePic = cons.readLine();
            ImageReader imageReader = new ImageReader(sourcePic);
            img = imageReader.readImage();            
            
            System.out.print("Destinatie: ");
            destinationPic = cons.readLine();            
            
            System.out.print("Gamma: ");
            gamma = Double.parseDouble(cons.readLine());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        timeCounter.stop();
        elapsedTimeRead = timeCounter.getElapsedTime();                    
      
          
        timeCounter.start();       
        
        ImageEditor imageEditor = new ImageEditor(img, gamma);
        imageEditor.powelLawGrayLevelTransform();
        
        timeCounter.stop();
        elapsedTimeProcessing = timeCounter.getElapsedTime();        
        
        timeCounter.start();
                    
        ImageWriter imageWriter = new ImageWriter(destinationPic);
        imageWriter.writeImage(img);
        
        timeCounter.stop();
        elapsedTimeWrite = timeCounter.getElapsedTime();
        
        //Timpi executie:
        System.out.println("Timp executie etapa citire informatii:");
        System.out.println(timeCounter.toString(elapsedTimeRead));
        
        System.out.println("Timp executie etapa procesare imagine:");
        System.out.println(timeCounter.toString(elapsedTimeProcessing));
        
        System.out.println("Timp executie etapa scriere in fisierul destinatie:");
        System.out.println(timeCounter.toString(elapsedTimeWrite));
        
        System.out.println("Timp executie citire si scriere:");
        System.out.println(timeCounter.toString(addPeriodsOfTime(elapsedTimeRead, elapsedTimeWrite)));
        
        System.out.println("Timp executie total:");
        System.out.println(timeCounter.toString(addPeriodsOfTime(elapsedTimeRead, elapsedTimeProcessing, elapsedTimeWrite)));
        
    }  

    //permite introducerea oricator perioade de timp pentru a fi adunate
    public static long addPeriodsOfTime(long ...a) {
        long sum = 0;
        for (long i : a) {
            sum += i;
        }
        
        return sum;
    }
    
}

