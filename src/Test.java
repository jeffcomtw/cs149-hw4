import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.Timer;


public class Test 
{
	public static void main(String args[])
        {
            
        System.out.println("------------------------ FIRST FIT ALGORITHM --------------------------");
	int FFcount=0;	
	for(int i=0;i<5;i++){	
                        System.out.println("\nALGORITHM RUN #" + (i+1));
			FirstFit FF=new FirstFit();	
			FFcount=FFcount+FF.start(); 
	}
	FFcount=FFcount/5;
	System.out.println("Avg Swapped in for FirstFit: " + FFcount);
	System.out.println("------------------------ END FIRST FIT ALGORITHM --------------------------");
            
	
        System.out.println("\n------------------------ NEXT FIT ALGORITHM --------------------------");
	int NFcount=0;	
	for(int i=0;i<5;i++){	
                        System.out.println("\nALGORITHM RUN #" + (i+1));
			NextFit NF=new NextFit();	
			NFcount=NFcount+NF.start(); 
	}
	NFcount=NFcount/5;
	System.out.println("Avg Swapped in for NextFit: " + NFcount);
	System.out.println("------------------------ END NEXT FIT ALGORITHM --------------------------");
            
            
        System.out.println("\n------------------------ BEST FIT ALGORITHM --------------------------");
	int BFcount=0;	
	for(int i=0;i<5;i++){	
                        System.out.println("\nALGORITHM RUN #" + (i+1));
			BestFit BF=new BestFit();	
			BFcount=BFcount+BF.start(); 
	}
	BFcount=BFcount/5;
	System.out.println("Avg Swapped in for BestFit: " + BFcount);
	System.out.println("------------------------ END BEST FIT ALGORITHM --------------------------");
        
            
        System.out.println("\n------------------------ WORST FIT ALGORITHM --------------------------");
	int WFcount=0;	
	for(int i=0;i<5;i++){	
                        System.out.println("\nALGORITHM RUN #" + (i+1));
			WorstFit WF=new WorstFit();	
			WFcount=WFcount+WF.start(); 
	}
	WFcount=WFcount/5;
	System.out.println("Avg Swapped in for WorstFit: " + WFcount);
	System.out.println("------------------------ END WORST FIT ALGORITHM --------------------------");
    }
}

