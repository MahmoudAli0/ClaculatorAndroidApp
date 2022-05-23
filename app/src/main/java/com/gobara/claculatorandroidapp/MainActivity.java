package com.gobara.claculatorandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView solution,result;
    MaterialButton button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8,button_9, button_divide,
    button_sub,button_multi,button_openBrac,button_closeBrac,button_equal,button_dot,button_zero,button_clear,
            button_c,button_plus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getRevernces();
        button_equal.setOnClickListener(this);
        button_multi.setOnClickListener(this);
        button_closeBrac.setOnClickListener(this);
        button_clear.setOnClickListener(this);
        button_clear.setOnClickListener(this);
        button_c.setOnClickListener(this);
        button_openBrac.setOnClickListener(this);
        button_dot.setOnClickListener(this);
        button_plus.setOnClickListener(this);
        button_sub.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_zero.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton clicableBtn = (MaterialButton) view;
        String btnText = clicableBtn.getText().toString();
        String dataToCalcu=solution.getText().toString();
        if(btnText.equals("AC")){
            solution.setText("");
            result.setText("0");
            return;
        }
        if (btnText.equals("=")){
            solution.setText(result.getText());
            return;
        }
        if(btnText.equals("C")){
            dataToCalcu= dataToCalcu.substring(0,dataToCalcu.length()-1);
        }else {
            dataToCalcu= dataToCalcu + btnText ;
        }

        solution.setText(dataToCalcu);
        String finalResult=getResult(dataToCalcu);
        if(!finalResult.equals("Error pls try again letter")){
            result.setText(finalResult);
        }


    }
    String getResult(String data){
        try {
            Context context=Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable =context.initStandardObjects();
            String finalRes= context.evaluateString(scriptable,data,"Javascript",1,null).toString();
          if (finalRes.endsWith(".0")){
              finalRes =finalRes.replace(".0","");
          }
            return finalRes;
        }catch (Exception e){
            return "Error pls try again letter";
        }

    }
    public void getRevernces(){
        solution=findViewById(R.id.solution_tv);
        result = findViewById(R.id.result_tv);
        button_1=findViewById(R.id.button_1);
        button_2=findViewById(R.id.button_2);
        button_3=findViewById(R.id.button_3);
        button_4=findViewById(R.id.button_4);
        button_5=findViewById(R.id.button_5);
        button_6=findViewById(R.id.button_6);
        button_7=findViewById(R.id.button_7);
        button_8=findViewById(R.id.button_8);
        button_9=findViewById(R.id.button_9);
        button_zero=findViewById(R.id.button_0);
        button_c=findViewById(R.id.button_c);
        button_divide=findViewById(R.id.button_divide);
        button_sub=findViewById(R.id.button_sub);
        button_plus=findViewById(R.id.button_plus);
        button_dot=findViewById(R.id.button_dot);
        button_openBrac=findViewById(R.id.button_openBrac);
        button_clear=findViewById(R.id.button_ac);
        button_closeBrac=findViewById(R.id.button_closeBrac);
        button_multi = findViewById(R.id.button_multiplay);
        button_equal = findViewById(R.id.button_equal);



    }
}