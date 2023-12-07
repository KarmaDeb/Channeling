package es.karmadev.api.channel.com.remote;

import es.karmadev.api.channel.future.Future;

import java.net.SocketAddress;

/**
 * Represents a remote server
 */
public interface IRemoteServer {

    /**
     * Get the server address
     *
     * @return the server address
     */
    SocketAddress getAddress();

    /**
     * Request access to a server channel
     *
     * @param channelId the channel id
     * @return the channel request
     */
    Future joinChannel(final long channelId);

    /**
     * Leave a channel
     *
     * @param channelId the channel id to leave
     */
    void leaveChannel(final long channelId);
}
