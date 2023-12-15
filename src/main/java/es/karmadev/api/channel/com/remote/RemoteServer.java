package es.karmadev.api.channel.com.remote;

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
import es.karmadev.api.channel.com.Bridge;
import es.karmadev.api.channel.data.BaseMessage;
import org.jetbrains.annotations.Nullable;

import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

/**
 * Represents a remote server
 */
public interface RemoteServer {

    /**
     * Get the server address
     *
     * @return the server address
     */
    SocketAddress getAddress();

    /**
     * Get a list of all the server available
     * channels
     *
     * @return the server available channels
     */
    Collection<String> getAvailableChannels();

    /**
     * Get all the channels the client
     * is currently connected to
     *
     * @return the channels the client
     * is connected to
     */
    Collection<? extends VirtualChannel> getChannels();

    /**
     * Get a channel that the current client
     * is connected to
     *
     * @param channel the channel name
     * @return the channel (if we are connected)
     */
    @Nullable
    VirtualChannel getChannel(final String channel);

    /**
     * Request access to a server channel
     *
     * @param channel the channel
     * @return the channel request
     */
    CompletableFuture<? extends VirtualChannel> joinChannel(final String channel);

    /**
     * Leave a channel
     *
     * @param channel the channel to leave
     */
    void leaveChannel(final String channel);

    /**
     * Create a bridge between the
     * current connected client and the
     * destination id
     *
     * @param clientId the client id to
     *                 create a bridge with
     * @return the resulting bridge
     */
    CompletableFuture<? extends Bridge> createBridge(final long clientId);

    /**
     * Write a message to the
     * server
     *
     * @param message the message to write
     */
    void write(final BaseMessage message);
}
