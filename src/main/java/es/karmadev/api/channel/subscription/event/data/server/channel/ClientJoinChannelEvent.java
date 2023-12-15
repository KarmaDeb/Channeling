package es.karmadev.api.channel.subscription.event.data.server.channel;

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

import es.karmadev.api.channel.VirtualChannel;
import es.karmadev.api.channel.com.remote.RemoteClient;
import es.karmadev.api.channel.data.BaseMessage;
import es.karmadev.api.channel.subscription.event.Cancellable;
import es.karmadev.api.channel.subscription.event.NetworkEvent;
import lombok.Getter;
import lombok.Setter;

/**
 * This event gets fired when a
 * remote client joins a channel
 */
@Getter
public class ClientJoinChannelEvent implements NetworkEvent, Cancellable {

    private final RemoteClient client;
    private final VirtualChannel channel;
    private final BaseMessage message;

    @Setter
    private boolean cancelled;

    /**
     * Initialize the event
     *
     * @param client the client joining the channel
     * @param channel the channel the client is joining
     * @param message the message used to join the channel
     */
    public ClientJoinChannelEvent(final RemoteClient client, final VirtualChannel channel, final BaseMessage message) {
        this.client = client;
        this.channel = channel;
        this.message = message.clone();
    }

    /**
     * Get the message used to join
     * the channel
     *
     * @return the join message
     *
     *
     */
    public BaseMessage getMessage() {
        return this.message.clone();
    }
}
