package kr.melted.devand.network.base;

import retrofit.Retrofit;

/**
 * Created by Envy on 2015-12-20.
 */
public class BaseAdapter {


    private static final String ENDPOINT = "http://localhost:8080";

    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        return retrofit != null
                ? retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .build()
                : retrofit;
    }
}
