package com.toandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.react.ReactActivity;

/**
 * Created by xieyusheng on 2018/6/27.
 */

public class myActivety extends Activity {
    public Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activety);
        button=(Button) findViewById(R.id.button);
        //1.匿名内部类
        button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View args0){
                        System.out.println("a");
                        //返回React  Native
                        Intent jumpIntent = new Intent(myActivety.this, MainActivity.class);
                        //返回RN的时候 带入一些数据，选择性质的渲染一些RN界面
                        jumpIntent.putExtra("fromAndroid", "谢玉胜");
                        startActivity(jumpIntent);
                    }
                }
        );
    }


}
