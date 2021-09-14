package fortz.company.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Register_Screen extends AppCompatActivity {

    private TextView login_instead;
    private Button registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__screen);

        registerBtn=(Button)findViewById(R.id.registerBtn);
        login_instead=(TextView)findViewById(R.id.login_instead);
        login_instead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login=new Intent(Register_Screen.this,Login_Screen.class);
                startActivity(login);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainPage=new Intent(Register_Screen.this,MainPage.class);
                startActivity(mainPage);
            }
        });
    }
}
