package luis.leyva.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*
import mx.itson.thecheezery.R

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btn_colddrinks.setOnClickListener {
            var intent = Intent(this, ProductosActivity::class.java)
            startActivity(intent)
        }

        btn_hot_drinks.setOnClickListener{
            var intent = Intent(this, HotDrinks::class.java)
            startActivity(intent)
        }

        btn_combos.setOnClickListener{
            var intent = Intent(this, Combos::class.java)
            startActivity(intent)
        }
        btn_sweets.setOnClickListener{
            var intent = Intent(this, Postres::class.java)
            startActivity(intent)
        }

        btn_salties.setOnClickListener{
            var intent = Intent(this, Salties::class.java)
            startActivity(intent)
        }
    }
}
