package com.example.sajalnarang.smsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText messageEditText;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageEditText = (EditText) findViewById(R.id.message);
        sendButton = (Button) findViewById(R.id.send_btn);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = messageEditText.getText().toString();
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("+917043207800", null, "Breakfast : Aloo Parantha, Dahi(Unlimited), Pickle, Corn, Egg Bhurji, Banana\n" +
                        "\n" +
                        "Lunch : Chana Masala Gravy, Matki Usal Dry, Curd Rice, Dal Fry, Chapati, Jeera Rice, Extra-Paneer Bhurji\n" +
                        "\n" +
                        "Tiffin : Masala dosa + Schezwan Chutney, Peanut Butter, Watermelon Juice\n" +
                        "\n" +
                        "Dinner : Paneer Tikka / Paneer Matar, Tuar Dal, Nan, Coconut Rice/Gajar Tomato Rice, Masala Papad, Ice Cream. Fruit-Muskmelon Extra - Fish\n", null, null);
                Toast.makeText(getApplicationContext(),"Check",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
    