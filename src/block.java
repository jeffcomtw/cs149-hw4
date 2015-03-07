import java.util.ArrayList;


public class block {
	
	private int begin;
	private int end;
	private int size;
	
	public block (int begin, int end){
		this.setBegin(begin);
		this.setEnd(end);
		setSize(end-begin+1);
	}
	

	public int getBegin() {
		return begin;
	}


	public void setBegin(int begin) {
		this.begin = begin;
	}


	public int getEnd() {
		return end;
	}


	public void setEnd(int end) {
		this.end = end;
	}
	
	
	public static block[] getEmptyBlocks(Object[] a){	
		ArrayList<block> bk= new ArrayList<block>();
		
		int b=0;
		int e=0;
		
		while(true){
			if(b==a.length){
				break;
			}
	
			if(a[b]==null){
				e=b;	
				if(e==a.length-1&&a[e]==null){
					bk.add(new block(b,e));
					break;
				}		
				while(true){	
					e++;
					if(e==a.length-1&&a[e]==null){
						bk.add(new block(b,e));
						b=e+1;
						break;
					}
					if(a[e]!=null){
						bk.add(new block(b,e-1));
						b=e;
						break;
					}
				}	
			}else{
				b++;
			}
		}
		
		block[] array= bk.toArray(new block[bk.size()]);
		
		return array;
	
	}
	
	
	public String toString(){
		return begin+" "+ end;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	

}
