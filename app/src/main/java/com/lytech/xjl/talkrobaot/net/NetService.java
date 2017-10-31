package com.lytech.xjl.talkrobaot.net;


import com.lytech.xjl.talkrobaot.bean.Message;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by xjl on 17-10-31.
 */

public interface NetService {

    /**
     * talk
     * @param question
     * @return
     */
    @Headers("Authorization:APPCODE 60233781427b44f2bdc890eb55657331")
    @GET("/iqa/query?")
    Observable<Message> talk(@Query("question") String question);
}
