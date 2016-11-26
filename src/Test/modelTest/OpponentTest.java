package Test.modelTest;

import Mastermind.model.KeyPeg;
import Mastermind.model.Opponent;

import static org.junit.Assert.*;

import Mastermind.model.Row;
import Mastermind.model.SymbolPeg;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.jvm.hotspot.debugger.cdbg.Sym;
import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OpponentTest {
    @Test
    public void shouldFailIfTheOpponentHasTheWrongRowLength() throws Exception {
        int rowLength = 4;
        Opponent opponent = new Opponent(rowLength);
        Assert.assertEquals(rowLength, opponent.getRowLength());
    }

    @Test
    public void shouldFailIfTheDefaultRowLengthIsNotSet() throws Exception {
        Opponent opponent = new Opponent();
        boolean rowLengthIsNotSet = opponent.getRowLength() == 0;
        Assert.assertFalse(rowLengthIsNotSet);
    }

    @Test
    public void shouldThrowExceptionIfTheOpponentHasTooSmallRowLength() throws Exception {
        int rowLength = 0;

        try {
            Opponent opponent = new Opponent(rowLength);
            fail();
        } catch (Exception e) {
            //ok
        }
    }

    @Test
    public void shouldThrowExceptionIfTheOpponentHasTooLargeRowLength() throws Exception {
        int rowLength = 20;

        try {
            Opponent opponent = new Opponent(rowLength);
            fail();
        } catch (Exception e) {
            //ok
        }
    }

    @Test
    public void shouldGetDifferentHints() throws Exception {
        Opponent opponent = new Opponent();
        Row row = new Row();
        List<List<KeyPeg>> hintHistory = new LinkedList<List<KeyPeg>>();

        // should definitely give us different hints after 100 iterations
        for(int i = 0; i < 100; i++) {
            opponent.generateSecretCode();
            opponent.checkGuess(row);
            hintHistory.add(opponent.getHint());
        }

        List<Boolean> isSame = new LinkedList<Boolean>();

        for(List<KeyPeg> hint : hintHistory) {
            for(int i = 0; i < hintHistory.size(); i++) {
                isSame.add(hint.equals(hintHistory.get(i)));
            }
        }

        boolean containsFalse = isSame.contains(false);

        Assert.assertTrue(containsFalse);
    }

    @Test
    public void shouldGenerateNotNullSecretCode() throws Exception {
        Opponent opponent = new Opponent();
        opponent.generateSecretCode();
        Field field = Opponent.class.getDeclaredField("secretCode");
        field.setAccessible(true);
        Row row = (Row)field.get(opponent);
        Assert.assertNotNull(row);
    }

    @Test
    public void shouldGenerateDifferentSecretCodes() throws Exception {
        Opponent opponent = new Opponent();
        Field field = Opponent.class.getDeclaredField("secretCode");
        field.setAccessible(true);
        Row rowTest;

        opponent.generateSecretCode();
        Row firstRow = (Row)field.get(opponent);
        int counter = 0;

        do {
            opponent.generateSecretCode();
            rowTest = (Row)field.get(opponent);

            if(counter++ >= 100) {
                fail();
            }
        } while(rowTest.equals(firstRow));
    }
}
