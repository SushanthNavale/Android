package com.example.windows.easygst;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import static com.example.windows.easygst.calculate.MyPreference;
import static com.example.windows.easygst.calculate.product;
import static com.example.windows.easygst.calculate.mfdprofit;
import static com.example.windows.easygst.calculate.retprofit;
import static com.example.windows.easygst.calculate.cgst;
import static com.example.windows.easygst.calculate.sgst;
import static com.example.windows.easygst.calculate.wholprofit;
import static com.example.windows.easygst.calculate.total;

public class display extends AppCompatActivity {
    SharedPreferences pref;

    public  String product1;
    public  String mfdprofit1;
    public  String wholprofit1;
    public  String retprofit1;
    public  String cgst1;
    public  String sgst1;
    public  String tcost1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TextView pcost=(TextView)findViewById(R.id.productcost);
        TextView mcost=(TextView)findViewById(R.id.mfdcost);
        TextView wcost=(TextView)findViewById(R.id.wholcost);
        TextView rcost=(TextView)findViewById(R.id.retacost);
        TextView ccost=(TextView)findViewById(R.id.cgstcost);
        TextView scost=(TextView)findViewById(R.id.sgstcost);
        TextView tcost=(TextView)findViewById(R.id.totalcost);
        pref=getApplicationContext().getSharedPreferences(MyPreference, Context.MODE_PRIVATE);

        product1=pref.getString(product,null).toString();
        pcost.setText(product1);

        mfdprofit1=pref.getString(mfdprofit,null).toString();
        mcost.setText(mfdprofit1);

        wholprofit1=pref.getString(wholprofit,null).toString();
        wcost.setText(wholprofit1);

        retprofit1=pref.getString(retprofit,null).toString();
        rcost.setText(retprofit1);

        cgst1=pref.getString(cgst,null).toString();
        ccost.setText(cgst1);

        sgst1=pref.getString(sgst,null).toString();
        scost.setText(sgst1);

        tcost1=pref.getString(total,null).toString();
        tcost.setText(tcost1);



    }


}
