package com.jing.rich;

import com.jing.rich.exception.PropNotOwnException;
import com.jing.rich.ground.Ground;
import com.jing.rich.ground.Land;
import com.jing.rich.tools.Assets;
import com.jing.rich.tools.GiftCard;
import com.jing.rich.tools.Phrases;
import com.jing.rich.tools.Prop;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-23
 * Time: 下午3:11
 * To change this template use File | Settings | File Templates.
 */
public class PlayerTest {
    private Player player;
    Map map;
    @Before
    public void setup(){
        player = new Player(0, 1000,Role.A_TU_BO, new Assets());
        map = Map.getInstance();
    }

    @Test
    public void should_Player_has_money_of_1000_when_start(){
        assertThat(player.getMoney(),is(1000));
    }

    @Test
    public void should_player1_in_6_when_roll_6(){
        player.move(6, map);
        int index = player.getPosition();
        Map map = Map.getInstance();
        assertTrue( map.getGround(index) instanceof Land);
    }

    @Test
    public void should_Player_in_0_when_last_position_69_and_roll_1_(){
        player.setPosition(69);
        player.move(1,map);
        assertThat(player.getPosition(),is(0));
    }


    @Test
    public void should_show_last_player_when_two_players_in_one_place(){
        Player jinBei = new Player(0, 1000,Role.JIN_BEI_BEI, new Assets());
        player.move(6,map);
        jinBei.move(6,map);
        Ground ground = map.getGround(6);
        assertThat(ground.getCurPlayer(),is(jinBei));
    }

    @Test
    public void should_show_pre_player_when_one_player_left(){
        Player jinBei = new Player(0, 1000,Role.JIN_BEI_BEI, new Assets());
        Player qFuRen = new Player(0, 1000,Role.QIAN_FU_REN, new Assets());
        player.move(6,map);
        jinBei.move(6,map);
        qFuRen.move(6,map);
        player.move(3,map);
        Ground ground = map.getGround(6);
        assertThat(ground.getCurPlayer(),is(qFuRen));
    }

    @Test
    public void shouldPlayerOwnLandWhenBuy(){
        Ground ground = map.getGround(6);
        Land land = (Land)ground;
        player.buyLand(land);
        assertThat(land.getOwner(),is(player));
    }

    @Test
    public void testUpDateLand(){
        Ground ground = map.getGround(6);
        Land land = (Land)ground;
        player.buyLand(land);
        player.upDateLand(land);
        assertThat(land.getLevel(),is(1));
    }

    @Test
    public void shouldPlayerBuyFailWhenLandHasOwner(){
        Player qFuRen = new Player(0, 1000,Role.QIAN_FU_REN, new Assets());
        Ground ground = map.getGround(6);
        Land land = (Land)ground;
        player.buyLand(land);
        assertThat(qFuRen.buyLand(land), is(false));
    }

    @Test
    public void shouldPlayerMoneyReducedWhenBuySucessLand(){
        Ground ground = map.getGround(6);
        Land land = (Land)ground;
        player.buyLand(land);
        assertThat(player.getMoney(),is(800));
    }



    @Test
    public void shouldMoneyIncreaseWhenSoldLand(){
        Ground ground = map.getGround(6);
        Land land = (Land)ground;
        player.buyLand(land);
        player.sellLand(land);
        assertThat(player.getMoney(),is(1200));
    }

    @Test
    public void shouldPlayerIncreasePointsWhenSelectPointsCard(){
        player.addGiftCard(GiftCard.POINTSCARD);
        assertThat(player.getPoints(),is(200));
    }

    @Test
    public void shouldPlayerIncreaseMoneyWhenSelectBonusCard(){
        player.addGiftCard(GiftCard.BONUSCARD);
        assertThat(player.getMoney(),is(3000));
    }

    @Test
    public void shouldPlayerHasFushenWhenSelectFuShenCard(){
        player.addGiftCard(GiftCard.FUSHENCARD);
        assertThat(player.getFuShenTimes(),is(5));
    }

    @Test
    public void shouldPlayerBeBloggedWhenInPrison(){
        player.move(49,map);
        player.reachPlaceActions(map);
        assertThat(player.isBogged(),is(true));
    }

    @Test
    public void shouldPlayerPointsIncreasePassMine(){
        player.move(65, map);
        player.reachPlaceActions(map);
        assertThat(player.getPoints(),is(80));
    }

    @Test
    public void shouldPlayerLoseMoneyWhenBuyLand(){
        Ground ground = map.getGround(6);
        player.buyLand(ground);
        assertThat(player.getMoney(),is(800));
    }

    @Test
    public void shouldPlayerGetMoneyWhenSellLand(){
        Ground ground = map.getGround(6);
        player.buyLand(ground);
        player.sellLand((Land)ground);
        assertThat(player.getMoney(),is(1200));
    }



    @Test
    public void shouldPlayerBankruptWhenOutOfMoney(){
        Player jinBeiBei = new Player(0, 200,Role.JIN_BEI_BEI, new Assets());
        Ground ground = map.getGround(6);
        jinBeiBei.buyLand(ground);
        assertThat(jinBeiBei.isBankrupt(),is(true));
    }

    @Test (expected = PropNotOwnException.class)
    public void shouldPlayerLosePropWhenSellTool() throws PropNotOwnException {
        player.buyProp(Prop.BOMB);
        player.sellProp(Prop.BOMB);
        player.sellProp(Prop.ROAD_BLOCK);
        assertThat(player.getProp().size(), is(0));
    }

    @Test
    public void shouldPlayerLosePointsWhenBuyTool() throws PropNotOwnException {
        player.addPoints(100);
        player.buyProp(Prop.BOMB);
        assertThat(player.getPoints(), is(50));
    }

    @Test
    public void shouldPlayerGetPointsWhenSellTool() throws PropNotOwnException {
        player.addPoints(100);
        player.buyProp(Prop.BOMB);
        player.sellProp(Prop.BOMB);
        assertThat(player.getPoints(), is(100));
    }

    @Test
    public void shouldPlayerInHospitalWhenPassBomb(){
        Ground ground = map.getGround(4);
        ground.addProp(Prop.BOMB);
        player.move(6, map);
        assertThat(player.getPosition(),is(Phrases.HOSPITAL_POS));
    }

    @Test
    public void shouldPlayerBeStoppedWhenPassBlock(){
        Ground ground = map.getGround(4);
        ground.addProp(Prop.ROAD_BLOCK);
        player.move(6, map);
        assertThat(player.getPosition(),is(4));
    }

    @Test
    public void shouldPlayerMoveUseRobotWhenPassBlock() throws PropNotOwnException {
        Ground ground = map.getGround(4);
        ground.addProp(Prop.ROAD_BLOCK);
        player.buyProp(Prop.ROBOT);
        player.useRobot(map);
        player.move(6, map);
        assertThat(player.getPosition(),is(6));
    }
}
