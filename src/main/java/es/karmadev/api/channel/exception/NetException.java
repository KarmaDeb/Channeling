package es.karmadev.api.channel.exception;

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

/**
 * Represents a generic network exception.
 * The amount of exceptions that can be thrown
 * of this type are infinite
 */
public class NetException extends Exception {

    /**
     * Initializes the network exception
     *
     * @param message the message
     */
    protected NetException(final String message) {
        super(message);
    }

    /**
     * Initialize the network exception
     *
     * @param error the error that caused this
     *              issue
     */
    protected NetException(final Throwable error) {
        super(error);
    }

    /**
     * Initializes the network exception
     *
     * @param message the message
     * @param other the exception that caused this
     *              issue
     */
    protected NetException(final String message, final Throwable other) {
        super(message, other);
    }
}
