package com.meijie.mjapp.logic.events;

import java.util.Observable;
import java.util.Observer;

public class listenGenPdf implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println(String.format("Pdf Has Generated -- %s", (String)arg));
	}

}
