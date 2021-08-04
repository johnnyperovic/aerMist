package llc.aerMist.app.ui

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import llc.aerMist.app.R

class MainActivity : AppCompatActivity(R.layout.activity_main)
{
    override fun onDestroy() {
        super.onDestroy()
        finish()
        System.exit(0)
    }
}