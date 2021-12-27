package Chapter1;
import java.io.*;
class Chapter1_5 {
	static char[] alphabets = {'a','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	static int maxcount = -1;
	static int mincount = -1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int n = Integer.parseInt(input);
		
		String[] alphabets = new String[n];
		
		for(int i=0; i<n; i++) {
			alphabets[i] = br.readLine();
		}
		
		dfsmax(alphabets, 0, n, 0, 0);
		dfsmin(alphabets, 0, n, 0, 0);
		System.out.println(mincount);
		System.out.println(maxcount);

	}
	
	static void dfsmax(String[] alphabet, int len, int n, int currLocation, int maxn) {
		int left;
		int right;
		if(len == 0) {
			maxn += alphabetindex(alphabet[0].charAt(0));
			dfsmax(alphabet, len+1, n, currLocation, maxn);
		}
		else {
			if(len == n) {
				if(maxcount == -1) {
					maxcount = maxn;
				}
				maxcount =  Math.max(maxcount, maxn);
				return;
			}
			left = alphabetindex(alphabet[len].charAt(currLocation));
			right = alphabetindex(alphabet[len].charAt(currLocation+1));
			dfsmax(alphabet, len+1, n, currLocation*2, maxn+left);
			dfsmax(alphabet, len+1, n, (currLocation+1)*2, maxn+right);
			
			
		}
		
		
	}
	static void dfsmin(String[] alphabet, int len, int n, int currLocation, int minn) {
		int left;
		int right;
		if(len == 0) {
			minn += alphabetindex(alphabet[0].charAt(0));
			dfsmin(alphabet, len+1, n, currLocation, minn);
		}
		else {
			if(len == n) {
				if(mincount == -1) {
					mincount = minn;
				}
				mincount =  Math.min(mincount, minn);
				return;
			}
			left = alphabetindex(alphabet[len].charAt(currLocation));
			right = alphabetindex(alphabet[len].charAt(currLocation+1));
			dfsmin(alphabet, len+1, n, currLocation*2, minn+left);
			dfsmin(alphabet, len+1, n, (currLocation+1)*2, minn+right);
			
			
		}
		
		
	}
	static int alphabetindex(char a) {
		
		for(int i=0; i<alphabets.length; i++) {
			if(alphabets[i] == a) {
				return i;
			}
		}
		return 0;
	}

} 