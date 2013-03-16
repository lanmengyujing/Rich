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
    private RichMap richMap;
    @Before
    public void setup(){
        player = new Player(0, 1000,Role.A_TU_BO, new Assets());
        richMap = RichMap.getInstance();
    }


    @Test
    public void shouldPlayer1In6whenRoll6(){
        player.move(6, this.richMap);
        int index = player.getPosition();
        RichMap richMap = RichMap.getInstance();
        assertTrue( richMap.getGround(index) instanceof Land);
    }

    @Test
    public void shouldPlayerIn0WhenLastPosition69andRollFor1(){
        player.setPosition(69);
        player.move(1, richMap);
        assertThat(player.getPosition(),is(0));
    }


    @Test
    public void shouldShowLastPlayerWhenTwoPlayersInOnePlace(){
        Player jinBei = new Player(0, 1000,Role.JIN_BEI_BEI, new Assets());
        player.move(6, richMap);
        jinBei.move(6, richMap);
        Ground ground = richMap.getGround(6);
        assertThat(ground.getCurPlayer(),is(jinBei));
    }

    @Test
    public void shouldShowPrePlayerWhenOnePlayerLeft(){
        Player jinBei = new Player(0, 1000,Role.JIN_BEI_BEI, new Assets());
        Player qFuRen = new Player(0, 1000,Role.QIAN_FU_REN, new Assets());
        player.move(6, richMap);
        jinBei.move(6, richMap);
        qFuRen.move(6, richMap);
        player.move(3, richMap);
        Ground ground = richMap.getGround(6);
        assertThat(ground.getCurPlayer(),is(qFuRen));
    }

    @Test
    public void shouldPlayerOwnLandWhenBuy(){
        Ground ground = richMap.getGround(6);
        Land land = (Land)ground;
        player.buyLand(land);
        assertThat(land.getOwner(),is(player));
    }

    @Test
    public void testUpDateLand(){
        Ground ground = richMap.getGround(6);
        Land land = (Land)ground;
        player.buyLand(land);
        player.upDateLand(land);
        assertThat(land.getLevel().getCode(),is(1));
    }

    @Test
    public void shouldPlayerBuyFailWhenLandHasOwner(){
        Player qFuRen = new Player(0, 1000,Role.QIAN_FU_REN, new Assets());
        Ground ground = richMap.getGround(6);
        Land land = (Land)ground;
        player.buyLand(land);
        assertThat(qFuRen.buyLand(land), is(false));
    }

    @Test
    public void shouldPlayerMoneyReducedWhenBuySuccessLand(){
        Ground ground = richMap.getGround(6);
        Land land = (Land)ground;
        player.buyLand(land);
        assertThat(player.getMoney(),is(800));
    }



    @Test
    public void shouldMoneyIncreaseWhenSoldLand(){
        Ground ground = richMap.getGround(6);
        Land land = (Land)ground;
        player.buyLand(land);
        player.sellLand(land);
        assertThat(player.getMoney(),is(1200));
    }

    @Test
    public void shouldPlayerIncreasePointsWhenSelectPointsCard(){
        player.addGiftCard(GiftCard.POINTS_CARD);
        assertThat(player.getPoints(),is(200));
    }

    @Test
    public void shouldPlayerIncreaseMoneyWhenSelectBonusCard(){
        player.addGiftCard(GiftCard.BONUS_CARD);
        assertThat(player.getMoney(),is(3000));
    }

    @Test
    public void shouldPlayerHasFushenWhenSelectFuShenCard(){
        player.addGiftCard(GiftCard.FUSHEN_CARD);
        assertThat(player.getFuShenTimes(),is(5));
    }

    @Test
    public void shouldPlayerBeBloggedWhenInPrison(){
        player.move(49, richMap);
        player.reachPlaceActions(richMap);
        assertThat(player.isBogged(),is(true));
    }

    @Test
    public void shouldPlayerPointsIncreasePassMine(){
        player.move(65, richMap);
        player.reachPlaceActions(richMap);
        assertThat(player.getPoints(),is(80));
    }

    @Test
    public void shouldPlayerLoseMoneyWhenBuyLand(){
        Ground ground = richMap.getGround(6);
        player.buyLand(ground);
        assertThat(player.getMoney(),is(800));
    }

    @Test
    public void shouldPlayerGetMoneyWhenSellLand(){
        Ground ground = richMap.getGround(6);
        player.buyLand(ground);
        player.sellLand((Land)ground);
        assertThat(player.getMoney(),is(1200));
    }



    @Test
    public void shouldPlayerBankruptWhenOutOfMoney(){
        Player jinBeiBei = new Player(0, 200,Role.JIN_BEI_BEI, new Assets());
        Ground ground = richMap.getGround(6);
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
        Ground ground = richMap.getGround(4);
        ground.addProp(Prop.BOMB);
        player.move(6, richMap);
        assertThat(player.getPosition(),is(Phrases.HOSPITAL_POS));
    }

    @Test
    public void shouldPlayerBeStoppedWhenPassBlock(){
        Ground ground = richMap.getGround(4);
        ground.addProp(Prop.ROAD_BLOCK);
        player.move(6, richMap);
        assertThat(player.getPosition(),is(4));
    }

    @Test
    public void shouldPlayerMoveUseRobotWhenPassBlock() throws PropNotOwnException {
        Ground ground = richMap.getGround(4);
        ground.addProp(Prop.ROAD_BLOCK);
        player.buyProp(Prop.ROBOT);
        player.useRobot(richMap);
        player.move(6, richMap);
        assertThat(player.getPosition(),is(6));
    }
}
