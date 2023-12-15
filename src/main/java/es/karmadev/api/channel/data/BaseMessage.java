package es.karmadev.api.channel.data;

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

import es.karmadev.api.kson.JsonInstance;
import org.jetbrains.annotations.Nullable;

/**
 * Base message. All messages must
 * be cloneable
 */
public interface BaseMessage extends Cloneable {

    /**
     * Get the message ID
     *
     * @return the message ID
     */
    long getId();

    /**
     * Get the full message
     *
     * @return the message
     */
    byte[] readAll();

    /**
     * Get the next byte array
     * from the message
     *
     * @return the byte array
     */
    @Nullable
    byte[] getBytes();

    /**
     * Get the next UTF
     * from the message
     *
     * @return the UTF
     */
    @Nullable
    String getUTF();

    /**
     * Get the next short
     * from the message
     *
     * @return the short
     */
    @Nullable
    Short getInt16();

    /**
     * Get the next integer
     * from the message
     *
     * @return the integer
     */
    @Nullable
    Integer getInt32();

    /**
     * Get the next long
     * from the message
     *
     * @return the long
     */
    @Nullable
    Long getInt64();

    /**
     * Get the next float
     * from the message
     *
     * @return the float
     */
    @Nullable
    Float getFloat32();

    /**
     * Get the next double
     * from the message
     *
     * @return the double
     */
    @Nullable
    Double getFloat64();

    /**
     * Get the next boolean from
     * the message
     *
     * @return the boolean
     */
    @Nullable
    Boolean getBoolean();

    /**
     * Get the next json data
     * from the message
     *
     * @return the json
     */
    @Nullable
    JsonInstance getJson();

    /**
     * Clone the message
     *
     * @return the cloned message
     */
    BaseMessage clone();
}
