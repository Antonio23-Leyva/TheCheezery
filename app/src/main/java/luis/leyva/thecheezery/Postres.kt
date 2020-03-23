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
import mx.itson.thecheezery.R

class Postres : AppCompatActivity() {
    var coldDrinks = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postres)

         cargarPostres()

        var adaptador = AdaptadorProductos(this, coldDrinks)
        listview.adapter = adaptador

    }

    fun cargarPostres(){
        coldDrinks.add(Product("Blueberry cake",
            R.drawable.blueberrycake, "vainilla cake flavor, topped with cheese topping and blueberries.", 6))
        coldDrinks.add(Product("Chocolate cupcake",
            R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries", 3))
        coldDrinks.add(Product("Lemon tartalette",
            R.drawable.lemontartalette, "pastry shell with a lemon flavored filling", 4))
        coldDrinks.add(Product("Red Velvet cake",
            R.drawable.redvelvetcake, "soft, moist, buttery cake with an easy cream cheese frosting", 6))
        coldDrinks.add(Product("Cherry cheesecake",
            R.drawable.strawberrycheesecake, "This cherry topped cheesecake is positively creamy and delicious and will be you new favorite desert", 7))
        coldDrinks.add(Product("Tiramisu", R.drawable.tiramisu, "Coffe-falvored italian dessert", 6))

    }


    private class AdaptadorProductos: BaseAdapter {
        var productos = ArrayList<Product>()
        var contexto: Context? = null

        constructor(contexto: Context, productos: ArrayList<Product>){
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
