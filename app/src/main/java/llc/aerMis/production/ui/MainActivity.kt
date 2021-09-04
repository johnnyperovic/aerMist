package llc.aerMis.production.ui

import androidx.appcompat.app.AppCompatActivity
import llc.aerMis.production.R

class MainActivity : AppCompatActivity(R.layout.activity_main)
{
    override fun onDestroy() {
        super.onDestroy()
        finish()
        System.exit(0)
    }
}