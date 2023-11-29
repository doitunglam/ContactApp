package com.example.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.ContactModel.Companion.contacts

open class MainActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = MainFragment.newInstance("RED","GREEN");


        initFragment()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection.
        return when (item.itemId) {
            R.id.option_menu_add_address -> {
                val addAddressFragment = AddAddressFragment.newInstance("RED","BLUE");
                addFragment(addAddressFragment);
//                supportFragmentManager.beginTransaction().addToBackStack("STACK1").replace(R.id.mainFragmentContainerView,addAddressFragment).commit()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initFragment() {
        val mainFragment = MainFragment.newInstance("A","B");
        supportFragmentManager.beginTransaction().replace(R.id.mainFragmentContainerView, mainFragment).commit()
    }

    private fun replaceFragment(fragment: Fragment) {
            supportFragmentManager.beginTransaction().replace(R.id.mainFragmentContainerView, fragment).commit();
    }
    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().addToBackStack(fragment.javaClass.simpleName).add(R.id.mainFragmentContainerView, fragment).commit();
    }
}