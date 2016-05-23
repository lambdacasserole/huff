package com.sauljohnson.huff;

import junit.framework.TestCase;

/**
 * Unit tests for the {@link HuffmanCompressor} class.
 *
 * @version 1.0 23 May 2016
 * @author  Saul Johnson
 */
public class HuffmanCompressorTests extends TestCase {

    public void testCompress() {
        // Initialize compressor.
        HuffmanCompressor subject = new HuffmanCompressor();

        // Compress byte array.
        byte[] data = new byte[] {1, 1, 1, 1, 2, 3, 4, 4, 5, 6, 6};
        HuffmanCompressionResult result = subject.compress(data);

        // Check length of compressed data.
        assertEquals(4, result.getData().length);
        assertEquals(28, result.getLength());
    }

    public void testDecompress() {
        // Initialize compressor.
        HuffmanCompressor subject = new HuffmanCompressor();

        // Compress byte array.
        byte[] data = new byte[] {1, 1, 1, 1, 2, 3, 4, 4, 5, 6, 6};
        HuffmanCompressionResult result = subject.compress(data);

        // Decompressed data should be identical.
        byte[] decompressed = subject.decompress(result.getData(), result.getTable(), result.getLength());
        for (int i = 0; i < data.length; i++) {
            assertEquals(data[i], decompressed[i]);
        }
    }
}
