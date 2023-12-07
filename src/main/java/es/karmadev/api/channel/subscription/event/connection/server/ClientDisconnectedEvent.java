package es.karmadev.api.channel.subscription.event.connection.server;

import es.karmadev.api.channel.com.remote.RemoteClient;
import es.karmadev.api.channel.subscription.event.NetworkEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

/**
 * This event gets fired whenever
 * a client decides to disconnect
 */
@AllArgsConstructor @Getter
public class ClientDisconnectedEvent implements NetworkEvent {

    private final @NonNull RemoteClient client;
}
