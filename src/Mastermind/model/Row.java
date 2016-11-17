package Mastermind.model;

import java.util.*;

public class Row {
    private List<SymbolPeg> symbolPegs;
    private List<KeyPeg> keyPegs;

    public Row(List<SymbolPeg> symbolPegs, List<KeyPeg> keyPegs) {

    }

    public List<SymbolPeg> getSymbolPegs() {
        List<SymbolPeg> symbolPegs = new LinkedList<SymbolPeg>();
        symbolPegs.add(SymbolPeg.King);
        symbolPegs.add(SymbolPeg.Queen);
        symbolPegs.add(SymbolPeg.Diamond);
        symbolPegs.add(SymbolPeg.Heart);
        return symbolPegs;
    }
}
