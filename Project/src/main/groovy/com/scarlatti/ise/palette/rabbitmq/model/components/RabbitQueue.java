package com.scarlatti.ise.palette.rabbitmq.model.components;

import com.scarlatti.ise.scriptBuilder.model.Component;
import com.scarlatti.ise.scriptBuilder.model.Creation;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.List;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 1/13/2018
 */
public class RabbitQueue extends Component {
    private RabbitQueueProps props;

    public RabbitQueue(RabbitQueueProps props) {
        this.props = props;
    }

    @Override
    public String provideId() {
        return props.getId();
    }

    @Override
    public List<Creation> provideCreations(ConfigurableListableBeanFactory beanFactory) {
        return null;
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
}
