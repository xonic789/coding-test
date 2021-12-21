import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 가운데를말해요 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		
		PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> minQ = new PriorityQueue<>();
		
	
		  StringBuilder sb = new StringBuilder();
	        for(int i = 0; i < n; i++) {
	            int num = sc.nextInt();
	            
	            if(minQ.size() == maxQ.size()) maxQ.add(num); //사이즈가 같으면 최대힙 넣기
	            else minQ.add(num); //다르면 최소힙 넣기
	            
	            if(!minQ.isEmpty() && !maxQ.isEmpty() && minQ.peek() < maxQ.peek()) { //최소의 현재값보다 최대의 현재값 크면 스왑
	                int temp = minQ.poll();
	                minQ.add(maxQ.poll());
	                maxQ.add(temp);
	            }
	            sb.append(maxQ.peek() + "\n");        
	        }
	        System.out.println(sb);
		
	}

}
