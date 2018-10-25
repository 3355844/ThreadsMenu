public class MainThread implements Runnable {
    private String thrName;
    private Thread mainThread;
    private String action = "c";
    private CreateThread createThread;
    private DeleteThread deleteThread;

    @Override
    public void run() {
        System.out.println("Main Thread is Started...");
        createThread.start();
        deleteThread.start();
        try {
            createThread.getThrCreate().join();
            deleteThread.getThrDelete().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getAction());

    }

    public void start(){

        createThread = new CreateThread(this);
        deleteThread = new DeleteThread(this);
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
