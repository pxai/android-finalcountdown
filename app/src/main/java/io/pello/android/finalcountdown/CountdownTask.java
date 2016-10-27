package io.pello.android.finalcountdown;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by PELLO_ALTADILL on 27/10/2016.
 *  * AsyncTask<Class1,Class2,Class3> where:
 * -Class1: type of information for the task (e.g. the URL to get), passed
 * 			through execute method
 * -Class2: type of information to indicate progress, must be the same
 *          class in onProgressUpdate method
 * -Class3: type of information for the postTask
 * @author Pello Xabier Altadill Izura
 */
public class CountdownTask
        extends AsyncTask<Integer, String, String> {
    private MainActivity mainActivity;

    public CountdownTask(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    @Override
    protected void onPreExecute () {
        Toast.makeText(this.mainActivity, "Starting Async Task", Toast.LENGTH_SHORT).show();
        this.mainActivity.getCountDownNumber().setText("10");
    }

    @Override
    protected String doInBackground(Integer... params) {
        int number = params[0];
        try {
            while (number > 0) {
                number--;
                this.publishProgress(number + "");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            Log.d("PELLODEBUG","Exception while counting down " + e.getMessage());
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... item) {
        Log.d("PELLODEBUG","onProgressUpdate called");
        this.mainActivity.getCountDownNumber().setText(item[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        mainActivity.getMediaPlayer().stop();
    }
}
