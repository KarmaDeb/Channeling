package es.karmadev.api.channel;

import es.karmadev.api.channel.data.BaseMessage;
import es.karmadev.api.channel.subscription.Subscriptor;

/**
 * Represents a channel between two or
 * more connections
 */
public interface VirtualChannel extends Subscriptor {

    /**
     * Get the channel name
     *
     * @return the channel name
     */
    String getName();

    /**
     * Write a message to the clients
     * connected on the channel
     *
     * @param message the channel to send
     */
    void write(final BaseMessage message);
}
