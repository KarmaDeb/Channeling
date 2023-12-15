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

import es.karmadev.api.channel.com.Connection;
import es.karmadev.api.channel.com.remote.RemoteServer;
import es.karmadev.api.channel.subscription.Subscriptor;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.CompletableFuture;

/**
 * Represents a client.
 * A client also represents a connection
 */
public interface Client extends Subscriptor, Connection {

    /**
     * Connect the client to a server
     *
     * @param address the server address
     * @param port the server port
     * @return the connection task
     */
    default CompletableFuture<? extends RemoteServer> connect(final String address, final int port) {
        InetSocketAddress sa = new InetSocketAddress(address, port);
        return connect(sa, true);
    }

    /**
     * Connect the client to a server
     *
     * @param address the server address
     * @return the connection task
     */
    default CompletableFuture<? extends RemoteServer> connect(final SocketAddress address) {
        return connect(address, true);
    }

    /**
     * Connect the client to a server
     *
     * @param address the server address
     * @param port the server port
     * @param bridge if the connection supports
     *               bridging
     * @return the connection task
     */
    default CompletableFuture<? extends RemoteServer> connect(final String address, final int port, final boolean bridge) {
        InetSocketAddress sa = new InetSocketAddress(address, port);
        return connect(sa, bridge);
    }

    /**
     * Connect the client to a server
     *
     * @param address the server address
     * @param bridge if the connection supports
     *               bridging
     * @return the connection task
     */
    CompletableFuture<? extends RemoteServer> connect(final SocketAddress address, final boolean bridge);

    /**
     * Get if the client is connected
     *
     * @return the client connection
     * status
     */
    boolean isConnected();

    /**
     * Get if the connection supports bridging.
     * Bridging allows two connections to be
     * directly connected through a virtual channel
     *
     * @return if the connection supports bridging
     */
    boolean supportsBridging();
}
