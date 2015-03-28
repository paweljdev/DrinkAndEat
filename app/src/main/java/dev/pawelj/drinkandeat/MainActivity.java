package dev.pawelj.drinkandeat;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    AlarmService mAlarmService;
    boolean mAlarmServiceBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart(){
        super.onStart();
        Intent intent = new Intent(getApplicationContext(), AlarmService.class);
        bindService(intent,mConnection,BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop(){
        super.onStop();
        // Unbind from the service
        if (mAlarmServiceBound) {
            unbindService(mConnection);
            mAlarmServiceBound = false;
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        if (mAlarmServiceBound) {
            unbindService(mConnection);
            mAlarmServiceBound = false;
        }
    }


    //TEST POPLACZENA Z SERWISEM
    public void TestSerwisu(View view){
        // Toast.makeText(this,"przycisk dziala", Toast.LENGTH_LONG).show();

        if (mAlarmServiceBound) {
            String wiadomosc = mAlarmService.wiadomosc();
            Toast.makeText(this, wiadomosc, Toast.LENGTH_LONG).show();
            Button zmianaNazwy = (Button)findViewById(R.id.TestServisu);
            zmianaNazwy.setText(wiadomosc);
        }


    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            AlarmService.AlarmServicelBinder binder = (AlarmService.AlarmServicelBinder) service;
            mAlarmService = binder.getService();
            mAlarmServiceBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mAlarmServiceBound = false;
        }
    };
    //KONIEC TESTU



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
