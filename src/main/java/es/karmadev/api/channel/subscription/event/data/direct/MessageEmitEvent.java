package es.karmadev.api.channel.subscription.event.data.direct;

import es.karmadev.api.channel.data.BaseMessage;
import es.karmadev.api.channel.subscription.event.Cancellable;
import es.karmadev.api.channel.subscription.event.NetworkEvent;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * This event represents when
 * a message is about to be sent
 */
public class MessageEmitEvent implements NetworkEvent, Cancellable {

    private BaseMessage message;
    @Getter @Setter
    private boolean cancelled;

    /**
     * Initialize the event
     *
     * @param message the message that is being sent
     */
    public MessageEmitEvent(final @NonNull BaseMessage message) {
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
