package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {
    TextView edt_view,edt_viewRes;
    String op;
    boolean isClicked=true;
    String oldNumber;
    double result=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_view=findViewById(R.id.editText);
        edt_viewRes=findViewById(R.id.editResult);
    }

    public void NumberEvent(View view) {
        if(isClicked){
            edt_view.setText("");
        }
        isClicked=false;

        String number=edt_view.getText().toString();
        switch(view.getId()){
            case R.id.btn9:
                number+="9";
                break;
            case R.id.btn8:
                number+="8";
                break;
            case R.id.btn7:
                number+="7";
                break;
            case R.id.btn6:
                number+="6";
                break;
            case R.id.btn5:
                number+="5";
                break;
            case R.id.btn4:
                number+="4";
                break;
            case R.id.btn3:
                number+="3";
                break;
            case R.id.btn2:
                number+="2";
                break;
            case R.id.btn1:
                number+="1";
                break;
            case R.id.btn0:
                number+="0";
                break;
            case R.id.btnpoint:
                number+=".";
                break;
            case R.id.btnNegative:
                number="-"+number;

                break;
            case R.id.btnMinus:

                number+="-";
                break;
            case R.id.btnplus:
                number+="+";
                break;
            case R.id.btnMultiply:
                number+="*";
                break;
            case R.id.btnModulus:
                number+="%";
                break;
            case R.id.btnDivide:
                number+="/";
        }
        edt_view.setText(number);


    }



    public void equalsEvent(View view) {

       ScriptEngine engine=new ScriptEngineManager().getEngineByName("rhino");
       String working;
       working=edt_view.getText().toString();
        try {
            result=(double)engine.eval(working);
        } catch (ScriptException e) {
            Toast.makeText(this,"Invalid Input ", Toast.LENGTH_SHORT).show();
        }

        edt_viewRes.setText(result+"");


    }

    public void Clear(View view) {
        isClicked=true;
        edt_view.setText("0");
        edt_viewRes.setText("");


    }

    public void ansEvent(View view) {
        edt_view.setText(result+"");
    }
}