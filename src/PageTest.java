import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class PageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
//		Set<ref> x= new HashSet<ref>();
//		ref a=new ref(0);
//		ref b=new ref(1);
//		ref c=new ref(2);
//		ref d=new ref(3);
//		x.add(a);
//		x.add(b);
//		x.add(c);
//		x.add(d);
//	
//		b.incAge();
//		x.add(new ref(1));
//		b.setReferenced(true);
//		
//		for(ref g:x){
//			println(""+g);
//		}
//		ref cc=new ref(0);
//		
//		println(""+x.contains(cc));
//------------------------------------------------------------------------------------------
		
		FIFO fifo=new FIFO();
		fifo.start();
		System.out.println("HitRatio:"+fifo.getHitRatio());
		
		LFU lfu=new LFU ();
		lfu.start();
		System.out.println("HitRatio:"+lfu.getHitRatio());
		
		MFU mfu=new MFU ();
		mfu.start();
		System.out.println("HitRatio:"+mfu.getHitRatio());	
		
		LRU lru=new LRU ();
		lru.start();
		System.out.println("HitRatio:"+lru.getHitRatio());
		
		RAND rand=new RAND ();
		rand.start();
		System.out.println("HitRatio:"+rand.getHitRatio());	
		
	}


	
}
