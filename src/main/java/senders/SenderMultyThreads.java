package senders;

import controllers.RequestController;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

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
            System.out.println();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}