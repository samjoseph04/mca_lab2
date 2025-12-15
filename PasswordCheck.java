import java.util.Scanner;

class UDE extends Exception {
	String strError;
	public UDE() {
		strError = "Unknown Error";
	}
	public UDE(String s) {
		strError = s;
	}
	public String showError() {
		return strError;
	}
}

class PasswordCheck {
	static void validate(String pwd) throws UDE {
	
		if(pwd.length() < 9) {
			throw new UDE("Password length should be atleast 9");
		}
		int i;
		boolean l = false, u = false, s = false;
		String sp = "@*!{}()[]=";
		
		for(i = 0; i < pwd.length(); i++) {
			char ch = pwd.charAt(i);
		
            		if (i > 0 && ch == pwd.charAt(i - 1))
                		throw new UDE("Consecutive repeated characters not allowed");
		
            		if (ch >= 'a' && ch <= 'z')
                		l = true;
            		else if (ch >= 'A' && ch <= 'Z')
                		u = true;
            		else if (ch >= '0' && ch <= '9') {

            		}
            		else if (sp.indexOf(ch) != -1)
                		s = true;
            		else
                		throw new UDE("Invalid special character used");
        	}

        	if (l == false)
            		throw new UDE("At least one lowercase letter required");

        	if (u == false)
            		throw new UDE("At least one uppercase letter required");

        	if (s == false)
            		throw new UDE("At least one special character required");
    	}
	
	
	public static void main(String args[]) {
		String pwd;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter password: ");
		pwd = sc.nextLine();
	
		try {
			validate(pwd);
			System.out.println("Password is valid");
		}
		catch(UDE e) {
			System.out.println(e.showError());
		}
	}
}

