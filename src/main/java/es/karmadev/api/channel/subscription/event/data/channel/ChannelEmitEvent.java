package es.karmadev.api.channel.subscription.event.data.channel;

import es.karmadev.api.channel.VirtualChannel;
import es.karmadev.api.channel.data.BaseMessage;
import es.karmadev.api.channel.subscription.event.Cancellable;
import es.karmadev.api.channel.subscription.event.NetworkEvent;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * Channel message emit event
 */
public class ChannelEmitEvent implements NetworkEvent, Cancellable {

    @Getter
    private final VirtualChannel channel;
    private BaseMessage message;
    @Getter @Setter
    private boolean cancelled;

    /**
     * Initialize the event
     *
     * @param channel the channel in where the message
     *                will be sent
     * @param message the message that is being sent
     */
    public ChannelEmitEvent(final @NonNull VirtualChannel channel, final @NonNull BaseMessage message) {
        this.channel = channel;
        this.message = message.clone();
    }

    /**
     * Get the message
     *
     * @return the message
     */
    public BaseMessage getMessage() {
        return message.clone();
    }

    /**
     * Set the message
     *
     * @param message the message
     */
    public void setMessage(final @NonNull BaseMessage message) {
        this.message = message.clone();
    }
}
