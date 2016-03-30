package com.monitorjbl.json;

import java.util.HashMap;
import java.util.Map;

/**
 * Allows runtime alteration of JSON responses
 */
public class JsonView<T> {
  protected final T value;
  protected final Map<Class<?>, Match> matches = new HashMap<>();
  protected int maxDepth = 0;

  protected JsonView(T value) {
    this.value = value;
  }

  T getValue() {
    return value;
  }

  Match getMatch(Class<?> cls) {
    return matches.get(cls);
  }

  public JsonView<T> onClass(Class<?> cls, Match match) {
    matches.put(cls, match);
    return this;
  }

  public static <E> JsonView<E> with(E value) {
    return new JsonView<>(value);
  }

  public int getMaxDepth() {
  	return maxDepth;
  }
	
  public JsonView<T> setMaxDepth(int maxDepth) {
	this.maxDepth = maxDepth;
	return this;
  }
  
  

}
