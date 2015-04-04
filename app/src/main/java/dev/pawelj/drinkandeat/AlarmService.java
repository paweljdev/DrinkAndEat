package dev.pawelj.drinkandeat;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by Yaqb on 2015-03-27.
 * Serwis, który będzie powiadamiał o posiłkach i piciu wody
 */
public class AlarmService extends Service {

    private final IBinder mBinder = new AlarmServicelBinder();

    public AlarmService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        //TODO - DELETE - TEST SERWISU
        Toast.makeText(this, "AutoStart serwisu", Toast.LENGTH_LONG).show();
        //END_TODO - DELETE - TEST SERWISU
        return START_STICKY;
    }


    public class AlarmServicelBinder extends Binder {
        AlarmService getService() {
            return AlarmService.this;
        }
    }

    //TODO - DELETE - TEST POPLACZENA Z SERWISEM
    public String wiadomosc(){
        return "dziala !!!";
    }
    //END_TODO - DELETE - TEST POPLACZENA Z SERWISEM
}
