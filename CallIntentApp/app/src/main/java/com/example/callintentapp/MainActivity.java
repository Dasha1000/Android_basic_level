package com.example.callintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMail();
        btnWeb();
        btnMap();
        btnCall();

    }

    private void btnCall() {
        Button btnCall = findViewById(R.id.btn_call);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel: ");
                Intent callIntent = new Intent(Intent.ACTION_DIAL,number);

                if(isIntentSafe(callIntent))
                    startActivity(callIntent);
                else
                    Toast.makeText(getApplicationContext(),"Your phone have no app can dial",
                            Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void btnMap() {
        Button btnMap = findViewById(R.id.btn_map);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo: 37.422219, -122.08364?z=14");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

                if(isIntentSafe(mapIntent))
                    startActivity(mapIntent);
                else
                    Toast.makeText(getApplicationContext(),"Your phone have no app open map",
                            Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void btnWeb() {
        Button btnWeb = findViewById(R.id.btn_web);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webPage = Uri.parse("http://vk.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webPage);

                if(isIntentSafe(webIntent))
                    startActivity(webIntent);
                else
                    Toast.makeText(getApplicationContext(),"Your phone have no open web pages",
                            Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void btnMail() {
        Button btnMail = findViewById(R.id.btn_mail);
        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",
        "example@gmail.com", null));
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"hello@mail.ru, hi@mail.ru"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Send Intent Message");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "I text my mail by Android App");

                if(isIntentSafe(emailIntent))
                    startActivity(emailIntent);
                else
                    Toast.makeText(getApplicationContext(),"Your phone have no app can send messages",
                            Toast.LENGTH_SHORT).show();
            }
        });
    }

    private  boolean isIntentSafe(Intent intent){
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent,0);
        return activities.size()>0;

    }
}
