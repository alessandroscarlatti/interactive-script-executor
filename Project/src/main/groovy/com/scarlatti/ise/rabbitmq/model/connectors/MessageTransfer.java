package com.scarlatti.ise.rabbitmq.model.connectors;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.scarlatti.ise.scriptBuilder.model.Connector;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 1/12/2018
 */
@JsonTypeName("RABBIT_MESSAGE_TRANSFER")
public class MessageTransfer extends Connector {
    private String from;
    private String to;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageTransfer that = (MessageTransfer) o;

        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        return to != null ? to.equals(that.to) : that.to == null;
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MessageTransfer{" +
            "from='" + from + '\'' +
            ", to='" + to + '\'' +
            '}';
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
