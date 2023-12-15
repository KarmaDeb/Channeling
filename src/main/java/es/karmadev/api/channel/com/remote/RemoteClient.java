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

import es.karmadev.api.channel.data.BaseMessage;

import java.net.SocketAddress;
import java.util.Properties;

/**
 * Represents a remote client
 */
public interface RemoteClient {

    /**
     * Get the client ID
     *
     * @return the client ID
     */
    long getId();

    /**
     * Get the client address
     *
     * @return the client address
     */
    SocketAddress getAddress();

    /**
     * Write a message directly
     * to the client
     *
     * @param message the message to write
     */
    void write(final BaseMessage message);

    /**
     * Disconnect the client from the
     * server, with the specified reason
     *
     * @param reason the disconnect reason
     */
    void disconnect(final String reason);

    /**
     * Get the remote client properties. Those
     * properties are only known by the server,
     * and are used by the server to store special
     * information that is not API-declared about
     * the client. For instance, those properties
     * could be used to store the remote client name
     * if implemented
     *
     * @return the client properties
     */
    Properties getProperties();
}
