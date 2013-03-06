package com.jing.rich.tools;


import com.jing.rich.ground.Land;

import java.util.ArrayList;
import java.util.List;


public class Assets {
    List<Land> assetsList = new ArrayList<Land>();

    public void addAssets(Land land) {
        assetsList.add(land);
    }

    public void lost(Land land) {
        assetsList.remove(land);
    }

    public void removeAll() {
        for (Land land : assetsList) {
            land.reSetting();
        }
    }

    public List<Land> getAssetsList() {
        return assetsList;
    }
}
