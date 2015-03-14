import java.util.Random;


public class randRef {
	static int nextRef(int x){
		Random r = new Random();
		int num=r.nextInt(10);
		int delta=0;
		
		if(num<7&&(num==0||num>0)){
			int[] d={-1,0,1};
			int u=r.nextInt(3);
			delta=d[u];		
		}else if((num>7||num==7)&&(num<9||num==9)){
			int[] d={2,3,4,5,6,7,8};
			int u=r.nextInt(7);
			delta=d[u];	
		}
		
		int next=x+delta;	
		if(next>9){
			next=next-9;
		}
		
		if(next<0){
			next=0;
		}
		return next;		
	}
}
