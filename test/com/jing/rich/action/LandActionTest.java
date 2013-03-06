package com.jing.rich.action;

import com.jing.rich.tools.Assets;
import com.jing.rich.Map;
import com.jing.rich.Player;
import com.jing.rich.Role;
import com.jing.rich.ground.Land;
import com.jing.rich.tools.GiftCard;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LandActionTest {
    LandAction landAction ;
    Land land;
    Player qFuRen;
    @Before
    public void setUp() throws Exception {
        qFuRen = new Player(0, 1000, Role.QIAN_FU_REN, new Assets());
        Player jinBei = new Player(0, 1000,Role.JIN_BEI_BEI, new Assets());
        land = new Land(200);
        land.setOwner(jinBei);
        landAction = new LandAction(qFuRen,land, Map.getInstance());
    }

    @Test
    public void testPayTollToOwner() throws Exception {
        int toll = landAction.PayTollToOwner(land.getOwner(),land);
        assertThat(toll,is(100));
    }

    @Test
    public void testPayTollToOwnerWhenHasFuShenCard() throws Exception {
        qFuRen.addGiftCard(GiftCard.FUSHENCARD);
        int toll = landAction.PayTollToOwner(land.getOwner(),land);
        assertThat(toll,is(0));
    }

    @Test
    public void testPayTollWhenOwnerInHospital() throws Exception {
        land.getOwner().setPosition(14);
        int toll = landAction.PayTollToOwner(land.getOwner(),land);
        assertThat(toll,is(0));
    }

    @Test
    public void testPayTollWhenOwnerInPrison() throws Exception {
        land.getOwner().setPosition(49);
        int toll = landAction.PayTollToOwner(land.getOwner(),land);
        assertThat(toll,is(0));
    }
}
