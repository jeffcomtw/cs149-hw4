import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class LRU {

	private Queue<ref> pages=new LinkedList<ref>();
	private int hitRatio;
	private int hits;
	
	public LRU(){
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
				ref f=find(reference);
				f.resetAge();
				printPage();
				System.out.println();
				continue;
			}
			
			if(pages.size()<4){
				pages.add(reference);
				printPage();
				System.out.println();
			}else if(pages.size()==4){				
				e=evict();
				pages.add( reference);	
				printPage();
				System.out.println("  Evicted "+ e.getRefNum() + " Paged "+ reference.getRefNum());	
			}
				
			for(ref a:pages){
				a.incAge();
			}
		}	
		
	}
	
	
	
	public ref evict(){
		Iterator<ref> i= pages.iterator();
		ref highest=i.next();
		
		while(i.hasNext()){
			ref t=i.next();
			if(t.getAge()>highest.getAge()){
				highest=t;
			}
		}
	
		pages.remove(highest);
		return highest;
	}
	
	public ref find(ref f){
		for(ref p:pages){
			if(p.equals(f)){
				return p;
			}
		}
		return null;
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
