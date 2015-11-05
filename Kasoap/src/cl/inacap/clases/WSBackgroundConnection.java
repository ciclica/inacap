package cl.inacap.clases;

import org.ksoap2.serialization.SoapPrimitive;
import android.os.AsyncTask;
import android.widget.TextView;
import cl.inacap.kasoap.R;

public class WSBackgroundConnection extends AsyncTask<String, Void, SoapPrimitive> {

	// En la actualidad, Android no permite conexiones a redes
	// en forma directa desde la interfaz. Es por esto que se utiliza
	// una clase que hemos definido como WSBackgroundConnection y que hereda
	// métodos desde AsyncTask.
	// El método que usamos aquí es doInBackground (interfaz está definida
	// en AsyncTask) cuya responsabilidad es llamar al servicio web.
	@Override
	protected SoapPrimitive doInBackground(String... params) {
		
		String numero,metodo;
		numero = params[0];
		metodo = params[1];
		
		if (metodo == "F2C" ) {
				return WSRequestor.getFCConversion(numero);	
		}else{
				return WSRequestor.getCSConversion(numero);
		}
		
		
		
		
	}
	
}