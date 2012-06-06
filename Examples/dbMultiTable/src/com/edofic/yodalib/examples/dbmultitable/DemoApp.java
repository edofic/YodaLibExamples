package com.edofic.yodalib.examples.dbmultitable;

import android.app.Application;

/**
 * User: andraz
 * Date: 6/6/12
 * Time: 10:56 PM
 * <p/>
 * Application is a natural singleton in android - so it's the natural place
 * to handle db
 */
public class DemoApp extends Application {
    private Db db;

    /**
     * lazy instantiate the db when needed
     *
     * @return
     */
    public synchronized Db getDb() {
        if (db == null) {
            db = new Db(this);
        }
        return db;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        //dont to forget to close your connections
        db.close();
    }
}
