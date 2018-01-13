package com.scarlatti.ise.palette.rabbitmq.model.connectors;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.scarlatti.ise.scriptBuilder.model.json.ConnectorProps;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 1/12/2018
 */
@JsonTypeName(MessageTransferProps.CONNECTOR_NAME)
public class MessageTransferProps extends ConnectorProps {
    private String from;
    private String to;
    private Integer howMany;

    public static final String CONNECTOR_NAME = "RABBIT_MESSAGE_TRANSFER";

    @Override
    public String connectorType() {
        return CONNECTOR_NAME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageTransferProps that = (MessageTransferProps) o;

        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        if (to != null ? !to.equals(that.to) : that.to != null) return false;
        return howMany != null ? howMany.equals(that.howMany) : that.howMany == null;
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (howMany != null ? howMany.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MessageTransferProps{" +
            "from='" + from + '\'' +
            ", to='" + to + '\'' +
            ", howMany=" + howMany +
            ", id='" + id + '\'' +
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

    public Integer getHowMany() {
        return howMany;
    }

    public void setHowMany(Integer howMany) {
        this.howMany = howMany;
    }
}
