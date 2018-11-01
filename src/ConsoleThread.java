import java.util.Scanner;

public class ConsoleThread implements Runnable {
    MainThread mainThread;
    Thread thrConsole;
    String thrName = "Console";
    String consoleValue;
    String[] commands = {"c", "r", "u", "d", "q"};

    String menu = "MENU program: \n" +
            "c - create \n" +
            "r - reade \n" +
            "u - update \n" +
            "d - delete \n" +
            "q - quit \n" +
            "enter command:";


    public void start() {
        if (thrConsole == null) {
            thrConsole = new Thread(this, thrName);
            thrConsole.start();
        }
    }

    private boolean commandChecker(String command) {
        for (String s : commands) {
            if (command.equals(s)) return true;
        }
        return false;
    }


    @Override
    public void run() {
        synchronized (this) {
            try {
                while (true) {
                    if(mainThread.getAction().equals("q")) break;
                    if (mainThread.getAction().equals("")) {
                        System.out.println(menu);
                        consoleValue = readConsoleValue();
                        if (commandChecker(consoleValue)) {
                            mainThread.setAction(consoleValue);
                        } else System.out.println("Wrong command");
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
