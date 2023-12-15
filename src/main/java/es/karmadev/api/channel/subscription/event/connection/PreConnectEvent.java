package es.karmadev.api.channel.subscription.event.connection;

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

import es.karmadev.api.channel.subscription.event.NetworkEvent;
import lombok.Getter;

import java.net.SocketAddress;
import java.util.Properties;

/**
 * This event is fired exclusively before
 * a connection is about to be performed
 */
@Getter
public final class PreConnectEvent implements NetworkEvent {

    private final SocketAddress address;
    private final Properties connectionProperties;

    /**
     * Initialize the event
     *
     * @param address the address that is starting the
     *                connection
     * @param properties the connection properties
     */
    public PreConnectEvent(final SocketAddress address, final Properties properties) {
        this.address = address;
        this.connectionProperties = properties;
    }
}
