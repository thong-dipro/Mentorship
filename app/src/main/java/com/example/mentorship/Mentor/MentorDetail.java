package com.example.mentorship.Mentor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mentorship.R;

import java.util.ArrayList;

public class MentorDetail extends AppCompatActivity implements MentorActivityClickListener {
   private TextView textView_numOfMentee,textView_numOfHourMent,textView_rate,textView_intro,textView_name;
   private RecyclerView recyclerView;
   private Mentor mentor = new Mentor();
   private ImageButton button_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_detail);
//        Intent intent = getIntent();
//        mentor = (Mentor) intent.getSerializableExtra("Mentor");
        textView_numOfMentee = findViewById(R.id.mentor_detail_textView_numOfMentee);
        textView_numOfHourMent = findViewById(R.id.mentor_detail_textView_numOfHourMentor);
        textView_rate = findViewById(R.id.mentor_detail_textView_rate);
        textView_intro = findViewById(R.id.mentor_detail_textView_introduce);
        textView_name = findViewById(R.id.mentor_detail_textView_name);
        recyclerView = findViewById(R.id.mentor_detail_recyclerView_fields);
        button_back = findViewById(R.id.mentor_detail_imageButton_back);
        textView_numOfMentee.setText(mentor.getNumOfMentee()+"");
        textView_numOfHourMent.setText(mentor.getNumOfHourMent()+"");
        textView_rate.setText(mentor.getRate()+"");
        textView_intro.setText(mentor.getIntroduction());
        textView_name.setText(mentor.getName());
        renderRecyclerView(mentor.getMentorActivities());
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void renderRecyclerView(ArrayList<MentorActivity> list){
        recyclerView.setHasFixedSize(true);
        MentorActivityAdapter adapter = new MentorActivityAdapter(list,this);
        RecyclerView.LayoutManager l = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        );
        recyclerView.setLayoutManager(l);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onMentorActivityClickListener(int i) {

    }
}