package com.edofic.yodalib.examples.dbmultitable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.edofic.yodalib.examples.dbmultitable.type.Person;
import com.edofic.yodalib.examples.dbmultitable.type.Product;

public class MainActivity extends Activity {
    private Db db;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final DemoApp demoApp = (DemoApp) getApplication();
        db = demoApp.getDb();
    }

    public void insertPerson(View sender) {
        db.persons.insert(new Person(0, "John", "Doe"));
    }

    public void insertProduct(View sender) {
        db.products.insert(new Product(0, "TestCase", 99));
    }

    public void read(View sender) {
        StringBuilder sb = new StringBuilder();
        for (Person p : db.persons.getAll()) {
            sb.append(p.toString());
        }
        for (Product p : db.products.getAll()) {
            sb.append(p.toString());
        }
        ((TextView) findViewById(R.id.text)).setText(sb.toString());
    }
}
