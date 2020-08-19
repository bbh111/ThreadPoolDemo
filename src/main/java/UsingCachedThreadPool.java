import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class UsingCachedThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0,10).forEach(s->{
            Runnable worker = new WorkerThread(""+s);
            service.execute(worker);
        });
        service.shutdown();
        while (!service.isTerminated()){

        }
        System.out.println("All Task run success");
    }
}
