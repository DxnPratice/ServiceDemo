package weather.newer.com.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    MediaPlayer player;
    public void play(){

    }
    public void next(){

    }
    public   static final  String TAG="SERVICE";
    public MyService() {
    }

    /**
     *   创建，只会执行一次，做服务的一些初始化
     *
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    /**
     *
     *多次执行
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }

    /**
     *
     * 销毁
     */
    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    /**
     *
     *
     * 解除绑定
     * @param intent
     * @return
     */
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind");
        return true;
    }




    /**
     *
     * 绑定
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");

        // TODO: Return the communication channel to the service.
       return new LocalBinder();
    }

    /**
     *
     * 重新绑定
     * @param intent
     */
    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind");
        super.onRebind(intent);
    }

    class LocalBinder extends Binder{
        /**
         *
         * 获得外部类的当前实例（服务对象）
         * @return
         */
        public MyService  getService(){
            return MyService.this;
        }
  /*      public void next(){
            player.start();
        }*/


    }
    public String sayHello(String name){
        return "hello"+name;
    }


}
