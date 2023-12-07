package es.karmadev.api.channel.future;

import es.karmadev.api.channel.com.IConnection;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Represents a connection future
 * task
 */
public final class ConnectionFuture implements Future {

    private final List<Consumer<Future>> subConsumers = new ArrayList<>();

    private Consumer<ConnectionFuture> completeConsumer;

    private boolean complete = false;

    @Getter
    private IConnection connection;
    @Getter
    private Throwable error;

    /**
     * Get if the task is yet
     * not complete
     *
     * @return if the task is complete
     */
    @Override
    public boolean isComplete() {
        return complete;
    }

    /**
     * Get if the task was successful, this
     * method always returns false unless
     * {@link #isComplete()} is true, in that
     * case the return method will depend on
     * if the task was successful or not
     *
     * @return the task status
     */
    @Override
    public boolean isSuccess() {
        return complete && connection != null;
    }

    /**
     * In case of the task unsuccessful state,
     * this method will return the error (if any)
     * that caused the task to not complete.
     *
     * @return the task error cause
     */
    @Override
    public @Nullable Throwable getCause() {
        return error;
    }

    /**
     * Add a future listener
     *
     * @param onComplete the future complete
     *                   listener
     */
    @Override
    public void addListener(final Consumer<Future> onComplete) {
        if (this.complete) {
            onComplete.accept(this);
            return;
        }

        subConsumers.add(onComplete);
    }

    /**
     * Set the error
     *
     * @param error the error
     */
    public void setError(final Throwable error) {
        if (this.complete) return;

        this.error = error;
        this.complete = true;

        if (this.completeConsumer != null) this.completeConsumer.accept(this);
        this.subConsumers.forEach((c) -> c.accept(this));
    }

    /**
     * Set the connection
     *
     * @param connection the connection
     */
    public void setConnection(final IConnection connection) {
        if (this.complete) return;

        this.connection = connection;
        this.complete = true;

        if (this.completeConsumer != null) this.completeConsumer.accept(this);
        this.subConsumers.forEach((c) -> c.accept(this));
    }

    /**
     * Add a future task listener
     *
     * @param consumer the completion executor
     * @return the future task
     */
    public ConnectionFuture onComplete(final Consumer<ConnectionFuture> consumer) {
        if (this.complete) {
            consumer.accept(this);
            return this;
        }

        if (this.completeConsumer == null) {
            this.completeConsumer = consumer;
        }
        return this;
    }
}
