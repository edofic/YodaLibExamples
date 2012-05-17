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

    @TableDatasource
    public final Datasource<Person> persons = new Datasource<Person>(this, Person.class);
    @TableDatasource
    public final Datasource<Product> products = new Datasource<Product>(this, Product.class);

    public Db(Context context) {
        super(context, name, version);
    }
}
