class Employee {
	int id;
	Employee(int id) {
		this.id = id;
		System.out.println("Employee ID: " + id);
	}
}

class Manager extends Employee {
	String department;
	Manager(int id, String department) {
		super(id);
		this.department = department;
		System.out.println("Department: " + department);
	}
}

class SuperConstructor {
	public static void main(String args[]) {
		Manager m = new Manager(101, "Analyst");
	}
}