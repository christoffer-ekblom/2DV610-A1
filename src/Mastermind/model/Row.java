package Mastermind.model;

import java.util.*;

public class Row {
    private List<SymbolPeg> symbolPegs;
    private List<KeyPeg> keyPegs;

    public Row(List<SymbolPeg> symbolPegs, List<KeyPeg> keyPegs) {
        this.symbolPegs = symbolPegs;
        this.keyPegs = keyPegs;
    }

    public List<SymbolPeg> getSymbolPegs() {
        return this.symbolPegs;
    }

    public List<KeyPeg> getKeyPegs() {
        return this.keyPegs;
    }
}
