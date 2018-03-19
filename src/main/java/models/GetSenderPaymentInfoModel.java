package models;

import org.codehaus.jackson.annotate.JsonProperty;

import static utils.Constants.*;

/**
 * Class of GetSenderPaymentInfo model
 */

public class GetSenderPaymentInfoModel {

    private String apiKey = API_KEY;
    private String system = SYSTEM[0];
    private String modelName = MODEL_NAME[1];
    private String calledMethod = CALLED_METHOD[1];
    private MethodProperties methodProperties;

    private GetSenderPaymentInfoModel(MethodProperties methodProperties) {
        this.methodProperties = methodProperties;
    }

    private static final class MethodProperties {

        private String language = LANGUAGE[0];
        private String[] documents;

        private MethodProperties(String[] documents) {
            this.documents = documents;
        }

        @JsonProperty("Language")
        public String getLanguage() {
            return language;
        }

        @JsonProperty("Documents")
        public String[] getDocuments() {
            return documents;
        }

    }

    public static GetSenderPaymentInfoModel getInstance(String[] documents) {
        return new GetSenderPaymentInfoModel(new MethodProperties(documents));
    }

}