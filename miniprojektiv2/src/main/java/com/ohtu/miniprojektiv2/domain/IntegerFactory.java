
package com.ohtu.miniprojektiv2.domain;

/**
 *
 * @author 41407
 */
public class IntegerFactory {

    private static Integer integer = 0;

    public static Integer next() {
        return integer++;
    }
}
