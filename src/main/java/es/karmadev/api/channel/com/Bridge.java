package es.karmadev.api.channel.com;

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

import es.karmadev.api.channel.com.remote.RemoteServer;
import es.karmadev.api.channel.data.BaseMessage;
import es.karmadev.api.channel.exception.NetException;

/**
 * Represents a direct bridge between
 * two connections through a channel.
 * The bridge can be used to directly
 * send data to another part of the
 * connection network.
 */
public interface Bridge {

    /**
     * Get the server currently
     * owning the bridge.
     *
     * @return the server
     */
    RemoteServer getServer();

    /**
     * Get the bridge creation issuer
     *
     * @return the bridge
     * issuer
     */
    Connection getIssuer();

    /**
     * Get the connection that receives
     * the data on this bridge
     *
     * @return the connection that receives
     * data
     */
    Connection getTarget();

    /**
     * Emit a message through the
     * bridge
     *
     * @param message the message to
     *                emit
     */
    void write(final BaseMessage message);

    /**
     * Close the bridge connection
     *
     * @throws NetException if there's a problem
     * while closing the connection
     */
    void close() throws NetException;
}
