package com.example.spacego.payment;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.spacego.R;
import com.example.spacego.databaseaccess.RetroService;
import com.example.spacego.databaseaccess.Retrofit_space;
import com.google.android.material.button.MaterialButton;
import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultListener;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentActivity extends AppCompatActivity implements PaymentResultWithDataListener {

    private String orderId; // Store order ID for verification
    private  RetroService retroService;
    private MaterialButton do_payment_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        do_payment_btn = findViewById(R.id.do_payment_btn);

        retroService = Retrofit_space.getRetrofitInst();
        do_payment_btn.setOnClickListener(v -> {createOrder(5.0);});

    }

    private void createOrder(double amt) {
        Call<OrderResponse> call = retroService.createOrder(amt);
        call.enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                if (response.isSuccessful() && response.body() != null){
                    orderId = response.body().getOrderId();
                    startPayment(orderId, amt);
                    Toast.makeText(PaymentActivity.this, " " + orderId + " " + amt, Toast.LENGTH_SHORT).show();
                    Log.d("id", " " + response.body().getOrderId());
                    Log.d("amt", " " + response.body().getAmount());
                    Log.d("currency", " " + response.body().getCurrency());
                }else {
                    Toast.makeText(PaymentActivity.this, "Error : " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OrderResponse> call, Throwable throwable) {
                Toast.makeText(PaymentActivity.this, "request Error : " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startPayment(String orderId, double amount) {
        Checkout checkout = new Checkout();
        checkout.setKeyID(getString(R.string.secret_id));

        try {
            JSONObject options = new JSONObject();
            options.put("name", "Space Travel Booking");
            options.put("description", "Mission Ticket");
            options.put("currency", "INR");
            options.put("amount", amount * 100);
            options.put("order_id", orderId);

            checkout.open(this, options);
        } catch (Exception e) {
            Toast.makeText(this, "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }




    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {
        verifyPayment(paymentData.getPaymentId(), orderId, paymentData.getSignature());
    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {
        Toast.makeText(this, "Payment Failed", Toast.LENGTH_LONG).show();
    }

    private void verifyPayment(String paymentId, String orderId, String signature) {
        Call<VerifyResponse> call = retroService.verifyPayment(paymentId, orderId, signature
                );
        call.enqueue(new Callback<VerifyResponse>() {
                    @Override
                    public void onResponse(Call<VerifyResponse> call, Response<VerifyResponse> response) {
                        Toast.makeText(PaymentActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<VerifyResponse> call, Throwable t) {
                        Toast.makeText(PaymentActivity.this, "Payment Verification Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}