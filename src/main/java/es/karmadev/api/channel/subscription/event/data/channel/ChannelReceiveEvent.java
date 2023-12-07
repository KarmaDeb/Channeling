package es.karmadev.api.channel.subscription.event.data.channel;

import es.karmadev.api.channel.VirtualChannel;
import es.karmadev.api.channel.data.BaseMessage;
import es.karmadev.api.channel.subscription.event.NetworkEvent;
import lombok.Getter;
import lombok.NonNull;

/**
 * Channel message receive event
 */
public class ChannelReceiveEvent implements NetworkEvent {

    @Getter
    private final VirtualChannel channel;
    private final BaseMessage message;

    /**
     * Initialize the event
     *
     * @param channel the channel in where
     *                the message has been received
     * @param message the message
     */
    public ChannelReceiveEvent(final @NonNull VirtualChannel channel, final @NonNull BaseMessage message) {
        this.channel = channel;
        this.message = message.clone();
    }

    /**
     * Get the received message
     *
     * @return the received message
     */
    public BaseMessage getMessage() {
        return message.clone();
    }
}
