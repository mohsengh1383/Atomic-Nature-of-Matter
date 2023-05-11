package project;

import java.lang.Math;
public class Blob {
    
    //variable center of Blob
    private double centerx;
    private double centery;



    //size of Blob
    private int size;


    //constractor
    public Blob() {
        size=0;
        centerx=0.5;
        centery=0.5;

    }
    


    public int mass() {
    
        return size;
        
    }



    public void add(int x, int y) {
        centerx = ((centerx * size)+x)/(size+1);
        centery = ((centery * size)+y)/(++size);
    }

  

    public double distanceTo(Blob blob) {
        
        return Math.sqrt(Math.pow(centery-blob.centery, 2)+Math.pow(centerx-blob.centerx, 2));

    }


    public String toString() {

        return String.format("%2d (%8.4f, %8.4f)", size , centery, centerx);
    }




}

