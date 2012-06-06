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

package com.edofic.yodalib.examples.dbbenchmark;

import com.edofic.yodalib.database.Column;
import com.edofic.yodalib.database.Table;

/**
 * User: andraz
 * Date: 4/5/12
 * Time: 11:38 PM
 */
@Table(name = "people", version = 1)
public class Person {
    @Column(name = "id", primaryKey = true, autoIncrement = true, position = 1)
    private long id;
    @Column(name = "name", position = 2)
    private long debt;
    @Column(name = "debt", position = 3)
    private String name;

    public Person() {
    }

    public Person(long id, String name, long debt) {
        this.debt = debt;
        this.id = id;
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public long getDebt() {
        return debt;
    }

    public void setDebt(long debt) {
        this.debt = debt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
