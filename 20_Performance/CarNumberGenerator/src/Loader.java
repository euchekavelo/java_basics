import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Loader {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        //Сформируем исполнитель с 3 потоками, куда отправим задачи для асинхронного исполнения.
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++){
            FileFormation fileFormation = new FileFormation(i);
            executor.execute(fileFormation);
        }

        //Инициируем завершение работы исполнителя после передачи в него задач.
        executor.shutdown();

        //Заблокируем основной поток до тех пор, пока все задачи не завершат выполнение
        //после инициации запроса о завершении работы исполнителя.
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }
}
