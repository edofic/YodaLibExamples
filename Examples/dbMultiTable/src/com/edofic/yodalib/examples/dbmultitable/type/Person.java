package com.edofic.yodalib.examples.dbmultitable.type;

import com.edofic.yodalib.database.Column;
import com.edofic.yodalib.database.Table;

/**
 * User: andraz
 * Date: 5/17/12
 * Time: 2:23 PM
 */
@Table
public class Person {
    @Column private long id;
    @Column private String name;
    @Column private String surname;

    public Person(long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Person() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s\n", getId(), getName(), getSurname());
    }
}
