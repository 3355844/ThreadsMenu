public class MainThread implements Runnable {
    private String thrName;
    private Thread mainThread;
    private String action = "";
    private CreateThread createThread;
    private DeleteThread deleteThread;
    private UpdateThread updateThread;
    private ReadThread readThread;

    @Override
    public void run() {
        System.out.println("Main Thread is Started...");
        startThreads();
        try {
            joinThreads();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getAction());

    }

    private void joinThreads() throws InterruptedException {
        createThread.getThrCreate().join();
        deleteThread.getThrDelete().join();
        updateThread.getThrUpdate().join();
        readThread.getThrRead().join();
    }

    private void startThreads() {
        createThread.start();
        deleteThread.start();
        updateThread.start();
        readThread.start();
    }

    public void start() {
        updateThread = new UpdateThread(this);
        createThread = new CreateThread(this);
        deleteThread = new DeleteThread(this);
        readThread = new ReadThread(this);
        mainThread = new Thread(this, thrName);
        mainThread.start();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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
