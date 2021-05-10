package shop.cloud.product.configuration;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServerConfig implements ApplicationListener<WebServerInitializedEvent> {

    private WebServer server;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        server = event.getWebServer();
    }

    public WebServer getServer() {
        return server;
    }
}
