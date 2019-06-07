package ejercicio2Examen;
 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tiempo {
  static Fecha nueva = new Fecha();

  private JFrame frmEjercicioFecha;
  private JTextField textoIntroducido;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Tiempo window = new Tiempo();
          window.frmEjercicioFecha.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Tiempo() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmEjercicioFecha = new JFrame();
    frmEjercicioFecha.setTitle("Ejercicio Fecha");
    frmEjercicioFecha.setBounds(100, 100, 450, 210);
    frmEjercicioFecha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmEjercicioFecha.getContentPane().setLayout(null);

    JLabel lblIntroduzcaLaFecha = new JLabel("Introduzca la fecha:");
    lblIntroduzcaLaFecha.setBounds(22, 34, 114, 14);
    frmEjercicioFecha.getContentPane().add(lblIntroduzcaLaFecha);

    textoIntroducido = new JTextField();
    textoIntroducido.setBounds(139, 31, 178, 20);
    frmEjercicioFecha.getContentPane().add(textoIntroducido);
    textoIntroducido.setColumns(10);

    JButton validarFecha = new JButton("Validar Fecha");
    validarFecha.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent arg0) {

        if (nueva.validarFecha(textoIntroducido.getText())) 
          JOptionPane.showMessageDialog(frmEjercicioFecha, "La fecha es valida.");
        else
          JOptionPane.showMessageDialog(frmEjercicioFecha, "La fecha no es valida.");

      }
    });
    validarFecha.setBounds(10, 90, 128, 23);
    frmEjercicioFecha.getContentPane().add(validarFecha);

    JButton diaPosterior = new JButton("Dia Posterior");
    diaPosterior.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        if (nueva.validarFecha(textoIntroducido.getText())) 
          textoIntroducido.setText(nueva.diaPosterior(textoIntroducido.getText()));
        else
          JOptionPane.showMessageDialog(frmEjercicioFecha, "La fecha no es valida.");
        
      }
    });
    diaPosterior.setBounds(148, 90, 155, 23);
    frmEjercicioFecha.getContentPane().add(diaPosterior);

    JButton diaAnterior = new JButton("Dia Anterior");
    diaAnterior.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        if (nueva.validarFecha(textoIntroducido.getText())) 
          textoIntroducido.setText(nueva.diaAnterior(textoIntroducido.getText()));
        else
          JOptionPane.showMessageDialog(frmEjercicioFecha, "La fecha no es valida.");

      }
    });
    diaAnterior.setBounds(313, 90, 119, 23);
    frmEjercicioFecha.getContentPane().add(diaAnterior);

    JButton diasHastaHoy = new JButton("Dias hasta hoy");
    diasHastaHoy.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(frmEjercicioFecha, nueva.diasHastaHoy(textoIntroducido.getText()));

      }
    });
    diasHastaHoy.setBounds(77, 135, 126, 23);
    frmEjercicioFecha.getContentPane().add(diasHastaHoy);

    JButton terminar = new JButton("Terminar");
    terminar.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    terminar.setBounds(230, 135, 155, 23);
    frmEjercicioFecha.getContentPane().add(terminar);
  }
}