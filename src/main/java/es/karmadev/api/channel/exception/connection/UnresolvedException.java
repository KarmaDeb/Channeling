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
import org.jetbrains.annotations.NotNull;

/**
 * The unresolved exception is thrown when
 * a socket address cannot be resolved.
 */
public class UnresolvedException extends NetException {

    /**
     * Initialize the exception
     *
     * @param address the address
     * @param port the port
     */
    public UnresolvedException(final @NotNull String address, final int port) {
        super(String.format("Cannot use address %s:%d. (Unresolved)", address, port));
    }
}
