package es.karmadev.api.channel.subscription.event.data.server;

import es.karmadev.api.channel.data.BaseMessage;
import es.karmadev.api.channel.subscription.event.Cancellable;
import es.karmadev.api.channel.subscription.event.NetworkEvent;
import lombok.Getter;
import lombok.Setter;

/**
 * This event gets fired
 * when the server broadcasts a
 * message
 */
@Getter
public class MessageBroadcastEvent implements NetworkEvent, Cancellable {

    private final BaseMessage message;
    @Setter
    private boolean cancelled;

    /**
     * Initialize the event
     *
     * @param message the message
     */
    public MessageBroadcastEvent(final BaseMessage message) {
        this.message = message.clone();
    }
}
