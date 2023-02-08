package com.example.thirdtry

import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.thirdtry.databinding.ActivityMyAssetBinding
import com.example.thirdtry.databinding.ActivityServiceTerminatedBinding
import com.google.android.material.navigation.NavigationView

class MyAsset : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // popup 애니메이션 제거


        val binding = ActivityMyAssetBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val intent = Intent(this, ServiceTerminated::class.java )
        startActivity(intent)
        print("여기까지 진행")
        // toolbar
        val toolbar = binding.toolbarContainer.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.navi_menu)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        //drawer create
        drawerLayout = findViewById(R.id.drawer_layout)

        //drawer event
        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        // service 종료 popup
        var linear = LinearLayout(this)
        var window = layoutInflater.inflate(R.layout.activity_service_terminated, linear, false)



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(
            R.menu.template_toolbar_menu,
            menu
        ) // main_menu 메뉴를 toolbar 메뉴 버튼으로 설정
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.END)
            }
            R.id.toolbar_info -> {
                val view = findViewById<View>(R.id.toolbar_info)
                print("hello")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //drawer 아이템 클릭 이벤트
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_item1 -> Toast.makeText(this, "menu item1 실행", Toast.LENGTH_SHORT).show()
            R.id.menu_item2 -> Toast.makeText(this, "menu item2 실행", Toast.LENGTH_SHORT).show()
            R.id.menu_item3 -> Toast.makeText(this, "menu item3 실행", Toast.LENGTH_SHORT).show()
        }
        return false
    }
}