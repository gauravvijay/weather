package com.weather.data;

import java.util.ArrayList;
import java.util.List;

public enum City {
  LONDON ("London"),
  PARIS ("Paris"),
  AMSTERDAM ("Amsterdam");
  
  private final String displayName;
  
  private City(String displayName){
    this.displayName = displayName;
  }
  
  public static City getSanitized(String displayName) {
    for (City city : City.values()) {
      if (city.toString().equals(displayName))
        return city;
    }
    // Return a default city if the request doesn't provide a city.
    return LONDON;
  }
  
  public static List<String> getCities() {
    // Alas ! no Java 8 streams support in App Engine runtime.
    City[] cities = values();
    List<String> names = new ArrayList<>();
    for (int i = 0; i < cities.length; i++) {
      names.add(cities[i].toString());
    }
    return names;
  }
  
  @Override
  public String toString() {
    return displayName;
  }
}