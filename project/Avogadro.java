package project;

import java.util.Scanner;

public class Avogadro{
	public static void main(String[] args){
		
		double nD=0;
        double sD=0;


        Scanner input = new Scanner(System.in);
        
        while (input.hasNextDouble()) {
            sD+=Math.pow(input.nextDouble(),2);
            nD++;
        }

        input.close();
        



        double D= (sD/(2*nD))*Math.pow(0.175E-6, 2);
        double T = 297;
        double viskozite = 9.135E-4;
        double Rbead= 0.5E-6;
        double boltzman=(D*6*viskozite*Rbead*3.1415)/T;
        double R = 8.31446;
        double avo = R/boltzman;

        
        System.out.println("boltzman =  "+String.format("%.4e", boltzman));
        System.out.println("avogadro =  "+String.format("%.4e", avo));
        
        



    }
}
