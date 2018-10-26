public class DeleteThread extends Thread {
    String thrName = "Delete";
    Thread thrDelete;
    MainThread mainThread;


    public void start() {
        if (thrDelete == null) {
            thrDelete = new Thread(this, thrName);
            thrDelete.start();
        }
    }

    @Override
    public void run() {
        System.out.println(this.thrName);
        synchronized (this) {
            try {
                while (true) {
                    System.out.println("run delete....");
                    if (mainThread.getAction().equals("d")) {
                        System.out.println("method delete");
                    } else {
                        wait(500);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public DeleteThread(MainThread mainThread) {
        this.mainThread = mainThread;
    }

    public Thread getThrDelete() {
        return thrDelete;
    }
}
