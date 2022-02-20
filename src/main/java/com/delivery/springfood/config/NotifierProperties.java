package com.delivery.springfood.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("notifier.email")
public class NotifierProperties {

    /**
     * Host do servidor de email
     */
    private String hostServer;

    /**
     * Porta do servidor de email
     */
    private Integer portServer;

    public String getHostServer() {
        return hostServer;
    }

    public void setHostServer(String hostServer) {
        this.hostServer = hostServer;
    }

    public Integer getPortServer() {
        return portServer;
    }

    public void setPortServer(Integer portServer) {
        this.portServer = portServer;
    }
}
