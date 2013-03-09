package com.jing.rich;

import com.jing.rich.action.LandActionTest;
import com.jing.rich.command.CommandParserTest;
import com.jing.rich.command.QueryCommandTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({LandTest.class, PlayerTest.class,
        GameTest.class, CommandParserTest.class ,
        LandActionTest.class, QueryCommandTest.class
})

public class AllClassesTest {

}
