import java.util.*;

class SearchThread extends Thread {
    int[] arr;
    int start, end;
    int key;

    SearchThread(int[] arr, int start, int end, int key) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.key = key;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            if (arr[i] == key) {
                System.out.println("Key found at index " + i + " by " + Thread.currentThread().getName());
            }
        }
    }
}

class ThreadSearchDemo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array:");
        int n = sc.nextInt();

        int[] arr = new int[n];   // FIXED

        for (int i = 0; i < n; i++) {
            System.out.println("Enter value " + (i + 1));
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the key:");
        int key = sc.nextInt();

        int chunkSize = 5;
        int threads = (int) Math.ceil((double) n / chunkSize);

        for (int i = 0; i < threads; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, n); // FIXED

            new SearchThread(arr, start, end, key).start();
        }

        sc.close();
    }
}
