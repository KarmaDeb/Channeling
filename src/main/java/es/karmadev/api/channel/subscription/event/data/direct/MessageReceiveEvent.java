package es.karmadev.api.channel.subscription.event.data.direct;

/*
 * Copyright 2023 KarmaDev
 *
 * This file is part of Channels.
 *
 * Channels is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Channels is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Channels. If not, see <http://www.gnu.org/licenses/>.
 */

import es.karmadev.api.channel.data.BaseMessage;
import es.karmadev.api.channel.subscription.event.NetworkEvent;
import lombok.NonNull;

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
    public MessageReceiveEvent(final @NonNull BaseMessage message) {
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
