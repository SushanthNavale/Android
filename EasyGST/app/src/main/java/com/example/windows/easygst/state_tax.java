package com.example.windows.easygst;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

public class state_tax extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_tax);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                      //  .setAction("Action", null).show();
                Intent intent = new Intent(state_tax.this,home.class);
                startActivity(intent);
            }
        });

        //ImageButton karnataka=(ImageButton)findViewById(R.id.imageButton10);







        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    public void assam (View view) {
        goToUrl ( "http://103.8.248.130/AssamTimsInfo/index.html");
    }

    public void arunachalpradesh (View view) {goToUrl ( "http://www.aruntax.nic.in");
    }
    public void andrapradesh (View view) {goToUrl ( "https://www.apct.gov.in/gstportal");
    }
    public void Bihar (View view) {goToUrl ( "https://www.biharcommercialtax.gov.in/bweb/");
    }
    public void Chhattisgarh (View view) {goToUrl ( "http://comtax.cg.nic.in/");
    }
    public void Goa (View view) {goToUrl ( "http://goacomtax.gov.in/");
    }
    public void Gujarat (View view) {goToUrl ( "https://www.commercialtax.gujarat.gov.in/vatwebsite/home/home.jsp");
    }
    public void Haryana (View view) {goToUrl ( "https://haryanatax.gov.in/HEX/appmanager/HexPortal/HaryanaExcise?JSESSIONID=GnJhZwZMSzJwTVGv9MJWnmhBGmSJdRlzwnZTTnXSDr9n4RD8pctG!942054490");
    }
    public void HimachalPradesh (View view) {goToUrl ( "https://hptax.gov.in/HPPortal/");
    }
    public void JammuandKashmir (View view) {goToUrl ( "http://jkexcise.nic.in/");
    }
    public void Jharkhand (View view) {goToUrl ( "http://jharkhandcomtax.gov.in/home");
    }
    public void Karnataka (View view) {goToUrl ( "http://ctax.kar.nic.in/index.asp");
    }
     public void Kerala (View view) {goToUrl ( "http://keralataxes.gov.in/");
    }
     public void MadyaPradesh (View view) {goToUrl ( "https://mptax.mp.gov.in/mpvatweb/");
    }
     public void Maharashtra (View view) {goToUrl ( "http://www.mahavat.gov.in/Mahavat/index.jsp");
    }
     public void Manipur (View view) {goToUrl ( "http://www.manipurvat.gov.in/");
    }
     public void Meghalaya (View view) {goToUrl ( "http://megvat.gov.in/");
    }
     public void Mizoram (View view) {goToUrl ( "http://zotax.nic.in/");
    }
    public void Nagaland (View view) {goToUrl ( "http://nagalandtax.nic.in/");
    }
    public void Orissa (View view) {goToUrl ( "https://odishatax.gov.in/");
    }
    public void Punjab (View view) {goToUrl ( "https://www.pextax.com/PEXWAR/appmanager/pexportal/PunjabExcise");
    }
    public void Rajasthan (View view) {goToUrl ( "http://rajtax.gov.in/vatweb/");
    }
    public void TamilNadu (View view) {goToUrl ( "https://ctd.tn.gov.in/home/");
    }
    public void Tripura (View view) {goToUrl ( "http://taxes.tripura.gov.in/");
    }
    public void Uttaranchal (View view) {goToUrl ( "http://comtax.uk.gov.in/");
    }
    public void UttarPradesh (View view) {goToUrl ( "http://comtax.up.nic.in/");
    }
    public void WestBengal (View view) {goToUrl ( "http://wbcomtax.nic.in/");
    }
    public void AndamanandNicobarIslands (View view) {goToUrl ( "https://www.sos.state.tx.us/");
    }
    public void Chandigarh (View view) {goToUrl ( "http://chandigarh.gov.in/dept_index.htm");
    }
    public void DadarandNagarHaveli (View view) {goToUrl ( "http://www.dnhctd.gov.in/");
    }
    public void DamanandDiu (View view) {goToUrl ( "http://www.ddvat.gov.in/");
    }
    public void Delhi (View view) {goToUrl ( "http://dvat.gov.in/website/home.html");
    }
    public void Lakshadeep(View view) {goToUrl ( "https://www.sos.state.tx.us/");
    }
    public void Pondicherry (View view) {goToUrl ( "http://gst.puducherry.gov.in/");
    }



    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
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
        getMenuInflater().inflate(R.menu.state_tax, menu);
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
            Intent intent = new Intent(state_tax.this,about.class);
            startActivity(intent);

        } else if (id == R.id.search) {
            Intent intent = new Intent(state_tax.this,search.class);
            startActivity(intent);

        } else if (id == R.id.structure) {
            Intent intent = new Intent(state_tax.this,structure.class);
            startActivity(intent);

        } else if (id == R.id.rate) {
            Intent intent = new Intent(state_tax.this,rate.class);
            startActivity(intent);

        } else if (id == R.id.calgst) {
            Intent intent = new Intent(state_tax.this,calculate.class);
            startActivity(intent);

        } else if (id == R.id.rmvgst) {
            Intent intent = new Intent(state_tax.this,removeGST.class);
            startActivity(intent);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
