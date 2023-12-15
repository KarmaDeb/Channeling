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

import es.karmadev.api.channel.VirtualChannel;
import es.karmadev.api.channel.com.remote.RemoteServer;
import es.karmadev.api.channel.exception.NetException;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a connection on a
 * {@link VirtualChannel}
 */
public interface Connection extends Remittent {

    /**
     * Get the connection ID
     *
     * @return the connection ID
     */
    long getId();

    /**
     * Get the remote server
     *
     * @return the remote server
     */
    @Nullable
    RemoteServer getServer();

    /**
     * Tries to close the connection. Once this
     * method is called, the connection will get
     * closed even though {@link NetException exception} is
     * thrown.
     *
     * @throws NetException if there's a network
     * problem while closing the connection
     */
    void close() throws NetException;
}
