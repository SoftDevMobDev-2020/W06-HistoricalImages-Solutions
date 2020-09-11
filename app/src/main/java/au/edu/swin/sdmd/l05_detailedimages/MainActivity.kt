package au.edu.swin.sdmd.l05_detailedimages

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var station: Location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        station = Location("Glenferrie Station", "Ada May Plante",
                -37.821539f, 145.036473f)

        val vStation = findViewById<TextView>(R.id.station)
        vStation.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("location", station)
            startActivityForResult(intent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode != Activity.RESULT_OK) return

        if (requestCode == 0) {
            val location = data?.getParcelableExtra<Location>("visited")
            val vStation = findViewById<TextView>(R.id.station)
            location?.let {
                vStation.setTextColor(if (location.visited) Color.GREEN else Color.RED)
                station.visited = location.visited
            }
        }
    }


}