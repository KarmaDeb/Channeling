package es.karmadev.api.channel.future;

import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

/**
 * Represents a future
 * task, which can be success,
 * fail, complete or not complete
 */
public interface Future {

    /**
     * Get if the task is yet
     * not complete
     *
     * @return if the task is complete
     */
    boolean isComplete();

    /**
     * Get if the task was successful, this
     * method always returns false unless
     * {@link #isComplete()} is true, in that
     * case the return method will depend on
     * if the task was successful or not
     *
     * @return the task status
     */
    boolean isSuccess();

    /**
     * In case of the task unsuccessful state,
     * this method will return the error (if any)
     * that caused the task to not complete.
     *
     * @return the task error cause
     */
    @Nullable
    Throwable getCause();

    /**
     * Add a future listener
     *
     * @param onComplete the future complete
     *                   listener
     */
    void addListener(final Consumer<Future> onComplete);
}
