/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PainelMarcaCirurgia.java
 *
 * Created on 24/11/2010, 09:51:12
 */

package interfaceGrafica;

import Medico.Medico;
import Paciente.HorarioDeAtendimento;
import Paciente.Paciente;
import java.util.List;
import persistencia.GravaLerMedico;

/**
 *
 * @author Administrador
 */
public class PainelMarcaCirurgia extends javax.swing.JPanel {

    /** Creates new form PainelMarcaCirurgia */
    public PainelMarcaCirurgia() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nomeDoMedicoDaConsulta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        nomeDoPaciente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        diaDaConsulta = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        mag2 = new javax.swing.JLabel();

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MARCAR CIRURGIA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Nome do Medico:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        String s = Main.secretaria.getListaDeMedicos().toString();
        s = s.replace("[", "");
        s = s.replace("]", "");
        s = s.replace(",", "\n");

        jTextArea1.setText(s);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        String c = Main.secretaria.getListaDePaciente().toString();

        c = c.replace("[", "");
        c = c.replace("]", "");
        c = c.replace(",", "\n");
        jTextArea3.setText(c);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel4.setText("Nome do Paciente:");

        jButton3.setText("Tentar Marcar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeDoPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(nomeDoMedicoDaConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(diaDaConsulta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(nomeDoMedicoDaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(nomeDoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(diaDaConsulta))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        limpar.setText("Limpar");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        jButton4.setText("Confirmar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(limpar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(mag2)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton4, limpar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(limpar)
                    .addComponent(jButton4)
                    .addComponent(mag2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mag2.setText("");
        diaDaConsulta.setText("");
        nomeDoMedicoDaConsulta.setText("");
        nomeDoPaciente.setText("");
        Main.frame1.setContentPane(Main.painelPrincipalMarca);
        Main.frame1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


     private Paciente pedePaciente(String paciente) {
       List<Paciente> listaDePaciente = Main.secretaria.getListaDePaciente();

       Paciente novoPaciente = null;
	for (Paciente pacientes : listaDePaciente) {
	    if ( pacientes.getNome().equalsIgnoreCase(paciente)){
                novoPaciente =  pacientes;
                return novoPaciente;
            }
        }
        return novoPaciente;
	}

     private Medico pedeMedico(String medico) {
       List<Medico> listaDeMedico = Main.secretaria.getListaDeMedico();

       Medico novoMedico = null;
	for (Medico medicos : listaDeMedico) {
	    if ( medicos.getNomeDoMedico().equalsIgnoreCase(medico)){
                novoMedico =  medicos;
                return novoMedico;
            }
        }
        return novoMedico;
	}

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try{
            Medico medico = pedeMedico(nomeDoMedicoDaConsulta.getText());
            Paciente paciente = pedePaciente(nomeDoPaciente.getText());
            paciente.setHorarioDeAtendimento(new HorarioDeAtendimento(paciente.getNumeroDeIdentificacao(), false, false));

            if (medico == null || paciente == null){
                diaDaConsulta.setText("Nome errado tente novamente");
            }
            else {
            if (medico.getDiasDeCirurgia().isEmpty()) {
                diaDaConsulta.setText("Medico nao realiza cirurgia");
            } else {
                Main.secretaria.marcarCirurgia(medico, paciente);
                diaDaConsulta.setText("Paciente marcado para " + paciente.getHorarioDeAtendimento().getDiaDoMes() + "/" + (paciente.getHorarioDeAtendimento().getMes()+1));
                GravaLerMedico.gravaMedico(Main.secretaria.getListaDeMedico());
}
            }
        } catch (Exception e){

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        mag2.setText("");
        diaDaConsulta.setText("");
        nomeDoMedicoDaConsulta.setText("");
        nomeDoPaciente.setText("");
    }//GEN-LAST:event_limparActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        mag2.setText("Paciente marcado. Click em voltar");
}//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel diaDaConsulta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JButton limpar;
    private javax.swing.JLabel mag2;
    private javax.swing.JTextField nomeDoMedicoDaConsulta;
    private javax.swing.JTextField nomeDoPaciente;
    // End of variables declaration//GEN-END:variables

}
