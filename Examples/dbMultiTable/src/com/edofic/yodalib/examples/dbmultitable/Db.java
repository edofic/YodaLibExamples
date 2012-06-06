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
