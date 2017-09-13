package com.lognex.api.endpoint;

import com.lognex.api.API;
import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;

@Slf4j
public abstract class BaseEndpoint {

    protected String executeGet(final String httpsUrl, final API.RequestBuilder rb) {
        String ret = "";

        URL url;
        try {


            HttpsURLConnection con;
            url = new URL(httpsUrl);

            con = (HttpsURLConnection) url.openConnection();
            Authenticator authenticator = new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return (new PasswordAuthentication(rb.login(), rb.password().toCharArray()));
                }
            };
            Authenticator.setDefault(authenticator);

            InputStream in = con.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder result = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null) {
                result.append(line);
            }
            ret = result.toString();
        } catch (IOException e) {
            log.error("Error: ", e);
        }

        return ret;
    }
}