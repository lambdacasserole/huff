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

## Benchmarks
Once again, this package isn't designed for straight-up file compression out of the box. If you do use it for that, however, here are some benchmarks running against the [Canterbury Corpus](http://corpus.canterbury.ac.nz/). Note that the compressed sizes do not include any space for the serialized prefix code tables/bit count needed to decompress the files again.

| File         | Uncompressed (Bytes) | Compressed (Bytes) | Ratio | Space Saving | Time (ms) |
|--------------|----------------------|--------------------|-------|--------------|-----------|
| alice29.txt  | 152089               | 87688              | 1.73  | 42%          | 321.2     |
| asyoulik.txt | 125179               | 75807              | 1.65  | 39%          | 128.8     |
| cp.html      | 24603                | 16199              | 1.52  | 34%          | 108.6     |
| fields.c     | 11150                | 7026               | 1.59  | 37%          | 45.5      |
| grammar.lsp  | 3721                 | 2170               | 1.71  | 42%          | 43.4      |
| kennedy.xls  | 1029744              | 462532             | 2.23  | 55%          | 524.2     |
| lcet10.txt   | 426754               | 250565             | 1.70  | 41%          | 287.5     |
| plrabn12.txt | 481861               | 275585             | 1.75  | 43%          | 198.6     |
| ptt5         | 513216               | 106551             | 4.82  | 79%          | 142.1     |
| sum          | 38240                | 25646              | 1.49  | 33%          | 22.5      |
| xargs.1      | 4227                 | 2602               | 1.62  | 38%          | 13.3      |

## Contributing
For most intents and purposes, Huff is considered to fulfil its original use case. Bug fixes and suggestions are welcome, however, from any member of the community.
