package services;

import com.google.gson.JsonObject;
import models.GetSenderPaymentInfoModel;
import tools.Tools;
import senders.Sender;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import static utils.Constants.*;

/**
 * Service class for GetSenderPaymentInfo model
 */

public final class GetSenderPaymentInfoService {

    private GetSenderPaymentInfoModel getSenderPaymentInfoModel;
    private Sender sender;
    private JsonObject serverResponse;

    public GetSenderPaymentInfoService(GetSenderPaymentInfoModel getSenderPaymentInfoModel) {
        this.getSenderPaymentInfoModel = getSenderPaymentInfoModel;
    }

    public boolean isSenderPaymentInfoTrue() throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        this.sender = new Sender(API_URL_ADDRESS + JSON, Tools.parseObjectToJson(this.getSenderPaymentInfoModel));
        this.serverResponse = this.sender.sendApiRequest();
        return Tools.getParamValueFromList(this.serverResponse.toString(), SUCCESS).equals(TRUE);
    }

}