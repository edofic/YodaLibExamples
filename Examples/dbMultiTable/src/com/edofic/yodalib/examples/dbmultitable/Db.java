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

package com.edofic.yodalib.examples.dbmultitable;

import android.content.Context;
import com.edofic.yodalib.database.Database;
import com.edofic.yodalib.database.Datasource;
import com.edofic.yodalib.examples.dbmultitable.type.Person;
import com.edofic.yodalib.examples.dbmultitable.type.Product;

/**
 * User: andraz
 * Date: 5/17/12
 * Time: 2:30 PM
 */
public class Db extends Database {
    public static final String name = "test.db";
    public static final int version = 2;

    @TableDatasource(injectForType = Person.class)
    public Datasource<Person> persons;
    @TableDatasource(injectForType = Product.class)
    public Datasource<Product> products;

    public Db(Context context) {
        super(context, name, version);
    }

    /**
     * closes both datasources
     * renders Db object useless as any calls to member datasources
     * will throw exceptions
     */
    public void close() {
        persons.close();
        products.close();
    }
}
