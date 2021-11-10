import java.util.*;
class Chapter1_3 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] days = new int[n][2];
		String[] temp = new String[n*2];
		int[][] day1 = new int[n][2];
		int[][] day2 = new int[n][2];
		boolean flag = true;

		for(int i=0; i<n*2; i++){
			String s = sc.next();
			String b = "";
			
			for(char c : s.toCharArray()){
				if(c == '/'){
					b += "0";
				}
				else{
					b += String.valueOf(c);	
				}
			}
			temp[i] = b;					 
		}
		int t = 0;
		for(int i=0; i<temp.length; i++) {
			if(i % 2 == 0) {
				days[t][0] = Integer.valueOf(temp[i]);
			}
			else {
				days[t][1] = Integer.valueOf(temp[i]);
				t++;
			}
		}
		

		
		Arrays.sort(days, new Comparator<int[]>() {
			
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o2[1]-o1[1];
				}
				
				else {
					return o1[0]-o2[0];
				}
				
			}
		});
		int p = 1;
		for(int i=0; i<days.length; i++) {
			for(int j=0; j<2; j++) {
				if(i == 0 ) {
				day1[i][0] = days[i][j];
				day1[i][1] = p;
				}
				else {
				day2[i][0] = days[i][j];
				day2[i][0] = p*-1; 
					
				}
			}
			p++;
		}
		
		
		
	}
}