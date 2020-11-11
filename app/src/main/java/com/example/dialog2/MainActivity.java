package com.example.dialog2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_choosepage,null);
                TextView cancel = view.findViewById(R.id.choosepage_cancel);
                TextView sure = view.findViewById(R.id.choosepage_sure);

                final Dialog dialog = builder.create();
                dialog.show();
                dialog.getWindow().setContentView(view);
                dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
                cancel.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                sure.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        final EditText username = (EditText)dialog.findViewById(R.id.username);
                        final EditText password = (EditText)dialog.findViewById(R.id.password);
                        if(username.getText().toString().equals("abc")&&password.getText().toString().equals("123")){
                            Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"用户名或密码错误！",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }


                    }
                });

            }
        });
    }
}