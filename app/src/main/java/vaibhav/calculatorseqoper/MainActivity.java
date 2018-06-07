package vaibhav.calculatorseqoper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    Button add,subtract,division,product,res;
    EditText num;
    ArrayList<String> operQueue ;
    float n1;
    float n2;
    int op=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operQueue = new ArrayList<>();

        num=(EditText)findViewById(R.id.num);
        subtract = (Button)findViewById(R.id.subtract);
        division = (Button)findViewById(R.id.division);
        product = (Button)findViewById(R.id.product);
        add = (Button)findViewById(R.id.add);
        res = (Button)findViewById(R.id.res);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!num.getText().toString().equals("")) {
                    String arg = num.getText().toString();
                    operQueue.add(arg);
                    operQueue.add("+");
                    num.setText("");
                }
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!num.getText().toString().equals("")) {
                    String arg = num.getText().toString();
                    operQueue.add(arg);
                    operQueue.add("-");
                    num.setText("");
                }
            }
        });

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!num.getText().toString().equals("")) {
                    String arg = num.getText().toString();
                    operQueue.add(arg);
                    operQueue.add("*");
                    num.setText("");
                }
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!num.getText().toString().equals("")) {
                    String arg = num.getText().toString();
                    operQueue.add(arg);
                    operQueue.add("/");
                    num.setText("");
                }
            }
        });

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String arg = num.getText().toString();
                operQueue.add(arg);
                float res=Float.parseFloat(operQueue.get(0));
                if(!num.getText().toString().equals("")) {
                    for (int i=0;i<operQueue.size();i++){
                        if((operQueue.get(i).equals("+")||operQueue.get(i).equals("-")||operQueue.get(i).equals("*")||operQueue.get(i).equals("/"))){
                            float secOper=Float.parseFloat(operQueue.get(i+1));
                            String oper=operQueue.get(i);
                            if(oper.equals("+")){
                                res=res+secOper;
                            }
                            else if(oper.equals("-")){
                                res=res-secOper;
                            }
                            else if(oper.equals("*")){
                                res=res*secOper;
                            }
                            else if(oper.equals("/")){
                                try{
                                    res=res/0;
                                    //Log.e("errorCalculator","dividebyZero");
                                }catch(Exception ex){
                                    Log.e("errorCalculator","dividebyZero");
                                }

                            }
                        }
                    }
                    num.setText(String.valueOf(res));
                }
            }
        });
    }
}
