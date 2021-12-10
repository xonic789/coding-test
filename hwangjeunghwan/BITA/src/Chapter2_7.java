import java.util.Scanner;

public class Chapter2_7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		double[][] xy = new double[n][2];
		for(int i=0; i<n; i++) {
		double x = sc.nextDouble(); double y = sc.nextDouble();
			xy[i][0] = x;
			xy[i][1] = y;
		}
		
		for(int i=2; i<n; i++) {
			int result = ccw(xy[i-2][0],xy[i-2][1],xy[i-1][0],xy[i-1][1],xy[i][0],xy[i][1]);
			if(result >0) {
				System.out.println("LEFT");
			}else if(result <0) {
				System.out.println("RIGHT");
			}else {
				
			}
		}
}
	
	static int ccw(double x1, double y1, double x2, double y2, double x3, double y3) {
	    double temp = x1*y2+x2*y3+x3*y1;
	    temp = temp - y1*x2-y2*x3-y3*x1;
	    if (temp > 0) {
	        return 1;
	    } else if (temp < 0) {
	        return -1;
	    } else {
	        return 0;
	    }
	}
}
