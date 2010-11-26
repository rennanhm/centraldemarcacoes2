package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import Medico.Medico;


public class GravaLerMedico implements Serializable{
	private static final transient long serialVersionUID = 1L;
	private static final String xmlMedico = "medico.xml";
	private static XStream xstream = new XStream();
	private static XStream xstream2 = new XStream(new DomDriver());
	
	
	
	
	public static void gravaMedico(List<Medico> listaDeMedicos) throws IOException {
		BufferedWriter writer1 = null;
		
		try {
			writer1 = new BufferedWriter(new FileWriter(xmlMedico));
			String listaMedico = xstream.toXML(listaDeMedicos);
	        writer1.write(listaMedico);
		} catch (IOException e1) {
			//System.err.println(e1);
		} finally {
			writer1.close();
		}
				
	}
	
	@SuppressWarnings("unchecked")
	public static List<Medico> lerMedico(List<Medico> listaDeMedicos) throws IOException {
		BufferedReader read1 = null; 
		List<Medico> listaMedico = null;
		try {
			read1 = new BufferedReader(new FileReader(xmlMedico));
			listaMedico = (List<Medico>) xstream2.fromXML(read1);
		} catch (IOException e1) {
			//System.err.println(e1);
		} finally {
			read1.close();
		}
		return listaMedico;
	}

}
