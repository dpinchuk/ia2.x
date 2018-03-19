package models;

import org.codehaus.jackson.annotate.JsonProperty;

import static utils.Constants.*;

/**
 * Class of TlGetSid model
 */

public class TlGetSidModel {

    private String apiKey = API_KEY;
    private String modelName = MODEL_NAME[2];
    private String calledMethod = CALLED_METHOD[2];
    private MethodProperties methodProperties;

    private TlGetSidModel(MethodProperties methodProperties) {
        this.methodProperties = methodProperties;
    }

    private static final class MethodProperties {

        private String phone = SENDER_PHONE;
        private String merchant = MERCHANT[0];
        private String loyaltyCardNumber = LOYALTY_CARD_NUMBER[0];

        @JsonProperty("Phone")
        public String getPhone() {
            return phone;
        }

        @JsonProperty("Merchant")
        public String getMerchant() {
            return merchant;
        }

        @JsonProperty("LoyaltyCardNumber")
        public String getLoyaltyCardNumber() {
            return loyaltyCardNumber;
        }

    }

    public static TlGetSidModel getInstance() {
        return new TlGetSidModel(new MethodProperties());
    }

}