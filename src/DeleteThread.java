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
        try {
            while (true) {
                if (mainThread.getAction().equals("d")) {
                    System.out.println("method delete");
                    mainThread.setAction("c");
                } else {
//                    notify();
                    wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public DeleteThread(MainThread mainThread) {
        this.mainThread = mainThread;
    }

    public Thread getThrDelete() {
        return thrDelete;
    }
}
