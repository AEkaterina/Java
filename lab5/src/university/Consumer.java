package university;

public class Consumer extends Thread {
    Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            store.get();
        }
    }
}
