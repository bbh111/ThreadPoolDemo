import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class UsingScheduledThreadPool {
    // Số lượng Thread trong ThreadPool
    private static final int NUMBER_THREAD = 5;
    // Thời gian trì hoãn trước khi thực hiện tác vụ đầu tiên
    private static final int INITIAL_DELAY = 2;
    // Thời gian trì hoãn kể từ lần gần nhất thực hiện tác vụ
    private static final int DELAY = 1;
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(NUMBER_THREAD);
        IntStream.range(0,10).forEach(s->{
            Runnable runnable = new WorkerThread(""+s);
            service.scheduleWithFixedDelay(runnable,INITIAL_DELAY,DELAY, TimeUnit.SECONDS);
        });
        //Thời gian chờ tối đa của từng task là 10s trước khi bị hủy
        service.awaitTermination(10,TimeUnit.SECONDS);
        service.shutdown();
        // Đợi tất cả các Thread chạy xong hết
        while (!service.isTerminated()){

        }
        System.out.println("All Thread success");
    }
}
