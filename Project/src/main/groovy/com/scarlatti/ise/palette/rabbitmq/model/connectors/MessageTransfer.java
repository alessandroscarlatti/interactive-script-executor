package com.scarlatti.ise.palette.rabbitmq.model.connectors;

import com.scarlatti.ise.scriptBuilder.model.Connector;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
public class MessageTransfer extends Connector {
    private MessageTransferProps props;

    public MessageTransfer(MessageTransferProps props) {
        this.props = props;
    }

    @Override
    public String provideId() {
        return props.getId();
    }

    @Override
    public String toString() {
        return "MessageTransfer{" +
            "props=" + props +
            '}';
    }

    public MessageTransferProps getProps() {
        return props;
    }

    public void setProps(MessageTransferProps props) {
        this.props = props;
    }
}
