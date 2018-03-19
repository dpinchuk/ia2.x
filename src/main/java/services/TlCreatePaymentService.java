package services;

import com.google.gson.JsonObject;
import controllers.RequestController;
import models.TlCreatePaymentModel;
import tools.Tools;
import senders.Sender;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Properties;

import static utils.Constants.*;

/**
 * Service class for TlCreatePayment model
 */

public final class TlCreatePaymentService {

    private TlCreatePaymentModel tlCreatePaymentModel;
    private List<String> paramList;
    private Sender sender;
    private JsonObject serverResponse;

    public TlCreatePaymentService(TlCreatePaymentModel tlCreatePaymentModel, List<String> paramList) {
        this.tlCreatePaymentModel = tlCreatePaymentModel;
        this.paramList = paramList;
    }

    private boolean isRequestOk(String field) throws IOException {
        return Tools.getParamValueFromList(this.serverResponse.toString(), field).equals(TRUE);
    }

    public Properties getDraftRef() throws IOException {
        this.sender = new Sender(API_URL_ADDRESS + JSON, Tools.parseObjectToJson(this.tlCreatePaymentModel));
        this.serverResponse = this.sender.sendApiRequest();
        if (this.isRequestOk(SUCCESS)) {
            return Tools.getPropertiesFromJSON(serverResponse.toString(), paramList);
        } else {
            return new Properties();
        }
    }

    public boolean getDraftRef_() throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        this.sender = new Sender(API_URL_ADDRESS + JSON, Tools.parseObjectToJson(this.tlCreatePaymentModel));
        this.serverResponse = this.sender.sendApiRequest();
        if (this.isRequestOk(SUCCESS)) {
            RequestController.properties.setProperty(paramList.get(0) + "Tas", Tools.getPropertiesFromJSON(serverResponse.toString(), paramList).getProperty(paramList.get(0)));
            return true;
        } else {
            return false;
        }
    }

}