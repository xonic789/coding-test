import java.util.Scanner;

public class Chapter1_9 {
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	
	double x1 = sc.nextDouble(); double y1 = sc.nextDouble();
	double x2 = sc.nextDouble(); double y2 = sc.nextDouble();
	double x3 = sc.nextDouble(); double y3 = sc.nextDouble();
	
	
	double sum = 0;
	
	sum = ((x1*y2+x2*y3+x3*y1)-(x2*y1+x3*y2+x1*y3));
	if(sum < 0) {
		sum =sum * -1;
		sum = sum/2;
		System.out.println(String.format("%.2f", sum));
	}
	else {
		sum = sum/2;
		System.out.println(String.format("%.2f", sum));
	}
	}
}
