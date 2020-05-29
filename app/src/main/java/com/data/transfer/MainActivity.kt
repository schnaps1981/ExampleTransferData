package com.data.transfer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResultListener
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_2.*

class MainActivity : AppCompatActivity(), SnackHandler {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = Data(name = "Ivan", surname = "Ivanov", age = 30)

        tv_data.text = data.toString()

        btn_start_second_activity.setOnClickListener {
            intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("data", data)
            startActivity(intent)
        }

        btn_transfer_activity_fragment.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("data", data)
            val fragment1 = Fragment1.newInstance(args = bundle)

            supportFragmentManager.beginTransaction().replace(R.id.fl_fragment1, fragment1).commit()
        }



        val fragment2 = Fragment2.newInstance(null)
        supportFragmentManager.beginTransaction().replace(R.id.fl_fragment2, fragment2).commit()
    }

    override fun showSnack(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }
}
