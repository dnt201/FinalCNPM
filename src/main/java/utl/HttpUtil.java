package utl;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {

    private String value;

    public HttpUtil(String value) {
        this.value = value;
    }

    public <T> T toModel(Class<T> tClass) {
        try {
            return new ObjectMapper().readValue(value,tClass);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static HttpUtil of(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                sb.append(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new HttpUtil(sb.toString());
    }
}
