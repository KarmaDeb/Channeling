package es.karmadev.api.channel.exception.connection;

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

import es.karmadev.api.channel.exception.NetException;

/**
 * This exception is thrown when an in-use
 * address is tried to be used on a connection
 */
public class BusyAddressException extends NetException {

    /**
     * Initialize the exception
     *
     * @param host the address
     * @param port the port
     */
    public BusyAddressException(final String host, final int port) {
        super(String.format("Failed to build connection. (Host %s:%d already in use)", host, port));
    }
}
