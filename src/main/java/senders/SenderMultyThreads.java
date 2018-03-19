package senders;

import controllers.RequestController;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import static controllers.RequestController.count;
import static controllers.RequestController.isCurentRequestTrue;

/**
 * Class for threads realizing
 */

public final class SenderMultyThreads implements Runnable {

    private RequestController requestController;

    public SenderMultyThreads(RequestController requestController) {
        this.requestController = requestController;
    }

    @Override
    public void run() {
        try {
            this.requestController.pay();
            if (isCurentRequestTrue) {
                System.out.println("[" + count + "]" + "Payment OK!");
            } else {
                System.out.println("[" + count + "]" + "Payment ERROR!");
            }
        } catch (KeyManagementException e) {
            //e.printStackTrace();
            System.out.println("[" + count + "]" + "Payment ERROR!");
        } catch (NoSuchAlgorithmException e) {
            //e.printStackTrace();
            System.out.println("[" + count + "]" + "Payment ERROR!");
        } catch (KeyStoreException e) {
            //e.printStackTrace();
            System.out.println("[" + count + "]" + "Payment ERROR!");
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("[" + count + "]" + "Payment ERROR!");
        }
    }

}