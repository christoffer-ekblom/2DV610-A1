package Test.modelTest;

import Mastermind.model.*;

import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldCallGenerateSecretCode() throws Exception {
        Opponent opponent = mock(Opponent.class);
        Game sut = new Game();

        sut.newGame();

        verify(opponent).generateSecretCode();
    }
}