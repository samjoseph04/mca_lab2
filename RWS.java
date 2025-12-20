class SM {
    int data;
    int readCount = 0;   // Number of readers reading
    boolean writing = false;

    // Reader method
    public synchronized void startRead(int readerId) {
        try {
            while (writing)       // Wait if a writer is writing
                wait();
            readCount++;
            System.out.println("Reader " + readerId + " starts reading. Data = " + data);
        } catch (Exception e) {}
    }

    public synchronized void endRead(int readerId) {
        readCount--;
        System.out.println("Reader " + readerId + " finished reading.");
        notifyAll();           // Notify waiting writers
    }

    // Writer method
    public synchronized void write(int value, int writerId) {
        try {
            while (writing || readCount > 0)   // Wait if readers/writer present
                wait();
            writing = true;
            data = value;
            System.out.println("Writer " + writerId + " wrote: " + data);
            writing = false;
            notifyAll();                       // Notify readers/writers
        } catch (Exception e) {}
    }
}

// Reader thread
class Reader extends Thread {
    SM q;
    int id;

    public Reader(SM q, int id) {
        this.q = q;
        this.id = id;
    }

    public void run() {
        while (true) {
            q.startRead(id);
            try { Thread.sleep(500); } catch(Exception e) {}
            q.endRead(id);
            try { Thread.sleep(500); } catch(Exception e) {}
        }
    }
}

// Writer thread
class Writer extends Thread {
    SM q;
    int id;

    public Writer(SM q, int id) {
        this.q = q;
        this.id = id;
    }

    public void run() {
        int i = 1;
        while (true) {
            q.write(i, id);
            i++;
            try { Thread.sleep(1000); } catch(Exception e) {}
        }
    }
}

// Main class
class RWS {
    public static void main(String args[]) {
        SM q = new SM();

        // Create readers
        for (int i = 1; i <= 3; i++) {
            new Reader(q, i).start();
        }

        // Create writers
        for (int i = 1; i <= 2; i++) {
            new Writer(q, i).start();
        }
    }
}
