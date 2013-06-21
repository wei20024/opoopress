/*
 * Copyright 2013 Alex Lin.
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
package org.opoo.press.util;

import java.util.Map;

/**
 * @author Alex Lin
 *
 */
public abstract class MapUtils {
	
	public static <K,V> void put(Map<K, V> map, K key, V value){
		if(value == null){
			map.remove(key);
		}else{
			map.put(key, value);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <K,V> V get(Map<K,Object> map, K key){
		Object value = map.get(key);
		if(value instanceof Accessor){
			return (V) ((Accessor) value).get();
		}
		return (V) value;
	}
	
	public static <K,V> boolean get(Map<K,V> map, K key, boolean defaultValue){
		Object object = map.get(key);
		if(object == null){
			return defaultValue;
		}
		if(object instanceof Boolean){
			return ((Boolean)object).booleanValue();
		}
		return "true".equalsIgnoreCase(object.toString());
	}
}