package cl.inacap.mermas.u1.javier.ferrada;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import cl.inacap.mermas.u1.clases.Producto;

public class ProductoActivity extends Activity {
	
	//  metodo para mostrar datos en el listview
	//  mostrare asi el listado de producto
	private ArrayAdapter<Producto> adapter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_producto);
		
	     // aca creo la variable para el listview
		ListView lis_prod = (ListView)findViewById(R.id.lv_productos);
		
		//  instacio producto
		Producto prod = new Producto();
		ArrayList<Producto> productos = prod.listaProducto();
		
		// 
		
		adapter = new ArrayAdapter<Producto>(getApplicationContext(),
							android.R.layout.simple_spinner_item, productos);
		
		lis_prod.setAdapter(adapter);
		adapter.notifyDataSetInvalidated();
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.producto, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
