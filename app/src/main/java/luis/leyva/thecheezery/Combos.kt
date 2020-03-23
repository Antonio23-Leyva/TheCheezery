package luis.leyva.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_combos.*
import kotlinx.android.synthetic.main.activity_producto_combo.view.*
import mx.itson.thecheezery.R

class Combos : AppCompatActivity() {
     var productoCombos = ArrayList<Product>()
     var adapter: AdaptadorCombos? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combos)

        cargarCombos()

        var adapter = AdaptadorCombos(this, productoCombos)
        combos.adapter = adapter

    }


    fun cargarCombos() {
        productoCombos.add(
            Product(
                "Cafe and dona",
                R.drawable.clubsandwich,
                "Cafe natural con una dona",
                7
            )
        )
        productoCombos.add(
            Product(
                "Cafe and piza juntos ",
                R.drawable.clubsandwich,
                "Una mezcla de sabor pizza con cafe",
                3
            )
        )

        productoCombos.add(
            Product(
                "Coffe and muffin ",
                R.drawable.clubsandwich,
                "Una mezcla de sabor mufin con chispas de chocolate y un delicioso cafe",
                8
            )
        )
        productoCombos.add(
            Product(
                "Pastel y cafe ",
                R.drawable.chickencrepes,
                "Atrevete a probar un rico pastel sabor vainilla con fresas y el inigualable cafe sabor caramelo",
                6
            )
        )

        productoCombos.add(
            Product(
                "Mar Vegano ",
                R.drawable.chickencrepes,
                "Este platillo esta constituido por pescado y ensaladas ",
                11
            )
        )

        productoCombos.add(
            Product(
                "Desayuno levanta muertos",
                R.drawable.chickencrepes,
                "Unos ricos guafles con platano y un delicioso cafe capuchino",
                3
            )
        )


    }
    class AdaptadorCombos : BaseAdapter {
        var productos = ArrayList<Product>()
        var contexto: Context? = null

        constructor(contexto: Context, productos: ArrayList<Product>) {
            this.contexto = contexto
            this.productos = productos
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod = productos[position]
            var inflador = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as  LayoutInflater
            var vista = inflador.inflate(R.layout.activity_producto_combo, null)
            vista.tv_titulo.text = prod.name
            vista.iv_procombo.setImageResource(prod.image)
            vista.tv_precio.text = "$${prod.price}"
            vista.tv_descripcion.text = prod.description

            return vista
        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return productos.size
        }

    }
}