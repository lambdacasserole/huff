package com.sauljohnson.huff;

import junit.framework.TestCase;

/**
 * Unit tests for the {@link FrequencyTree} class.
 *
 * @version 1.0 18 May 2016
 * @author  Saul Johnson
 */
public class FrequencyTreeTests extends TestCase {

    public void testFromFrequencySet() {
        // Create Huffman tree from frequency set.
        ByteFrequencySet frequencies = new ByteFrequencySet(new byte[] {1, 2, 4, 4, 8, 16, 32});
        FrequencyTree subject = FrequencyTree.fromFrequencySet(frequencies);

        // Get tree leaves (terminal nodes).
        Node[] leaves = subject.getLeaves();

        // We should have 256 leaves, with the prefix "01" for byte '4'.
        assertEquals(256, leaves.length);
        assertEquals("01", leaves[4].buildBitSequence().toBitString());
    }
}