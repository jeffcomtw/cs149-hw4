
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.Timer;


public class BestFit {
	private int swapCount;
	private Timer timer;
	private process[] mem=new process[100];
	private block[] EmptyBlocks;
	private ArrayList<process> inMemory= new ArrayList<process>();
	private Queue<process> processes=new LinkedList<process>();
	private 	ActionListener actionListener;
	
        public BestFit(){	
		setSwapCount(0);
		for(int i=0;i<1000;i++){	
			processes.add(new process(" "+i));
		}	
		
		EmptyBlocks= block.getEmptyBlocks(mem);
	
	    
	
		actionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		       	
		    	 /* TRIGGER EVERY SECOND!!!!!!!!!!!!!!!!
		    	  * for every process P in memory, decrement its duration. 
		    	  * If duration reach 0, then replace P inside "process[] mem" with null.(Basically the process is done and memory space is freed)
		    	  * After that "EmptyBlocks= block.getEmptyBlocks(mem)" is called to recalculate array of empty block ( since removing process form memory destroy/create new empty block)
		    	  * THEN PRINT the  process[] mem :D 
		    	  * After the main forloop, fill() is called (it take a process in "Queue<process> processes" and try to fill it in memory ( process[] mem)
		    	  */
		    	  
		        for(process p:inMemory){  
		        	p.decrementTime();  	
		        	if(p.getTime()==0){
		        		for(int i=0;i<mem.length;i++){
			        		if(mem[i]!=null&&mem[i].equals(p)){mem[i]=null;};
			        	}
		        		EmptyBlocks= block.getEmptyBlocks(mem);
		        		Arrays.sort(EmptyBlocks, new BlockCompare());
                                        System.out.print("ENDED:          ");
		        		printing();
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
		//remove a process from "Queue<process> processes"
		process p=null;
		p=processes.remove();
		
		
		//compare the size of the process of each empty block in EmptyBlocks
		for(block b:EmptyBlocks){
			//if can fit....put it in (for loop below do the job)
			if(b.getSize()>=p.getSize()){
				swapCount++;
				for(int i=b.getBegin();i<b.getBegin()+p.getSize();i++){
					mem[i]=p;
				}
				//inMemory hold a process currently in process[] mem
				inMemory.add(p);
				//again fill a memory with process may create/destroy a empty block. This line must be called
				EmptyBlocks= block.getEmptyBlocks(mem);
				Arrays.sort(EmptyBlocks, new BlockCompare());
			    System.out.print("PROCESSED SWAPPED:  ");
			    printing();
			    
				accepted=true;
				break;
			}		
		}
	
	//if process is too big to fit. add it back to the end of queue
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
