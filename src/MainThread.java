public class MainThread implements Runnable {
    private String thrName;
    private Thread mainThread;
    private String action = "c";
    private CreateThread createThread;

    @Override
    public void run() {
        System.out.println("Main Thread");
        createThread.start(action);
        try {
            createThread.getThrCreate().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void start(String value){
        createThread = new CreateThread(value);
        mainThread = new Thread(this, thrName);
        mainThread.start();
    }

    public MainThread(String thrName) {
        this.thrName = thrName;
    }

    public String getThrName() {
        return thrName;
    }

    public Thread getMainThread() {
        return mainThread;
    }

}
