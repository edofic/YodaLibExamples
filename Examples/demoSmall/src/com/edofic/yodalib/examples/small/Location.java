package com.edofic.yodalib.examples.small;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.edofic.yodalib.location.ManagedLocator;
import com.edofic.yodalib.ui.AsyncLoader;

public class Location extends Activity {
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
        //init locator for updates every minute with initialisation if last known location is not older than a day
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
