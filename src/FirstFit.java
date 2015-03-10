import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.Timer;


public class FirstFit {
	private int swapCount;
	private Timer timer;
	private process[] mem=new process[100];
	private block[] EmptyBlocks;
	private ArrayList<process> inMemory= new ArrayList<process>();
	private Queue<process> processes=new LinkedList<process>();
	private 	ActionListener actionListener;
	
        public FirstFit(){	
		setSwapCount(0);
		for(int i=0;i<1000;i++){	
			processes.add(new process(" "+i));
		}	
		
		EmptyBlocks= block.getEmptyBlocks(mem);
	
	    
	
		actionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		       		
		        for(process p:inMemory){  
		        	p.decrementTime();  	
		        	if(p.getTime()==0){
		        		for(int i = 0; i < mem.length; i++){
			        		if(mem[i] != null && mem[i].equals(p))
                                                {   mem[i] = null; }
			        	}
		        		EmptyBlocks= block.getEmptyBlocks(mem);
                                        System.out.print("SWAPPED:          ");
		        		printing();
		        	}
		        }
		        
		        fill();
                        System.out.print("PROCESSED ENDED:  ");
		        printing();
		      }
		    };
		
		    timer = new Timer(1000, actionListener);
		    
	}
	
	public int start(){
		timer.start();
		
		long start = System.currentTimeMillis();
		long end = start + 60*1000;
		while (System.currentTimeMillis() < end){}
		timer.stop();
		return getSwapCount();
	}
	
	
	
	public void fill(){
		boolean accepted=false;
		process p=null;
		p=processes.remove();
		for(block b:EmptyBlocks){
			
			if(b.getSize()>=p.getSize()){
				swapCount++;
				for(int i = b.getBegin(); i < b.getBegin()+ p.getSize(); i++){
					mem[i]=p;
				}
				inMemory.add(p);
				EmptyBlocks= block.getEmptyBlocks(mem);
				accepted=true;
				break;
			}		
		}
		
	if(!accepted)
		processes.add(p);	
	}
	
	
	public void printing(){
		
			for(int i=0;i<mem.length;i++){
        		if(mem[i]==null){
        			System.out.print(".");
        		}else{
        			System.out.print(mem[i].getName());
        		}
        	}	
		
			System.out.println();
	}

	public int getSwapCount() {
		return swapCount;
	}

	public void setSwapCount(int swapCount) {
		this.swapCount = swapCount;
	}
}
