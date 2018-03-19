package services;

import com.google.gson.JsonObject;
import controllers.RequestController;
import models.TlGetSidModel;
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
 * Service class for TlGetSid model
 */

public final class TlGetSidService {

    private TlGetSidModel tlGetSidModel;
    private List<String> paramList;
    private Sender sender;
    private String serverResponse;

    public TlGetSidService(TlGetSidModel tlGetSidModel, List<String> paramList) {
        this.tlGetSidModel = tlGetSidModel;
        this.paramList = paramList;
    }

    private boolean isRequestOk(String field) throws IOException {
        return Tools.getParamValueFromList(this.serverResponse.toString(), field).equals(TRUE);
    }

    public Properties getTlGetSid() throws IOException {
        this.sender = new Sender(API_URL_ADDRESS + JSON, Tools.parseObjectToJson(this.tlGetSidModel));
        this.serverResponse = this.sender.sendApiRequest();
        if (this.isRequestOk(SUCCESS)) {
            return Tools.getPropertiesFromJSON(serverResponse.toString(), paramList);
        } else {
            return new Properties();
        }
    }

    public boolean getTlGetSid_() throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        this.sender = new Sender(API_URL_ADDRESS + JSON, Tools.parseObjectToJson(this.tlGetSidModel));
        this.serverResponse = this.sender.sendApiRequest();
        if (this.isRequestOk(SUCCESS)) {
            RequestController.properties.setProperty(paramList.get(0), Tools.getPropertiesFromJSON(serverResponse.toString(), paramList).getProperty(paramList.get(0)));
            return true;
        } else {
            return false;
        }
    }

}