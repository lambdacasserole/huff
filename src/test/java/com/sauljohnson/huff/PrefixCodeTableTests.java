package com.sauljohnson.huff;

import com.sauljohnson.backspin.BitSequence;
import junit.framework.TestCase;

/**
 * Unit tests for the {@link PrefixCodeTable} class.
 *
 * @version 1.0 24 May 2016
 * @author  Saul Johnson
 */
public class PrefixCodeTableTests extends TestCase {

    public void testGetCodes() {
        // Initialize table with known symbols and codes.
        BitSequence[] codes = new BitSequence[] {};
        PrefixCodeTable subject = new PrefixCodeTable(new int[] {}, codes);

        // Code array should be gettable.
        assertEquals(codes, subject.getCodes());
    }

    public void testGetSymbols() {
        // Initialize table with known symbols and codes.
        int[] symbols = new int[] {};
        PrefixCodeTable subject = new PrefixCodeTable(symbols, new BitSequence[] {});

        // Symbol array should be gettable.
        assertEquals(symbols, subject.getSymbols());
    }

    public void testTranslateSymbol() {
        // Initialize table with known symbols and codes.
        int[] symbols = new int[] {1};
        BitSequence[] codes = new BitSequence[] {BitSequence.fromBitString("01")};
        PrefixCodeTable subject = new PrefixCodeTable(symbols, codes);

        // The code '01' should translate to symbol '1'.
        assertEquals("01", subject.translateSymbol(1).toBitString());
    }

    public void testTranslateCode() {
        // Initialize table with known symbols and codes.
        int[] symbols = new int[] {1};
        BitSequence[] codes = new BitSequence[] {BitSequence.fromBitString("01")};
        PrefixCodeTable subject = new PrefixCodeTable(symbols, codes);

        // The symbol '1' should translate to code '01'.
        assertEquals(1, subject.translateCode(BitSequence.fromBitString("01")));
    }

    public void testHasCode() {
        // Initialize table with known symbols and codes.
        int[] symbols = new int[] {1};
        BitSequence[] codes = new BitSequence[] {BitSequence.fromBitString("01")};
        PrefixCodeTable subject = new PrefixCodeTable(symbols, codes);

        // The code '01' should exist.
        assertTrue(subject.hasCode(BitSequence.fromBitString("01")));
    }
}
