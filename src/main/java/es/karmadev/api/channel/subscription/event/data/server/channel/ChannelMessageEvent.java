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
import lombok.NonNull;
import lombok.Setter;

/**
 * Channel message emit event
 */
public class ChannelMessageEvent implements NetworkEvent, Cancellable {

    @Getter
    private final VirtualChannel channel;
    @Getter
    private final RemoteClient sender;

    private BaseMessage message;
    @Getter @Setter
    private boolean cancelled;

    /**
     * Initialize the event
     *
     * @param sender the message sender
     * @param channel the channel in where the
     *                message is being sent
     * @param message the message that is being sent
     */
    public ChannelMessageEvent(final @NonNull VirtualChannel channel, final @NonNull RemoteClient sender, final @NonNull BaseMessage message) {
        this.channel = channel;
        this.sender = sender;
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
