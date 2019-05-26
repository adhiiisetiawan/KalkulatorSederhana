package com.example.kalkulatorsederhana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editbil1,editbil2;
    TextView hasil;
    Button btnTambah,btnKurang,btnKali,btnBagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editbil1 = findViewById(R.id.edt_bil1);
        editbil2 = findViewById(R.id.edt_bil2);
        hasil = findViewById(R.id.result);
        btnTambah = findViewById(R.id.tambah);
        btnKurang = findViewById(R.id.kurang);
        btnKali = findViewById(R.id.kali);
        btnBagi = findViewById(R.id.bagi);

        btnTambah.setOnClickListener(this);
        btnKurang.setOnClickListener(this);
        btnKali.setOnClickListener(this);
        btnBagi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tambah){
            String inputBilangan1 = editbil1.getText().toString().trim();
            String inputBilangan2 = editbil2.getText().toString().trim();

            boolean isEmptyFields = true;
            boolean isInvalidDouble =  true;

            if (TextUtils.isEmpty(inputBilangan1)){
                isEmptyFields = true;
                editbil1.setError("Kolom ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputBilangan2)){
                isEmptyFields = true;
                editbil2.setError("Kolom ini tidak boleh kosong");
            }

            Double bilangan1 = toDouble(inputBilangan1);
            Double bilangan2 = toDouble(inputBilangan2);

            if (bilangan1 == null){
                isInvalidDouble = true;
                editbil1.setError("Bilangan yang anda masukkan harus pecahan");
            }

            if (bilangan2 == null){
                isInvalidDouble = true;
                editbil2.setError("Bilangan yang anda masukkan harus pecahan");
            }

            if (!isEmptyFields && !isInvalidDouble){
                double hasilKali = bilangan1*bilangan2;
                hasil.setText(String.valueOf(hasilKali));

                double hasilBagi = bilangan1/bilangan2;
                hasil.setText(String.valueOf(hasilKali));
            }
        }
    }

    Double toDouble(String str){
        try{
            return Double.valueOf(str);
        } catch (NumberFormatException e){
            return null;
        }
    }
}
