package cn.edu.bistu.cs.se.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtResult=(TextView)findViewById(R.id.textResult);

        Button btnsin=(Button)findViewById(R.id.buttonSin);
        btnsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num=(Double)Math.sin((Double.parseDouble(txtResult.getText().toString()))*Math.PI/180);
                txtResult.setText(String.valueOf(num));
            }
        });
        Button btncos=(Button)findViewById(R.id.buttonCos);
        btncos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num=(Double)Math.cos((Double.parseDouble(txtResult.getText().toString()))*Math.PI/180);
                txtResult.setText(String.valueOf(num));
            }
        });
        Button btntan=(Button)findViewById(R.id.buttonTan);
        btntan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num=(Double)Math.tan((Double.parseDouble(txtResult.getText().toString()))*Math.PI/180);
                txtResult.setText(String.valueOf(num));
            }
        });
        Button btnlog=(Button)findViewById(R.id.buttonLog);
        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num=(Double)Math.log(Double.parseDouble(txtResult.getText().toString()));
                txtResult.setText(String.valueOf(num));
            }
        });
        Button btnex=(Button)findViewById(R.id.buttonExRate);
        btnex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num=(0.146)* Double.parseDouble(txtResult.getText().toString());
                txtResult.setText("$"+String.valueOf(num));
            }
        });
        Button btnone=(Button) findViewById(R.id.buttonOne);
        btnone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText()+"1");
            }
        });
        Button btntwo=(Button)findViewById(R.id.buttonTwo);
        btntwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText()+"2");
            }
        });
        Button btnthree=(Button)findViewById(R.id.buttonThree);
        btnthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText()+"3");
            }
        });
        Button btnfour=(Button)findViewById(R.id.buttonFour);
        btnfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText()+"4");
            }
        });
        Button btnfive=(Button)findViewById(R.id.buttonFive);
        btnfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText()+"5");
            }
        });
        Button btnsix=(Button)findViewById(R.id.buttonSix);
        btnsix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText()+"6");
            }
        });
        Button btnseven=(Button)findViewById(R.id.buttonSeven);
        btnseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText()+"7");
            }
        });
        Button btneight=(Button)findViewById(R.id.buttonEight);
        btneight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText()+"8");
            }
        });
        Button btnnine=(Button)findViewById(R.id.buttonNine);
        btnnine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText()+"9");
            }
        });
        Button btnzero=(Button)findViewById(R.id.buttonZero);
        btnzero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText()+"0");
            }
        });
        Button btnpoint=(Button)findViewById(R.id.buttonPoint);
        btnpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText()+".");
            }
        });
        Button btnplus=(Button)findViewById(R.id.buttonPlus);
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText()+"+");
            }
        });
        Button btnsub=(Button)findViewById(R.id.buttonSub);
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText()+"-");
            }
        });
        Button btnmul=(Button)findViewById(R.id.buttonMul);
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText()+"*");
            }
        });
        Button btndiv=(Button)findViewById(R.id.buttonDiv);
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText()+"/");
            }
        });

        Button btndelete=(Button)findViewById(R.id.buttonDelete);
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String skr=txtResult.getText().toString();
                try{
                    txtResult.setText(skr.substring(0,skr.length()-1));
                }catch(Exception e){
                    txtResult.setText(" ");
                }
            }
        });
        Button btnclear=(Button)findViewById(R.id.buttonClear);
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(" ");
            }
        });


        Button btnequal=(Button)findViewById(R.id.buttonEqual);
        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNum();
            }
        });
    }
    public void getNum(){
        //取得TextView组件
        final TextView txtResult=(TextView)findViewById(R.id.textResult);
        //将所取得的TextView组件转换为字符串。
        String skr = txtResult.getText().toString();
        //进行是否存在运算符号的判断
        if (!skr.contains("+")&&!skr.contains("-")&&!skr.contains("*")&&!skr.contains("/")){
            txtResult.setText(skr);
            return;
        }
        //若存在运算符号，则进入正式运算。
        //定义数组，在数组中保存TextView组件所取得的字符串
        String[] strings = new String[skr.length()];
        for (int i = 0; i < skr.length(); i++) {
            strings[i] = skr.substring(i, i + 1);
        }
        String skr1 = "a";//保存运算符号前一段数，字符串形式
        String skr2 = "a";//保存运算符号后一段数，字符串形式
        String skr3 = "a";//保存具体运算符号，字符串形式
        //遍历整个数组并进行相关操作
        for (int i = 0; i < skr.length(); i++)//遍历数组
        {
            //进行加减乘除运算符号存在于何处的判断
            if (strings[i].equals("+") || strings[i].equals("-") || strings[i].equals("*") || strings[i].equals("/")) {

                skr1 = skr.substring(0, i);
                skr2 = skr.substring(i + 1);

                skr3 = skr.substring(i, i + 1);
                break;


            }
        }
        double num1 = Double.parseDouble(skr1);
        double num2 = Double.parseDouble(skr2);
        double num3 = 0;
        switch (skr3) {
            case "+":
                num3 = num1 + num2;
                break;
            case "-":
                num3 = num1 - num2;
                break;
            case "*":
                num3 = num1 * num2;
                break;
            case "/": {
                if (num2 == 0) {
                    txtResult.setText("除数不可以为0");
                    break;
                }
                num3 = num1 / num2 * 1.0;
                break;
            }
        }
        txtResult.setText(String.valueOf(num3));
    }
}

