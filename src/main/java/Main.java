import controllers.RequestController;
import senders.SenderMultyThreads;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static controllers.RequestController.count;
import static utils.Constants.LIMIT;
import static utils.Constants.REQUEST_PER_SECOND;

/**
 * Main Class for run program
 */

public class Main {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, URISyntaxException {
        // 0 - sequential alone payment start
        // other - multy thread payment start
        paymentProcess(0);
    }

    private static void paymentProcess(int process) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        if (process == 0) {
            // Выполняем последовательные оплаты от 0 до указанного числа
            for (int i = 0; i < LIMIT * REQUEST_PER_SECOND; i++) {
                RequestController requestController = new RequestController();
                if (requestController.pay()) {
                    System.out.println("[" + count + "]" + "Payment OK!");
                } else {
                    System.out.println("[" + count + "]" + "Payment ERROR!");
                }
            }
        } else {
            // Создаем pool потоков
            ExecutorService service = Executors.newFixedThreadPool(LIMIT);
            // Потоки выполняют одновременно запросы от 0 до указанного числа.
            // Ориентировочно - REQUEST_PER_SECOND запросов в сек.
            IntStream.range(0, LIMIT * REQUEST_PER_SECOND).forEach(i -> service.submit(new SenderMultyThreads(new RequestController())));
        }
    }

}