package services;

import com.google.gson.JsonObject;
import controllers.RequestController;
import models.CreateDraftPaymentOnSiteModel;
import tools.Tools;
import senders.Sender;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static utils.Constants.*;

/**
 * Service class for CreateDraftPaymentOnSite model
 */

public final class CreateDraftPaymentOnSiteService {

    private CreateDraftPaymentOnSiteModel createDraftPaymentOnSiteModel;
    private List<String> paramList;
    private Sender sender;
    private JsonObject serverResponse;

    public CreateDraftPaymentOnSiteService(CreateDraftPaymentOnSiteModel createDraftPaymentOnSiteModel, List<String> paramList) {
        this.createDraftPaymentOnSiteModel = createDraftPaymentOnSiteModel;
        this.paramList = paramList;
    }

    private boolean isRequestOk(String field) throws IOException {
        return Tools.getParamValueFromList(this.serverResponse.toString(), field).equals(TRUE);
    }

    public boolean getDraftRef() throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        this.sender = new Sender(API_URL_ADDRESS + JSON, Tools.parseObjectToJson(this.createDraftPaymentOnSiteModel));
        this.serverResponse = this.sender.sendApiRequest();
        if (this.isRequestOk(SUCCESS)) {
            RequestController.properties.setProperty(paramList.get(0), Tools.getPropertiesFromJSON(serverResponse.toString(), paramList).getProperty(paramList.get(0)));
            return true;
        } else {
            return false;
        }
    }

}