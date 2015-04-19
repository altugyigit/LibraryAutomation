package com.altygtsoft.libraryautomation;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.google.zxing.*;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QRReader extends Activity {
    /** Called when the activity is first created. */

    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrreader);
        scan();
    }



    private void scan() {
        Button qrBtn = (Button)findViewById(R.id.scanner);
        Button barBtn = (Button)findViewById(R.id.scanner2);
        qrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intent, 0);
            }
        });

        barBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                intent.putExtra("SCAN_MODE", "CODABAR");
                startActivityForResult(intent, 0);
            }
        });



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0){
            TextView txtResult = (TextView)findViewById(R.id.textView);
            if(resultCode == RESULT_OK) {
                txtResult.setText(data.getStringExtra("SCAN_RESULT"));
            }
            else if(resultCode == RESULT_CANCELED){
                txtResult.setText("TARAMA İPTAL");

            }
        }
    }


}