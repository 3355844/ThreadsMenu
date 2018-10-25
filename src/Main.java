import java.util.Currency;

public class Main {
    public static void main(String[] args) {

        MainThread mainThread = new MainThread("Main");
        mainThread.start();
        try {

            for (int i = 0; i < 5; i++) {
                mainThread.getMainThread().join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("END...");
    }
}
