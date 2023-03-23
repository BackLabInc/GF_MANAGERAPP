package com.example.gf_managerapp

import android.app.WallpaperManager
import android.graphics.drawable.Drawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ListView
import com.example.gf_managerapp.R

class gf_home_launcher : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gf_home_launcher)

        val wallpaperUser = findViewById<ImageView>(R.id.wallpaperUser)
        var wallpaperManager: WallpaperManager = WallpaperManager.getInstance(this);
        var wallpaperDrawable: Drawable = wallpaperManager.getDrawable()
        wallpaperUser.setImageDrawable(wallpaperDrawable)

        var apps: ImageModel

        //Log.e("prueba", apps.name)
        /*var appsLauncher = intent.getSerializableExtra("listaAppa")
        var customerAdapter: CustomAdapter? = null
        var lv = findViewById<ListView>(R.id.lvLauncher)
        customerAdapter = this?.let { CustomAdapter(it, appsLauncher as ArrayList<ImageModel>) }
        lv?.adapter = customerAdapter*/


    }
}