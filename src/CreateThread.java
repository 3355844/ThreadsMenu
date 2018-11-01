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
        synchronized (this) {

            try {
                while (true) {
                    if(mainThread.getAction().equals("q")) break;
                    if (mainThread.getAction().equals("c")) {
                        System.out.println("method create");
                        mainThread.setAction("");
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
