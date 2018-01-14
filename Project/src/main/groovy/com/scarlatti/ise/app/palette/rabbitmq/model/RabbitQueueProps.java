package com.scarlatti.ise.app.palette.rabbitmq.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.scarlatti.ise.app.scriptBuilder.model.json.ComponentProps;

import java.util.Objects;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 1/12/2018
 */
@JsonTypeName(RabbitQueueProps.COMPONENT_NAME)
public class RabbitQueueProps extends ComponentProps {
    private String address;
    private String vhost;
    private String queue;
    private String username;
    private String password;

    public static final String COMPONENT_NAME = "RABBIT_QUEUE";

    @Override
    public String componentType() {
        return COMPONENT_NAME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RabbitQueueProps that = (RabbitQueueProps) o;
        return Objects.equals(address, that.address) &&
            Objects.equals(vhost, that.vhost) &&
            Objects.equals(queue, that.queue) &&
            Objects.equals(username, that.username) &&
            Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, vhost, queue, username, password);
    }

    @Override
    public String toString() {
        return "RabbitQueueProps{" +
            "address='" + address + '\'' +
            ", vhost='" + vhost + '\'' +
            ", queue='" + queue + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            "} " + super.toString();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVhost() {
        return vhost;
    }

    public void setVhost(String vhost) {
        this.vhost = vhost;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
