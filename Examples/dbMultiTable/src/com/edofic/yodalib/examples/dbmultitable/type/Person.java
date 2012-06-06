/*
 * Copyright 2012 Andraz Bajt
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
    @Column
    private long id;
    @Column
    private String name;
    @Column
    private String surname;

    public Person(long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Person() {
    }

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
