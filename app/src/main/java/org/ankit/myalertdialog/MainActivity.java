package org.ankit.myalertdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.ankit.perfectdialog.EasyCustomDialog;
import org.ankit.perfectdialog.EasyCustomDialogListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new EasyCustomDialog.Builder(this,"Do you really want to Exit?")
                //.setSubTitle("Please think before you go?")
                .onConfirm(new EasyCustomDialogListener() {
                    @Override
                    public void execute() {
                        Toast.makeText(MainActivity.this,"done",Toast.LENGTH_LONG).show();
                    }
                })
                .onCancel(new EasyCustomDialogListener() {
                    @Override
                    public void execute() {
                        Toast.makeText(MainActivity.this,"cancel",Toast.LENGTH_LONG).show();
                    }
                })
                .build();
    }
}
