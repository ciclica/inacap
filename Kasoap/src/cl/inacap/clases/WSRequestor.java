package cl.inacap.clases;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;
import org.xmlpull.v1.XmlPullParserException;

import android.widget.TextView;
import cl.inacap.kasoap.R;



public class WSRequestor {
	
	// Definimos par�metros necesarios para la conexi�n al servicio web.
	// Poner especial atenci�n en SOAP_ACTION: especifica precisamente el servicio.
	// y en METHOD_NAME: indica el m�todo o funci�n que llamamos
	private static final String SOAP_ACTION = "http://www.w3schools.com/webservices/FahrenheitToCelsius";
	private static final String SOAP_ACTION2 = "http://www.w3schools.com/webservices/CelsiusToFahrenheit";
	private static final String METHOD_NAME = "FahrenheitToCelsius";
	private static final String METHOD_NAME2 = "CelsiusToFahrenheit";
	private static final String NAMESPACE = "http://www.w3schools.com/webservices/";
	private static final String URL = "http://www.w3schools.com/webservices/tempconvert.asmx?wsdl";
	
	public static SoapPrimitive getFCConversion (String valor) {
		
		SoapObject request = new SoapObject (NAMESPACE, METHOD_NAME);
		request.addProperty("Fahrenheit", valor );
			
		// Definimos una envolvente que nos permite "encapsular"
		// la respuesta
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope (SoapEnvelope.VER11);
		
		// necesaria para conectarse a un servicio web .Net 
		soapEnvelope.dotNet = true;
		
		soapEnvelope.setOutputSoapObject(request);
		
		AndroidHttpTransport aht = new AndroidHttpTransport (URL);
		
		try {
			// Llamamos al servicio, obtenemos un resultado de tipo SoapPrimitive
			// que contiene nuestra resputesta
			aht.call (SOAP_ACTION, soapEnvelope);
			SoapPrimitive resultString = (SoapPrimitive) soapEnvelope.getResponse();
			
			return resultString;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Caso en que no podemos obtener conversi�n
		// (normalmente por rechazo a la conexi�n)
		return null;
	}
	
public static SoapPrimitive getCSConversion (String valor) {
		
		SoapObject request = new SoapObject (NAMESPACE, METHOD_NAME2);
		
		// Para este ejemplo, hemos dejado fijo el valor 40 en Fahrenheit
		
		//request.addProperty("Celsius", "27");
		request.addProperty("Celsius", valor );
		
		// Definimos una envolvente que nos permite "encapsular"
		// la respuesta
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope (SoapEnvelope.VER11);
		
		// necesaria para conectarse a un servicio web .Net 
		soapEnvelope.dotNet = true;
		
		soapEnvelope.setOutputSoapObject(request);
		
		AndroidHttpTransport aht = new AndroidHttpTransport (URL);
		
		try {
			// Llamamos al servicio, obtenemos un resultado de tipo SoapPrimitive
			// que contiene nuestra resputesta
			aht.call (SOAP_ACTION2, soapEnvelope);
			SoapPrimitive resultString = (SoapPrimitive) soapEnvelope.getResponse();
			
			return resultString;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Caso en que no podemos obtener conversi�n
		// (normalmente por rechazo a la conexi�n)
		return null;
	}
	
	

}
