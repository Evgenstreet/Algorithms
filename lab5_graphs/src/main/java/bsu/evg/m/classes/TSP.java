package bsu.evg.m.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//Travel list before optimization: [City: {x=2.0, y=4.0}, City: {x=3.0, y=3.0}, City: {x=5.0, y=4.0}, City: {x=1.0, y=1.0}, City: {x=0.0, y=0.0}, City: {x=2.0, y=6.0}, City: {x=5.0, y=2.0}, City: {x=1.0, y=3.0}]
//Travel distance before optimization: 26.9263696105735
//Travel list with optimization: [City: {x=2.0, y=4.0}, City: {x=2.0, y=6.0}, City: {x=5.0, y=4.0}, City: {x=5.0, y=2.0}, City: {x=3.0, y=3.0}, City: {x=1.0, y=1.0}, City: {x=0.0, y=0.0}, City: {x=1.0, y=3.0}]
//Travel distance with optimization: 18.66075116262454


public class TSP {
    public static void main(String[] args) {
        List<City> cityList = new ArrayList<>();
        cityList.add(new City(0,0));
        cityList.add(new City(1,1));
        cityList.add(new City(2,4));
        cityList.add(new City(3,3));
        cityList.add(new City(5,4));
        cityList.add(new City(1,3));
        cityList.add(new City(5,2));
        cityList.add(new City(2,6));

        Collections.shuffle(cityList);

        System.out.println("Travel list before optimization: " + cityList);
        System.out.println("Travel distance before optimization: " +  TSP.calculateDistance(cityList));

        TSP.optimizationTravelByDoubleChange(cityList);
        System.out.println("Travel list with optimization: " + cityList);
        System.out.println("Travel distance with optimization: " +  TSP.calculateDistance(cityList));

    }

    public static double calculateDistance(List<City> citiesMap) {
        double distance = 0;
        for(int i = 0; i < citiesMap.size()-1; i++) {
            distance += citiesMap.get(i).distance(citiesMap.get(i+1));
        }
        distance += citiesMap.get(0).distance(citiesMap.get(citiesMap.size()-1));
        return distance;
    }

    public static void optimizationTravelByDoubleChange(List<City> citiesMap) {
        boolean stop = true;
        while(stop) {
            stop = false;
            for (int i = 0; i < citiesMap.size() - 1; i++) {
                for (int j = i + 1; j < citiesMap.size(); j++) {
                    double oldDistance = citiesMap.get(i).distance(citiesMap.get(i + 1)) + citiesMap.get(j).distance(citiesMap.get( (j + 1) % citiesMap.size() ));
                    double newDistance = citiesMap.get(i).distance(citiesMap.get(j)) + citiesMap.get(i + 1).distance(citiesMap.get( (j + 1) %  citiesMap.size() ));
                    if (oldDistance > newDistance) {
                        City cityTmp = citiesMap.get(i + 1);
                        citiesMap.set(i + 1, citiesMap.get((j)));
                        citiesMap.set(j, cityTmp);
                        stop = true;
                    }
                }
            }
        }
    }
}
