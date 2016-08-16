package weather.newer.com.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //服务的引用
    MyService myService;
    public   static final  String TAG="activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");
    }

    public void doStart(View view) {
        //启动服务
        startService(new Intent(this,MyService.class));
    }

    public void doStop(View view) {
        //停止服务
        stopService(new Intent(this, MyService.class));
    }

    public void doBind(View view) {
        //绑定   1,意图 ，定义了要绑定的服务 2,服务连接器 3,标识符，如果服务不存在则创建
        bindService(
              new Intent(this,MyService.class)  ,
                conn,
                BIND_AUTO_CREATE

        );
    }

    public void doUnbind(View view) {
        //取消绑定
        unbindService(conn);
    }
    //服务连接器(服务监视器）
    ServiceConnection  conn=new ServiceConnection() {
        /**
         *
         * 绑定后，获得服务的引用
         * @param name       ComponentName
         * @param service   IBinder
         */
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //获得引用
            MyService.LocalBinder binder= (MyService.LocalBinder) service;
            myService=binder.getService();
            Log.d("     ", "onServiceConnected");

        }

        /**
         *
         * 服务意外结束时执行
         * @param name
         */
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("     ", "onServiceDisconnected");
                 myService=null;
        }
    };

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }
}
