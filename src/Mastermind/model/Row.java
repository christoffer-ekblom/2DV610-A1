package Mastermind.model;

import java.util.*;

public class Row {
    private List<SymbolPeg> symbolPegs;
    private List<KeyPeg> keyPegs;

    public Row() {

    }

    public Row(List<SymbolPeg> symbolPegs) throws Exception {
        this(symbolPegs, new LinkedList<KeyPeg>());
    }

    public Row(List<SymbolPeg> symbolPegs, List<KeyPeg> keyPegs) throws Exception {
        if(symbolPegs.isEmpty()) {
            throw new Exception();
        }

        this.symbolPegs = symbolPegs;
        this.keyPegs = keyPegs;
    }

    public List<SymbolPeg> getSymbolPegs() {
        return this.symbolPegs;
    }

    public List<KeyPeg> getKeyPegs() {
        return this.keyPegs;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(this == null || obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Row row = (Row)obj;

        return this.getSymbolPegs().equals(row.getSymbolPegs());
    }
}
