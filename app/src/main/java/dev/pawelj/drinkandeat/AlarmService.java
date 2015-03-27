package dev.pawelj.drinkandeat;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by Yaqb on 2015-03-27.
 * Serwis, który będzie powiadamiał o posiłkach i piciu wody
 */
public class AlarmService extends Service {
    public AlarmService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flag, int startID){

        Toast.makeText(this, "Serwis dziala", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
