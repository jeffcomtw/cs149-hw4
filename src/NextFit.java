import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

import javax.swing.Timer;

public class NextFit {
	private int swapCount;
	private Timer timer;
	private process[] mem=new process[100];
	private block[] EmptyBlocks;
	private ArrayList<process> inMemory= new ArrayList<process>();
	private Queue<process> processes=new LinkedList<process>();
	private int leftoff=0;
	private int previousEmptySize=0;
        private int cycle = 1;
	
	public NextFit(){	
		setSwapCount(0);
		for(int i=0;i<1000;i++){	
			processes.add(new process(" "+i));
		}	
		
		EmptyBlocks= block.getEmptyBlocks(mem);
	
	    
	
	ActionListener actionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {

		        for(process p:inMemory){  
		        	p.decrementTime();  	
		        	if(p.getTime()==0){
		        		for(int i=0;i<mem.length;i++){
			        		if(mem[i]!=null&&mem[i].equals(p)){mem[i]=null;};
			        	}
		        		EmptyBlocks= block.getEmptyBlocks(mem);
                                        System.out.print("ENDED:          ");
                                        printing();
		        		if(previousEmptySize<EmptyBlocks.length){
		        			leftoff++;
		        		}
		        		previousEmptySize=EmptyBlocks.length;
		        		
		        		if(leftoff==EmptyBlocks.length){
					    	leftoff=0;
					    }
                                        
		        		
		        	}
		        } 
		        
      
		        fill();
             
   
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
		
		
	    for(int c=leftoff;c<EmptyBlocks.length;c++){
	    	
	    	if(c==EmptyBlocks.length-1){
	    		if(EmptyBlocks[c].getSize()>=p.getSize()){
	    			swapCount++;
					leftoff=c;
					for(int i=EmptyBlocks[c].getBegin();i<EmptyBlocks[c].getBegin()+p.getSize();i++){
						mem[i]=p;
					}
					inMemory.add(p);
					EmptyBlocks= block.getEmptyBlocks(mem);
			        System.out.print("PROCESS SWAPPED:    ");
				    printing();
				
					accepted=true;
					
					break;
	    		}else{
	    			leftoff=0;
	    			break;
	    		}
	    	}
	    	
			if(EmptyBlocks[c].getSize()>=p.getSize()){
				swapCount++;
				leftoff=c;
				for(int i=EmptyBlocks[c].getBegin();i<EmptyBlocks[c].getBegin()+p.getSize();i++){
					mem[i]=p;
				}
				inMemory.add(p);
				EmptyBlocks= block.getEmptyBlocks(mem);
		        System.out.print("PROCESS SWAPPED:    ");
			    printing();
				

				accepted=true;
				break;
			}		
		}
	 
	    
	if(!accepted)
		processes.add(p);	
	}
	
	
	public void printing(){
		      // System.out.print("Cycle # " +  cycle + ": ");
			for(int i=0;i<mem.length;i++){
        		if(mem[i]==null){
        			System.out.print(".");
        		}else{
        			System.out.print(mem[i].getName());
        		}
        	}	
		
                       // cycle++;
			System.out.println();
	}

	public int getSwapCount() {
		return swapCount;
	}

	public void setSwapCount(int swapCount) {
		this.swapCount = swapCount;
	}
}