package fortz.company.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EarnCoins extends AppCompatActivity {

    private TextView inviteFriends, watchVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earn_coins);

        inviteFriends=(TextView)findViewById(R.id.invite_friends);
        watchVideo=(TextView)findViewById(R.id.watch_video);

        getSupportActionBar().setTitle("Earn Coins");

    }
}
