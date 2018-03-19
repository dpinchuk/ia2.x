package models;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

import static utils.Constants.*;

/**
 * Class of TlCreatePayment model
 */

public final class TlCreatePaymentModel {

    private String apiKey = API_KEY;
    private String modelName = MODEL_NAME[1];
    private String calledMethod = CALLED_METHOD[4];
    private MethodProperties methodProperties;

    private TlCreatePaymentModel(MethodProperties methodProperties) {
        this.methodProperties = methodProperties;
    }

    private static final class MethodProperties {

        private String preauthorizationAmount = PREAUTHORIZATION_AMOUNT[0];
        private String pToPAmount = P_TO_P_AMOUNT[0];
        private String transactionId;
        private String orderDescription;
        private String masterPassSessionId;
        private String cardAlias = CARD_ALIAS[0];
        private String loyaltyCardRef = LOYALTY_CARD_REF[0];
        private String loyaltyCardNumber = LOYALTY_CARD_NUMBER[0];
        private String phone = SENDER_PHONE;
        private String successUrl = SUCCESS_URL;
        private String errorUrl = ERROR_URL;

        private MethodProperties(String transactionId, String orderDescription, String masterPassSessionId) {
            this.transactionId = transactionId;
            this.orderDescription = orderDescription;
            this.masterPassSessionId = masterPassSessionId;
        }

        @JsonProperty("PreauthorizationAmount")
        public String getPreauthorizationAmount() {
            return preauthorizationAmount;
        }

        @JsonProperty("PToPAmount")
        public String getPToPAmount() {
            return pToPAmount;
        }

        @JsonProperty("TransactionId")
        public String getTransactionId() {
            return transactionId;
        }

        @JsonProperty("OrderDescription")
        public String getOrderDescription() {
            return orderDescription;
        }

        @JsonProperty("MasterPassSessionId")
        public String getMasterPassSessionId() {
            return masterPassSessionId;
        }

        @JsonProperty("CardAlias")
        public String getCardAlias() {
            return cardAlias;
        }

        @JsonProperty("LoyaltyCardRef")
        public String getLoyaltyCardRef() {
            return loyaltyCardRef;
        }

        @JsonProperty("LoyaltyCardNumber")
        public String getLoyaltyCardNumber() {
            return loyaltyCardNumber;
        }

        @JsonProperty("Phone")
        public String getPhone() {
            return phone;
        }

        @JsonProperty("SuccessUrl")
        public String getSuccessUrl() {
            return successUrl;
        }

        @JsonProperty("ErrorUrl")
        public String getErrorUrl() {
            return errorUrl;
        }

    }

    public static TlCreatePaymentModel getInstance(List<String> id) {
        return new TlCreatePaymentModel(new MethodProperties(
                id.get(0),
                id.get(1),
                id.get(2)
        ));
    }

}