package tools;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static utils.Constants.*;

/**
 * Class of tools
 */

public class Tools {

    private Tools() {
    }

    // The method converts Object to JSON as string
    public static String parseObjectToJson(Object object) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        return objectMapper.writeValueAsString(object);
    }

    // The method takes a JSON as string and collection List<String> as params and returns Ptoperties. Used replaceAll(regex)
    public static Properties getPropertiesFromJSON(String jsonString, List<String> paramList) throws IOException {
        Properties properties = new Properties();
        String string;
        for (String param : paramList) {
            string = new ObjectMapper().readTree(jsonString).findValues(param).toString().replaceAll(REGEX_REPLACE_QUOTES_BRACKETS, "");
            properties.setProperty(param, string);
        }
        return properties;
    }

    // The method takes a JSON as string and collection List<String> as params and returns string. Used replaceAll(regex)
    public static String getParamValueFromList(String jsonString, String param) throws IOException {
        return new ObjectMapper().readTree(jsonString).findValues(param).get(0).toString().replaceAll(REGEX_REPLACE_QUOTES, "");
    }

}