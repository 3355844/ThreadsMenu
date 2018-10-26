import java.util.Scanner;

public class ConsoleThread implements Runnable {
    MainThread mainThread;
    Thread thrConsole;
    String thrName = "Console";

    public void start(){
        if (thrConsole == null) {
            thrConsole = new Thread(this, thrName);
            thrConsole.start();
        }
    }


    @Override
    public void run() {
        synchronized (this) {
            try {
                while (true) {
                    if (mainThread.getAction().equals("")) {
                        System.out.println("enter value:");
                        mainThread.setAction(readConsoleValue());
                    } else {
                        wait(500);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static String readConsoleValue() {
        String value;
        Scanner scanner = new Scanner(System.in);
        value = scanner.nextLine();
        return value;
    }

    public Thread getThrConsole() {
        return thrConsole;
    }

    public ConsoleThread(MainThread mainThread) {
        this.mainThread = mainThread;
    }
}
