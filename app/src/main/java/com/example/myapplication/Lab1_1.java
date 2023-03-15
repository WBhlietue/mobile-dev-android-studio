package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Lab1_1 extends AppCompatActivity {

    TextView asnwer, viewNum;
    Calculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        asnwer = findViewById(R.id.answer);
        viewNum = findViewById(R.id.view);
        findViewById(R.id.btn_0).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculator.AddNum('0');
                ChangeText();
            }
        });
        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculator.AddNum('1');
                ChangeText();
            }
        });
        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculator.AddNum('2');
                ChangeText();
            }
        });
        findViewById(R.id.btn_3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculator.AddNum('3');
                ChangeText();
            }
        });
        findViewById(R.id.btn_4).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculator.AddNum('4');
                ChangeText();
            }
        }) ;
        findViewById(R.id.btn_5).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculator.AddNum('5');
                ChangeText();
            }
        });
        findViewById(R.id.btn_6).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculator.AddNum('6');
                ChangeText();
            }
        });
        findViewById(R.id.btn_7).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculator.AddNum('7');
                ChangeText();
            }
        });
        findViewById(R.id.btn_8).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculator.AddNum('8');
                ChangeText();
            }
        });
        findViewById(R.id.btn_9).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculator.AddNum('9');
                ChangeText();
            }
        });
        findViewById(R.id.btn_pl).setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.AddOparator('+');
                ChangeText();
            }
        }));
        findViewById(R.id.btn_mi).setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.AddOparator('-');
                ChangeText();
            }
        }));
        findViewById(R.id.btn_mul).setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.AddOparator('*');
                ChangeText();
            }
        }));
        findViewById(R.id.btn_div).setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.AddOparator('/');
                ChangeText();
            }
        }));
        findViewById(R.id.btn_point).setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.AddOparator('.');
                ChangeText();
            }
        }));
        findViewById(R.id.btn_toM).setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.ChangeM();
                ChangeText();
            }
        }));
        findViewById(R.id.btn_del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.Del();
                ChangeText();
            }
        });
        findViewById(R.id.btn_point).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.Point();;
                ChangeText();
            }
        });
        findViewById(R.id.btn_C).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.Clean();
                ChangeText();
            }
        });
        findViewById(R.id.btn_power).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.AddOparator('^');
                ChangeText();
            }
        });



    }
    public void ChangeText(){
        asnwer.setText(calculator.GetAnswer());
        viewNum.setText(calculator.GetView());
    }
}
class Calculator{
//    private ScriptEngineManager manager;
    private String mainText = "";
    public  String toCalculate = "";
    private int isM = 0;
    public Calculator(){
//        isM = false;
    }


    public void AddNum(char c){
        mainText+=c;
        toCalculate = (isM == 1?"0":"") + mainText;
    }
    public void AddOparator(char c){
        if(!IsNum(mainText.charAt(mainText.length() - 1))){
            mainText = mainText.substring(0, mainText.length() - 1) + c;
        }else
        mainText += c;
        toCalculate = "";
    }
    boolean IsNum(char c){
        return c <= 57 && c >= 48;
    }
    public void Clean(){
        mainText = "";
        toCalculate ="";
        isM = 0;
    }

    public String GetAnswer(){
        if(toCalculate.equals("")){
            return "";
        }
        List<String> nums=  new ArrayList<>();
        List<Character> ope = new ArrayList<>();

        String tmp = "";
        for(int i = 0; i < toCalculate.length(); i++){

            if(IsNum(toCalculate.charAt(i)) || toCalculate.charAt(i) == '.'){

                tmp += toCalculate.charAt(i);
                try{
                    if(!IsNum(toCalculate.charAt(i+1)) && toCalculate.charAt(i+1) != '.'){
                        nums.add(tmp);
                        tmp = "";
                    }
                }catch(Exception e){
                    nums.add(tmp);
                    tmp = "";
                }
            }else{
                ope.add(toCalculate.charAt(i));
            }
        }
        for(int i = 0; i < ope.size(); i++){
            if(ope.get(i) == '^' ){
                nums.set(i, (Math.pow( Double.parseDouble(nums.get(i)) , Double.parseDouble(nums.get(i+1)))+""));
                ope.remove(i);
                nums.remove(i+1);
                i--;
            }
        }
        for(int i = 0; i < ope.size(); i++){
            if(ope.get(i) == '*' ){
                nums.set(i, (Double.parseDouble(nums.get(i)) * Double.parseDouble(nums.get(i+1)))+"");
                ope.remove(i);
                nums.remove(i+1);
                i--;
            }
            else if( ope.get(i) == '/'){
                nums.set(i, (Double.parseDouble(nums.get(i)) / Double.parseDouble(nums.get(i+1)))+"");
                nums.remove(i+1);
                ope.remove(i);
                i--;
            }
        }
        while(ope.size() > 0){
            if(ope.get(0) == '+') {
                nums.set(0, (Double.parseDouble(nums.get(0)) + Double.parseDouble(nums.get(1))) + "");
                nums.remove(1);
                ope.remove(0);


            }else  if(ope.get(0) == '-') {
                nums.set(0, (Double.parseDouble(nums.get(0)) - Double.parseDouble(nums.get(1))) + "");
                nums.remove(1);
                ope.remove(0);
            }
        }
        return nums.get(0);
    }
    public void ChangeM(){
        if(isM == 1){
            isM = 0;
            mainText = mainText.substring(1, mainText.length());
            if( IsNum( mainText.charAt((mainText.length() -1)) )) {
                toCalculate =  mainText;
            }else{
                toCalculate = "";
            }
        }else{
            isM = 1;
            mainText = "-" + mainText;
            if( IsNum( mainText.charAt((mainText.length() -1)) )) {
                toCalculate = "0" + mainText;
            }else{
                toCalculate = "";
            }
        }
    }
    public void Point(){
        List<String> nums=  new ArrayList<>();

        String tmp = "";
        for(int i = 0; i < mainText.length(); i++){
            if(IsNum(mainText.charAt(i)) || mainText.charAt(i) == '.'){
                tmp += mainText.charAt(i);
                try{
                    if(!IsNum(mainText.charAt(i+1)) ){
                        nums.add(tmp);
                        tmp = "";
                    }
                }catch(Exception e){
                    nums.add(tmp);
                    tmp = "";
                }
            }
        }
        String last= nums.get(nums.size()-1);
        if(last.indexOf('.') == -1){
            mainText += ".";
            toCalculate = "";
        }
    }

    public void Del(){

        if(mainText.length() > 1){
            mainText = mainText.substring(0, mainText.length() - 1);
            if(IsNum(mainText.charAt(mainText.length()-1))){
                toCalculate = (isM == 1 ? "0":"") + mainText;
            }else{
                toCalculate = "";
            }
        }else
        if(mainText.length() == 1){
            mainText = "";
            toCalculate = "0";
            isM = 0;
        }
    }


    public String GetView(){
        return mainText.equals("") ? "0" : mainText;
    }

}
