package com.sauljohnson.huff;

/**
 * Represents a set of byte occurrence frequencies.
 *
 * @version 1.0 18 May 2016
 * @author  Saul Johnson, Alex Mullen, Lee Oliver
 */
public class ByteFrequencySet {
   
    /** The array of occurrence frequencies that underlies the set. */
    private final double[] frequencies;
        
    /**
     * Initialises a new instance of a byte frequency set.
     * @param data  the data from which to initialise the frequency set
     */
    public ByteFrequencySet(byte[] data) {
        frequencies = new double[256];
        final double unit = 1.00d / (double) data.length;
        for (byte b : data) {
            frequencies[b & 0xFF] += unit;
        }
    }
    
    /**
     * Gets the size of the frequency set.
     * @return  the size of the frequency set
     */
    public int getSize() {
        return frequencies.length;
    }
    
    /**
     * Gets the occurrence frequency of the specified byte.
     * @param index the byte for which to get the occurrence frequency
     * @return      the occurrence frequency of the specified byte
     */
    public double getUnsignedByteFrequency(int index) {
        return frequencies[index];
    }
}
