public class UpdateThread implements Runnable {
    MainThread mainThread;
    Thread thrUpdate;
    String thrName = "Update";

    public void start(){
        if (thrUpdate == null) {
            thrUpdate = new Thread(this, thrName);
            thrUpdate.start();
        }
    }

    @Override
    public void run() {
        System.out.println(this.thrName);
        synchronized (this) {
            try {
                while (true) {
                    System.out.println("run update.....");
                    if (mainThread.getAction().equals("u")) {
                        System.out.println("method update");
                    } else {
                        wait(500);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Thread getThrUpdate() {
        return thrUpdate;
    }

    public UpdateThread(MainThread mainThread) {
        this.mainThread = mainThread;
    }
}
