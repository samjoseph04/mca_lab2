import java.util.*;

class Rev {
	public int reverse(int a) {
		int rev = 0;
		int dig;
		while(a!=0){
			dig = a % 10;
			rev = rev * 10 + dig;
			a = a / 10;
		}
		return rev;
	}
	
	public void palindrome() {
		Rev obj = new Rev();
		int num;
		int r;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number: ");
		num = s.nextInt();
		r = obj.reverse(num);
		System.out.println("Reverse of number: " + r);
		if(num == r) {
			System.out.println("Given number is palindrome");
		} else {
			System.out.println("Given number is not palindrome");
		}
	}
		
		
		
	
	public static void main(String args[]) {
		Rev obj1 = new Rev();
		obj1.palindrome();
	}
}
		