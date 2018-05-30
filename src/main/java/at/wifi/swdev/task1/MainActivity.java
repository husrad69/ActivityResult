package at.wifi.swdev.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startUeberpruefung(View view) {
        Intent intent = new Intent(this, AgeVerificationActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode==REQUEST_CODE && resultCode==RESULT_OK){
            TextView tv = findViewById(R.id.tv_ergebnis);
            boolean result = data.getExtras().getBoolean(AgeVerificationActivity.MINDERJAEHRIG);
            if   (result == false) {
                tv.setText("Sie sind noch nicht volljaehrig");
            }else {
                tv.setText("Sie sind volljaehrig");

            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
