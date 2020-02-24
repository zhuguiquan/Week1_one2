package com.bw.week1_one.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.week1_one.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;



/**
 * DateTime:2020/2/22 0022
 * author:朱贵全(Administrator)
 * function:
 */
public class NetUtil1 {
//    private static NetUtil1 netUtil=new NetUtil1();
//
//    public static NetUtil1 getInstance() {
//        return netUtil;
//    }
//
//    public NetUtil1() {
//    }
//
//    @SuppressLint("StaticFieldLeak")
//    public void getData(String dizhi, HomeCallBack callback){
//        new AsyncTask<Void,Void,String>(){
//            @Override
//            protected void onPostExecute(String value) {
//                    callback.onGetJison(value);
//                Log.i("xxx",value);
//            }
//
//            @Override
//            protected String doInBackground(Void... voids) {
//                InputStream inputStream=null;
//                String s="";
//                try {
//                    URL url = new URL(dizhi);
//                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//                    urlConnection.setRequestMethod("GET");
//                    urlConnection.setConnectTimeout(5000);
//                    urlConnection.setReadTimeout(5000);
//                    urlConnection.connect();
//                    if(urlConnection.getResponseCode()==200){
//                         inputStream = urlConnection.getInputStream();
//                         s = io2String(inputStream);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }finally {
//                    if (inputStream != null) {
//                        try {
//                            inputStream.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//                return s;
//            }
//        };
//    }
//
//    private String io2String(InputStream inputStream) throws IOException {
//        int len=-1;
//        byte[] bytes = new byte[1024];
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        while ((len=inputStream.read(bytes))!=-1){
//            byteArrayOutputStream.write(bytes,0,len);
//        }
//        byte[] bytes1 = byteArrayOutputStream.toByteArray();
//        String s = new String(bytes1);
//        return s;
//
//    }
//    public boolean hanNet(Context context){
//        ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
//        if (activeNetworkInfo != null&&activeNetworkInfo.isAvailable()) {
//            return true;
//        }else{
//            return false;
//        }
//    }
//public void getPhoto(String http, ImageView imageView){
//    Glide.with(imageView).load(http)
//            .error(R.mipmap.ic_launcher)
//            .placeholder(R.mipmap.ic_launcher_round)
//            .apply(RequestOptions.bitmapTransform(new RoundedCorners(80)))
//            .into(imageView);
//}
//   public interface HomeCallBack{
//        void onGetJison(String s);
//        void onError(Throwable throwable);
//    }
}
