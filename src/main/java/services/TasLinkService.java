package services;

import models.TasLinkModel;
import senders.Sender;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import static utils.Constants.*;

/**
 * Service class for create url e-dev.taslink.com.ua/novaposhta_api/?pay=
 */

public final class TasLinkService {

    private TasLinkModel tasLinkModel;
    private Sender sender;

    public TasLinkService(TasLinkModel tasLinkModel) {
        this.tasLinkModel = tasLinkModel;
    }

    public int sendTasLinkRequest() throws IOException {
        this.sender = new Sender(TASLINK_URL + "?pay=" + this.tasLinkModel.getSid());
        return this.sender.sendGet();
    }

}