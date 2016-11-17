package Test;

import Mastermind.*;
import Mastermind.model.*;

import org.junit.*;
import static org.mockito.Mockito.*;

public class MasterMindTest {

    private Mastermind sut;

    @Before
    public void setUp() {
        sut = new Mastermind();
    }

    @Test
    public void shouldExecuteRun() {
        Game game = mock(Game.class);

        sut.initialize();

        verify(game).run();
    }
}