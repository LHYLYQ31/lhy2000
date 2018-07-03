package com.sinosoft.myboot.common.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("rawtypes")
public class PageData extends HashMap<String, Object> implements Map<String, Object> {

    private static final long serialVersionUID = 1L;

    Map map = null;
    HttpServletRequest request;

    @SuppressWarnings("unchecked")
    public PageData(HttpServletRequest request) {
        this.request = request;
        Map properties = request.getParameterMap();
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            }
            else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            }
            else {
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        map = returnMap;
    }

    public PageData() {
        map = new HashMap();
    }

    @Override
    public Object get(Object key) {
        Object obj = null;
        if (map.get(key) instanceof Object[]) {
            Object[] arr = (Object[]) map.get(key);
            obj = request == null ? arr
                    : (request.getParameter((String) key) == null ? arr
                            : arr[0]);
        }
        else {
            obj = map.get(key);
        }
        return obj;
    }

    public String getString(Object key) {
        return (String) get(key);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object put(String key, Object value) {
        return map.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Set entrySet() {
        return map.entrySet();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Set keySet() {
        return map.keySet();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void putAll(Map t) {
        map.putAll(t);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection values() {
        return map.values();
    }

}
