package com.soap.bcn;

import java.util.ArrayList;
import java.util.List;

public class Mes {
	List<Dia> Dias;

	public Mes() {
		Dias = new ArrayList<Dia>();
	}

	public Mes(List<Dia> dias) {
		super();
		Dias = dias;
	}

	public Dia add(Dia dia) {
		Dias.add(dia);
		return dia;
	}

	public void remove(Dia dia) {
		Dias.remove(dia);
	}
}
