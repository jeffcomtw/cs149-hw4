import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class LFU {
	private ArrayList<ref> referencedPage=new ArrayList<ref>();
	private Queue<ref> pages=new LinkedList<ref>();
	private int hitRatio;
	private int hits;
	
	public LFU(){
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
				f.incUses();
				printPage();
				System.out.println();
				continue;
			}
			
			if(pages.size()<4){
				reference.incUses();
				pages.add(reference);
				printPage();
				System.out.println();
			}else if(pages.size()==4){								
				e=evict();
				reference.incUses();
				pages.add( reference);	
				printPage();
				System.out.println("  Evicted "+ e.getRefNum() + " Paged "+ reference.getRefNum());	
			}
			
		}	
		
	}
	
	
	
	public ref evict(){
		Iterator<ref> i= pages.iterator();
		ref smallest=i.next();
		
		while(i.hasNext()){
			ref t=i.next();
			if(t.getUses()<smallest.getUses()){
				smallest=t;
			}
		}
	
		pages.remove(smallest);
		return smallest;
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