package com.example.judy.medium_cs179k;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import android.widget.Button;

import android.app.Activity;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity// implements View.OnClickListener
{

    private static int RC_SIGN_IN = 1;      //request code flag for when we return from starting the activity
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;       //references specific part of the database

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

//    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button browsebtn = findViewById(R.id.button2);
        browsebtn.setOnClickListener(new View.OnClickListener()
                                     {
                                                 @Override
                                         public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.button2:
                                             Toast.makeText(getApplicationContext(),
                                                     "Testing", Toast.LENGTH_SHORT).show();

                                             Intent intent = new Intent(getApplicationContext() , BrowserActivity.class);
                                             startActivity(intent);
//                break;
                                         }
    });


//    }
//
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mFirebaseAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener()
        {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth)
            {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null)
                {
                    //user is signed in
                    Toast.makeText(MainActivity.this, "You are now signed in", Toast.LENGTH_LONG).show();
                }
                else
                {
                    //user is signed out
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)   //autofills in user credentials from cache
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.EmailBuilder().build(),
                                            new AuthUI.IdpConfig.GoogleBuilder().build()))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };

    }
//================Judy's test code=====================================================
    //this is to test out the navigation bar for user ui


//=====================================================================================
//    @Override
//    protected void onPause()
//    {
//        super.onPause();
//        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
//    }
//
//    @Override
//    protected void onResume()
//    {
//        super.onResume();
//        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
//    }

}
