package cl.inacap.mermas.u1.javier.ferrada;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		// creo el boton  Productos
		Button btn_prod = (Button)findViewById(R.id.btn_productos);
		btn_prod.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// esto genera la llamada a mi validar
			    //  cuando clikea lo mando a la lista..
			
				// toast muestra msg en activity..
				Toast.makeText(MenuActivity.this, "Muestra la Lista de Productos", Toast.LENGTH_SHORT).show();
				
				// para llamar a otro Activity se usa. Intent
				
				Intent cargaProd = new Intent(MenuActivity.this, ProductoActivity.class);
				MenuActivity.this.startActivity(cargaProd);
			}
		});		
		
		// creo el boton  Cliente
		Button btn_cli = (Button)findViewById(R.id.btn_cliente);
		btn_cli.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// esto genera la llamada a mi validar
			    //  cuando clikea lo mando a la lista..
			
				// toast muestra msg en activity..
				Toast.makeText(MenuActivity.this, "Agrega Cliente", Toast.LENGTH_SHORT).show();
				
				// para llamar a otro Activity se usa. Intent
				
				Intent cargaCli = new Intent(MenuActivity.this, ClienteActivity.class);
				MenuActivity.this.startActivity(cargaCli);
			}
		});		
		
		
		// creo el boton  PEdido
				Button btn_ped = (Button)findViewById(R.id.btn_pedido);
				btn_ped.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						// esto genera la llamada a mi validar
					    //  cuando clikea lo mando a la lista..
					
						// toast muestra msg en activity..
						Toast.makeText(MenuActivity.this, "Pedidos", Toast.LENGTH_SHORT).show();
						
						// para llamar a otro Activity se usa. Intent
						
						Intent cargaPed = new Intent(MenuActivity.this, PedidosActivity.class);
						MenuActivity.this.startActivity(cargaPed);
					}
				});		
		
				
				
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
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
