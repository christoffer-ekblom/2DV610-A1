package Mastermind.model;

import java.util.*;

public class Row {
    private List<SymbolPeg> symbolPegs;
    private List<KeyPeg> keyPegs;

    public Row(List<SymbolPeg> symbolPegs, List<KeyPeg> keyPegs) {
        this.symbolPegs = symbolPegs;
    }

    public List<SymbolPeg> getSymbolPegs() {
        return this.symbolPegs;
    }

    public List<KeyPeg> getKeyPegs() {
        List<KeyPeg> keyPegs = new LinkedList<KeyPeg>();
        keyPegs.add(KeyPeg.Black);
        keyPegs.add(KeyPeg.Black);
        keyPegs.add(KeyPeg.White);
        return keyPegs;
    }
}
