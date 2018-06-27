package com.toandroid;

import android.widget.TextView;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

/**
 * Created by xieyusheng on 2018/6/26.
 */

public class MyTextViewManager extends SimpleViewManager<TextView> {

    @Override
    public String getName() {
        return "MyTextView";
    }
    //需要创建view实例,并且返回组件
    @Override
    protected TextView createViewInstance(ThemedReactContext reactContext) {
        TextView textView = new TextView(reactContext);
        textView.setText("你好！中国");
        return textView;
    }
}
