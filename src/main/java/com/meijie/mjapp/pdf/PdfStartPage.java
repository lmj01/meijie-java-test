package com.meijie.mjapp.pdf;

import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.pdf.PdfDocument;

public class PdfStartPage implements IEventHandler {

	@Override
	public void handleEvent(Event event) {
		System.out.println(String.format("pdf new page , started"));
		PdfDocumentEvent documentEvent = (PdfDocumentEvent)event;
		PdfDocument pdfDocument = documentEvent.getDocument();
//		Painting painting
		// TODO Auto-generated method stub
		
	}

}
