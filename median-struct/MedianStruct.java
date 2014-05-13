public class MedianStruct{

	private Heap bot, top;
	private int bots, tops;//bot size, top size

	public MedianStruct(){
		bots = tops = 0;
		bot = new Heap(true);
		top = new Heap(false);


	}

	public void add(int n){
		if(bots == tops){
			if(n > getMedian())
			bot.add(n)
			bots++;
		}
		else if(bots > tops){
			top.add(n);
			tops++;
		}
	}
		
	public int getMedian(){
		if(bots == tops){
			return (bot.peek() + top.peek()) / 2;
		}
		else return bot.peek();
	}

	public int removeMedian(){
		if(bots == tops){
			bots--;
			tops--;
			return (bot.get() + top.get()) / 2;
		}
		else{
			bot--;
			return bot.get();
		}
