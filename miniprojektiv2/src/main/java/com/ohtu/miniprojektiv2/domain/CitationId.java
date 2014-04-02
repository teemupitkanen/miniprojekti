/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ohtu.miniprojektiv2.domain;

/**
 *
 * @author 41407
 */
public class CitationId {
    private static int id = 0;

    protected static int getId() {
        id++;
        return id;
    }
}
