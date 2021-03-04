package it.trr.jasper;

import java.util.ArrayList;
import java.util.List;

import it.trr.jasper.domain.Automobile;
import it.trr.jasper.domain.Proprietario;

public class JasperAppMain {

	public static void main(String args[]) {
		System.out.println("Exporting report...");

		List<Automobile> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Automobile a = new Automobile();
			a.setMarca("Marca" + i);
			a.setAnno(2000 + i);
			a.setModello("Modello" + i);

			Proprietario prop = new Proprietario();
			prop.setNome("Ivan" + (i * 2));
			prop.setCognome("Maltese" + (i * 2));
			a.setProprietario(prop);

			list.add(a);
		}

		JasperService srv = new JasperService();
		try {
			srv.getJasperPrint(list, "esempio");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}