package es.karmadev.api.channel.com.remote;

import es.karmadev.api.channel.VirtualChannel;
import es.karmadev.api.channel.com.Bridge;
import es.karmadev.api.channel.data.BaseMessage;
import org.jetbrains.annotations.Nullable;

import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

/**
 * Represents a remote server
 */
public interface RemoteServer {

    /**
     * Get the server address
     *
     * @return the server address
     */
    SocketAddress getAddress();

    /**
     * Get all the channels the client
     * is currently connected to
     *
     * @return the channels the client
     * is connected to
     */
    Collection<? extends VirtualChannel> getChannels();

    /**
     * Get a channel that the current client
     * is connected to
     *
     * @param channel the channel name
     * @return the channel (if we are connected)
     */
    @Nullable
    VirtualChannel getChannel(final String channel);

    /**
     * Request access to a server channel
     *
     * @param channel the channel
     * @return the channel request
     */
    CompletableFuture<VirtualChannel> joinChannel(final String channel);

    /**
     * Leave a channel
     *
     * @param channel the channel to leave
     */
    void leaveChannel(final String channel);

    /**
     * Create a bridge between the
     * current connected client and the
     * destination id
     *
     * @param clientId the client id to
     *                 create a bridge with
     * @return the resulting bridge
     */
    CompletableFuture<Bridge> createBridge(final long clientId);

    /**
     * Write a message to the
     * server
     *
     * @param message the message to write
     */
    void write(final BaseMessage message);
}
