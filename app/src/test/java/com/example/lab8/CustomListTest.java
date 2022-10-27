package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void hasCityTest() {
        list = MockCityList();
        // add the city to cityList first
        City city = new City("Edmonton", "Alberta");
        list.addCity(city);

        // check if city is belongs to the list
        assertTrue(list.hasCity(city));
    }

    @Test
    void deleteCityTest() {
        list = MockCityList();
        // add the city to cityList first
        City city = new City("Edmonton", "Alberta");
        list.addCity(city);

        // deletes object from list and check if it's deleted
        list.deleteCity(city);
        assertFalse(list.hasCity(city));

        // the object city is successfully deleted from list if this
        // point is reached, we can reuse it to test delete function's
        // exception functionality
        assertThrows(IllegalArgumentException.class, ()->
                list.deleteCity(city));
    }

    @Test
    void countCitiesTest() {
        list = MockCityList();
        // add a city to cityList
        City city = new City("Edmonton", "Alberta");
        list.addCity(city);

        // check if count is 1
        assertEquals(1, list.countCities());

        // delete the city
        list.deleteCity(city);

        // check if count is 0
        assertEquals(0, list.countCities());
    }
}
