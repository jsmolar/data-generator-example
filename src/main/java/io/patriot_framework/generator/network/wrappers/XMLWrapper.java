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

package io.patriot_framework.generator.network.wrappers;

import io.patriot_framework.generator.Data;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;

import java.util.List;

public class XMLWrapper implements DataWrapper {

    private Document document = DocumentHelper.createDocument();

    @Override
    public String wrapData(List<Data> data) {
        return null;
    }

//    @Override
//    public String wrapData(Device device, E data) {
//        Element root = document.addElement("root");
//        root.addAttribute("name", device.getLabel())
//            .addAttribute("data", data.toString());
//
//        return document.asXML();
//    }
//
//    @Override
//    public String wrapData(Device device, HashMap<String, E> data) {
//        Element root = document.addElement("root");
//        root.addAttribute("name", device.getLabel());
//        for (Map.Entry me : data.entrySet()) {
//            root.addAttribute(me.getKey().toString(), me.getValue().toString());
//        }
//
//        return document.asXML();
//    }

}
