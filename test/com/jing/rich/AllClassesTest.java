package com.jing.rich;

import com.jing.rich.action.LandActionTest;
import com.jing.rich.command.CommandParserTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({LandTest.class, PlayerTest.class,
        GameTest.class, CommandParserTest.class , LandActionTest.class
})

public class AllClassesTest {

}
