package it.trr.jasper;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import it.trr.jasper.domain.Automobile;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class JasperService {

	
	public void getJasperPrint(List<Automobile> beans, String jasperFileName)
			throws Exception {
		JRDataSource jasperBeans = new JRBeanCollectionDataSource(beans, true);
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(JRParameter.REPORT_LOCALE, Locale.ITALY);
		jasperFileName = jasperFileName + ".jasper";
		InputStream report = this.getClass().getClassLoader().getResourceAsStream(jasperFileName);
		JasperPrint print = JasperFillManager.fillReport(report, parameters, jasperBeans);
		JasperExportManager.exportReportToPdfFile(print, "C:/TEMP/testDiOggi.pdf");
	}
}
