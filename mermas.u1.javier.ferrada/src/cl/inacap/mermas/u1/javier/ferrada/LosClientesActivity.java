package cl.inacap.mermas.u1.javier.ferrada;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import cl.inacap.mermas.u1.clases.BaseDatos;




public class LosClientesActivity extends Activity {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_los_clientes);
		
		cargar(); 
	}
	
	
	

	
	

	public void cargar(){
		

		//instancio la clase base datos
				BaseDatos baseHelper = new BaseDatos(this,"Frescos",null,1);
				// puntero a la base para lee en ella
				SQLiteDatabase base = baseHelper.getReadableDatabase();
				
		if (base!=null){
			// recorre la tabla con Query
			Cursor c = base.rawQuery("Select * from cliente",null);
			int Registros = c.getCount(); //  cantidad de registros de registros
			int i = 0;
			final String[] losclientes = new String[Registros];
			
			if (c.moveToFirst()){
				do{//el indice trae el campo de la tabla...
				// String campos = c.getInt(0)+".- N:"+   es el Id del arreglo
				//					c.getString(1)+" en:"+  es nombre
				//					c.getString(2)+" "+  es apellido
				//					c.getString(3)+" "+  
				// 					c.getString(4);
					
					String campos = c.getString(1)+"-"+c.getString(2)+"-"+c.getString(3)+"-"+c.getString(0);
				
					losclientes[i] = campos;
					i++;	
				}while (c.moveToNext());
			}
			
	
			//  creo el adaptador para el list 
		
	ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,losclientes);
	
	
		
	ListView lista = (ListView)findViewById(R.id.lv_losClientes);
	lista.setAdapter(adapter);
	
	  
	   // Here, you set the data in your ListView
	    
	    adapter.notifyDataSetChanged();
	 
	    
	    
	    // ListView Item Click Listener
	    lista.setOnItemClickListener(new OnItemClickListener() {

             @Override
             public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
               
              // ListView Clicked item index
              int itemPosition     = position;
              int IDRegistro;        
              
             
          	
              String[] RescataID = losclientes[itemPosition].split("-");
              IDRegistro =  Integer.valueOf(RescataID[3]);
              
              //Toast.makeText(getApplicationContext(),"Selecciono:"+ IDRegistro  ,Toast.LENGTH_SHORT).show();
              
              //Toast.makeText(getApplicationContext(),"Selecciono:"+ losclientes[itemPosition] ,Toast.LENGTH_SHORT).show();
              
              confirmarOperacion(IDRegistro);
               
             }
        }); 
	   		
		}
		
		
	}
	
	
	/**
	 * Se confirma la operacion a realizar sobre un Usuario
	 * */
	public void confirmarOperacion(int itemPosition)
	{
		
		final int id = itemPosition;
		final CharSequence[] items = {"Editar", "Borrar", "Cancelar"};
		 
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Que operacion desea hacer con: "   + "?");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		    	if(item == 0){
		    		//editarUsuario();
		    	}
		    	else if(item == 1)
		    	{
		    	 borrar(id);		
		    	
		    	}
		    	else if(item == 2)
		    	{
		    		//dialog.cancel();	
		    	}
		    }
		});
		AlertDialog alert = builder.create();
		alert.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.los_clientes, menu);
		return true;
	}
	
	public void borrar(int itemPosition){
	
		int id;
		id = itemPosition;
		//instancio la clase base datos
		BaseDatos baseHelper = new BaseDatos(this,"Frescos",null,1);
		// puntero a la base para lee en ella
		SQLiteDatabase base = baseHelper.getReadableDatabase();
		
			if (base!=null){			
				Cursor c = base.rawQuery("delete from cliente where Id ="+id,null);
				c.getCount();
				 Toast.makeText(getApplicationContext(),"delete from cliente where Id =  " + id ,Toast.LENGTH_SHORT).show();
				
			}
			
		//	Cursor c = base.rawQuery("delete from cliente where Id = 1",null);
		//	int Registros = c.getCount(); //  cantidad de registros de registros	
		//	 Toast.makeText(getApplicationContext(),"Registro Disponibles " +Registros ,Toast.LENGTH_SHORT).show();
				
			 
		
	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();  // obtiene el id del boton presionado..
		if (id == R.id.action_settings) {
			return true;
		}
		
		switch (id){
			case R.id.menu_cliente:
				// llama a la activity agregar clientes clientes
				Intent cargaCli = new Intent(LosClientesActivity.this, ClienteActivity.class);
				LosClientesActivity.this.startActivity(cargaCli);
				return true;
				
			case R.id.menu_productos:
				// llama a la activity agregar clientes clientes
				Intent cargaProd = new Intent(LosClientesActivity.this, ProductoActivity.class);
				LosClientesActivity.this.startActivity(cargaProd);
				return true;	
				
			case R.id.menu_pedidos:	
				Intent cargaPed = new Intent(LosClientesActivity.this, PedidosActivity.class);
				LosClientesActivity.this.startActivity(cargaPed);
				
			default:
				return super.onOptionsItemSelected(item);
		}
		
		
		
		
	}

	
}
