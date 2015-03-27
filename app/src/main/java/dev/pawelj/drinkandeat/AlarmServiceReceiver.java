package dev.pawelj.drinkandeat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Yaqb on 2015-03-27.
 * Receiver uruchomi serwis podczas startu urządzenia
 */
public class AlarmServiceReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){
        Intent stockService = new Intent(context, AlarmService.class);
        context.startService(stockService);
    }

}
