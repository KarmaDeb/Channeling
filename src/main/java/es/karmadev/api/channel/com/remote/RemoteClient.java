package es.karmadev.api.channel.com.remote;

import es.karmadev.api.channel.data.BaseMessage;

import java.net.SocketAddress;
import java.util.Properties;

/**
 * Represents a remote client
 */
public interface RemoteClient {

    /**
     * Get the client ID
     *
     * @return the client ID
     */
    long getId();

    /**
     * Get the client address
     *
     * @return the client address
     */
    SocketAddress getAddress();

    /**
     * Write a message directly
     * to the client
     *
     * @param message the message to write
     */
    void write(final BaseMessage message);

    /**
     * Disconnect the client from the
     * server, with the specified reason
     *
     * @param reason the disconnect reason
     */
    void disconnect(final String reason);

    /**
     * Get the remote client properties. Those
     * properties are only known by the server,
     * and are used by the server to store special
     * information that is not API-declared about
     * the client. For instance, those properties
     * could be used to store the remote client name
     * if implemented
     *
     * @return the client properties
     */
    Properties getProperties();
}
