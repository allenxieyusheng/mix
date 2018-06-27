#### 混合开发概述
**1. 阐述**：  

在RN开发的过程中时常需要调用原生的一些模块／组件／以及相互之间的界面的跳转调用，之前的文章中简单的阐述了如何封装一些组件和模块，但是在功能的迭代中发现，一些封装的东东已经满足不了开发的需求，因此，混合开发显得格外的重要


**2. 思路：**  
所谓的混合开发就是在APP的界面RN和Android极面之间的相互转换，主要的有两种
1. 从RN--->Android
2. 从Android -->RN 

## 从RN---Android的思路是  
首先一点我们得知道RN的界面只是一个MianActivity 在这我们通过这句,将jsBundle注册到这个Activety中
```
AppRegistry.registerComponent('toandroid', () => App);

public class MainActivity extends ReactActivity {
    //toandroid 在js的入口文件中引入  名称需要相同
    @Override
    protected String getMainComponentName() {
        return "toandroid";
    }
}
```
要启动原生的Activety就需要在封装的模块中去调用Intent方法

```
    @ReactMethod
    public void echoSome(String msg){
//        System.out.print(msg);
        Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
        Intent jumpIntent = new Intent(mContext, myActivety.class);
        //这句很重要
        jumpIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //开启另外一个Active，当然你也可以从js端加点参数过来
        mContext.startActivity(jumpIntent);
    }
```


## 从Android---RN的思路是
在原生端我们自定义的Activety中Intent被注册在RN的MainActivity  

```



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

```

需要参数的话就在导出的模块中 导出给JS端，js端通过这个返回的参数，来指定的渲染一些界面
```
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
```
这时候就可以在js端获取到啦
```
  componentDidMount(){
     //进行从Activity中获取数据传输到JS
     NativeModules.echo.dataToJS((value) => {
                    alert(value);
                  },
                   (result) => {
                    ToastAndroid.show('JS界面:错误信息为:'+result,ToastAndroid.SHORT);
                  })
  }
```



实例代码[传送门](https://github.com/allenxieyusheng/mix)