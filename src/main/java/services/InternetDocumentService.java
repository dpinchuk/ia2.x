package services;

import com.google.gson.JsonObject;
import controllers.RequestController;
import models.InternetDocumentModel;
import tools.Tools;
import senders.Sender;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static utils.Constants.*;

/**
 * Service class for InternetDocument model
 */

public final class InternetDocumentService {

    private InternetDocumentModel internetDocumentModel;
    private List<String> paramList;
    private Sender sender;
    private JsonObject serverResponse;

    public InternetDocumentService(InternetDocumentModel internetDocumentModel, List<String> paramList) {
        this.internetDocumentModel = internetDocumentModel;
        this.paramList = paramList;
    }

    private boolean isRequestOk(String field) throws IOException {
        return Tools.getParamValueFromList(this.serverResponse.toString(), field).equals(TRUE);
    }

    public boolean getInternetDocumentListProperties() throws IOException {
        this.sender = new Sender(API_URL_ADDRESS + JSON, Tools.parseObjectToJson(this.internetDocumentModel));
        this.serverResponse = this.sender.sendApiRequest();
        if (this.isRequestOk(SUCCESS)) {
            RequestController.properties = Tools.getPropertiesFromJSON(serverResponse.toString(), paramList);
            return true;
        } else {
            return false;
        }
    }

}