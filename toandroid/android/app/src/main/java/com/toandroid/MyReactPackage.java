package com.toandroid;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by xieyusheng on 2018/6/26.
 */

public class MyReactPackage  implements ReactPackage {
    //原生模块
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
//        return Collections.emptyList();
        List<NativeModule> modules =new ArrayList<>();
        modules.add(new echo(reactContext));
        return modules;
    }
    //原生视图
    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList(
                //刚创建的视图实例
                new MyTextViewManager()
        );
    }
}
