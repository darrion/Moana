package moanainc.com.moana.controller;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import moanainc.com.moana.R;
import moanainc.com.moana.firebase.FirebaseInterface;
import moanainc.com.moana.model.Model;
import moanainc.com.moana.model.report.PurityReport;
import moanainc.com.moana.model.Report;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        ArrayList<Report> availReports = FirebaseInterface.getAvailabilityReports();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Report report : availReports) {
            googleMap.addMarker(new MarkerOptions().position(new LatLng(report.getLat(), report.getLng()))
                    .title(report.getName())
                    .snippet(report.toString())
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
            builder.include(new LatLng(report.getLat(), report.getLng()));
        }

        ArrayList<Report> purityReports = FirebaseInterface.getPurityReports();
        for (Report report : purityReports) {
            mMap.addMarker(new MarkerOptions().position(new LatLng(report.getLat(), report.getLng()))
                    .title(report.getName())
                    .snippet(report.toString())
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            builder.include(new LatLng(report.getLat(), report.getLng()));
        }

        ArrayList<Report> historyReports = FirebaseInterface.getHistoryReports();
        for (Report report : historyReports) {
            mMap.addMarker(new MarkerOptions().position(new LatLng(report.getLat(), report.getLng()))
                    .title(report.getName())
                    .snippet(report.toString())
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
            builder.include(new LatLng(report.getLat(), report.getLng()));
        }
        ArrayList<Report> sourceReports = FirebaseInterface.getSourceReports();
        for (Report report : sourceReports) {
            mMap.addMarker(new MarkerOptions().position(new LatLng(report.getLat(), report.getLng()))
                    .title(report.getName())
                    .snippet(report.toString())
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            builder.include(new LatLng(report.getLat(), report.getLng()));
        }

        if(!FirebaseInterface.getAllReports().isEmpty()) {
            LatLngBounds bounds = builder.build();
            int width = getResources().getDisplayMetrics().widthPixels;
            int height = getResources().getDisplayMetrics().heightPixels;
            int padding = (int) (width * 0.12);
            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds,  width, height, padding));
        }
    }

    public void onBackButton(View view) {
        Intent goToWelcome = new Intent(getBaseContext(), WelcomeActivity.class);
        getBaseContext().startActivity(goToWelcome);
    }
}
