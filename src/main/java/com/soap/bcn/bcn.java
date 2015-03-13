package com.soap.bcn;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javassist.convert.Transformer;

import javax.xml.soap.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

public class bcn {

	private static final String URL = "https://servicios.bcn.gob.ni/Tc_Servicio/ServicioTC.asmx?WSDL";

	public static ByteArrayOutputStream Respuesta(SOAPMessage mensaje)
			throws Exception {
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
				.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory
				.createConnection();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		SOAPMessage soapResponse = soapConnection.call(mensaje, URL);
		soapResponse.writeTo(baos);
		return baos;
	}

	public static void leer(ByteArrayOutputStream stream) {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		byte[] buffer = new byte[2048];
		try {
			buffer = stream.toByteArray();
			// stream.write(buffer);
			InputStream inputs = new ByteArrayInputStream(buffer);
			List<Dia> dias = new ArrayList<Dia>();
			XMLStreamReader x = inputFactory.createXMLStreamReader(inputs);
			// System.out.println(new String(buffer,"UTF-8"));
			x.nextTag();// <?xml version="1.0" encoding="utf-8"?>
			x.nextTag();// <soap:Envelope
						// xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
						// xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
						// xmlns:xsd="http://www.w3.org/2001/XMLSchema">
			x.nextTag();// <soap:Body>
			x.nextTag();// <RecuperaTC_MesResponse
						// xmlns="http://servicios.bcn.gob.ni/">
			x.nextTag();// <RecuperaTC_MesResult>
			x.nextTag();// <Detalle_TC xmlns="">*/
			
			while (x.hasNext()) {
				x.next();
				Dia dia= new Dia();
				dia.setFecha(x.getElementText());
				x.next();
				dia.setValor(Double.parseDouble(x.getElementText()));
				x.next();
				dia.setAno(Integer.parseInt(x.getElementText()));
				x.next();
				dia.setMes(Integer.parseInt(x.getElementText()));
				x.next();
				dia.setDia(Integer.parseInt(x.getElementText()));
				x.next();
				dias.add(dia);
			}
			
			/*
			 * x.next();//<Tc>
			 * 
			 * //x.nextTag(); System.out.println(x.getLocalName());
			 * System.out.println(x.getElementText()); x.next();
			 * System.out.println(x.getLocalName());
			 * System.out.println(x.getElementText()); x.next();
			 * System.out.println(x.getLocalName());
			 * System.out.println(x.getElementText()); x.next();
			 * System.out.println(x.getLocalName());
			 * System.out.println(x.getElementText()); x.next();
			 * System.out.println(x.getLocalName());
			 * System.out.println(x.getElementText()); // x.next();
			 * System.out.println(x.getLocalName()); x.next(); x.next();
			 * System.out.println(x.getElementText());
			 */

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void SOAP() throws Exception {
		// Create SOAP Connection
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
				.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory
				.createConnection();

		// Send SOAP Message to SOAP Server
		SOAPMessage soapResponse = soapConnection.call(tipoCambioMes(3, 2015),
				URL);
		SOAPMessage soapResponse1 = soapConnection.call(
				tipoCambioDia(12, 3, 2015), URL);

		// print SOAP Response
		System.out.print("Response SOAP Message:");
		soapResponse.writeTo(System.out);
		System.out.println();
		System.out.print("Response SOAP Message:");
		soapResponse1.writeTo(System.out);

		soapConnection.close();
	}

	public static SOAPMessage tipoCambioMes(int Mes, int Anio) throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();
		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("Host", "servicios.bcn.gob.ni");
		headers.addHeader("Content-Type", "text/xml; charset=utf-8");
		headers.addHeader("SOAPAction",
				"http://servicios.bcn.gob.ni/RecuperaTC_Mes");

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.setPrefix("soap");

		envelope.addNamespaceDeclaration("soap",
				"http://schemas.xmlsoap.org/soap/envelope/");
		envelope.addNamespaceDeclaration("xsi",
				"http://www.w3.org/2001/XMLSchema-instance");
		envelope.addNamespaceDeclaration("xsd",
				"http://www.w3.org/2001/XMLSchema");

		// SOAP Body
		SOAPBody soapBody = envelope.getBody();
		SOAPHeader soapHeader = envelope.getHeader();
		soapHeader.recycleNode();
		soapBody.setPrefix("soap");

		SOAPElement RecuperaTC_Mes = soapBody.addChildElement("RecuperaTC_Mes",
				"", "http://servicios.bcn.gob.ni/");
		// RecuperaTC_Mes.addAttribute(envelope.createName("xmlns"),
		// "http://servicios.bcn.gob.ni/");

		SOAPElement nAnio = RecuperaTC_Mes.addChildElement("Ano");
		nAnio.addTextNode(Integer.toString(Anio));
		SOAPElement nMes = RecuperaTC_Mes.addChildElement("Mes");
		nMes.addTextNode(Integer.toString(Mes));

		soapMessage.saveChanges();

		/* Print the request message */
		/*
		 * System.out.print("Request SOAP Message:");
		 * soapMessage.writeTo(System.out);
		 */

		System.out.println();

		return soapMessage;
	}

	public static SOAPMessage tipoCambioDia(int Dia, int Mes, int Anio)
			throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();
		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("Host", "servicios.bcn.gob.ni");
		headers.addHeader("Content-Type", "text/xml; charset=utf-8");
		headers.addHeader("SOAPAction",
				"http://servicios.bcn.gob.ni/RecuperaTC_Dia");

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.setPrefix("soap");

		envelope.addNamespaceDeclaration("soap",
				"http://schemas.xmlsoap.org/soap/envelope/");
		envelope.addNamespaceDeclaration("xsi",
				"http://www.w3.org/2001/XMLSchema-instance");
		envelope.addNamespaceDeclaration("xsd",
				"http://www.w3.org/2001/XMLSchema");

		// SOAP Body
		SOAPBody soapBody = envelope.getBody();
		SOAPHeader soapHeader = envelope.getHeader();
		soapHeader.recycleNode();
		soapBody.setPrefix("soap");

		SOAPElement RecuperaTC_Mes = soapBody.addChildElement("RecuperaTC_Dia",
				"", "http://servicios.bcn.gob.ni/");

		SOAPElement nAnio = RecuperaTC_Mes.addChildElement("Ano");
		nAnio.addTextNode(Integer.toString(Anio));
		SOAPElement nMes = RecuperaTC_Mes.addChildElement("Mes");
		nMes.addTextNode(Integer.toString(Mes));
		SOAPElement nDia = RecuperaTC_Mes.addChildElement("Dia");
		nDia.addTextNode(Integer.toString(Dia));

		soapMessage.saveChanges();

		/* Print the request message */
		System.out.print("Request SOAP Message:");
		soapMessage.getContentDescription();
		soapMessage.writeTo(System.out);

		System.out.println();

		return soapMessage;
	}

	/*public static OutputStream getStream(SOAPMessage message) {
		StreamResult sr = new StreamResult();

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		sr.setOutputStream(out);

		try {
			javax.xml.transform.Transformer trans = TransformerFactory
					.newInstance().newTransformer();
			trans.transform(message, sr);

			// Use out to your heart's desire.
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return sr;
	}*/

}
