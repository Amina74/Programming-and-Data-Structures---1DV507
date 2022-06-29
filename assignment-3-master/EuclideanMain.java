package ah224uq_assign3;
import java.util.Scanner;
public class EuclideanMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please provide intgers: ");
		int input1 = scan.nextInt();
		int input2 = scan.nextInt();
		int input3 = scan.nextInt();
		int input4 = scan.nextInt();
		int input5 = scan.nextInt();
		int input6 = scan.nextInt();
		System.out.println("GCD ("+input1+" , "+input2+") = " + EuclideanAlgorithm(input1,input2));
		System.out.println("GCD ("+input3+" , "+input4+") = " + EuclideanAlgorithm(input3,input4));
		System.out.println("GCD ("+input5+" , "+input6+") = " + EuclideanAlgorithm(input5,input6));

		scan.close();
	}

	public static int EuclideanAlgorithm(int input1, int input2){
		while( input2!= 0)
		{
			int a = input2;
			input2 = input1%input2;
			input1 = a;
		}
		return input1;

	}

}
