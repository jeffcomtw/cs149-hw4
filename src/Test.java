import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.Timer;


public class Test {
	public static void main(String args[]){
		
//		ArrayList<Integer> x =new ArrayList<Integer>();
//		
//		x.add(45);
//		x.add(85);
//		x.add(2);
//		x.add(3);
//		x.add(47);
//		x.add(77);
//		
//		
//		ListIterator<Integer> i =x.listIterator();
//		i.next();
//		i.add(333);
//		i.add(334);
//
//		System.out.println(i.next()+"dffffffffffffffffffff");
//		
//		for(int n:x){
//			System.out.println(n);
//		}
		
//	int  FFcount=0;	
//	for(int i=0;i<5;i++){	
//		  FirstFit FF=new FirstFit();
//		  FFcount=FFcount+FF.start(); 
//	}
//	FFcount=FFcount/5;
//	System.out.println("Avg Swapped in for FirstFit:" + FFcount);
            
        System.out.println("------------------------ FIRST FIT ALGORITHM --------------------------");
	int FFcount=0;	
	for(int i=0;i<5;i++){	
                        System.out.println("\nALGORITHM RUN #" + (i+1));
			FirstFit FF=new FirstFit();	
			FFcount=FFcount+FF.start(); 
	}
	FFcount=FFcount/5;
	System.out.println("Avg Swapped in for FirstFit:" + FFcount);
	System.out.println("------------------------ END First FIT ALGORITHM --------------------------");
	
        System.out.println("\n------------------------ NEXT FIT ALGORITHM --------------------------");
	int NFcount=0;	
	for(int i=0;i<5;i++){	
                        System.out.println("\nALGORITHM RUN #" + (i+1));
			NextFit NF=new NextFit();	
			NFcount=NFcount+NF.start(); 
	}
	NFcount=NFcount/5;
	System.out.println("Avg Swapped in for NextFit:" + NFcount);
	System.out.println("------------------------ END NEXT FIT ALGORITHM --------------------------");
	
	}
}
