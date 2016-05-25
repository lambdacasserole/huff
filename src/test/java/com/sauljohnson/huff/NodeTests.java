package com.sauljohnson.huff;

import junit.framework.TestCase;

/**
 * Unit tests for the {@link Node} class.
 *
 * @version 1.0 24 May 2016
 * @author  Saul Johnson
 */
public class NodeTests extends TestCase {

    /**
     * Rounds a floating-point value to a number of decimal places.
     * @param value     the value to round
     * @param precision the number of decimal places to round to
     * @return          the value rounded to the number of decimal places
     */
    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    public void testHasChildren() {
        // Initialize data node and parent node.
        Node dataSubject = new Node(0, 0);
        Node parentSubject = new Node(0, dataSubject, new Node(0, 0));

        // Data node should not have children.
        assertFalse(dataSubject.hasChildren());

        // Parent node should have children.
        assertTrue(parentSubject.hasChildren());
    }

    public void testHasParent() {
        // Initialize data node and parent node.
        Node dataSubject = new Node(0, 0);
        Node parentSubject = new Node(0, dataSubject, new Node(0, 0));

        // Data node should have a parent.
        assertTrue(dataSubject.hasParent());

        // Parent node should not have a parent.
        assertFalse(parentSubject.hasParent());
    }

    public void testGetData() {
        // Initialize data node.
        Node subject = new Node(0, 64);

        // Data should be gettable.
        assertEquals(64, subject.getData());
    }

    public void testBuildBitSequence() {
        // Initialize data node and parent node.
        Node zeroSubject = new Node(0, 16);
        Node oneSubject = new Node(0, 32);
        Node subject = new Node(0, zeroSubject, oneSubject);

        // Bit sequences should build properly.
        assertEquals("0", zeroSubject.buildBitSequence().toBitString());
        assertEquals("1", oneSubject.buildBitSequence().toBitString());
    }

    public void testToXml() {
        // Initialize data node.
        Node subject = new Node(1, 16);

        // Node should produce correct XML.
        assertEquals("<node frequency=\"1.0\" data=\"16\"/>", subject.toXml());
    }

    public void testSortByFrequency() {
        // Unsorted node list.
        Node[] subject = new Node[] {
                new Node(0.1, 1),
                new Node(0.4, 4),
                new Node(0.3, 3),
                new Node(0.2, 2)
        };

        // Sort by frequency and check array is sorted.
        Node.sortByFrequency(subject);
        for (int i = 0; i < subject.length; i++) {
            assertEquals(i + 1, subject[i].getData());
        }
    }

    public void testCombineLeastFrequent() {
        // Unsorted node list.
        Node[] subject = new Node[] {
                new Node(0.1, 1),
                new Node(0.4, 4),
                new Node(0.3, 3),
                new Node(0.2, 2)
        };

        // Combine least frequent nodes and check.
        subject = Node.combineLeastFrequent(subject);
        assertEquals(3, subject.length);
        assertEquals(0.3, round(subject[0].getFrequency(), 1));
    }

    public void testCombine() {
        // Create combined node.
        Node subject = Node.combine(new Node(0.1, 1), new Node(0.2, 1));

        // Subject should have children and correct frequency.
        assertTrue(subject.hasChildren());
        assertEquals(0.3, round(subject.getFrequency(), 1));
    }
}
