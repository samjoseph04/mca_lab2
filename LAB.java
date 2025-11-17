import java.io.*;
class LAB {
	public static void main(String args[])
	{
		int op1, op2, op3, ans;
		op1 = Integer.parseInt(args[0]);
		op2 = Integer.parseInt(args[1]);
		op3 = Integer.parseInt(args[2]);
		
		switch(op3) {
			case 0:
				ans = op1 + op2;
				System.out.println("Sum = " + ans);
				break;
			case 1:
				ans = op1 - op2;
				System.out.println("Difference = " + ans);
				break;
			case 2:
				ans = op1 * op2;
				System.out.println("Product = " + ans);
				break;
			case 3:
				ans = op1 / op2;
				System.out.println("Divisor = " + ans);
				break;
			case 4:
				ans = op1 % op2;
				System.out.println("Reminder = " + ans);
				break;
		}
	}
}