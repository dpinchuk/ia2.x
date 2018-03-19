package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Interface of constants
 */

public interface Constants {

    String API_URL_ADDRESS = "http://webclient.sb.np.ua/data/get/container/";
    String TASLINK_URL = "https://e-dev.taslink.com.ua/novaposhta_api/";
    String JSON = "json/";
    String XML = "xml/";

    String API_KEY = "aa61ede9b6546ed07afe09f1854054ec";
    String[] MODEL_NAME = {"InternetDocument", "Payment", "PaymentGeneral"};
    String[] CALLED_METHOD = {"save", "getSenderPaymentInfo", "tlGetSid", "CreateDraftPaymentOnSite", "tlCreatePayment", "tlSendXML"};

    String PAYER_TYPE = "Sender";
    String[] PAYMENT_METHOD = {"Cash", "NonCash"};
    String DATE_TIME = String.valueOf((new SimpleDateFormat("dd.MM.yyyy")).format(new Date()));
    String[] CARGO_TYPE = {"Parcel", "Cargo", "Documents", "TiresWheels", "Pallet"};
    String VOLUME_GENERAL = "";
    String WEIGHT = "1";
    String[] SERVICE_TYPE = {"WarehouseDoors", "WarehouseWarehouse", "DoorsDoor", "DoorsWarehouse"};
    String SEATS_AMOUNT = "1";
    String DESCRIPTION = "1234567890";
    String COST = "1";

    String[] CITY_SENDER = {"8d5a980d-391c-11dd-90d9-001a92567626"};
    String SENDER = "47dd5d18-6c60-11e7-af9a-005056886752";
    String SENDER_ADDRESS = "1ec09d6a-e1c2-11e3-8c4a-0050568002cf";
    String CONTACT_SENDER = "480d1f06-6c60-11e7-af9a-005056886752";
    String SENDER_PHONE = "380675003746";

    String CITY_RECIPIENT = "8d5a980d-391c-11dd-90d9-001a92567626";
    String RECIPIENT = "481dbd47-6c60-11e7-af9a-005056886752";
    String RECIPIENT_ADDRESS = "1ec09d88-e1c2-11e3-8c4a-0050568002cf";
    String CONTACT_RECIPIENT = "0c89d76e-92d7-11e7-af9a-005056886752";
    String RECIPIENT_PHONE = "380674034972";

    String[] SYSTEM = {"MobileApp"};
    String[] LANGUAGE = {"uk", "ru", "en"};
    String[] MERCHANT = {"000000020000001"};
    String[] LOYALTY_CARD_NUMBER = {"50877878"};
    String[] PAYMENT_SYSTEM = {"98d779a7-bc88-4352-9093-c61137aa8b90"};
    String[] CARD_ALIAS = {"Карта Юры #7"};
    String[] LOYALTY_CARD_REF = {"500007506251"};
    String[] PREAUTHORIZATION_AMOUNT = {"35"};
    String[] P_TO_P_AMOUNT = {"0"};
    String[] OPERATION_TYPE = {"PaymentForServices"};

    String CHARSET = "UTF-8";
    int LIMIT = 30;
    int REQUEST_PER_SECOND = 30;

    String SUCCESS = "success";
    String ERROR = "false";
    String TRUE = "true";
    String SUCCESS_URL = "http://novaposhta.sb.np.ua/cardpay/Success";
    String ERROR_URL = "http://novaposhta.sb.np.ua/cardpay/Fail";
    String RECHNO = "1";

    String REGEX_REPLACE_QUOTES = "[\"]";
    String REGEX_REPLACE_QUOTES_BRACKETS = "[\\[\\]\"]";

}