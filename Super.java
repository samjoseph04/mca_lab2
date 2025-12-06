import java.util.Scanner;

class A {
    int a;

    public A() {
        a = 0;
    }

    public A(int n) {
        a = n;
    }

    public void read(Scanner s) {
        System.out.print("Enter integer: ");
        a = s.nextInt();
    }

    public void disp() {
        System.out.println("A = " + a);
    }
}

class B extends A {
    String b;

    public B() {
        b = "";
    }

    public B(int n, String str) {
        super(n);
        b = str;
    }

    public void read(Scanner s) {
        super.read(s);
        s.nextLine(); // clear buffer
        System.out.print("Enter string: ");
        b = s.nextLine();
    }

    public void disp() {
        super.disp();
        System.out.println("B = " + b);
    }
}

class C extends B {
    float c;

    public C() {
        c = 0f;
    }

    public C(int n, String str, float f) {
        super(n, str);
        c = f;
    }

    public void read(Scanner s) {
        super.read(s);
        System.out.print("Enter float: ");
        c = s.nextFloat();
    }

    public void disp() {
        super.disp();
        System.out.println("C = " + c);
    }
}

class Sup {
    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        int ch;

        A aObj = null;
        B bObj = null;
        C cObj = null;

        while (true) {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Create object of Class A");
            System.out.println("2. Create object of Class B");
            System.out.println("3. Create object of Class C");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    aObj = new A();
                    aObj.read(s);
                    System.out.println("\nDisplaying A:");
                    aObj.disp();
                    break;

                case 2:
                    bObj = new B();
                    bObj.read(s);
                    System.out.println("\nDisplaying B:");
                    bObj.disp();
                    break;

                case 3:
                    cObj = new C();
                    cObj.read(s);
                    System.out.println("\nDisplaying C:");
                    cObj.disp();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
