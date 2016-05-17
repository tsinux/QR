package pub.iyu.qr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    private EditText username,password;
    private String usernameValue,passwordValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除标题
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.accountEdittext);
        password = (EditText) findViewById(R.id.pwdEdittext);

        Button loginBtn = (Button)findViewById(R.id.login_in);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usernameValue = username.getText().toString();
                passwordValue = password.getText().toString();

                if(usernameValue.equals("admin") && passwordValue.equals("admin")){

                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();

                    //跳转界面
                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                  Toast.makeText(LoginActivity.this,"账号或者密码错误，请重新输入",Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
