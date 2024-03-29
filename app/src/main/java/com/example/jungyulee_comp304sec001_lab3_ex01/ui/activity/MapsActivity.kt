package com.example.jungyulee_comp304sec001_lab3_ex01.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jungyulee_comp304sec001_lab3_ex01.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.jungyulee_comp304sec001_lab3_ex01.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.toggleMapTypeButton.setOnClickListener {
            toggleMapType()
        }

        binding.toggleMapTypeButton.text = "Change to Satellite View"
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val name = intent.getStringExtra("name") ?: "Landmark"
        val latitude = intent.getDoubleExtra("latitude", 0.0)
        val longitude = intent.getDoubleExtra("longitude", 0.0)

        val landmarkLocation = LatLng(latitude, longitude)
        mMap.addMarker(MarkerOptions().position(landmarkLocation).title(name))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(landmarkLocation, 15f))
    }

    private fun toggleMapType() {
        if (mMap.mapType == GoogleMap.MAP_TYPE_NORMAL) {
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE)
            binding.toggleMapTypeButton.text = "Change to Map View"
        } else {
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL)
            binding.toggleMapTypeButton.text = "Change to Satellite View"
        }
    }
}
