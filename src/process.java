import java.util.Random;


public class process {
	private int size;
	private int time;
	private String name;
	
	public process(String name){
		
		int[] b={5, 11, 17, 31};
		Random r = new Random();
		
		time=r.nextInt(4) + 1;
		size=b[r.nextInt(3)];
		this.name=name;
	}
	

	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean equals(Object x){
		process p=( process )x;
		return this.getName().equals(p.getName());		
	}
	
	public void decrementTime(){	
		time--;
	}

}
