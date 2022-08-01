package com.example.basic_launcher;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;

public abstract class AirplaneModeReceiver extends BroadcastReceiver {

    private Context context;

    /**
     * Initialize tihe reciever with a Context object.
     * @param context
     */
    public AirplaneModeReceiver(Context context) {
        this.context = context;
    }

    /**
     * Receiver for airplane mode status updates.
     *
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        if(Settings.System.getInt(
                context.getContentResolver(),
                Settings.Global.AIRPLANE_MODE_ON, 0
        ) == 0) {
            airplaneModeChanged(false);
        } else {
            airplaneModeChanged(true);
        }
    }

    /**
     * Used to register the airplane mode reciever.
     */
    public void register() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        context.registerReceiver(this, intentFilter);
    }

    /**
     * Used to unregister the airplane mode reciever.
     */
    public void unregister() {
        context.unregisterReceiver(this);
    }

    /**
     * Called when airplane mode is changed.
     *
     * @param enabled
     */
    public abstract void airplaneModeChanged(boolean enabled);

}