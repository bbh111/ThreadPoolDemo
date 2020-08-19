public class WorkerThread implements Runnable{
    private String task;

    public WorkerThread(String task) {
        this.task = task;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "Starting Task"+task);
        processingTask();
        System.out.println(Thread.currentThread().getName() + "Finish Task"+ task);
    }

    private void processingTask() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
