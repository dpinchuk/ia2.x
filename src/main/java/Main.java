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

import static utils.Constants.LIMIT;

/**
 * Main Class for run program
 */

public class Main {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, URISyntaxException {
        // Создаем pool потоков
        ExecutorService service = Executors.newFixedThreadPool(LIMIT);

        // Потоки выполняют одновременно запросы от 0 до указанного числа. Ориентировочно - за 1 сек
        IntStream.range(0, LIMIT * 60).forEach(i -> service.submit(new SenderMultyThreads(new RequestController())));
    }

}