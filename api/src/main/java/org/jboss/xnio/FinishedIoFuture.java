/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008, JBoss Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.xnio;

/**
 * An implementation of {@link IoFuture} that represents an immediately-successful operation.
 *
 * @param <T> the type of result that this operation produces
 */
public class FinishedIoFuture<T> extends AbstractIoFuture<T> {
    /**
     * Create an instance.
     *
     * @param result the operation result
     */
    public FinishedIoFuture(T result) {
        setResult(result);
    }

    /**
     * Run a notifier.  The base implemenation runs the notifier in the current thread, always.
     *
     * @param notifier the notifier to run
     */
    protected void runNotifier(final Notifier<T> notifier) {
        notifier.notify(this);
    }

    /**
     * Cancel the operation.  Since this operation is always complete, this is a no-op.
     *
     * @return this instance
     */
    public IoFuture<T> cancel() {
        return this;
    }
}