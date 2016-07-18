package com.ahmadarif.fcmdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    String TAG = "FormActivity";
    String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvResponse = (TextView) findViewById(R.id.response);

        // [START handle_data_extras]
        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                String value = getIntent().getExtras().getString(key);
                Log.d(TAG, "Key: " + key + " Value: " + value);
                response = value;
            }
        }
        Button logTokenButton = (Button) findViewById(R.id.logTokenButton);
        if (logTokenButton != null) {
            logTokenButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (FirebaseInstanceId.getInstance().getToken() == null) {
                        response = FirebaseInstanceId.getInstance().getToken();
                        Log.d(TAG, "InstanceID token: " + FirebaseInstanceId.getInstance().getToken());
                    } else {
                        Log.d(TAG, "InstanceID token: " + FirebaseInstanceId.getInstance().getToken());
                        response = FirebaseInstanceId.getInstance().getToken();
                    }
                    tvResponse.setText(response);
                }
            });
        }
    }
}
