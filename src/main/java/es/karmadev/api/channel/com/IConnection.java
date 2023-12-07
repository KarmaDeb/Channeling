package es.karmadev.api.channel.com;

import es.karmadev.api.channel.com.remote.IRemoteServer;
import es.karmadev.api.channel.data.BaseMessage;
import es.karmadev.api.channel.exception.NetException;

/**
 * Represents a connection on a
 * {@link es.karmadev.api.channel.IChannel}
 */
public interface IConnection {

    /**
     * Write a message on the connection
     *
     * @param message the message to write
     */
    void write(final BaseMessage message);

    /**
     * Get the remote server
     *
     * @return the remote server
     */
    IRemoteServer getServer();

    /**
     * Tries to close the connection. Once this
     * method is called, the connection will get
     * closed even though {@link NetException exception} is
     * thrown.
     *
     * @throws NetException if there's a network
     * problem while closing the connection
     */
    void close() throws NetException;
}
