package Test;

import Mastermind.*;
import Mastermind.controller.*;

import org.junit.*;

import static org.mockito.Mockito.*;

public class MastermindTest {

    @Before
    public void setUp() {
        // Empty
    }

    @Test
    public void shouldExecuteRun() {
        PlayGame game = mock(PlayGame.class);
        Mastermind sut = new Mastermind(game);

        sut.initialize();

        verify(game).run();
    }
}
