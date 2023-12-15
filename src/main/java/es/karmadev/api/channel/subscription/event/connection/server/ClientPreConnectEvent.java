package es.karmadev.api.channel.subscription.event.connection.server;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.net.SocketAddress;

/**
 * This event gets fired when a client
 * starts the connection. During this,
 * the client is not ready to process data
 */
@AllArgsConstructor @Getter
public class ClientPreConnectEvent implements NetworkEvent {

    private final @NonNull SocketAddress address;
}
