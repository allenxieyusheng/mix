package com.toandroid;

import com.facebook.react.ReactActivity;

public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    //toandroid 在js的入口文件中引入  名称需要相同
    @Override
    protected String getMainComponentName() {
        return "toandroid";
    }
}
