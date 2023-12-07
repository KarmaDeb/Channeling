package es.karmadev.api.channel.subscription.event.connection;

import es.karmadev.api.channel.subscription.event.NetworkEvent;
import lombok.Getter;

import java.net.SocketAddress;
import java.util.Properties;

/**
 * This event is fired exclusively before
 * a connection is about to be performed
 */
@Getter
public final class PreConnectEvent implements NetworkEvent {

    private final SocketAddress address;
    private final Properties connectionProperties;

    /**
     * Initialize the event
     *
     * @param address the address that is starting the
     *                connection
     * @param properties the connection properties
     */
    public PreConnectEvent(final SocketAddress address, final Properties properties) {
        this.address = address;
        this.connectionProperties = properties;
    }
}
