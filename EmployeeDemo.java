import java.util.*;

class Employee {
    int eno;
    String ename;
    int esal;

    void read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee no, name and salary:");

        eno = sc.nextInt();
        sc.nextLine();              // consume newline
        ename = sc.nextLine();
        esal = sc.nextInt();
    }

    void disp() {
        System.out.println(eno + "\t" + ename + "\t" + esal);
    }

    boolean compare(int no) {
        return eno == no;
    }
}

class EmployeeDemo {
    public static void main(String args[]) {
        int n, i;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        n = sc.nextInt();

        Employee[] emp = new Employee[n];

        for (i = 0; i < n; i++) {
            emp[i] = new Employee();
            System.out.println("\nEnter details of Employee " + (i + 1));
            emp[i].read();
        }

        System.out.println("\nEmployee Details");
        System.out.println("Eno\tEname\tSalary");

        for (i = 0; i < n; i++) {
            emp[i].disp();
        }

        // Searching for an employee
        System.out.print("\nEnter employee number to search: ");
        int searchNo = sc.nextInt();

        boolean found = false;

        for (i = 0; i < n; i++) {
            if (emp[i].compare(searchNo)) {
                System.out.println("\nEmployee Found:");
                System.out.println("Eno\tEname\tSalary");
                emp[i].disp();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nEmployee not found.");
        }
    }
}
