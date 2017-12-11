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

public class removeGST extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String MyPreference11="myprefarence";
    public static final String product11="productkey";
    public static final String cgst11="cgst";
    public static final String sgst11="sgst";
    public static final String total12="total";
    SharedPreferences sharedPreferences11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_gst);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
                Intent intent = new Intent(removeGST.this,home.class);
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

        final EditText pcost1=(EditText)findViewById(R.id.pcost);
        final EditText cgst1=(EditText)findViewById(R.id.cgst);
        final EditText sgst1=(EditText)findViewById(R.id.sgst);
        Button remove=(Button)findViewById(R.id.remove);
        sharedPreferences11=getSharedPreferences(MyPreference11, Context.MODE_PRIVATE);

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //text field validation........................................
                String strpcost11 = pcost1.getText().toString();
                String strcgst11 = cgst1.getText().toString();
                String strsgst11= sgst1.getText().toString();


                if(TextUtils.isEmpty(strpcost11)) {
                    pcost1.setError("Enter production cost($)!");
                    return;
                }
                else if(TextUtils.isEmpty(strcgst11)) {
                    cgst1.setError("Enter Central GST(%)!");
                    return;
                }
                else if(TextUtils.isEmpty(strsgst11)) {
                    sgst1.setError("Enter State GST%)!");
                    return;
                }


                //gst remove.................................................................

                double productioncost1=Double.parseDouble(strpcost11);
                double cgstcost1=Double.parseDouble(strcgst11);
                double sgstcost1=Double.parseDouble(strsgst11);
                double totalgst11=cgstcost1+sgstcost1;

               // double per11 = (productioncost1/ 100.0f) * totalgst11;

                double remove11=productioncost1-(productioncost1*(100.0f/(100.0f+totalgst11)));


                double removegst=productioncost1-remove11;

                String.format("%.0f", removegst);



                String total22 = Double.toString(removegst);



                //..................................................................
                SharedPreferences.Editor editor=sharedPreferences11.edit();
                editor.putString(product11,strpcost11);
                editor.putString(cgst11,strcgst11);
                editor.putString(sgst11,strsgst11);
                editor.putString(total12,total22);
                editor.commit();


                Intent intent = new Intent(removeGST.this,remove.class);
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
        getMenuInflater().inflate(R.menu.remove_gst, menu);
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
            Intent intent = new Intent(removeGST.this,about.class);
            startActivity(intent);
        } else if (id == R.id.search) {
            Intent intent = new Intent(removeGST.this,search.class);
            startActivity(intent);


        } else if (id == R.id.structure) {
            Intent intent = new Intent(removeGST.this,structure.class);
            startActivity(intent);

        } else if (id == R.id.rate) {
            Intent intent = new Intent(removeGST.this,rate.class);
            startActivity(intent);

        } else if (id == R.id.calgst) {
            Intent intent = new Intent(removeGST.this,calculate.class);
            startActivity(intent);

        } else if (id == R.id.rmvgst) {
            Intent intent = new Intent(removeGST.this,removeGST.class);
            startActivity(intent);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
