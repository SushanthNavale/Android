package com.example.windows.easygst;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class calculate extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

   public static final String MyPreference="myprefarence";
    public static final String product="productkey";
    public static final String mfdprofit="mfdprofitkey";
    public static final String wholprofit="wholprofitkey";
    public static final String retprofit="retprofit";
    public static final String cgst="cgst";
    public static final String sgst="sgst";
    public static final String total="total";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                       // .setAction("Action", null).show();
                Intent intent = new Intent(calculate.this,home.class);
               startActivity(intent);

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        //assign the textfield and button.................................................

        final EditText production=(EditText)findViewById(R.id.production);
        final EditText mfd_profit=(EditText)findViewById(R.id.mfd_profit);
        final EditText whol_profit=(EditText)findViewById(R.id.whol_profit);
        final EditText ret_profit=(EditText)findViewById(R.id.ret_profit);
        final EditText c_gst=(EditText)findViewById(R.id.c_gst);
        final EditText s_gst=(EditText)findViewById(R.id.s_gst);
        Button calculate=(Button)findViewById(R.id.button);
        sharedPreferences=getSharedPreferences(MyPreference, Context.MODE_PRIVATE);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //text field validation........................................
                String strproduction = production.getText().toString();
                String strmfd = mfd_profit.getText().toString();
                String strwhol = whol_profit.getText().toString();
                String strrt= ret_profit.getText().toString();
                String strcgst = c_gst.getText().toString();
                String strsgst = s_gst.getText().toString();

                if(TextUtils.isEmpty(strproduction)) {
                    production.setError("Enter production cost($)!");
                    return;
                }
                else if(TextUtils.isEmpty(strmfd)) {
                    mfd_profit.setError("Enter Mfd. Profit Margin($)!");
                    return;
                }
                else if(TextUtils.isEmpty(strwhol)) {
                    whol_profit.setError("Enter Wholesalar Profit(%)!");
                    return;
                }
                else if(TextUtils.isEmpty(strrt)) {
                    ret_profit.setError("Enter Retailer Profit(%)!");
                    return;
                }
                else if(TextUtils.isEmpty(strcgst)) {
                    c_gst.setError("Enter Central GST(%)!");
                    return;
                }
                else if(TextUtils.isEmpty(strsgst)) {
                    s_gst.setError("Enter State GST(%)!");
                    return;
                }
                //gst calculation.................................................................

                double productioncost=Double.parseDouble(strproduction);
                double cgstcost=Double.parseDouble(strcgst);
                double sgstcost=Double.parseDouble(strsgst);
                double mfdprofit1=Double.parseDouble(strmfd);

                double ratrofit = Double.parseDouble(strrt);

                double per = (productioncost/ 100.0f) * ratrofit;

                double wprofit=Double.parseDouble(strwhol);

                double par2=(productioncost/100.0f)*wprofit;

                double par3=(productioncost/100.0f)*mfdprofit1;

                double totappar=per+par2+par3;

                double totalgst=cgstcost+sgstcost;

                double gstamount=productioncost*(totalgst/100.0f);

                double total1=productioncost+gstamount+totappar;

                String total2 = Double.toString(total1);

                //...............................................................................
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(product,strproduction);
                editor.putString(mfdprofit,strmfd);
                editor.putString(wholprofit,strwhol);
                editor.putString(retprofit,strrt);
                editor.putString(cgst,strcgst);
                editor.putString(sgst,strsgst);
                editor.putString(total,total2);
                editor.commit();

                Intent intent = new Intent(calculate.this,display.class);
                startActivity(intent);

            }
        });



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.about) {
            Intent intent = new Intent(calculate.this,about.class);
            startActivity(intent);
        } else if (id == R.id.search) {
            Intent intent = new Intent(calculate.this,search.class);
            startActivity(intent);


        } else if (id == R.id.structure) {
            Intent intent = new Intent(calculate.this,structure.class);
            startActivity(intent);

        } else if (id == R.id.rate) {
            Intent intent = new Intent(calculate.this,rate.class);
            startActivity(intent);

        } else if (id == R.id.calgst) {
            Intent intent = new Intent(calculate.this,calculate.class);
            startActivity(intent);

        } else if (id == R.id.rmvgst) {
            Intent intent = new Intent(calculate.this,removeGST.class);
            startActivity(intent);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
