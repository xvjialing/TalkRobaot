package com.lytech.xjl.talkrobaot.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xjl on 17-10-31.
 */

public class NetUtils {
    private NetUtils(){}

    private static class NetUtilsHolder{
        private static final NetUtils netUtils=new NetUtils();
    }

    public static synchronized NetUtils getInstance(){
        return NetUtilsHolder.netUtils;
    }

    public NetService getNetService(){
        Retrofit retrofit=new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(UrlUtils.baseUrl)
                .build();
        NetService netService=retrofit.create(NetService.class);

        return netService;
    }
}
