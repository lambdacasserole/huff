package com.sauljohnson.huff;

import junit.framework.TestCase;

/**
 * Unit tests for the {@link ByteFrequencySet} class.
 *
 * @version 1.0 18 May 2016
 * @author  Saul Johnson
 */
public class ByteFrequencySetTests extends TestCase {

    public void testGetSize() {
        // Initialize empty byte frequency set.
        ByteFrequencySet subject = new ByteFrequencySet(new byte[] {});

        // 256 entries should be present in set.
        assertEquals(256, subject.getSize());
    }

    public void testGetUnsignedByteFrequency() {
        // Initialize byte frequency set.
        ByteFrequencySet subject = new ByteFrequencySet(new byte[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 8});

        // The byte '1' has a probability of 0.1, '8' has a probability of 0.2.
        assertEquals(0.1, subject.getUnsignedByteFrequency(1));
        assertEquals(0.2, subject.getUnsignedByteFrequency(8));
    }
}
