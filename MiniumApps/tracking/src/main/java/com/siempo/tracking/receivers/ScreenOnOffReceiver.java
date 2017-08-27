package com.siempo.tracking.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.siempo.tracking.model.LogEvent;
import com.siempo.tracking.util.TrackingLogger;

import org.androidannotations.annotations.EReceiver;

import minium.co.core.log.Tracer;

/**
 * Created by Shahab on 11/24/2016.
 */
@EReceiver
public class ScreenOnOffReceiver extends BroadcastReceiver {

    private boolean screenOff;

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            screenOff = true;
            Tracer.d("Screen off event");
        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            screenOff = false;
            Tracer.d("Screen on event");
        }
        TrackingLogger.log(new LogEvent(LogEvent.EventType.SCREEN_ON).setEffect(screenOff ? "On" : "Off"));
        //TrackingLogger.log("Screen event\t" + (screenOff ? "On" : "Off"), null);
    }
}