package com.example.tommorow.ui;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.tommorow.BaseActivity;
import com.example.tommorow.R;

import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/4/22.
 * Controller class, corresponding to layout file
 * Handle map activity logic
 * Current Code is using webview to show google map
 * API code were commented
 * Layout file name: activity_map.xml
 */
public class MapsActivity extends BaseActivity implements LocationListener {


    //    private GoogleMap mMap;
//    private GoogleApiClient mGoogleApiClient;
//    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
//    private static final int REQUEST_CHECK_SETTINGS = 2;
//    private static final int PLACE_PICKER_REQUEST = 3;
//    private LocationRequest mLocationRequest;
//    private boolean mLocationUpdateState;
//    private Location mLastLocation;
    private static final String MAP_URL = "https://www.google.com.au/maps/search/hospitals";
    private WebView webView;
    private Location mostRecentLocation;

    @Override
    public int getContnetView() {
        return R.layout.activity_map;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        title.setText(getResources().getString(R.string.map));
        getLocation();
        init();
//        setupWebView();
    }

    private void init() {
        webView = (WebView) findViewById(R.id.webView);
        //enable javascript
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        webView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });

        webView.loadUrl(MAP_URL);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                view.loadUrl(url);
                return true;
            }
        });

    }

    private void getLocation() {
        LocationManager locationManager =
                (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        String provider = locationManager.getBestProvider(criteria,true);
        //In order to make sure the device is getting the location, request updates.
        locationManager.requestLocationUpdates(provider, 1, 0, this);
        mostRecentLocation = locationManager.getLastKnownLocation(provider);
    }

//    private void setupWebView(){
//        final String centerURL = "javascript:centerAt(" +
//                mostRecentLocation.getLatitude() + "," +
//                mostRecentLocation.getLongitude()+ ")";
//        webView = (WebView) findViewById(R.id.webView);
//        webView.getSettings().setJavaScriptEnabled(true);
//        //Wait for the page to load then send the location information
//        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public void onPageFinished(WebView view, String url){
//                webView.loadUrl(centerURL);
//            }
//        });
//        webView.loadUrl(MAP_URL);
//    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }


//    public void requestPermission()
//    {
//        if (ContextCompat.checkSelfPermission(MapsActivity.this,
//                Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//            if (ActivityCompat.shouldShowRequestPermissionRationale(MapsActivity.this,
//                    Manifest.permission.ACCESS_FINE_LOCATION)) {
//            } else {
//                ActivityCompat.requestPermissions(MapsActivity.this,
//                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_PERMISSION_REQUEST_CODE);
//            }
//        }
//    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//
//        if (mGoogleApiClient == null) {
//            mGoogleApiClient = new GoogleApiClient.Builder(this)
//                    .addConnectionCallbacks(this)
//                    .addOnConnectionFailedListener(this)
//                    .addApi(LocationServices.API)
//                    .build();
//        }
//        createLocationRequest();
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadPlacePicker();
//            }
//        });
//        requestPermission();
//}

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_CHECK_SETTINGS) {
//            if (resultCode == RESULT_OK) {
//                mLocationUpdateState = true;
//                startLocationUpdates();
//            }
//        }
//
//        if (requestCode == PLACE_PICKER_REQUEST) {
//            if (resultCode == RESULT_OK) {
//                Place place = PlacePicker.getPlace(this, data);
//                String addressText = place.getName().toString();
//                addressText += "\n" + place.getAddress().toString();
//
//                placeMarkerOnMap(place.getLatLng());
//            }
//        }
//    }
//
//    // 2
//    @Override
//    protected void onPause() {
//        super.onPause();
//        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
//    }
//
//    // 3
//    @Override
//    public void onResume() {
//        super.onResume();
//        if (mGoogleApiClient.isConnected() && !mLocationUpdateState) {
//            startLocationUpdates();
//        }
//    }
//
//    protected void startLocationUpdates() {
//        //1
//        if (ActivityCompat.checkSelfPermission(this,
//                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this,
//                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
//                    LOCATION_PERMISSION_REQUEST_CODE);
//            return;
//        }
//        //2
//        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest,
//                this);
//    }
//
//
//    protected void createLocationRequest() {
//        mLocationRequest = new LocationRequest();
//        // 2
//        mLocationRequest.setInterval(10000);
//        // 3
//        mLocationRequest.setFastestInterval(5000);
//        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//
//        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
//                .addLocationRequest(mLocationRequest);
//
//        PendingResult<LocationSettingsResult> result =
//                LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient,
//                        builder.build());
//
//        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
//            @Override
//            public void onResult(@NonNull LocationSettingsResult result) {
//                final Status status = result.getStatus();
//                switch (status.getStatusCode()) {
//                    // 4
//                    case LocationSettingsStatusCodes.SUCCESS:
//                        mLocationUpdateState = true;
//                        startLocationUpdates();
//                        break;
//                    // 5
//                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
//                        try {
//                            status.startResolutionForResult(MapsActivity.this, REQUEST_CHECK_SETTINGS);
//                        } catch (IntentSender.SendIntentException e) {
//                        }
//                        break;
//                    // 6
//                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
//                        break;
//                }
//            }
//        });
//    }
//
//    private void loadPlacePicker() {
//        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
//
//        try {
//            startActivityForResult(builder.build(MapsActivity.this), PLACE_PICKER_REQUEST);
//        } catch(GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        // 2
//        mGoogleApiClient.connect();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        // 3
//        if( mGoogleApiClient != null && mGoogleApiClient.isConnected() ) {
//            mGoogleApiClient.disconnect();
//        }
//    }
//
//    @Override
//    public int getContnetView() {
//        return R.layout.activity_map;
//    }
//
//
//    /**
//     * Manipulates the map once available.
//     * This callback is triggered when the map is ready to be used.
//     * This is where we can add markers or lines, add listeners or move the camera. In this case,
//     * we just add a marker near Sydney, Australia.
//     * If Google Play services is not installed on the device, the user will be prompted to install
//     * it inside the SupportMapFragment. This method will only be triggered once the user has
//     * installed Google Play services and returned to the app.
//     */
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        // Add a marker in Sydney and move the camera
////        LatLng sydney = new LatLng(-34, 151);
////        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
////        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,12));
//
//        mMap.getUiSettings().setZoomControlsEnabled(true);
//        mMap.setOnMarkerClickListener(this);
//        requestPermission();
//    }
//
//



}

