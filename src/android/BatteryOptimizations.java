package com.kaminosoft.batteryoptimazations;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;

import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import android.net.Uri;
import android.net.ConnectivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;

/**
 * This class echoes a string called from JavaScript.
 */
public class BatteryOptimizations extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    
        Context context = cordova.getActivity().getApplicationContext();
        String packageName = context.getPackageName();

        if (action.equals("IsIgnoringBatteryOptimizations")) {
            try {

                if (Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP_MR1) {

                    int message = 0;
                    PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
                    if (pm.isIgnoringBatteryOptimizations(packageName)) {
                        
                        message = 1; //CON PERMISO
                    }
                    else
                    {
                        message = 0; //SIN PERMISO
                    }
                    callbackContext.success(message);
                    return true;
                }
                else 
                {
                    callbackContext.success(1); //CON PERMISO
                    return true;
                }
                
            } catch (Exception e) {

                callbackContext.error("IsIgnoringBatteryOptimizations: failed N/A");
                return false;
            }
        }
        return false;

    }//end execute
    
}
