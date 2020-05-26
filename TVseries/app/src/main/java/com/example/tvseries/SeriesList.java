package com.example.tvseries;

import java.util.ArrayList;
import java.util.List;

public class SeriesList {
    List<String> getListTV (String spinner){
        List<String> list = new ArrayList<>();
        if(spinner.equals("Comedies")){
            list.add("Friends");
            list.add("Mike & Molly");
        }
        if(spinner.equals("Fantasy")){
            list.add("Game of Thrones");
        }
        if(spinner.equals("Detectives")){
            list.add("Sharp visors");
        }
        if(spinner.equals("Dramas")){
            list.add("One day");
        }
        return list;
    }
}
