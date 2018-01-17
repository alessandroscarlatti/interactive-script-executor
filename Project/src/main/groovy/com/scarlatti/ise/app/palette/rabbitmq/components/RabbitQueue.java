package com.scarlatti.ise.app.palette.rabbitmq.components;

import com.scarlatti.ise.app.scriptBuilder.model.ComponentDefinition;
import com.scarlatti.ise.app.scriptBuilder.model.Creation;
import com.scarlatti.ise.app.scriptBuilder.model.ISEComponent;
import com.scarlatti.ise.app.scriptBuilder.model.json.ComponentProps;
import com.scarlatti.ise.app.scriptExecutor.model.ISEScriptContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.List;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
public class RabbitQueue extends ISEComponent{
    private RabbitQueueProps props;
    private static final Logger log = LoggerFactory.getLogger(RabbitQueue.class);

    public RabbitQueue(RabbitQueueProps props) {
        this.props = props;
    }

    @Override
    public String provideId() {
        return props.getId();
    }

    @Override
    public List<Creation> provideCreations(ConfigurableListableBeanFactory beanFactory) {

        // TODO I don't think I'm using this...
        return null;
    }

    @Override
    public void registerComponent(ISEScriptContext context) {
        log.info("Registering component: " + this.provideId() + " " + this);

        ConnectionFactory connectionFactory = new ISERabbitConnectionFactory(props);
        context.registerSingletonObject("connectionFactory-" + props.getId(), connectionFactory);

        RabbitTemplate rabbitTemplate = new ISERabbitTemplate(connectionFactory, props);
        context.registerSingletonObject("rabbitTemplate-" + rabbitTemplate);
    }

    public RabbitQueueProps getProps() {
        return props;
    }

    public void setProps(RabbitQueueProps props) {
        this.props = props;
    }

    @Override
    public String toString() {
        return "RabbitQueue{" +
            "props=" + props +
            '}';
    }

    public static class ISERabbitConnectionFactory extends CachingConnectionFactory {
        public ISERabbitConnectionFactory(RabbitQueueProps props) {
            super();

            if (props == null) throw new IllegalStateException("ISERabbitConnectionFactory may not accept null RabbitQueueProps");

            this.setAddresses(props.getAddress());
            this.setVirtualHost(props.getVhost());
            this.setUsername(props.getUsername());
            this.setPassword(props.getPassword());
        }
    }

    public static class ISERabbitTemplate extends RabbitTemplate {
        public ISERabbitTemplate(ConnectionFactory connectionFactory, RabbitQueueProps props) {
            super();

            if (props == null) throw new IllegalStateException("ISERabbitTemplate may not accept null RabbitQueueProps");

            this.setQueue(props.getQueue());
            this.setConnectionFactory(connectionFactory);
        }
    }

    public static class DefaultComponentDefinition extends ComponentDefinition {
        @Override
        public String forType() {
            return RabbitQueueProps.COMPONENT_NAME;
        }

        @Override
        public ISEComponent provideComponent(ComponentProps props) {
            return new RabbitQueue((RabbitQueueProps)props);
        }
    }
}
