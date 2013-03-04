package com.jing.rich;


import com.jing.rich.ground.Land;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-2-28
 * Time: 下午10:19
 * To change this template use File | Settings | File Templates.
 */
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

    public List<Land> getAssetsList(){
        return assetsList;
    }
}
