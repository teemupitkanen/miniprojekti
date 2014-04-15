
package com.ohtu.miniprojektiv2.domain;

/**
 * Class for creating integers.
 * @author 41407
 */
public abstract class IntegerFactory {

    /**
     * A counter for keeping track of integer values.
     */
    
    private static Integer incrementingInteger = 0;

    /**
     * For getting the next integer.
     * @return returns an Integer.
     */
    public static Integer next() {
        return incrementingInteger++;
    }
    
    /**
     * Resets the counter.
     * @return returns an Integer with the value of 0.
     */
    public static Integer reset() {
        incrementingInteger = 0;
        return incrementingInteger;
    }
}
