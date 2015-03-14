import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class RAND {
	private ArrayList<ref> referencedPage=new ArrayList<ref>();
	private Queue<ref> pages=new LinkedList<ref>();
	private int hitRatio;
	private int hits;
	
	public RAND(){
		hitRatio=0;
		hits=0;
	}
	
	public void start(){
		ref e=null;
		Random x=new Random();
		int r=x.nextInt(10);
		
		for(int i=0;i<100;i++){		
			int ref=randRef.nextRef(r);	
			ref reference=new ref(ref);
			
			System.out.print(reference.getRefNum()+" : ");
			
			if(pages.contains(reference)){
				hits++;
				printPage();
				System.out.println();
				continue;
			}
			
			if(pages.size()<4){
				pages.add( reference);
				printPage();
				System.out.println();
			}else if(pages.size()==4){
				e=evict();
				pages.add( reference);
				printPage();
				System.out.println("  Evicted "+ e.getRefNum() + " Paged "+ reference.getRefNum());	
			}
	
			
		}	
		
	}
	
	
	
	public ref evict(){
		Random rr = new Random();	
		int num =rr.nextInt(4)+1;
		ref x=null;
		Iterator<ref> i= pages.iterator();
		
		for(int h=0;h<num;h++){
			x=i.next();
		}
		//System.out.println(x);
		pages.remove(x);
		return x;
		
	}
	
	public void printPage(){
		for(ref p:pages){
			System.out.print(p.getRefNum()+" ");	
		}
		//System.out.println();
	}
	


	public double getHitRatio() {
		return (double) hits/100;
	}

	

}
