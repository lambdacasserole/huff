# Huff
Huffman compression Maven package for Java.

Huff is designed to provide a simple starting point for applications seeking to use Huffman coding to compress data. Given a byte array, an instance of the `HuffmanCompressor` class will:

+ Calculate byte occurence frequencies for the data set.
+ Create a Huffman tree using this set of frequencies.
+ Build prefix codes for each byte based on its relative occurence frequency.
+ Use the [backspin](https://github.com/lambdacasserole/backspin) bit manipulation package to write a compressed representation of the data to a `BitOutputStream`. 
+ Return the contents of this `BitOutputStream` as a compressed byte array, along with its length in bits (bit count) and a `PrefixCodeTable` for decompressing the data again.

The `HuffmanCompressor` class is also capable of decompressing the data using a prefix code table, a bit count and a compressed byte array.

## Limitations
Huff is absolutely not a package that will produce archive files out-of-the-box. It is also not an optimised-for-speed implementation. If you do use it for file compression, serializing the `PrefixCodeTable` and bit count for storage alongside your compressed data is up to you. 

That said, when you need to transparently Huffman-code a byte array (or even just do a basic frequency analysis on it), Huff is a good choice. 
