package Test;

import Mastermind.*;
import Mastermind.controller.PlayGame;
import org.junit.*;

import static org.mockito.Mockito.*;

public class MastermindTest {

    private Mastermind sut;

    @Before
    public void setUp() {
        sut = new Mastermind();
    }

    @Test
    public void shouldExecuteRun() {
        PlayGame game = mock(PlayGame.class);

        sut.initialize();

        verify(game).run();
    }
}
