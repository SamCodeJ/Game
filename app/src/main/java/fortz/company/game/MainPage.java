package fortz.company.game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import fortz.company.game.model.QuestionModel;

public class MainPage extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Button settingBtn, playBtn;
    private ArrayList<QuestionModel> questionArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initializeArrayList();

        playBtn= findViewById(R.id.playBtn);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainPage.this,PlayGame.class);
                intent.putExtra("questionArrayList", questionArrayList);
                startActivity(intent);
            }
        });
        settingBtn=findViewById(R.id.settingBtn);

        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainPage.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        NavigationView nav_view=(NavigationView)findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Intent intent;
                switch(item.getItemId()){
                    case R.id.gold_membership:

                        intent=new Intent(MainPage.this, GoldMembership.class);
                        startActivity(intent);

                        break;
                    case R.id.leader_board:

                        break;
                    case R.id.share:

                        break;
                    case R.id.withdraw:

                        intent=new Intent(MainPage.this, Withdraw.class);
                        startActivity(intent);
                        break;
                    case R.id.instructions:

                        break;
                    case R.id.earn_coins:

                        intent=new Intent(MainPage.this, EarnCoins.class);
                        startActivity(intent);
                        break;
                    case R.id.contact_us:

                        break;
                    case R.id.privacy_policy:

                        break;
                }

                return true;
            }
        });



    }

    private void initializeArrayList(){
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference("Questions");

        databaseReference.addValueEventListener(new ValueEventListener() {
            int counter=0;
            @Override
            public void onDataChange(DataSnapshot snapshot) {
//                Log.d("Message","Here in InitQuestion");
                for(DataSnapshot postSnapshot: snapshot.getChildren()){
                    String optionA=postSnapshot.child("option_a").getValue().toString();
                    String optionB=postSnapshot.child("option_b").getValue().toString();
                    String optionC=postSnapshot.child("option_c").getValue().toString();
                    String optionD=postSnapshot.child("option_d").getValue().toString();
                    String questionContent=postSnapshot.child("question_content").getValue().toString();
                    String rightAnswer=postSnapshot.child("right_answer").getValue().toString();
                    questionArrayList.add(new QuestionModel(counter++,questionContent,optionA,optionB,optionC,optionD,rightAnswer));
                }
//                initRecyclerView();
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drawermenu, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(mToggle.onOptionsItemSelected(item)){

//            if (id==R.id.gold_membership){
//                Intent intent=new Intent(MainPage.this, GoldMembership.class);
//                startActivity(intent);
//                finish();
//            }else if(id==R.id.leaderboard){
//
//            }else if(id==R.id.share){
//
//            }else if(id==R.id.withdraw){
//                Intent intent=new Intent(MainPage.this, Withdraw.class);
//                startActivity(intent);
//                finish();
//            }else if(id==R.id.instructions){
//
//            }else if(id==R.id.earn_coins){
//                Intent intent=new Intent(MainPage.this, EarnCoins.class);
//                startActivity(intent);
//                finish();
//            }else if(id==R.id.contact_us){
//
//            }else if(id==R.id.privacy_policy){
//
//            }
//            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return false;
    }
}
