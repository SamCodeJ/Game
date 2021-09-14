package fortz.company.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;


public class RegistrationOptions extends AppCompatActivity {

    private TextView login_instead, userID;
    private RelativeLayout normal_registration;
    private CallbackManager callbackManager;
    private LoginButton fbLoginButton;
    private ImageView profile_pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_options);
        callbackManager = CallbackManager.Factory.create();

        login_instead=(TextView) findViewById(R.id.login_instead);
        fbLoginButton=findViewById(R.id.fb_login_button);
        userID=findViewById(R.id.user_id);
        profile_pic=findViewById(R.id.profile_pic);

        fbLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                userID.setText(loginResult.getAccessToken().getUserId());
                String imageUrl="https://graph.facebook.com/"+loginResult.getAccessToken().getUserId()+"/picture?return_ssl_resources=1";
                Picasso.get().load(imageUrl).into(profile_pic);
                Log.d("imageUrl",imageUrl);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        normal_registration= (RelativeLayout) findViewById(R.id.normal_registration);

        login_instead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login=new Intent(RegistrationOptions.this,Login_Screen.class);
                startActivity(login);
            }
        });

        normal_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login=new Intent(RegistrationOptions.this,Register_Screen.class);
                startActivity(login);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
