package com.sniuniu.afunny.net;

import com.sniuniu.afunny.DataList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FunnyApi {

    @GET("satinCommentApi")
    Observable<String> getSatinComment(@Query("id") int id, @Query("page") int page);

    @GET("satinGodApi")
    Observable<DataList> getsatinGodApi(@Query("type")int type, @Query("page") int page);

    int TYPE_ALL = 1;
    int TYPE_TEXT = 2;
    int TYPE_PICTURE = 3;
    int TYPE_GIF = 4;
    int TYPE_VIDEO = 5;

}
