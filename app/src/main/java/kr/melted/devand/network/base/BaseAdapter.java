package kr.melted.devand.network.base;

import retrofit.RestAdapter;

/**
 * Created by Envy on 2015-12-20.
 */
public class BaseAdapter {


    private static final String ENDPOINT = "http://192.168.211.164:8080";

    private static RestAdapter retrofit;

    public static RestAdapter getRetrofit() {
        return retrofit == null
                ? retrofit = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                : retrofit;
    }
}
