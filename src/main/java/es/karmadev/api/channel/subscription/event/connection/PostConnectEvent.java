package es.karmadev.api.channel.subscription.event.connection;

import es.karmadev.api.channel.com.remote.RemoteServer;
import es.karmadev.api.channel.subscription.event.NetworkEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

/**
 * This event is fired exclusively before
 * a connection is completely made
 */
@Getter @AllArgsConstructor
public final class PostConnectEvent implements NetworkEvent {

    private final @NonNull RemoteServer server;
}
