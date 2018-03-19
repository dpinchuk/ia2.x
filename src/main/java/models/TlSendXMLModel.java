package models;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

import static utils.Constants.*;

/**
 * Class of TlSendXML model
 */

public final class TlSendXMLModel {

    private String apiKey = API_KEY;
    private String modelName = MODEL_NAME[1];
    private String calledMethod = CALLED_METHOD[5];
    private MethodProperties methodProperties;

    private TlSendXMLModel(MethodProperties methodProperties) {
        this.methodProperties = methodProperties;
    }

    private static final class MethodProperties {
        private Documents[] documents;

        private MethodProperties(Documents[] documents) {
            this.documents = documents;
        }

        @JsonProperty("Documents")
        public Documents[] getDdocuments() {
            return documents;
        }
    }

    private static final class Documents {
        private String barcode;
        private String documentRef;
        private String amountToPay;
        private String operationType = OPERATION_TYPE[0];
        private String sid;
        private String recno = RECHNO;

        private Documents(List<String> elements) {
            this.barcode = elements.get(0);
            this.documentRef = elements.get(1);
            this.amountToPay = elements.get(2);
            this.sid = elements.get(3);
        }

        @JsonProperty("Barcode")
        public String getBarcode() {
            return barcode;
        }

        @JsonProperty("DocumentRef")
        public String getDocumentRef() {
            return documentRef;
        }

        @JsonProperty("AmountToPay")
        public String getAmountToPay() {
            return amountToPay;
        }

        @JsonProperty("OperationType")
        public String getOperationType() {
            return operationType;
        }

        @JsonProperty("Sid")
        public String getSid() {
            return sid;
        }

        @JsonProperty("Recno")
        public String getRecno() {
            return recno;
        }

    }

    public static TlSendXMLModel getInstance(List<String> id) {
        return new TlSendXMLModel(new MethodProperties(new Documents[]{new Documents(id)}));
    }

}