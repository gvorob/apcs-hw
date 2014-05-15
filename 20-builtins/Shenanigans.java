import java.util.*;
	
public class Shenanigans{
	static long time;
	
	public static void main(String[] args){
		TreeMap<Long,Long> tm = new TreeMap<Long,Long>();
		TreeSet<Long> ts = new TreeSet<Long>();
		HashMap<Long,Long> hm = new HashMap<Long,Long>();
		HashSet<Long> hs = new HashSet<Long>();
		Random r = new Random();

		startTime();
		for(int i = 0; i < 1000000;i++){
			tm.put(new Long(i),null);
		}
		endTime();
		startTime();
		for(int i = 0; i < 1000000;i++){
			hm.put(new Long(i),null);
		}
		endTime();
		startTime();
		for(int i = 0; i < 1000000;i++){
			tm.get(new Long(i));
		}
		endTime();
		startTime();
		for(int i = 0; i < 1000000;i++){
			hm.get(new Long(i));
		}
		endTime();
	}

	static void startTime(){
		time = System.currentTimeMillis();
	}
	
	static void endTime(){
		System.out.println(System.currentTimeMillis() - time);
	}
}
