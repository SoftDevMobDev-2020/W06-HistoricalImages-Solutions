package au.edu.swin.sdmd.l05_detailedimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val location = intent.getParcelableExtra<Location>("location")

        val vName = findViewById<TextView>(R.id.name)
        vName.text = location.name

        val vAuthor = findViewById<TextView>(R.id.author)
        vAuthor.text = location.author

    }
}