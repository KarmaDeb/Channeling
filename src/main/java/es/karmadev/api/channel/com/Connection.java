package es.karmadev.api.channel.com;

import es.karmadev.api.channel.VirtualChannel;
import es.karmadev.api.channel.com.remote.RemoteServer;
import es.karmadev.api.channel.exception.NetException;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a connection on a
 * {@link VirtualChannel}
 */
public interface Connection {

    /**
     * Get the connection ID
     *
     * @return the connection ID
     */
    long getId();

    /**
     * Get the remote server
     *
     * @return the remote server
     */
    @Nullable
    RemoteServer getServer();

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
