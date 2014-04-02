/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ohtu.miniprojektiv2.domain;

/**
 *
 * @author teemupitkanen1
 */
public interface Citation {

    boolean equals(Object obj);

    String getTitle();

    void setTitle(String title);
    
}
