package com.crossbank.front;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import sun.security.validator.KeyStores;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Set;

/**
 * The entry point.
 * @author Dmitry Dobrynin
 * Created at 06.02.16 23:45.
 */
@SpringBootApplication
@Configuration
public class FrontApplication {
    Logger logger = LoggerFactory.getLogger(FrontApplication.class);
    @Autowired
    private RestTemplate client;
    @Autowired
    private AccountService accountService;
    @Value("${key-store-password}")
    private String keyStorePassword;

    public static void main(String[] args) {
        SpringApplication.run(FrontApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException, KeyManagementException {
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String s, SSLSession sslSession) { return true; }
        });
        TrustManager[] trustManager = new TrustManager[] {
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        try {
                            KeyStore store = KeyStore.getInstance("JKS");
                            store.load(getClass().getResourceAsStream("/crossbank.jks"), keyStorePassword.toCharArray());
                            Set<X509Certificate> trustedCerts = KeyStores.getTrustedCerts(store);
                            X509Certificate[] certificates = new X509Certificate[trustedCerts.size()];
                            trustedCerts.toArray(certificates);
                            return certificates;
                        } catch (Exception e) {
                            throw new IllegalArgumentException("Could not load trusted certificates!", e);
                        }
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType ) {}
                    public void checkServerTrusted( X509Certificate[] certs, String authType ) {}
                }
        };
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustManager, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        return new RestTemplate();
    }
}