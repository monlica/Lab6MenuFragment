package com.example.lab6menufragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.lab6menufragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().add(
                binding.frameLayout.id,
                FirstFragment()
            ).commit()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        when(item?.itemId){
            R.id.menu1 -> {
                transaction.replace(R.id.frameLayout,FirstFragment())
                transaction.addToBackStack(null)
                transaction.commit()
                return true}
            R.id.menu2 -> {
                transaction.replace(R.id.frameLayout,SecondFragment())
                transaction.addToBackStack(null)
                transaction.commit()
                return true}
            R.id.menu3 -> {
                transaction.replace(R.id.frameLayout,ThirdFragment())
                transaction.addToBackStack(null)
                transaction.commit()
                return true}
            else -> return super.onOptionsItemSelected(item)
        }
    }
}