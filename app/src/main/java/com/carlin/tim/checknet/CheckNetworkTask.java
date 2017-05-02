package com.carlin.tim.checknet;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Tim on 5/1/2017.
 */

public class CheckNetworkTask extends AsyncTask<Void, Integer, Boolean> {

    private final Context mContext;
    private final View mView;

    public CheckNetworkTask(Context context, View view) {
        this.mContext = context;
        this.mView = view;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        NetworkStatus status = new NetworkStatus(mContext);
        return status.isConnected();
    }

    @Override
    protected void onPostExecute(Boolean aBool){
        super.onPostExecute(aBool);
        TextView textView  = (TextView)mView.findViewById(R.id.connectedTextViewValue);
        textView.setText(Boolean.toString(aBool));
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

}
