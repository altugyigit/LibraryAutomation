package com.altygtsoft.libraryautomation;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        startAuthorization();
    }

    private void startAuthorization() {
        final EditText userName = (EditText) findViewById(R.id.txtUserName);
        final EditText password = (EditText) findViewById(R.id.txtPassword);
        Button login = (Button) findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().equals("Ali") && password.getText().toString().equals("1")){

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("ISADMIN", true );
                    startActivity(intent);

                }
                else if (userName.getText().toString().equals("Ogrenci") && password.getText().toString().equals("2")){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("ISADMIN", false );
                    startActivity(intent);
                }

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
