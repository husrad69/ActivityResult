package at.wifi.swdev.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AgeVerificationActivity extends AppCompatActivity {


    public static final String MINDERJAEHRIG = "minderjaehrig";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_verification);
    }

    public void startVerifikation(View view) {

        EditText et_alter = findViewById(R.id.et_alter);


        if (et_alter.getText().toString().equals("")) {
            Toast.makeText(this, "Bitte eine Nummer eingeben!", Toast.LENGTH_LONG).show();
        } else {

            String input = et_alter.getText().toString();
            int inputInt = Integer.parseInt(input);
            Intent intent = new Intent();
            if (inputInt < 18) {
                intent.putExtra(MINDERJAEHRIG, false);
            } else {
                intent.putExtra(MINDERJAEHRIG, true);
            }

            setResult(RESULT_OK, intent);
            finish();
        }
    }
}

