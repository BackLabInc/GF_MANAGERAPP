package com.example.gf_managerapp

import android.app.WallpaperManager
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gf_managerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*REVISAR LA SOCLICITUD DE PERMISOS*/

        var wallpaperManager: WallpaperManager = WallpaperManager.getInstance(this);
        var wallpaperDrawable: Drawable = wallpaperManager.getDrawable()

        binding.wallpaperUser.setImageDrawable(wallpaperDrawable)
    }
}