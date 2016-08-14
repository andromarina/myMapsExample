package com.example.myMaps;

import com.google.api.client.util.Key;

import java.util.List;

/**
 * Created by mara on 4/15/16.
 */
public class PlacesResult {

    @Key("predictions")
    public List<Prediction> predictions;

}
