package com.example.windows.easygst;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import static com.example.windows.easygst.removeGST.MyPreference11;
import static com.example.windows.easygst.removeGST.product11;
import static com.example.windows.easygst.removeGST.cgst11;
import static com.example.windows.easygst.removeGST.sgst11;
import static com.example.windows.easygst.removeGST.total12;

public class remove extends AppCompatActivity {
    SharedPreferences pref11;
    public  String product1;
    public  String cgst1;
    public  String sgst1;
    public String tcost1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);
        TextView pcost11=(TextView)findViewById(R.id.productcost11);
        TextView ccost11=(TextView)findViewById(R.id.cgstcost11);
        TextView scost11=(TextView)findViewById(R.id.sgstcost11);
        TextView tcost11=(TextView)findViewById(R.id.totalcost11);
        pref11=getApplicationContext().getSharedPreferences(removeGST.MyPreference11, Context.MODE_PRIVATE);


        product1=pref11.getString(removeGST.product11,null).toString();
        pcost11.setText(product1);

        cgst1=pref11.getString(removeGST.cgst11,null).toString();
        ccost11.setText(cgst1);

        sgst1=pref11.getString(removeGST.sgst11,null).toString();
        scost11.setText(sgst1);

        tcost1=pref11.getString(removeGST.total12,null).toString();
        tcost11.setText(tcost1);
    }
}
