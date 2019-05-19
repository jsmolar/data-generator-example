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

package io.patriot_framework.generator.device.passive.sensors;

import io.patriot_framework.generator.Data;
import io.patriot_framework.generator.controll.SensorCoapController;
import io.patriot_framework.generator.dataFeed.DataFeed;
import io.patriot_framework.generator.device.AbstractDevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Abstract class for device Composition - one unit with multiple DataFeeds
 */
public abstract class AbstractSensor extends AbstractDevice implements Sensor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractSensor.class);

    private List<DataFeed> dataFeeds = new ArrayList<>();

    public AbstractSensor(String label, DataFeed... dataFeeds) {
        super(label);
        Arrays.asList(dataFeeds).forEach(this::addDataFeed);
        setCoapController(new SensorCoapController(this));
    }

    @Override
    public List<Data> requestData(Object... param) {
        List<Data> result = new ArrayList<>();
//        HashMap<String, Data> networkData = new HashMap<>();

        for(DataFeed df : dataFeeds) {
            Data newData = df.getNextValue();
//            networkData.put(df.getLabel(), newValue);
            result.add(newData);
        }

        if(getNetworkAdapter() != null) {
            getNetworkAdapter().send(result);
        }

        LOGGER.info(this.toString() + " new data: " + result.toString());

        return result;
    }

    @Override
    public void addDataFeed(DataFeed dataFeed) {
        this.dataFeeds.add(dataFeed);
    }

    @Override
    public void removeDataFeed(DataFeed dataFeed) {
        this.dataFeeds.remove(dataFeed);
    }

    @Override
    public List<DataFeed> getDataFeeds() {
        return Collections.unmodifiableList(dataFeeds);
    }

//    public abstract void setDataConverter(DataConverter<E,T> dataConverter);

}
