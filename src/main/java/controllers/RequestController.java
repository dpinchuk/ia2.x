package controllers;

import models.*;
import services.*;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Properties;

/**
 * Class controller for execution payment process
 */

public final class RequestController {

    public static Properties properties = new Properties();

    private InternetDocumentService internetDocumentService;
    private GetSenderPaymentInfoService getSenderPaymentInfoService;
    private TlGetSidService tlGetSidService;
    private CreateDraftPaymentOnSiteService createDraftPaymentOnSiteService;
    private TlCreatePaymentService tlCreatePaymentService;
    private TlSendXMLService tlSendXMLService;
    private TasLinkService tasLinkService;

    public static int count = 0;
    public static boolean isCurentRequestTrue = false;

    public RequestController() {
    }

    public boolean pay() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        ++count;
        // метод создания ИД [InternetDocument]
        this.internetDocumentService = new InternetDocumentService(InternetDocumentModel.getInstance(), Arrays.asList("Ref", "IntDocNumber", "CostOnSite"));
        if (this.internetDocumentService.getInternetDocumentListProperties()) {

            // метод получения информации о возможности оплаты ИД [getSenderPaymentInfo]
            this.getSenderPaymentInfoService = new GetSenderPaymentInfoService(GetSenderPaymentInfoModel.getInstance(new String[]{properties.getProperty("IntDocNumber")}));
            if (this.getSenderPaymentInfoService.isSenderPaymentInfoTrue()) {

                // метод получения SID от ТАС [tlGetSid]
                this.tlGetSidService = new TlGetSidService(TlGetSidModel.getInstance(), Arrays.asList("Sid"));
                if (this.tlGetSidService.getTlGetSid_()) {

                    // метод получения DraftRef для оплаты в ТАС [CreateDraftPaymentOnSite]
                    this.createDraftPaymentOnSiteService = new CreateDraftPaymentOnSiteService(CreateDraftPaymentOnSiteModel.getInstance(new String[]{properties.getProperty("IntDocNumber")}), Arrays.asList("DraftRef"));
                    if (this.createDraftPaymentOnSiteService.getDraftRef()) {

                        // метод создания платежа и получения окончательного SID в ТАС [tlCreatePayment]
                        this.tlCreatePaymentService = new TlCreatePaymentService(TlCreatePaymentModel.getInstance(Arrays.asList(
                                properties.getProperty("DraftRef"),
                                properties.getProperty("IntDocNumber"),
                                properties.getProperty("Sid")
                        )),
                                Arrays.asList("Sid"));
                        if (this.tlCreatePaymentService.getDraftRef_()) {

                            // метод отправки данных в формате XML в ТАС [tlSendXML]
                            this.tlSendXMLService = new TlSendXMLService(TlSendXMLModel.getInstance(Arrays.asList(
                                    properties.getProperty("IntDocNumber"),
                                    properties.getProperty("Ref"),
                                    properties.getProperty("CostOnSite"),
                                    properties.getProperty("SidTas")
                            )));
                            if (this.tlSendXMLService.sendTlSendXMLModel()) {

                                // оплата https://e-dev.taslink.com.ua/novaposhta_api/?pay=${SID}
                                this.tasLinkService = new TasLinkService(TasLinkModel.getInstance(properties.getProperty("SidTas")));
                                if (this.tasLinkService.sendTasLinkRequest() == 200) {
                                    this.isCurentRequestTrue = true;
                                }
                            }
                        }
                    }
                }
            }
        } return this.isCurentRequestTrue;
    }

}