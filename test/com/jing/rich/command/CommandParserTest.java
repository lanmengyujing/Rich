package com.jing.rich.command;

import com.jing.rich.tools.CommandParser;
import com.jing.rich.Player;
import com.jing.rich.exception.CommandNotFoundException;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class CommandParserTest {
    private CommandParser parser;
    @Before
    public void setUp() {
        parser = new CommandParser();
    }

    @Test(expected = CommandNotFoundException.class)
    public void shouldThrowExceptionInputHello() throws CommandNotFoundException{
        Command command = parser.ParseCommand("hello");
    }

    @Test
    public void testParseCommand() throws CommandNotFoundException {
        Command command = parser.ParseCommand("Roll");
        assertThat(command instanceof RollCommand, is(true));
    }

    @Test
     public void testParsePlayersInitCommand() throws Exception {
        List<Player> playerList = parser.parsePlayersInitCommand("1234");
        assertThat(playerList.get(0).getRole().getName(), is("钱夫人"));
        assertThat(playerList.get(1).getRole().getName(), is("阿土伯"));
        assertThat(playerList.get(3).getRole().getName(), is("金贝贝"));
        assertThat(playerList.get(2).getRole().getName(), is("孙小美"));
    }

}
