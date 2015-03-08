import java.util.Comparator;
	//this class allow you to sort array of process base on arrival time
	public class BlockCompare implements Comparator<block>{

		@Override
		public int compare(block o1, block o2) {
			
			if(o1.getSize()<o2.getSize()){
				return -1;
			}
			
			if(o1.getSize()>o2.getSize()){
				return 1;
			}	
			
			return 0;
		}
		
	  }