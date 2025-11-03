package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

import kotlin.math.pow

class MainActivity : ComponentActivity(), View.OnClickListener {
    lateinit var btnAdd : Button;
    lateinit var btnSub : Button;
    lateinit var btnMult : Button;
    lateinit var btnDiv : Button;
    lateinit var btnExp : Button;

    lateinit var etA: EditText;
    lateinit var etB: EditText;
    lateinit var resultTv : TextView;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btn_add);
        btnSub = findViewById(R.id.btn_sub);
        btnMult = findViewById(R.id.btn_mult);
        btnDiv = findViewById(R.id.btn_div);
        btnExp = findViewById(R.id.btn_exp);
        resultTv = findViewById(R.id.result_tv);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnExp.setOnClickListener(this);
        etA = findViewById(R.id.et_a);
        etB = findViewById(R.id.et_b);
    }

    override fun onClick(v: View?) {
        if (etA.text.toString().trim().length == 0 || etB.text.toString().trim().length == 0) {
            resultTv.text = "Please enter both numbers"
            return
        }
        var a = etA.text.toString().toDouble();
        var b = etB.text.toString().toDouble();


        var result = 0.0;
        when(v?.id){
            R.id.btn_add->{
                result = a+b;
            }
            R.id.btn_sub->{
                result = a-b;

            }
            R.id.btn_mult->{
                result = a*b;

            }
            R.id.btn_div->{
                if(b == 0.0)
                {
                    resultTv.text = "Cannot divide by zero"
                    return
                }
                result = a/b;

            }
            R.id.btn_exp->{
                result = a.pow(b);

            }

        }
        resultTv.text = "result is $result";


    }
}
