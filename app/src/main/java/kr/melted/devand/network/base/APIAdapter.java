package kr.melted.devand.network.base;

import java.util.List;

import kr.melted.devand.network.model.Event;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Envy on 2015-12-20.
 */
public class APIAdapter extends BaseAdapter {

    public interface APIService {
        @GET("/event")
        void getEventList(Callback<List<Event>> db);

        @POST("/event")
        void createEvent(String name, String desc, String create_by, Callback<String> db);
    }

    public static APIService getInstance() {
        return getRetrofit().create(APIService.class);
    }
}
