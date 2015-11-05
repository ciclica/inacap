package cl.inacap.mermas.u1.javier.ferrada;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cl.inacap.mermas.u1.clases.Usuario;



public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//  esconde la action bar.
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		// creo el boton
		Button btn_ingreso = (Button)findViewById(R.id.btn_ingresar);
		btn_ingreso.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// esto genera la llamada a mi validar
					validarUsuario();
				    
			}
		});	
		
	}
	

	public void validarUsuario(){
		// creo las variables para recoger los ingresos..
		EditText fld_user = (EditText)findViewById(R.id.txt_user);
		EditText fld_clave = (EditText)findViewById(R.id.txt_clave);
		
		Usuario user = new Usuario();
		if(user.validarUsuario(fld_user.getText().toString(), fld_clave.getText().toString())){
			
			fld_user.setText("");
			fld_clave.setText("");
			
			// toast muestra msg en activity..
			Toast.makeText(MainActivity.this, "Ingresando", Toast.LENGTH_SHORT).show();
			
			// para llamar a otro Activity se usa. Intent
			
			Intent cargaMenu = new Intent(MainActivity.this, LosClientesActivity.class);
			MainActivity.this.startActivity(cargaMenu);
		}
		else
		{
			Toast.makeText(MainActivity.this, "Demo User:juan Clave:juan ", Toast.LENGTH_SHORT).show();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
