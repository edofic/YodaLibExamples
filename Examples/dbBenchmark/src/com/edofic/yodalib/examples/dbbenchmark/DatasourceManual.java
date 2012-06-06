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

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * User: andraz
 * Date: 4/5/12
 * Time: 11:36 PM
 */
public class DatasourceManual {
    private SQLiteDatabase db;
    private final DbHelper dbHelper;

    private final String[] allColumnsPeople = {
            DbHelper.COLUMN_ID,
            DbHelper.COLUMN_NAME,
            DbHelper.COLUMN_DEBT
    };

    public DatasourceManual(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    private Person cursorToPerson(Cursor cursor) {
        long id = cursor.getLong(0);
        String name = cursor.getString(1);
        long debt = cursor.getLong(2);
        return new Person(id, name, debt);
    }

    public ArrayList<Person> getAllPersons() {
        ArrayList<Person> persons = new ArrayList<Person>();
        Cursor cursor = db.query(DbHelper.TABLE_PEOPLE, allColumnsPeople,
                null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Person person = cursorToPerson(cursor);
            persons.add(person);
            cursor.moveToNext();
        }
        cursor.close();
        return persons;
    }

    public void insertPerson(Person person) {
        ContentValues values = new ContentValues();
        values.put(DbHelper.COLUMN_NAME, person.getName());
        values.put(DbHelper.COLUMN_DEBT, person.getDebt());

        if (person.getId() != 0) {
            values.put(DbHelper.COLUMN_ID, person.getId());
            db.update(DbHelper.TABLE_PEOPLE, values,
                    DbHelper.COLUMN_ID + " = " + person.getId(),
                    null);
        } else {
            long newId = db.insert(DbHelper.TABLE_PEOPLE, null, values);
            person.setId(newId);
        }
    }

    public void deletePerson(long id) {
        db.delete(
                DbHelper.TABLE_PEOPLE,
                DbHelper.COLUMN_ID + " = " + id,
                null);
    }

    public void clear() {
        db.delete(DbHelper.TABLE_PEOPLE, null, null);
    }
}
