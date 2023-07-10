package sg.edu.rp.c326.id22015010.demopricediscount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText priceEditText;
    EditText discountEditText;
    TextView payTextView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        priceEditText=findViewById(R.id.priceEditText);
        discountEditText=findViewById(R.id.discountEditText);
        payTextView=findViewById(R.id.payTextView);
        btn=findViewById(R.id.calculateButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePay();
            }
        });

    }
    private void calculatePay() {
        double price = Double.parseDouble(priceEditText.getText().toString());
        double discount = Double.parseDouble(discountEditText.getText().toString());
        double finalPay = calcPay(price, discount);
        payTextView.setText("Pay: " + finalPay);
    }
    private double calcPay(double price, double discount) {
        double pay = price * (1 - discount / 100);
        return pay;
    }

}