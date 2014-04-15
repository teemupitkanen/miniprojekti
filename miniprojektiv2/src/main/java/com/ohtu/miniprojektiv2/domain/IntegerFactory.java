
package com.ohtu.miniprojektiv2.domain;

/**
 *
 * @author 41407
 */
public abstract class IntegerFactory {

    
    private static Integer incrementingInteger = 0;

    public static Integer next() {
        return incrementingInteger++;
    }
    
    public static Integer reset() {
        incrementingInteger = 0;
        return incrementingInteger;
    }
}
