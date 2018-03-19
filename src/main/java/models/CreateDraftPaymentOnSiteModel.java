package models;

import org.codehaus.jackson.annotate.JsonProperty;

import static utils.Constants.*;

/**
 * Class of CreateDraftPaymentOnSite model
 */

public class CreateDraftPaymentOnSiteModel {

    private String apiKey = API_KEY;
    private String modelName = MODEL_NAME[1];
    private String calledMethod = CALLED_METHOD[3];
    private MethodProperties methodProperties;

    private CreateDraftPaymentOnSiteModel(MethodProperties methodProperties) {
        this.methodProperties = methodProperties;
    }

    private static final class MethodProperties {

        private String[] documents;
        private String paymentSystem = PAYMENT_SYSTEM[0];

        private MethodProperties(String[] documents) {
            this.documents = documents;
        }

        @JsonProperty("Documents")
        public String[] getDocuments() {
            return documents;
        }

        @JsonProperty("PaymentSystem")
        public String getPaymentSystem() {
            return paymentSystem;
        }

    }

    public static CreateDraftPaymentOnSiteModel getInstance(String[] documents) {
        return new CreateDraftPaymentOnSiteModel(new MethodProperties(documents));
    }

}