package com.scarlatti.ise.rabbitmq.model.components;

import com.scarlatti.ise.scriptBuilder.model.Component;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 1/12/2018
 */
public class RabbitQueue extends Component {
    private String address;
    private String vhost;
    private String queue;
    private String username;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RabbitQueue that = (RabbitQueue) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (vhost != null ? !vhost.equals(that.vhost) : that.vhost != null) return false;
        if (queue != null ? !queue.equals(that.queue) : that.queue != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        return password != null ? password.equals(that.password) : that.password == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (vhost != null ? vhost.hashCode() : 0);
        result = 31 * result + (queue != null ? queue.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RabbitQueue{" +
            "id='" + id + '\'' +
            ", address='" + address + '\'' +
            ", vhost='" + vhost + '\'' +
            ", queue='" + queue + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", id='" + id + '\'' +
            '}';
    }
}
