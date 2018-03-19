package senders;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import static org.apache.http.HttpHeaders.USER_AGENT;
import static utils.Constants.CHARSET;

/**
 * Class for create http-request and send it
 */

public final class Sender {

    private String urlAddress;
    private String jsonString;
    private HttpClient httpClient;
    private HttpPost httpPost;
    private HttpResponse httpResponse;
    private StringEntity entity;
    private String jsonAsString;

    public Sender(String urlAddress, String jsonString) {
        this.urlAddress = urlAddress;
        this.jsonString = jsonString;
    }

    public Sender(String urlAddress) {
        this.urlAddress = urlAddress;
    }

     // метод отправки POST-запроса с телом JSON
    public JsonObject sendApiRequest() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException, IOException {

        this.entity = new StringEntity(this.jsonString, ContentType.APPLICATION_FORM_URLENCODED);
        this.httpClient = HttpClientBuilder.create().build();
        this.httpPost = new HttpPost(this.urlAddress);
        this.httpPost.setEntity(this.entity);
        this.httpResponse = this.httpClient.execute(this.httpPost);
        this.jsonAsString = EntityUtils.toString(this.httpResponse.getEntity(), CHARSET);

        return new Gson().fromJson(this.jsonAsString, JsonObject.class);
    }

    // метод получения кода ответа от сервера на выполнение посоледнего этапа запроса на оплату
    public int sendGet() throws IOException {
        URL url = new URL(this.urlAddress);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        return connection.getResponseCode();
    }

}