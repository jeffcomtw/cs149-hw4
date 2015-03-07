import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.Timer;


public class FirstFit {
	
	private Timer timer;
	private process[] mem=new process[100];
	private block[] EmptyBlocks;
	private ArrayList<process> inMemory= new ArrayList<process>();
	private Queue<process> processes=new LinkedList<process>();
	
	
	public FirstFit(){		
		for(int i=0;i<100;i++){	
			processes.add(new process(" "+i));
		}	
		
		EmptyBlocks= block.getEmptyBlocks(mem);
	
	    
	
	ActionListener actionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        System.out.println();
		       
		
		        for(process p:inMemory){  
		        	p.decrementTime();  	
		        	if(p.getTime()==0){
		        		for(int i=0;i<mem.length;i++){
			        		if(mem[i]!=null&&mem[i].equals(p)){mem[i]=null;};
			        	}
		        		EmptyBlocks= block.getEmptyBlocks(mem);
		        		printing();
		        	}
		        }
		        
		        fill();
		        printing();
		      }
		    };
		
		    timer = new Timer(1000, actionListener);
	}
	
	public void start(){
		timer.start();
		
		long start = System.currentTimeMillis();
		long end = start + 60*1000;
		while (System.currentTimeMillis() < end){}
	}
	
	
	
	public void fill(){
		boolean accepted=false;
		process p=processes.remove();
		for(block b:EmptyBlocks){
			
			if(b.getSize()>=p.getSize()){
				for(int i=b.getBegin();i<b.getBegin()+p.getSize();i++){
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
	

	
}
