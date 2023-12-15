package es.karmadev.api.channel.subscription;

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

import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents a channel subscription.
 * A subscription is nothing but a contract between
 * a connection and a channel, in where the channel
 * will notice the connection when a new message is
 * received under specific circumstances or vice-versa
 */
@Getter
public abstract class ChannelSubscription {

    private final long id = ThreadLocalRandom.current().nextLong();
}
