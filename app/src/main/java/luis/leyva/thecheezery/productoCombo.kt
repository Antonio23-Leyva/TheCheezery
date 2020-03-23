package luis.leyva.thecheezery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_producto_combo.*
import mx.itson.thecheezery.R

class productoCombo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_combo)

        val bundle = intent.extras

        if (bundle != null) {
            tv_titulo.text = bundle.getString("name")
            iv_procombo.setImageResource(bundle.getInt("image"))
            tv_precio.text = bundle.getString("price")
            tv_descripcion.text = bundle.getString("description")
        }
    }

}
