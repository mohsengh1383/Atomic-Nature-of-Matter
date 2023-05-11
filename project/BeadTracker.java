package project;

public class BeadTracker {
    
    private BeadTracker(){
        
    }



    public static void main(String[] args) {

        int minSize = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        double mindistance = Double.parseDouble(args[2]);







        //for test of recursive 
        Picture picFirst = new Picture(args[3]);
        BeadFinder beadFinderFirst= new BeadFinder(picFirst, tau);
        Blob[] newbBlobs =  beadFinderFirst.getbeads(minSize);


        //call recursive
        ExtractDistances(newbBlobs, minSize, tau, mindistance, args, 4);




    }


    //method recursive for getting blobs******************************

    private static void ExtractDistances(Blob[] firstBlobs  , int minsize,double tua , double mindistance , String[] args,int i){
        
        if (args.length==i) {
            return;
        }

        Picture pic  = new Picture(args[i]);
        BeadFinder BF = new BeadFinder(pic, tua);
        Blob[] newblobs = BF.getbeads(minsize);

        distancePrinter(firstBlobs, newblobs, mindistance);



        ExtractDistances(newblobs, minsize, tua, mindistance, args, i+1);
        
        
    }


    


    private static void distancePrinter(Blob[] firstBlobs , Blob[] secondBlobs,double minPixels) {


        


        for (Blob blob1 : firstBlobs) {

            double mindistance=Integer.MAX_VALUE;

            for (Blob blob2 : secondBlobs) {

                double distance =blob1.distanceTo(blob2) ;
                
                if (distance<minPixels  &&  distance<mindistance) {
                    mindistance=distance;
                }

            }

            if (mindistance!=Integer.MAX_VALUE) {
                System.out.println(Math.round(mindistance*10000)/10000.0);
            }
            
        }


    }


    


}
