package es.karmadev.api.channel;

import es.karmadev.api.channel.com.Bridge;
import es.karmadev.api.channel.com.remote.RemoteClient;
import es.karmadev.api.channel.data.BaseMessage;
import es.karmadev.api.channel.subscription.Subscriptor;
import org.jetbrains.annotations.Nullable;

import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

/**
 * Represents a server channel
 */
public interface Server extends Subscriptor {

    /**
     * Get the server ID
     *
     * @return the server ID
     */
    long getId();

    /**
     * Get the address of the server
     *
     * @return the server address
     */
    SocketAddress getAddress();

    /**
     * Get the server connected clients
     *
     * @return the server connected
     * clients
     */
    Collection<? extends RemoteClient> getClients();

    /**
     * Get a client by its ID
     *
     * @param id the ID to filter with
     * @return the client
     */
    @Nullable
    default RemoteClient getClient(final long id) {
        return getClients().stream().filter((cl) -> cl.getId() == id)
                .findAny().orElse(null);
    }

    /**
     * Get the server channels
     *
     * @return the server channels
     */
    Collection<? extends VirtualChannel> getChannels();

    /**
     * Get all the server bridges
     *
     * @return the server created
     * bridges
     */
    Collection<? extends Bridge> getBridges();

    /**
     * Create a new channel.
     *
     * @param name the channel name
     * @return the created channel
     */
    VirtualChannel createChannel(final String name);

    /**
     * Get an existing channel
     *
     * @param name the channel name
     * @return the channel
     */
    @Nullable
    default VirtualChannel getChannel(final String name) {
        return getChannels().stream().filter((ch) -> ch.getName().equalsIgnoreCase(name))
                .findAny().orElse(null);
    }

    /**
     * Write a message to all the clients. Unlike the
     * method {@link VirtualChannel#write(BaseMessage)} this
     * method sends the message to all the clients directly
     *
     * @param message the message to send
     */
    void broadcast(final BaseMessage message);

    /**
     * Get if the server is running
     *
     * @return if the server is
     * running
     */
    boolean isRunning();

    /**
     * Start the server
     *
     * @return if the server was started
     */
    CompletableFuture<Boolean> start();

    /**
     * Stop the server
     */
    void stop();
}
