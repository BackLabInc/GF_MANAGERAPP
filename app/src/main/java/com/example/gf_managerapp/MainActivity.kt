package com.example.gf_managerapp

import android.app.WallpaperManager
import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.gf_managerapp.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val packageManager = packageManager
        val componentName = ComponentName(this, MainActivity::class.java)
        packageManager.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP)

        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        /*REVISAR LA SOCLICITUD DE PERMISOS*/

        var wallpaperManager: WallpaperManager = WallpaperManager.getInstance(this);
        var wallpaperDrawable: Drawable = wallpaperManager.getDrawable()

        binding.wallpaperUser.setImageDrawable(wallpaperDrawable)

        /*Listar apps del sistema*/

        /*Start Menu*/
         drawerLayout = findViewById(R.id.drawer_layout)
        setSupportActionBar(binding.toolbar)
        binding.navItem.setNavigationItemSelectedListener{true}

        val toggle = ActionBarDrawerToggle(this, drawerLayout, binding.toolbar, R.string.open_navigation, R.string.close_navigation)
        drawerLayout.addDrawerListener(toggle)

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, gf_home_screen()).commit()
            binding.navItem.setCheckedItem(R.id.gf_home)
        }



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.gf_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, gf_home_screen()).commit()

        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}