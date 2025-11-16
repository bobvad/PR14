package com.example.expertsystem_degtinnikov;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public int nLayout = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }
    public void OnLayout(View view)
    {
        if(nLayout == 0)
        {
            setContentView(R.layout.step_1);
            nLayout = 1;
        }
        else if(nLayout == 1)
        {
            EditText tbFirstName = findViewById(R.id.tbFirstName);
            EditText tbLastName = findViewById(R.id.tbLastName);
            if(String.valueOf(tbFirstName.getText()).isEmpty())
            {
                AlertDialog("Уведомление","Необходимо ввести имя пользователя");
            }
            else if(String.valueOf(tbLastName.getText()).isEmpty())
            {
                AlertDialog("Уведомление","Необходимо ввести фамилию пользователя");
            }
            else
            {
                setContentView(R.layout.step_2);
                nLayout = 2;
            }
        }
        else if(nLayout == 2)
        {
            RadioGroup rgPeriod = findViewById(R.id.rgPeriod);
            if(rgPeriod.getCheckedRadioButtonId() == -1)
            {
                AlertDialog("Уведомление", "Необходимо выбрать переодичность занятий");
                return;
            }
            else
            {
               setContentView(R.layout.step_3);
               nLayout = 3;
            }
        }
        else if(nLayout == 3)
        {
            CheckBox isRear = findViewById(R.id.isRear);
            CheckBox isBiceps = findViewById(R.id.isBiceps);
            CheckBox isTriceps = findViewById(R.id.isTriceps);
            CheckBox isMuscles = findViewById(R.id.isMuscles);
            if(isRear.isChecked()
                    || isBiceps.isChecked()
                    || isTriceps.isChecked()
                    || isMuscles.isChecked())
            {
                setContentView(R.layout.step_4);
                nLayout = 4;
            }
            else
            {
                AlertDialog("Уведомления","Необходимо выбрать часть тела для тренировок");
                return;
            }
        }
        else if(nLayout == 4)
        {
            EditText tbWeight = findViewById(R.id.tbWeight);
            EditText tbHeight = findViewById(R.id.tbHeight);

            if(String.valueOf(tbWeight.getText()).isEmpty())
            {
                AlertDialog("Уведомления","Необходимо ввести вес пользователя");
                return;
            }
            else if(String.valueOf(tbHeight.getText()).isEmpty())
            {
                AlertDialog("Уведомления","Необходимо ввести рост пользователя");
                return;
            }
            else
            {
                setContentView(R.layout.step_5);
                nLayout = 5;
            }
        }
        else  if(nLayout == 5)
        {
            RadioGroup rgGender = findViewById(R.id.rgGender);
            if (rgGender.getCheckedRadioButtonId() == -1)
            {
                AlertDialog("Уведомление","Необходимо выбрать ваш пол");
                return;
            }
            else
            {
                setContentView(R.layout.step_3);
                nLayout = 6;
            }
        }
    }
    public void AlertDialog(String title, String message)
    {
        AlertDialog.Builder Builder = new AlertDialog.Builder(MainActivity.this);
        Builder.setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog Alert = Builder.create();
        Alert.show();
    }
}