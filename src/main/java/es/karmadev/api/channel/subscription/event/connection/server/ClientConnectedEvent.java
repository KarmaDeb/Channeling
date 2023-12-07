package es.karmadev.api.channel.subscription.event.connection.server;

import es.karmadev.api.channel.com.remote.RemoteClient;
import es.karmadev.api.channel.subscription.event.NetworkEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

/**
 * This event gets fired when a
 * client is successfully connected. Meaning
 * data is ready to be sent through
 * him
 */
@AllArgsConstructor @Getter
public class ClientConnectedEvent implements NetworkEvent {

    private final @NonNull RemoteClient client;
}
