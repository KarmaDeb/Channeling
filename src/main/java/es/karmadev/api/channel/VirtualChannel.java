package es.karmadev.api.channel;

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

import es.karmadev.api.channel.com.Remittent;
import es.karmadev.api.channel.data.BaseMessage;
import es.karmadev.api.channel.subscription.Subscriptor;

/**
 * Represents a channel between two or
 * more connections
 */
public interface VirtualChannel extends Subscriptor, Remittent {

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
