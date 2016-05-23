package com.sauljohnson.huff;

import java.io.ByteArrayOutputStream;

import com.sauljohnson.backspin.BitInputStream;
import com.sauljohnson.backspin.BitOutputStream;
import com.sauljohnson.backspin.BitSequence;

/**
 * Represents a compressor that uses plain Huffman coding to compress a set of bytes.
 *
 * @version 1.0 22 May 2016
 * @author  Saul Johnson, Alex Mullen, Lee Oliver
 */
public class HuffmanCompressor {

    /**
     * Compresses a byte array using using plain Huffman coding.
     * @param data  the data to compress
     * @return      the result of data compression, including the compressed data
     */
    public HuffmanCompressionResult compress(byte[] data) {
        //  Calculate translation table.
        final ByteFrequencySet frequencies = new ByteFrequencySet(data);
        final FrequencyTree tree = FrequencyTree.fromFrequencySet(frequencies);
        final PrefixCodeTable table = new PrefixCodeTable(tree);

        // Compress data.
        final BitOutputStream bitOut = new BitOutputStream();
        for (byte datum : data) {
            bitOut.write(table.translateSymbol(datum & 0xFF));
        }

        // Return compressed data, complete with table and header.
        return new HuffmanCompressionResult(bitOut.toArray(), table, bitOut.getLength());
    }

    /**
     * Decompresses a byte array using plain Huffman coding.
     * @param data      the data to decompress
     * @param table     the prefix code table to use to decompress the data
     * @param length    the length of the compressed data in bits
     * @return          the decompressed data
     */
    public byte[] decompress(byte[] data, PrefixCodeTable table, int length) {
        // Read data in a bits, output as bytes.
        final BitInputStream bitIn = new BitInputStream(data);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        // Decompress data.
        BitSequence buffer = new BitSequence();
        while (bitIn.getPosition() < length) {
            buffer.append(bitIn.read());
            if (table.hasCode(buffer)) {
                out.write(table.translateCode(buffer));
                buffer = new BitSequence();
            }
        }
        return out.toByteArray();
    }
}
