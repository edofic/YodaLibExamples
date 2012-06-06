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
