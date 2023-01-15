/*
 * Copyright 2017 John Grosh (john.a.grosh@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jagrosh.discordipc;

import com.jagrosh.discordipc.entities.Packet;
import org.json.JSONObject;

/**
 * An implementable listener used to handle events caught by an {@link IPCClient}.<p>
 *
 * Can be attached to an IPCClient using {@link IPCClient#setListener(IPCListener)}.
 *
 * @author John Grosh (john.a.grosh@gmail.com)
 */
public interface IPCListener
{
    /**
     * Fired whenever an {@link IPCClient} sends a {@link Packet} to Discord.
     *
     * @param client The IPCClient sending the Packet.
     * @param packet The Packet being sent.
     */
    default void onPacketSent(IPCClient client, Packet packet) {}

    /**
     * Fired whenever an {@link IPCClient} receives a {@link Packet} to Discord.
     *
     * @param client The IPCClient receiving the Packet.
     * @param packet The Packet being received.
     */
    default void onPacketReceived(IPCClient client, Packet packet) {}

    /**
     * Fired whenever an {@link IPCClient} is ready and connected to Discord.
     *
     * @param client The now ready IPCClient.
     */
    default void onReady(IPCClient client) {}

    /**
     * Fired whenever an {@link IPCClient} has closed.
     *
     * @param client The now closed IPCClient.
     * @param json A {@link JSONObject} with close data.
     */
    default void onClose(IPCClient client, JSONObject json) {}

    /**
     * Fired whenever an {@link IPCClient} has disconnected,
     * either due to bad data or an exception.
     *
     * @param client The now closed IPCClient.
     * @param t A {@link Throwable} responsible for the disconnection.
     */
    default void onDisconnect(IPCClient client, Throwable t) {}
}