//    @Override
//    public void onRequestPermissionsResult(int requestCode,
//                                           String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case LOCATION_PERMISSION_REQUEST_CODE: {
//                // If request is cancelled, the result arrays are empty.
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//                    // permission was granted, yay! Do the
//                    // contacts-related task you need to do.
//                    setUpMap();
//
//                } else {
//
//                    // permission denied, boo! Disable the
//                    // functionality that depends on this permission.
//                }
//                return;
//            }
//
//            // other 'case' lines to check for other
//            // permissions this app might request
//        }
//    }
//
//    private void setUpMap() {
//        requestPermission();
//
//        mMap.setMyLocationEnabled(true);
//
//        LocationAvailability locationAvailability =
//                LocationServices.FusedLocationApi.getLocationAvailability(mGoogleApiClient);
//        if (null != locationAvailability && locationAvailability.isLocationAvailable()) {
//            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
//            if (mLastLocation != null) {
//                LatLng currentLocation = new LatLng(mLastLocation.getLatitude(), mLastLocation
//                        .getLongitude());
//                //add pin at user's location
//                placeMarkerOnMap(currentLocation);
//                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 12));
//            }
//        }
//    }
//
//    private String getAddress( LatLng latLng ) {
//        // 1
//        Geocoder geocoder = new Geocoder( this );
//        String addressText = "";
//        List<Address> addresses = null;
//        Address address = null;
//        try {
//            // 2
//            addresses = geocoder.getFromLocation( latLng.latitude, latLng.longitude, 1 );
//            // 3
//            if (null != addresses && !addresses.isEmpty()) {
//                address = addresses.get(0);
//                for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
//                    addressText += (i == 0)?address.getAddressLine(i):("\n" + address.getAddressLine(i));
//                }
//            }
//        } catch (IOException e ) {
//        }
//        return addressText;
//    }
//
//    protected  void placeMarkerOnMap(LatLng location) {
//        MarkerOptions markerOptions = new MarkerOptions().position(location);
//
//        String titleStr = getAddress(location);
//        markerOptions.title(titleStr);
//
//        mMap.addMarker(markerOptions);
//    }
//
//
//    @Override
//    public void onConnected(@Nullable Bundle bundle) {
//        setUpMap();
//        if (mLocationUpdateState) {
//            startLocationUpdates();
//        }
//    }
//
//    @Override
//    public void onConnectionSuspended(int i) {
//
//    }
//
//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//
//    }
//
//    @Override
//    public void onLocationChanged(Location location) {
//        mLastLocation = location;
//        if (null != mLastLocation) {
//            placeMarkerOnMap(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()));
//        }
//
//    }
//
//    @Override
//    public boolean onMarkerClick(Marker marker) {
//        return false;
//    }
//}
