package fortz.company.game;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fortz.company.game.model.QuestionModel;

public class PlayGame extends AppCompatActivity {

    private TextView countDown;
    private EditText etQuestion, etOptionA, etOptionB, etOptionC, etOptionD;
    private QuestionModel question1, question2, question3, question4, question5, questionModel;
    private ImageView ivSubmit;
    int counter;
    ArrayList<QuestionModel>questionArrayList;


    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        etQuestion=findViewById(R.id.et_questions);
        etOptionA=findViewById(R.id.et_option_a);
        etOptionB=findViewById(R.id.et_option_b);
        etOptionC=findViewById(R.id.et_option_c);
        etOptionD=findViewById(R.id.et_option_d);
        ivSubmit=findViewById(R.id.iv_submit);

        questionArrayList= (ArrayList<QuestionModel>) getIntent().getSerializableExtra("questionArrayList");

//
//
//        counter=1;
//        ivSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                timer.cancel();
//                timer.start();
//
//                questionModel= questionList.get(counter);
//                etQuestion.setText(questionModel.getQuestion());
//                etOptionA.setText(questionModel.getOptionA());
//                etOptionB.setText(questionModel.getOptionB());
//                etOptionC.setText(questionModel.getOptionC());
//                etOptionD.setText(questionModel.getOptionD());
//
//                ++counter;
//            }
//        });
//
//        etOptionA.setOnClickListener(new EventListener());
//        etOptionB.setOnClickListener(new EventListener());
//        etOptionC.setOnClickListener(new EventListener());
//        etOptionD.setOnClickListener(new EventListener());
//
//        countDown=(TextView)findViewById(R.id.count_down);
//
//        timer=new CountDownTimer(20000, 1000) {
//
//            public void onTick(long millisUntilFinished) {
//                countDown.setText(""+ millisUntilFinished / 1000);
//            }
//
//            public void onFinish() {
//                countDown.setText("00");
//            }
//        }.start();
//         questionModel= questionList.get(0);
//         etQuestion.setText(questionModel.getQuestion());
//         etOptionA.setText(questionModel.getOptionA());
//         etOptionB.setText(questionModel.getOptionB());
//         etOptionC.setText(questionModel.getOptionC());
//         etOptionD.setText(questionModel.getOptionD());

        displayQuestion();
    }

    public void displayQuestion(){
        Collections.shuffle(questionArrayList);

        Log.d("question",questionArrayList.get(0).getQuestion());
        Log.d("question1",questionArrayList.get(1).getQuestion());
        Log.d("question2",questionArrayList.get(2).getQuestion());


    }



    private class EventListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            v.getSolidColor();
        }
    }
}
