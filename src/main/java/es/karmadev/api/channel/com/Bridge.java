package es.karmadev.api.channel.com;

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
