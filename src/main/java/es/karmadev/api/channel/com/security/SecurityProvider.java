package es.karmadev.api.channel.com.security;

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

import java.security.Key;

/**
 * Represents a security
 * provider utilities
 */
public interface SecurityProvider {

    /**
     * Get the security provider
     * instance
     *
     * @param algorithm the algorithm to use
     *                  on the security provider
     * @return the security provider
     */
    static SecurityProvider getInstance(final String algorithm) {
        return new Provider(algorithm);
    }

    /**
     * Encode the data
     *
     * @param data the data to encode
     * @param key the key to use to encode
     *            the data
     * @return the encoded data
     */
    byte[] encodeData(final byte[] data, final Key key);

    /**
     * Decode the data
     *
     * @param data the data to decode
     * @param key the key to use to decode
     *            the data
     * @return the decoded data
     */
    byte[] decodeData(final byte[] data, final Key key);
}