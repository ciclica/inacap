package cl.inacap.mermas.u1.javier.ferrada;

import android.app.Activity;
import android.content.ContentValues;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cl.inacap.mermas.u1.clases.BaseDatos;
//import cl.inacap.mermas.u1.clases.Cliente;


public class ClienteActivity extends Activity {
	EditText fld_Nom,fld_Dir,fld_Rut ;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cliente);
		
		
		
		
		
		
		// creo las variables para recoger los ingresos..
			fld_Nom = (EditText)findViewById(R.id.txt_nom);
			fld_Dir = (EditText)findViewById(R.id.txt_dir);
			fld_Rut = (EditText)findViewById(R.id.txt_rut);
		
	
		// creo el boton
		Button btn_crea = (Button)findViewById(R.id.btn_creCli);
		btn_crea.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// esto genera la llamada a mi validar
					insertaCliente();
				    
			}
		});	
	}
	
	public void insertaCliente(){
		//  creo variables y les paso los valores de los edittext 
		String CreaNombre = fld_Nom.getText().toString();
		String CreaDirecc = fld_Dir.getText().toString();
		String CreaRut = fld_Rut.getText().toString();
		String CreaEstado = "Nuevo";
		
		//intacio la clase base datos
		BaseDatos baseHelper = new BaseDatos(this,"Frescos",null,1);
		// puntero a la base para escribir en ella
		SQLiteDatabase base = baseHelper.getWritableDatabase();
		if (base!=null){
			
			ContentValues nuevoCliente = new ContentValues();
				nuevoCliente.put("Nombre", CreaNombre);
				nuevoCliente.put("Direccion", CreaDirecc);
				nuevoCliente.put("Rut", CreaRut);
				nuevoCliente.put("Estado", CreaEstado);
			
			long i = base.insert("cliente",null,nuevoCliente);
			
			//  dejo las variables del activity en blanco..
			fld_Nom.setText("");
			fld_Dir.setText("");
			fld_Rut.setText("");
			
			
			if (i>0){
				Toast.makeText(ClienteActivity.this, "Inserta Registro", Toast.LENGTH_SHORT).show();	
			}
			
		}
		
	//  instacion cliente y llamo al metodo insert.	
	//	Cliente creCli = new Cliente();	 
	//    creCli.InsertaCliente(fld_Nom.getText().toString(), fld_Dir.getText().toString(),
	//   				fld_Rut.getText().toString());
	    	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cliente, menu);
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
