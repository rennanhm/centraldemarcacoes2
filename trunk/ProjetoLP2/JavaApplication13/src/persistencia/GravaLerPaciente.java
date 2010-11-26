package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import Paciente.Paciente;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class GravaLerPaciente implements Serializable{
	private static final transient long serialVersionUID = 1L;
	private static final String xmlPaciente = "paciente.xml";
	private static XStream xstream = new XStream();
	private static XStream xstream2 = new XStream(new DomDriver());
	
	public static void gravaPaciente(List<Paciente> listaDePacientes) throws IOException {
		BufferedWriter writer1 = null;
		
		try {
			writer1 = new BufferedWriter(new FileWriter(xmlPaciente));
			String listaMedico = xstream.toXML(listaDePacientes);
	        writer1.write(listaMedico);
	        
		} catch (IOException e1) {
			//System.err.println(e1);
		} finally {
			writer1.close();
		}
				
	}
	
	@SuppressWarnings("unchecked")
	public static List<Paciente> lerPaciente(List<Paciente> listaDePacientes) throws IOException {
		BufferedReader read1 = null; 
		List<Paciente> listaPaciente = null;
		try {
			read1 = new BufferedReader(new FileReader(xmlPaciente));
			listaPaciente = (List<Paciente>) xstream2.fromXML(read1);
			
		} catch (IOException e1) {
			//System.err.println(e1);
		} finally {
			read1.close();
		}
		return listaPaciente;
	}

}
