class MaxOfThree {
    public int Max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String args[]) {
        MaxOfThree obj = new MaxOfThree();
        int a, b, c, max;
        a = 30;
        b = 23;
        c = 35;
        max = obj.Max(obj.Max(a, b),c);
        System.out.println("Max: " + max);
    }
}