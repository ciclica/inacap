package cl.inacap.kasoap;


import java.util.concurrent.ExecutionException;
import cl.inacap.clases.WSBackgroundConnection;
// import com.example.ksoapejemplo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    
		

		// Llamamos en forma asincrónica a nuestro objeto de conexión
		// Esto es requerido puesto que, en la actualidad, Android no permite
		// conexiones a redes desde la UI.
		
	     
	  // creo el boton
			Button btn_1 = (Button)findViewById(R.id.button1);
			btn_1.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// llama al metodo para ejecutar. el sw
						Procesa();
					    
				}
			});	
			
			// creo el boton
						Button btn_2 = (Button)findViewById(R.id.button2);
						btn_2.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View v) {
								// llama al metodo para ejecutar. el sw
									Procesa2();
								    
							}
						});	
			
		
		
	}
	
	
	public void Procesa(){
		
		EditText initTv = (EditText) findViewById (R.id.txt_Cs);
		// TextView ValIni = (TextView) findViewById (R.id.txt_fh);
		EditText ValIni = (EditText) findViewById (R.id.txt_fh);
	     String valor = ValIni.getText().toString();
		try {
			
			String[] Valores = { valor,"F2C" };
			
			initTv.setText("" + new WSBackgroundConnection().execute(Valores).get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
public void Procesa2(){
		
		EditText initTv = (EditText) findViewById (R.id.txt_Cs);
		EditText ValIni = (EditText) findViewById (R.id.txt_fh);
		//TextView ValIni = (TextView) findViewById (R.id.txt_fh);
	     String valor = initTv.getText().toString();
		try {
			
			String[] Valores = { valor,"C2F" };
			
			ValIni.setText("" + new WSBackgroundConnection().execute(Valores).get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
