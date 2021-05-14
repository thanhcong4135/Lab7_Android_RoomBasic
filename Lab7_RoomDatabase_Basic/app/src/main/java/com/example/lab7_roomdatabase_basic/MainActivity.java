package com.example.lab7_roomdatabase_basic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab7_roomdatabase_basic.database.UserDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edt_user;
    private Button btn_add, btn_remove;
    RecyclerView rcv_user;

    private UserAdapter userAdapter;
    List<User> mListUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        userAdapter = new UserAdapter();
        mListUser = new ArrayList<>();
        userAdapter.setData(mListUser);

        rcv_user.setAdapter(userAdapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }

    private void initUI(){
        edt_user = findViewById(R.id.tv_name);
        btn_add = findViewById(R.id.btn_add);
        btn_remove = findViewById(R.id.btn_remove);
        rcv_user = findViewById(R.id.rcv_user);
    }

    private void addUser() {
        String strUserName = edt_user.getText().toString().trim();

        if(TextUtils.isEmpty(strUserName)){
            return;
        }

        User user = new User(strUserName);
        UserDatabase.getInstance(this).userDAO().insertUser(user);
        Toast.makeText(this, "Add user successfully", Toast.LENGTH_SHORT).show();

        edt_user.setText("");

        mListUser = UserDatabase.getInstance(this).userDAO().getListUser();
        userAdapter.setData(mListUser);
    }


}



