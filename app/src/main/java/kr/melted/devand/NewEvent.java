package kr.melted.devand;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kr.melted.devand.base.BaseActivity;
import kr.melted.devand.network.base.APIAdapter;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class NewEvent extends BaseActivity {


    private Button save;

    private EditText name, description, created_by;

    private APIAdapter.APIService apiService = APIAdapter.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutResource(R.layout.activity_new_event);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiService.createEvent(name.getText().toString(), description.getText().toString(), created_by.getText().toString(), new Callback<String>() {
                    @Override
                    public void success(String s, Response response) {
                        if(response.getStatus() == 200)
                            finish();
                        else
                            Toast.makeText(NewEvent.this, "이벤트를 만들지 못했습니다.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
            }
        });

        name = (EditText) findViewById(R.id.field_name);
        description = (EditText)findViewById(R.id.field_desc);
        created_by = (EditText) findViewById(R.id.created_by);
    }

    @Override
    protected void initMenu() {

    }
}
