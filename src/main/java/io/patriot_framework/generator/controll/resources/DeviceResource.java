/*
 * Copyright 2019 Patriot project
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package io.patriot_framework.generator.controll.resources;

import io.patriot_framework.generator.device.passive.sensors.Sensor;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class DeviceResource extends CoapResource {

    private Sensor sensor;

    public DeviceResource(Sensor sensor) {
        super(sensor.getLabel());
        this.sensor = sensor;

        getAttributes().setTitle("Device resources");
        add(new DataFeedResource(sensor));
    }


    @Override
    public void handleGET(CoapExchange exchange) {

        // respond to the request
        exchange.respond("Hello World!");
    }

    @Override
    public void handlePOST(CoapExchange exchange) {

    }
}
