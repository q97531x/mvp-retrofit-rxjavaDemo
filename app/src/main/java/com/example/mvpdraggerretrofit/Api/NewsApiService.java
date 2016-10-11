package com.example.mvpdraggerretrofit.Api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by XmacZone on 16/9/26.
 * 新闻api接口配置
 */

public interface NewsApiService {
    @FormUrlEncoded
    @POST("newsList")
    Observable<String> getNews(@Field("uid") String uid, @Field("areaId") String areaId,
                               @Field("fromId") String fromId);

}
