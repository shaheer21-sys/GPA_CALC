package com.example.gpa_calc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.firebase.auth.FirebaseAuth;

import static android.util.Log.d;


public class MainActivity extends AppCompatActivity {
    String TAG = "main Activity";
    Button logoutButton;
    int marks[]={12,50,89,45,98};
    int cred[]={4,4,4,2,2};
    TextView sgpa_disp;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Toolbar for Logout Button
        sgpa_disp=findViewById(R.id.textView3);
        double ans=sgpa(marks,cred);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "Firebase connection successful", Toast.LENGTH_LONG).show();
        logoutButton = findViewById(R.id.buttonLog);
        sgpa_disp.setText(Double.toString(ans));

    }

    //Function to logout firebase account
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(getApplicationContext(),login.class));
        finish();
    }
    public double sgpa(int marks[], int cred[])
    {
        int gr=0; int sum=0; int total_creds=0;
        for(int i=0;i<marks.length;i++) {
            if (marks[i] >= 60) {
                gr = (int) (marks[i] / 10) + 1;

            } else if (marks[i] < 60 && marks[i] >= 45) {
                gr = 5;
            } else if (marks[i] < 45 && marks[i]>= 40)
                gr = 4;
            else
                gr = 0;
            total_creds+=cred[i];
            sum=sum+(gr*cred[i]);

        }
        return (sum/total_creds);



        }
    }







