package com.jing.rich;

import com.jing.rich.ground.Ground;
import com.jing.rich.tools.Assets;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTest {
    private Game game;
    private RichMap richMap;
    private List<Player> playerList;
    private Player jinBeiBei;
    private Player aTuBo;
    @Before
    public void setup(){
        game = new  Game();
        richMap = RichMap.getInstance();
        playerList  = new ArrayList<Player>();
        aTuBo = new Player(0, 1000, Role.A_TU_BO, new Assets());
        jinBeiBei = new Player(0, 200, Role.JIN_BEI_BEI, new Assets());
    }

   @Test
    public void shouldPlayerOutOfGameWhenBankrupt(){
       Ground ground = richMap.getGround(6);
       jinBeiBei.buyLand(ground);
       game.judgeRemovePlayer(jinBeiBei);
       assertThat(game.getPlayerAmount(), is(0));
   }

    @Test
    public void shouldGameOverWhenOnlyOnePlayer(){
        playerList.add(jinBeiBei);
        playerList.add(aTuBo);
        game.setPlayers(playerList);
        Ground ground = richMap.getGround(6);
        jinBeiBei.buyLand(ground);
        game.judgeRemovePlayer(jinBeiBei);
        assertThat(game.judgeGameOver(), is(true));
    }

    @Test
    public void getWinnerWhenGameOver(){
        playerList.add(jinBeiBei);
        playerList.add(aTuBo);
        game.setPlayers(playerList);
        Ground ground = richMap.getGround(6);
        jinBeiBei.buyLand(ground);
        game.judgeRemovePlayer(jinBeiBei);
        assertThat(game.getWinner(), is(aTuBo));
    }
}
