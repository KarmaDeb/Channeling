package es.karmadev.api.channel;

import es.karmadev.api.channel.com.Connection;
import es.karmadev.api.channel.com.remote.RemoteServer;
import es.karmadev.api.channel.subscription.Subscriptor;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.CompletableFuture;

/**
 * Represents a client.
 * A client also represents a connection
 */
public interface Client extends Subscriptor, Connection {

    /**
     * Connect the client to a server
     *
     * @param address the server address
     * @param port the server port
     * @return the connection task
     */
    default CompletableFuture<RemoteServer> connect(final String address, final int port) {
        InetSocketAddress sa = new InetSocketAddress(address, port);
        return connect(sa, true);
    }

    /**
     * Connect the client to a server
     *
     * @param address the server address
     * @return the connection task
     */
    default CompletableFuture<RemoteServer> connect(final SocketAddress address) {
        return connect(address, true);
    }

    /**
     * Connect the client to a server
     *
     * @param address the server address
     * @param port the server port
     * @param bridge if the connection supports
     *               bridging
     * @return the connection task
     */
    default CompletableFuture<RemoteServer> connect(final String address, final int port, final boolean bridge) {
        InetSocketAddress sa = new InetSocketAddress(address, port);
        return connect(sa, bridge);
    }

    /**
     * Connect the client to a server
     *
     * @param address the server address
     * @param bridge if the connection supports
     *               bridging
     * @return the connection task
     */
    CompletableFuture<RemoteServer> connect(final SocketAddress address, final boolean bridge);

    /**
     * Get if the client is connected
     *
     * @return the client connection
     * status
     */
    boolean isConnected();

    /**
     * Get if the connection supports bridging.
     * Bridging allows two connections to be
     * directly connected through a virtual channel
     *
     * @return if the connection supports bridging
     */
    boolean supportsBridging();
}
