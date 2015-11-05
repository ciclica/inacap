package cl.inacap.mermas.u1.javier.ferrada;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
// import android.widget.ListView;
import android.widget.Spinner;
import cl.inacap.mermas.u1.clases.BaseDatos;
// import cl.inacap.mermas.u1.clases.Cliente;
import cl.inacap.mermas.u1.clases.Producto;

// la activity imprmeta el onitemSelectedListeer para mostrar el item selec
// en los comobox.. mejor spinner

public class PedidosActivity extends Activity implements OnItemSelectedListener {
	
	// creo los contenedores Aparter para llenar los spinner..
	private ArrayAdapter<Producto> adapterProd;
	// private ArrayAdapter<Cliente> adapterClie;
	
	// cambio para leer desde la tabla
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pedidos);
		
		// aca creo la variable spiiner y le paso el objeto del activity
		Spinner listaPro = (Spinner)findViewById(R.id.sp_producto);
		// Spinner listaCli = (Spinner)findViewById(R.id.sp_Cliente);
		
				
		//  instacio producto y cliente llengo el array list
		Producto prod = new Producto();
		// Cliente clie = new Cliente();
		ArrayList<Producto> productos = prod.listaProducto();
		// ArrayList<Cliente> clientes = clie.listaCliente();
						
	    // ahora toca llenar los spinner 
			
		adapterProd = new ArrayAdapter<Producto>(getApplicationContext(),
									android.R.layout.simple_spinner_item, productos);
		//adapterClie = new ArrayAdapter<Cliente>(getApplicationContext(),
		//							android.R.layout.simple_spinner_item, clientes);
		
		listaPro.setAdapter(adapterProd);
		//adapterProd.notifyDataSetInvalidated();	
		//listaCli.setAdapter(adapterClie);
		//adapterClie.notifyDataSetInvalidated();	
	
		
		
		
		// los spinner estan llenos falta marcar el elemento seleccionado...
		// se usa  setOnItemSelectedListener()
		
		cargarListaCliente();
		
				
	}
	

	public void cargarListaCliente(){
		
		//intacio la clase base datos
		BaseDatos baseHelper = new BaseDatos(this,"Frescos",null,1);
		// puntero a la base para lee en ella
		SQLiteDatabase base = baseHelper.getReadableDatabase();
		if (base!=null){
			// recorre la tabla
			Cursor c = base.rawQuery("Select Id,nombre,rut from cliente",null);
			int Registros = c.getCount(); //  q de registros
			int i = 0;
			String[] losclientes = new String[Registros];
			
			if (c.moveToFirst()){
				do{
					//el indice trae el campo de la tabla...
					String campos = c.getInt(0)+".- Cliente:"+
									c.getString(1)+" Rut:"+
									c.getString(2);
					losclientes[i] = campos;
					i++;
				}while (c.moveToNext());
			}
			
	
	// aca creo la variable spiiner y le paso el objeto del activity
	
	
	//		
	ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,
								android.R.layout.simple_list_item_1, losclientes);
	
	// creo el spinner lo asocio al spinner en el layout
	Spinner listaCliBD = (Spinner)findViewById(R.id.sp_CliBase);
	listaCliBD.setAdapter(adapter);   // le paso el adapter...
	
	
		
	
		}
	}


	
	

	@Override
	public void onItemSelected(AdapterView<?> adapter, View view, int position,
	        long id) {
	   ///
		
	}
	 
	@Override
	public void onNothingSelected(AdapterView<?> adapter) {
	 
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pedidos, menu);
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
