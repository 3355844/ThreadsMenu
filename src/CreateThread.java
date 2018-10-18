public class CreateThread implements Runnable {
    String thrName;
    Thread thrCreate;


    public void start(String action) {
        if (action.equalsIgnoreCase("c") && thrCreate == null) {
            thrCreate = new Thread(this, thrName);
            thrCreate.start();
        }
    }

    @Override
    public void run() {
        System.out.println("create Thread");

    }

    public CreateThread(String thrName) {
        this.thrName = thrName;
    }

    public String getThrName() {
        return thrName;
    }

    public Thread getThrCreate() {
        return thrCreate;
    }
}
