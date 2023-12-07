package es.karmadev.api.channel.subscription.event.data;

import es.karmadev.api.channel.data.BaseMessage;
import es.karmadev.api.channel.subscription.event.NetworkEvent;

/**
 * Message receive event
 */
public class MessageReceiveEvent implements NetworkEvent {

    private final BaseMessage message;

    /**
     * Initialize the event
     *
     * @param message the message
     */
    public MessageReceiveEvent(final BaseMessage message) {
       this.message = message;
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
