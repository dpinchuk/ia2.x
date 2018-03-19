package models;

import org.codehaus.jackson.annotate.JsonProperty;

import static utils.Constants.*;

/**
 * Class of InternetDocument model
 */

public final class InternetDocumentModel {

    private String apiKey = API_KEY;
    private String modelName = MODEL_NAME[0];
    private String calledMethod = CALLED_METHOD[0];
    private MethodProperties methodProperties;

    private InternetDocumentModel(MethodProperties methodProperties) {
        this.methodProperties = methodProperties;
    }

    private static final class MethodProperties {

        private String payerType = PAYER_TYPE;
        private String paymentMethod = PAYMENT_METHOD[0];
        private String dateTime = DATE_TIME;
        private String cargoType = CARGO_TYPE[0];
        private String volumeGeneral = VOLUME_GENERAL;
        private String weight = WEIGHT;
        private String serviceType = SERVICE_TYPE[0];
        private String seatsAmount = SEATS_AMOUNT;
        private String description = DESCRIPTION;
        private String cost = COST;

        private String citySender = CITY_SENDER[0];
        private String sender = SENDER;
        private String senderAddress = SENDER_ADDRESS;
        private String contactSender = CONTACT_SENDER;
        private String sendersPhone = SENDER_PHONE;

        private String cityRecipient = CITY_RECIPIENT;
        private String recipient = RECIPIENT;
        private String recipientAddress = RECIPIENT_ADDRESS;
        private String contactRecipient = CONTACT_RECIPIENT;
        private String recipientsPhone = RECIPIENT_PHONE;

        @JsonProperty("PayerType")
        public String getPayerType() {
            return payerType;
        }

        @JsonProperty("PaymentMethod")
        public String getpaymentMethod() {
            return paymentMethod;
        }

        @JsonProperty("DateTime")
        public String getDateTime() {
            return dateTime;
        }

        @JsonProperty("CargoType")
        public String getCargoType() {
            return cargoType;
        }

        @JsonProperty("VolumeGeneral")
        public String getVolumeGeneral() {
            return volumeGeneral;
        }

        @JsonProperty("Weight")
        public String getWeight() {
            return weight;
        }

        @JsonProperty("ServiceType")
        public String getServiceType() {
            return serviceType;
        }

        @JsonProperty("SeatsAmount")
        public String getSeatsAmount() {
            return seatsAmount;
        }

        @JsonProperty("Description")
        public String getDescription() {
            return description;
        }

        @JsonProperty("Cost")
        public String getCost() {
            return cost;
        }

        @JsonProperty("CitySender")
        public String getCitySender() {
            return citySender;
        }

        @JsonProperty("Sender")
        public String getSender() {
            return sender;
        }

        @JsonProperty("SenderAddress")
        public String getSenderAddress() {
            return senderAddress;
        }

        @JsonProperty("ContactSender")
        public String getContactSender() {
            return contactSender;
        }

        @JsonProperty("SendersPhone")
        public String getSendersPhone() {
            return sendersPhone;
        }

        @JsonProperty("CityRecipient")
        public String getCityRecipient() {
            return cityRecipient;
        }

        @JsonProperty("Recipient")
        public String getRecipient() {
            return recipient;
        }

        @JsonProperty("RecipientAddress")
        public String getRecipientAddress() {
            return recipientAddress;
        }

        @JsonProperty("ContactRecipient")
        public String getContactRecipient() {
            return contactRecipient;
        }

        @JsonProperty("RecipientsPhone")
        public String getRecipientsPhone() {
            return recipientsPhone;
        }
    }

    public static InternetDocumentModel getInstance() {
        return new InternetDocumentModel(new MethodProperties());
    }

}