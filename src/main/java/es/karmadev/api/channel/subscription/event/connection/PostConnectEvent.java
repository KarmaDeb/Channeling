package es.karmadev.api.channel.subscription.event.connection;

import es.karmadev.api.channel.com.IConnection;
import es.karmadev.api.channel.subscription.event.NetworkEvent;
import lombok.Getter;

import java.net.SocketAddress;

/**
 * This event is fired exclusively before
 * a connection is completely made
 */
@Getter
public final class PostConnectEvent implements NetworkEvent {

    private final SocketAddress address;
    private final IConnection connection;

    /**
     * Initialize the event
     *
     * @param address the address that is starting the
     *                connection
     */
    public PostConnectEvent(final SocketAddress address, final IConnection connection) {
        this.address = address;
        this.connection = connection;
    }
}
