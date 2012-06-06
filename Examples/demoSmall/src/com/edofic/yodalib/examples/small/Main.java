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

package com.edofic.yodalib.examples.small;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.edofic.yodalib.location.ManagedLocator;
import com.edofic.yodalib.ui.AsyncLoader;

public class Main extends Activity {
    private ManagedLocator locator;
    private AsyncLoader loader;
    private TextView currentLocation;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        currentLocation = (TextView) findViewById(R.id.currentLocation);
        loader = (AsyncLoader) findViewById(R.id.loader);
        loader.setTask(new DelayedLoader());
    }

    @Override
    protected void onResume() {
        super.onResume();
        //init locator for updates every minute with initialization if last known location is not older than a day
        locator = new ManagedLocator(this, locationUpdates, ManagedLocator.ONE_MINUTE, true, true, ManagedLocator.ONE_DAY);

        loader.load();
    }

    @Override
    protected void onPause() {
        super.onPause();
        locator.stop();
    }

    private Handler locationUpdates = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            final android.location.Location location = locator.getCurrentBest();
            currentLocation.setText(location.getLongitude() + " " + location.getLatitude());
        }
    };

    private class DelayedLoader extends AsyncTask {
        @Override
        protected Object doInBackground(Object... objects) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            loader.done();
        }
    }
}
