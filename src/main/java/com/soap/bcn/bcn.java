package com.soap.bcn;

import javax.xml.soap.*;

public class bcn {

	public static void SOAP() throws Exception {
		// Create SOAP Connection
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
				.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory
				.createConnection();

		// Send SOAP Message to SOAP Server
		String url = "https://servicios.bcn.gob.ni/Tc_Servicio/ServicioTC.asmx?WSDL";
		SOAPMessage soapResponse = soapConnection.call(tipoCambioMes(3,2015), url);
		SOAPMessage soapResponse1 = soapConnection.call(tipoCambioDia(12,3,2015), url);

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
		headers.addHeader("SOAPAction", "http://servicios.bcn.gob.ni/RecuperaTC_Mes");
		
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

		SOAPElement RecuperaTC_Mes = soapBody.addChildElement("RecuperaTC_Mes","","http://servicios.bcn.gob.ni/");
		//RecuperaTC_Mes.addAttribute(envelope.createName("xmlns"), "http://servicios.bcn.gob.ni/");
		
		SOAPElement nAnio = RecuperaTC_Mes.addChildElement("Ano");
		nAnio.addTextNode(Integer.toString(Anio));
		SOAPElement nMes = RecuperaTC_Mes.addChildElement("Mes");
		nMes.addTextNode(Integer.toString(Mes));
		
		
		soapMessage.saveChanges();

		/* Print the request message */
		System.out.print("Request SOAP Message:");
		soapMessage.getContentDescription();
		soapMessage.writeTo(System.out);

		System.out.println();

		return soapMessage;
	}
	public static SOAPMessage tipoCambioDia(int Dia,int Mes, int Anio) throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();
		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("Host", "servicios.bcn.gob.ni");
		headers.addHeader("Content-Type", "text/xml; charset=utf-8");
		headers.addHeader("SOAPAction", "http://servicios.bcn.gob.ni/RecuperaTC_Dia");
		
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

		SOAPElement RecuperaTC_Mes = soapBody.addChildElement("RecuperaTC_Dia","","http://servicios.bcn.gob.ni/");
		
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
}
