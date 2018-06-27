package com.toandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by xieyusheng on 2018/6/27.
 */

public class echo extends ReactContextBaseJavaModule {
    private Context mContext;
    public echo(ReactApplicationContext reactContext) {
        super(reactContext);
        mContext=reactContext;
    }

    @Override
    public String getName() {
        return "echo";
    }
    //被调用
    @ReactMethod
    public void echoSome(String msg){
//        System.out.print(msg);
        Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
        Intent jumpIntent = new Intent(mContext, myActivety.class);
        jumpIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(jumpIntent);
    }
    @ReactMethod
    public void dataToJS(Callback successBack, Callback errorBack){
        try{
            Activity currentActivity = getCurrentActivity();
            String XXXX = currentActivity.getIntent().getStringExtra("fromAndroid");
            successBack.invoke(XXXX);
        }catch (Exception e){
            errorBack.invoke(e.getMessage());
        }

    }
}
