package com.sauljohnson.huff;

/**
 * Represents the result of a {@link HuffmanCompressor} compressing a set of bytes.
 *
 * @version 1.0 23 May 2016
 * @author  Saul Johnson
 */
public class HuffmanCompressionResult {

    /** The compressed data. */
    private byte[] data;

    /** The prefix code table used to compress the data. */
    private PrefixCodeTable table;

    /** The length of the compressed data. **/
    private int length;

    /**
     * Initializes a new instance of the result of a {@link HuffmanCompressor} compressing a set of bytes.
     * @param data      the compressed data
     * @param table     the prefix code table used to compress the data
     * @param length    the length of the compressed data in bits
     */
    public HuffmanCompressionResult(byte[] data, PrefixCodeTable table, int length) {
        this.data = data;
        this.table = table;
        this.length = length;
    }

    /**
     * Gets the compressed data.
     * @return  the compressed data
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Gets the prefix code table used to compress the data.
     * @return  the prefix code table used to compress the data
     */
    public PrefixCodeTable getTable() {
        return table;
    }

    /**
     * Gets the length of the compressed data in bits.
     * @return  the length of the compressed data in bits
     */
    public int getLength() {
        return length;
    }
}
