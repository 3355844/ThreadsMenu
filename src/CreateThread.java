public class CreateThread implements Runnable {

    MainThread mainThread;
    String thrName = "Create";
    Thread thrCreate;

    public void start() {
        if (thrCreate == null) {
            thrCreate = new Thread(this, thrName);
            thrCreate.start();
        }
    }

    @Override
    public void run() {
        System.out.println(this.thrName);
        synchronized (this) {

            try {
                while (true) {
                    System.out.println("run create.....");
                    if (mainThread.getAction().equals("c")) {
                        System.out.println("method create");
                    } else {
                        wait(500);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public Thread getThrCreate() {
        return thrCreate;
    }

    public CreateThread(MainThread mainThread) {
        this.mainThread = mainThread;
    }
}
