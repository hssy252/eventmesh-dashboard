package org.apache.eventmesh.dashboard.console.utils;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class ParsePropertiesUtils {

    public static String[] parseProperties(String properties) {
        String[] strings = new String[2];
        ArrayList<String> keyList = new ArrayList<>();
        ArrayList<String> valueList = new ArrayList();
        String[] splits = properties.split("\\n");
        for (String split : splits) {
            if (split.equals("\n") || split.equals("\r") || split.equals("")) {
                continue;
            }
            String[] kvs = split.split("=");
            keyList.add(kvs[0]);
            valueList.add(kvs[1].split("\r")[0]);
        }
        strings[0] = keyList.stream().map(String::valueOf).collect(Collectors.joining(","));
        strings[1] = valueList.stream().map(String::valueOf).collect(Collectors.joining(","));

        return strings;
    }

}
