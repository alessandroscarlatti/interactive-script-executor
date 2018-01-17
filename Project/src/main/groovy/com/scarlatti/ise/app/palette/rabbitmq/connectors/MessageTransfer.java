package com.scarlatti.ise.app.palette.rabbitmq.connectors;

import com.scarlatti.ise.app.palette.rabbitmq.components.RabbitQueue;
import com.scarlatti.ise.app.scriptBuilder.model.ConnectorDefinition;
import com.scarlatti.ise.app.scriptBuilder.model.ISEConnector;
import com.scarlatti.ise.app.scriptBuilder.model.json.ConnectorProps;
import com.scarlatti.ise.app.scriptExecutor.model.ISEScriptContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
public class MessageTransfer extends ISEConnector {
    private MessageTransferProps props;
    private static final Logger log = LoggerFactory.getLogger(RabbitQueue.class);

    public MessageTransfer(MessageTransferProps props) {
        this.props = props;
    }

    @Override
    public String provideId() {
        return props.getId();
    }

    @Override
    public void registerConnector(ISEScriptContext context) {
        log.info("Registering component: " + this.provideId() + " " + this);

        context.registerSingletonConnnector(this);
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

    public static class DefaultConnectorDefinition extends ConnectorDefinition {
        @Override
        public ISEConnector provideConnector(ConnectorProps props) {
            return new MessageTransfer((MessageTransferProps)props);
        }

        @Override
        public String forType() {
            return MessageTransferProps.CONNECTOR_NAME;
        }
    }
}
