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

import es.karmadev.api.channel.com.Bridge;
import es.karmadev.api.channel.com.remote.RemoteClient;
import es.karmadev.api.channel.data.BaseMessage;
import es.karmadev.api.channel.subscription.Subscriptor;
import org.jetbrains.annotations.Nullable;

import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

/**
 * Represents a server channel
 */
public interface Server extends Subscriptor {

    /**
     * Get the server ID
     *
     * @return the server ID
     */
    long getId();

    /**
     * Get the address of the server
     *
     * @return the server address
     */
    SocketAddress getAddress();

    /**
     * Get the server connected clients
     *
     * @return the server connected
     * clients
     */
    Collection<? extends RemoteClient> getClients();

    /**
     * Get a client by its ID
     *
     * @param id the ID to filter with
     * @return the client
     */
    @Nullable
    default RemoteClient getClient(final long id) {
        return getClients().stream().filter((cl) -> cl.getId() == id)
                .findAny().orElse(null);
    }

    /**
     * Get the server channels
     *
     * @return the server channels
     */
    Collection<? extends VirtualChannel> getChannels();

    /**
     * Get all the server bridges
     *
     * @return the server created
     * bridges
     */
    Collection<? extends Bridge> getBridges();

    /**
     * Create a new channel.
     *
     * @param name the channel name
     * @return the created channel
     */
    VirtualChannel createChannel(final String name);

    /**
     * Get an existing channel
     *
     * @param name the channel name
     * @return the channel
     */
    @Nullable
    default VirtualChannel getChannel(final String name) {
        return getChannels().stream().filter((ch) -> ch.getName().equalsIgnoreCase(name))
                .findAny().orElse(null);
    }

    /**
     * Write a message to all the clients. Unlike the
     * method {@link VirtualChannel#write(BaseMessage)} this
     * method sends the message to all the clients directly
     *
     * @param message the message to send
     */
    void broadcast(final BaseMessage message);

    /**
     * Get if the server is running
     *
     * @return if the server is
     * running
     */
    boolean isRunning();

    /**
     * Start the server
     *
     * @return if the server was started
     */
    CompletableFuture<Boolean> start();

    /**
     * Stop the server
     */
    void stop();
}
