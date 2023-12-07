package es.karmadev.api.channel;

import es.karmadev.api.channel.data.BaseMessage;
import es.karmadev.api.channel.future.Future;
import es.karmadev.api.channel.subscription.AChannelSubscription;
import es.karmadev.api.channel.subscription.event.NetworkEvent;

import java.net.SocketAddress;
import java.util.Collection;

/**
 * Represents a server channel
 */
public interface IServer {

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
     * Get the server channels
     *
     * @return the server channels
     */
    Collection<? extends IChannel> getChannels();

    /**
     * Create a new channel.
     *
     * @param name the channel name
     * @return the created channel
     */
    IChannel createChannel(final String name);

    /**
     * Add a subscription to the client.
     *
     * @param subscription the subscription to add
     */
    void subscribe(final AChannelSubscription subscription);

    /**
     * Remove a subscriptor from the
     * client
     *
     * @param subscription the subscription
     */
    void unsubscribe(final AChannelSubscription subscription);

    /**
     * Handle an event for the client
     *
     * @param event the event to handle
     */
    void handle(final NetworkEvent event);

    /**
     * Write a message to all the clients. Unlike the
     * method {@link IChannel#write(BaseMessage)} this
     * method sends the message to all the clients directly
     *
     * @param message the message to send
     */
    void write(final BaseMessage message);

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
    Future start();

    /**
     * Stop the server
     */
    void stop();
}
