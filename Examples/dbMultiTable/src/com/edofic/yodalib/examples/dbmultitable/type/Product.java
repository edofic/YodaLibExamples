package com.edofic.yodalib.examples.dbmultitable.type;

import com.edofic.yodalib.database.Column;
import com.edofic.yodalib.database.Table;

/**
 * User: andraz
 * Date: 5/17/12
 * Time: 2:23 PM
 */
@Table
public class Product {
    @Column private long id;
    @Column private String tag;
    @Column private long price;

    public Product(long id, String tag, long price) {
        this.id = id;
        this.tag = tag;
        this.price = price;
    }

    public Product() {}

    public long getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%d %s %d\n", getId(), getTag(), getPrice());
    }
}
