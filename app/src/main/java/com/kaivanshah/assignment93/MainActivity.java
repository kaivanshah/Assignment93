package com.kaivanshah.assignment93;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    Button btn_Save, btn_Check;
    TextView tv_Messgage;
    String FILENAME = "hello_file.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_Save = (Button)(this.findViewById(R.id.btn_Save));
        Button btn_Check = (Button)(this.findViewById(R.id.btn_Check));
        tv_Messgage = (TextView) (this.findViewById(R.id.tv_Messgage));

        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WriteFile();

            }
        });

        btn_Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                File oFile =new File(getApplicationContext().getFilesDir() + "/" + FILENAME);
                if(oFile.exists())
                {
                    tv_Messgage.setText("File exist");
                }
                else
                {
                    tv_Messgage.setText("File is not exist");
                }

            }
        });
    }

    public void WriteFile()
    {
            try
            {

                String string = "hello world!";


                FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                fos.write(string.getBytes());
                fos.flush();
                fos.close();
                Toast.makeText(this, "File is Saved Successfully", Toast.LENGTH_LONG).show();
            }
            catch (Exception e)
            {
                tv_Messgage.setText(e.getMessage());

            }
        }
    }






