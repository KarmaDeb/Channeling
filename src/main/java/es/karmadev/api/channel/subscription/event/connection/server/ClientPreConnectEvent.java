package es.karmadev.api.channel.subscription.event.connection.server;

import es.karmadev.api.channel.subscription.event.NetworkEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.net.SocketAddress;

/**
 * This event gets fired when a client
 * starts the connection. During this,
 * the client is not ready to process data
 */
@AllArgsConstructor @Getter
public class ClientPreConnectEvent implements NetworkEvent {

    private final @NonNull SocketAddress address;
}
