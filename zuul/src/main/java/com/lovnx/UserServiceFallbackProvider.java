package com.lovnx;
 
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
 
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
 
@Component
public class UserServiceFallbackProvider implements ZuulFallbackProvider {
 
    @Override
    public String getRoute() {
        return "sendCodePlatformUserService";
    }
 
    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }
 
            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }
 
            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }
 
            @Override
            public void close() {
 
            }
 
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("sendCodePlatformUserService不可用".getBytes());
            }
 
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("text", "html", Charset.forName("UTF-8"));
                headers.setContentType(mt);
                return headers;
            }
        };
    }
}