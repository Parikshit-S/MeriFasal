package com.example.android.merifasal.ui.Categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.android.merifasal.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView chatsRV;
    private EditText userMsgEdt;
    private FloatingActionButton sendMsgFAB;
    private final String BOT_KEY = "bot";
    private final String USER_KEY = "user";
    private ArrayList<ChatsModel>chatsModelArrayList;
    private ChatRVAdapter chatRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatsRV = findViewById(R.id.idRvChats);
        userMsgEdt = findViewById(R.id.idEdtMessage);
        sendMsgFAB = findViewById(R.id.idFABSend);
        chatsModelArrayList = new ArrayList<>();
        chatRVAdapter = new ChatRVAdapter(chatsModelArrayList, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        chatsRV.setLayoutManager(manager);
        chatsRV.setAdapter(chatRVAdapter);

        sendMsgFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userMsgEdt.getText().toString().isEmpty()){
                    Toast.makeText(ChatActivity.this, "Please enter your message", Toast.LENGTH_SHORT).show();
                    return;
                }
                getResponse(userMsgEdt.getText().toString());
                userMsgEdt.setText("");
            }
        });
    }
    private void getResponse(String message){
        chatsModelArrayList.add(new ChatsModel(message, USER_KEY));
        chatRVAdapter.notifyDataSetChanged();
        String url ="http://api.brainshop.ai/get?bid=160547&key=yKrsAmy7x0OdMkrs&uid=[uid]&msg="+message;
        String BASE_URL = "http://api.brainshop.ai/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<MagModel> call = retrofitAPI.getMessage(url);
        call.enqueue(new Callback<MagModel>() {
            @Override
            public void onResponse(Call<MagModel> call, Response<MagModel> response) {
                if(response.isSuccessful()){
                    MagModel model = response.body();
                    chatsModelArrayList.add(new ChatsModel(model.getCnt(), BOT_KEY));
                    chatRVAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MagModel> call, Throwable t) {
                chatsModelArrayList.add(new ChatsModel("Please revert your questions", BOT_KEY));
                chatRVAdapter.notifyDataSetChanged();
            }
        });
    }
}