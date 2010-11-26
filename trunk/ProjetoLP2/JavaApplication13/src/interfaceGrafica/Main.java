/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaceGrafica;

import Medico.Medico;
import Paciente.Paciente;
import PlanoDeSaude.PlanoDeSaude;
import Secretaria.Estatisticas;
import Secretaria.Secretaria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import persistencia.GravaLerMedico;
import persistencia.GravaLerPaciente;
import persistencia.GravaLerPlanoDeSaude;

/**
 *
 * @author rodolfolv
 */
public class Main {
    public static JFrame frame1;
    public static JPanel painelPrincipal, consultaEstatisticaDeUmMedico, mostraEstatisticaCirurgia, mostraEstatistica, estatisticaMedico,painelEstatisticaEspecialidade, painelEstatistica, painelCadastraMedico, painelMarcaCirurgia, painelListaDeEspera, painelCancelaUmaConsulta, painelCadastraPlanodeSaude, painelPrincinpalMedico, painelPrincipalPaciente, painelPrincinpalPlanoDeSaude, painelCadastraPaciente, painelAdicionaHorarioDeMedico, painelAgendaDosMedicos, painelExcluiPaciente, painelAlteraPreco, listaDePlanos, marcarConsulta, painelPrincipalMarca, painelMarcaConsultaEspecialidade, cancelaConsulta, painelDesMarcaConsulta, painelListadePacientes;
    public static Secretaria secretaria;
    public static List<Medico> listaDeMedico;
    public static List<Paciente> listaDePaciente;
    public static List<PlanoDeSaude> listaDePlanoDeSaude;
    public static Estatisticas estatistica;

    public static void main(String[] args){
        try{
			listaDePaciente = GravaLerPaciente.lerPaciente(listaDePaciente);
		} catch (Exception e){
			listaDePaciente = new ArrayList<Paciente>();
		}
	try{
		listaDeMedico = GravaLerMedico.lerMedico(listaDeMedico);
            } catch (Exception e){
		listaDeMedico = new ArrayList<Medico>();
	}

        try{
		listaDePlanoDeSaude = GravaLerPlanoDeSaude.lerPlanoDeSaude(listaDePlanoDeSaude);
            } catch (Exception e){
		listaDePlanoDeSaude = new ArrayList<PlanoDeSaude>();
	}
        System.out.println(listaDePlanoDeSaude.toString());
        secretaria = new Secretaria(listaDeMedico, listaDePaciente, listaDePlanoDeSaude);
       estatistica = new Estatisticas(secretaria.getListaDeMedico());
       frame1 = new FramePrincipal();
       listaDePlanos = new ListaDePlanos();
       painelExcluiPaciente = new PainelExcluiPaciente();
       painelPrincipal = new PainelPrincipal();
       painelPrincipalMarca = new PainelPrincipalMarcarConsulta();
       painelAlteraPreco = new PainelAlterarPreco();
       painelCadastraMedico = new CadastraMedico();
       marcarConsulta = new PainelMarcar();
       painelCancelaUmaConsulta = new PainelCancelaUmaConsullta();
       cancelaConsulta = new PainelCancelarConsulta();
       painelMarcaCirurgia = new PainelMarcaCirurgia();
       painelCadastraPlanodeSaude = new CadastraPlanoDeSaude();
       painelPrincinpalMedico = new PrincipalMedico();
       painelDesMarcaConsulta = new DesmarcarConsultaDia();
       painelListadePacientes = new ListaPaciente();
       painelMarcaConsultaEspecialidade = new PainelMarcaConsultaEspecialidade();
       painelPrincinpalPlanoDeSaude = new PrincipalPlanoDeSaude();
       painelPrincipalPaciente = new PrincipalPaciente();
       painelCadastraPaciente = new CadastraPaciente();
       painelAgendaDosMedicos = new PainelAgendaDosMedicos();
       painelAlteraPreco = new PainelAlterarPreco();
       painelEstatistica = new PainelPrincinpalEstatistica();
       painelEstatisticaEspecialidade = new EstatisticaDeUmaEspecialidade();
       estatisticaMedico = new EstatisticaMedico();
       mostraEstatistica = new MostraEstatistica();
       mostraEstatisticaCirurgia = new MostraEstatisticaCirurgia();
       consultaEstatisticaDeUmMedico = new ConsultaEstatisticaDeUmMedico();


       frame1.setVisible(true);
       frame1.setContentPane(painelPrincipal);
       
    }





}
