package luis.leyva.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_productos.*
import kotlinx.android.synthetic.main.producto_view.view.*
import mx.itson.thecheezery.*

class HotDrinks : AppCompatActivity() {

    var hotdrinks = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hot_drinks)

        cargarhotdrinks()

        var adaptador = AdaptadorHotDrinks(this, hotdrinks)
        listview.adapter = adaptador
    }

    fun cargarhotdrinks() {
        hotdrinks.add(
            Product(
                "Latte",
                R.drawable.latte,
                "Coffe drink made with espresso and steamed milk.",
                6
            )
        )
        hotdrinks.add(
            Product(
                "Hot chocolate",
                R.drawable.hotchocolate,
                "Heated drink consisting of shaved chocolate, topped with marshmallows",
                5
            )
        )
        hotdrinks.add(
            Product(
                "Espresso",
                R.drawable.espresso,
                "Full-flavored, concentrated form of coffe",
                4
            )
        )
        hotdrinks.add(
            Product(
                "Chai latte",
                R.drawable.chailatte,
                "Spiced tea concentrate with milk",
                6
            )
        )
        hotdrinks.add(
            Product(
                "Capuccino",
                R.drawable.capuccino,
                "A cappucino is an espresso-based coffe drink, prepared with steamed foam",
                7
            )
        )

    }

    private class AdaptadorHotDrinks : BaseAdapter {
        var productos = ArrayList<Product>()
        var contexto: Context? = null

        constructor(contexto: Context, productos: ArrayList<Product>) {
            this.contexto = contexto
            this.productos = productos
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod = productos[position]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.producto_view, null)

            vista.producto_img.setImageResource(prod.image)
            vista.producto_nombre.setText(prod.name)
            vista.producto_desc.setText(prod.description)
            vista.producto_precio.setText("$${prod.price}")

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
