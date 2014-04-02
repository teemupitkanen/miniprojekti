
package com.ohtu.miniprojektiv2.domain;


public interface Citation {

    @Override
    boolean equals(Object obj);

    int getId();

    String getTitle();

    void setTitle(String title);
   
}
