package project;

import java.util.ArrayList;
import java.awt.Color;



public class BeadFinder {

    private int width=0;
    private int height=0;
    private ArrayList<Blob> blobs;
    private double tau;
    private Picture pic;
    private boolean[][] visited;



    public BeadFinder(Picture picture, double tauu){

        pic=picture;
        tau=tauu;
        width=picture.width();
        height=picture.height();
        blobs = new ArrayList<Blob>();
        visited= new boolean[width][height];
        findBlobs();

    }




    public static void main(String[] args) {
        
        BeadFinder beadFinder = new BeadFinder(new Picture(args[2]),Double.parseDouble(args[1]) );
        Blob[] beads= beadFinder.getbeads(Integer.parseInt(args[0]));
        

        for (int i = 0; i < beads.length; i++) {
            
            System.out.println(beads[i]);
        }
        
        
    }

    


    private void findBlobs(){
        
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                
                if ( !visited[col][row] && isBrilliant(col, row)) {
                    Blob blob = new Blob();
                    blobCompleterwithPicture(  blob, row, col);
                    blobs.add(blob);
                }  
            }
        }

        
    }





    private void blobCompleterwithPicture(Blob blob, int row,int col){
        //first i use pic.set(col, row, new Color(0, 0, 0));
        
        blob.add(row, col);

        
        if (row+1 < height &&!visited[col][row+1]&&  isBrilliant(col, row+1)){ 
            blobCompleterwithPicture(blob, row+1, col);
        }
        
        if (col-1>0&& !visited[col-1][row]&& isBrilliant(col-1, row)){
            blobCompleterwithPicture(blob, row, col-1);
        }


        if (row-1>0 && !visited[col][row-1]&&  isBrilliant(col, row-1)) {
            blobCompleterwithPicture(blob, row-1, col);
        }


        if (col+1<width && !visited[col+1][row]&& isBrilliant(col+1, row)){ 
            blobCompleterwithPicture(blob, row, col+1);
        }
    
        

        

    }





    private boolean isBrilliant(int col,int row){

        visited[col][row]=true;
        Color color = pic.get(col, row);
        int minOfrgb= Math.min(color.getRed(),Math.min(color.getGreen(),color.getBlue()));
        
        if (minOfrgb>=tau) {
            return true;
        } else {
            return false;
        }
    }






    public Blob[] getbeads(int min) {


        //Blob[] niceblob = new Blob[blobs.size()];
        // int j=0;
        // for (int i = 0; i < blobs.size(); i++) {
        //     if (blobs.get(i).mass()>=min) {
        //         niceblob[j]=blobs.get(i);
        //         j++;
        //     }
        // }



        //blobs.removeIf(blob -> blob.mass()<min); 
        
        for (int i = 0; i < blobs.size(); i++) {
            if (blobs.get(i).mass()<min) {
                blobs.remove(i);
                i--;
            }
        }

        return blobs.toArray(new Blob[blobs.size()]);

    }


}
