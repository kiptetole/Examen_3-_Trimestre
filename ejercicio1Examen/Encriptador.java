package ejercicio1Examen;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

/**
 * 1. Escribe un programa que usando la interfaz gráfica de Java escoja un
 * fichero del sistema de archivos y lo almacene en otro de manera que se
 * sustituyan todas las ocurrencias de los siguientes caracteres (mayúscula o
 * minúscula) del fichero original por sus correspondientes números: A 4 B 8 E 3
 * I 1 O 0 S 5 T 7 Componentes gráficos: • Etiquetas. • Fichero origen y
 * destino. • Botón para ejecutar la acción.
 * 
 * @author Cristina Prieto Jalao
 *
 */
public class Encriptador extends JFrame {

  private JPanel contentPane;
  private static Encriptador frame = new Encriptador();

  public static void main(String[] args) {
    main();
  }

  /**
   * Lanza la aplicación
   */
  public static void main() {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Crea la ventana
   */
  public Encriptador() {
    setResizable(false);
    setTitle("Guardar contenido");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 370, 264);

    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JTextArea textArea_resultado = new JTextArea();
    textArea_resultado.setEditable(false);
    textArea_resultado.setBounds(28, 220, 598, 202);
    contentPane.add(textArea_resultado);

    JScrollPane scrollPane = new JScrollPane(textArea_resultado, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollPane.setBounds(28, 220, 598, 202);
    contentPane.getRootPane().add(scrollPane);

    JLabel label_fichero1 = new JLabel("Fichero 1:");
    label_fichero1.setBounds(39, 25, 60, 14);
    contentPane.add(label_fichero1);

    JLabel label_fichero2 = new JLabel("Fichero 2:");
    label_fichero2.setBounds(39, 94, 60, 14);
    contentPane.add(label_fichero2);

    JFileChooser jfc1 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    jfc1.setDialogTitle("Seleccione un fichero...");

    JButton boton_fichero1 = new JButton("Selección de fichero");
    boton_fichero1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int returnValue = jfc1.showDialog(null, "Seleccionar");
        if (returnValue == JFileChooser.APPROVE_OPTION)
          if (jfc1.getSelectedFile().getPath() != null)
            boton_fichero1.setText("Seleccionado");
      }
    });
    boton_fichero1.setBounds(151, 25, 178, 23);
    contentPane.add(boton_fichero1);

    JFileChooser jfc2 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    jfc2.setDialogTitle("Seleccione un fichero...");

    JButton boton_fichero2 = new JButton("Selección de fichero");
    boton_fichero2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int returnValue = jfc2.showDialog(null, "Seleccionar");
        if (returnValue == JFileChooser.APPROVE_OPTION)
          if (jfc2.getSelectedFile().getPath() != null)
            boton_fichero2.setText("Seleccionado");
      }
    });
    boton_fichero2.setBounds(151, 90, 178, 23);
    contentPane.add(boton_fichero2);

    JButton boton_guardar = new JButton("Guardar");
    boton_guardar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          BufferedReader br1 = new BufferedReader(new FileReader(jfc1.getSelectedFile().getPath()));
          BufferedWriter bw = new BufferedWriter(new FileWriter(jfc2.getSelectedFile().getPath()));

          String linea = "";
          while (linea != null) {
            linea = br1.readLine();
            if (linea != null) {
              linea = linea.replace('A', '4').replace('a', '4').replace('B', '8').replace('b', '8').replace('E', '3')
                  .replace('e', '3').replace('I', '1').replace('i', '1').replace('O', '0').replace('o', '0')
                  .replace('S', '5').replace('s', '5').replace('T', '7').replace('t', '7');

              bw.write(linea + "\n");
            }
          }

          br1.close();
          bw.close();

          JOptionPane.showMessageDialog(frame, "Fichero guardado con éxito");

        } catch (IOException | NullPointerException ioe) {
          JOptionPane.showMessageDialog(frame, "Indica los dos ficheros correctamente.", "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    boton_guardar.setBounds(125, 144, 91, 23);
    contentPane.add(boton_guardar);
  }
}