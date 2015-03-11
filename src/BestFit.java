
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Busairo
 */
public class BestFit {
        private int swapCount;
	private Timer timer;
	private process[] mem=new process[100];
	private block[] EmptyBlocks;
	private ArrayList<process> inMemory= new ArrayList<process>();
	private Queue<process> processes=new LinkedList<process>();
	private int leftoff=0;
	private int previousEmptySize=0;
        private int cycle = 1;
	
	public BestFit(){	
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
                                        System.out.print("SWAPPED:          ");
                                        printing();
		        		if(previousEmptySize<EmptyBlocks.length){
		        			leftoff++;
		        		}
		        		previousEmptySize=EmptyBlocks.length;
                                        
                                        //sort
                                        Arrays.sort(EmptyBlocks, new BlockCompare());
		        		
		        		if(leftoff==EmptyBlocks.length){
					    	leftoff=0;
					    }
                                        
		        		
		        	}
		        } 
		        
      
		        fill();
                        System.out.print("PROCESS ENDED:    ");
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
	    for(int c=leftoff;c<EmptyBlocks.length;c++){	
			if(EmptyBlocks[c].getSize()>=p.getSize()){
				swapCount++;
				leftoff=c;
				for(int i=EmptyBlocks[c].getBegin();i<EmptyBlocks[c].getBegin()+p.getSize();i++){
					mem[i]=p;
				}
				inMemory.add(p);
				EmptyBlocks= block.getEmptyBlocks(mem);
                                
                                //sort
				Arrays.sort(EmptyBlocks, new BlockCompare());

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
