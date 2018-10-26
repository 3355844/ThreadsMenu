public class ReadThread implements Runnable {
    MainThread mainThread;
    Thread thrRead;
    String thrName = "Read";

    public void start(){
        if (thrRead == null) {
            thrRead = new Thread(this, thrName);
            thrRead.start();
        }
    }

    @Override
    public void run() {
        System.out.println(this.thrName);
        synchronized (this) {

            try {
                while (true) {
                    System.out.println("run read.....");
                    if (mainThread.getAction().equals("r")) {
                        System.out.println("method read");
                    } else {
                        wait(500);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Thread getThrRead() {
        return thrRead;
    }

    public ReadThread(MainThread mainThread) {
        this.mainThread = mainThread;
    }
}
