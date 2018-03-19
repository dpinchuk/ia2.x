package services;

import com.google.gson.JsonObject;
import models.TlSendXMLModel;
import tools.Tools;
import senders.Sender;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import static utils.Constants.*;

/**
 * Service class for TlSendXML model
 */

public final class TlSendXMLService {

    private TlSendXMLModel tlSendXMLModel;
    private Sender sender;
    private JsonObject serverResponse;

    public TlSendXMLService(TlSendXMLModel tlSendXMLModel) {
        this.tlSendXMLModel = tlSendXMLModel;
    }

    public boolean sendTlSendXMLModel() throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        this.sender = new Sender(API_URL_ADDRESS + JSON, Tools.parseObjectToJson(this.tlSendXMLModel));
        this.serverResponse = this.sender.sendApiRequest();
        return Tools.getParamValueFromList(this.serverResponse.toString(), SUCCESS).equals(TRUE);
    }

}