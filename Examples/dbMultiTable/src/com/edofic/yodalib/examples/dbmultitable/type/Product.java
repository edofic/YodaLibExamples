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
public class Product {
    @Column
    private long id;
    @Column
    private String tag;
    @Column
    private long price;

    public Product(long id, String tag, long price) {
        this.id = id;
        this.tag = tag;
        this.price = price;
    }

    public Product() {
    }

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
