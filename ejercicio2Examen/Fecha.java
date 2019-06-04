package ejercicio2Examen;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

class Fecha {

  static SimpleDateFormat formatdate = new SimpleDateFormat("dd/MM/yyyy");
  static Calendar aux = GregorianCalendar.getInstance();

  /** 
   * Validar fecha: muestra un mensaje diciendo si la fecha es o no válida.
   * 
   * @param fecha
   * @return
   */
  public String validarFecha(String fecha) {
    String[] partes;
    int d, m, y;

    if (fecha.contains("/") && fecha.length() == 10) {
      partes = fecha.split("/");
      d = Integer.parseInt(partes[0]);
      m = (Integer.parseInt(partes[1])) - 1;
      y = Integer.parseInt(partes[2]);
    } else
      return "Se ha introducido mal el formato de la fecha.";

    aux.set(y, m, d);

    if (fecha.equals(formatdate.format(aux.getTime())))
      return "Formato bien introducido";
    else
      return "Mal introducido mal los parametros de la fecha.";
  }

  /**
   * Día posterior: Modifica la fecha sumándole un día. Debe validar la fecha
   * antes de hacer la operación.
   * 
   * @param fecha
   * @return
   */
  public String diaPosterior(String fecha) {
    String comparador = validarFecha(fecha);

    if (comparador.equals("Formato bien introducido")) {
      aux.add(Calendar.DATE, 1);
      return "Un dia mas a " + fecha + " es " + formatdate.format(aux.getTime());
    } else
      return comparador;

  }

  /**
   *  Día anterior: Modifica la fecha restándole un día. Debe validar la fecha
   * antes de hacer la operación.
   *  
   * @param fecha
   * @return
   */
  public String diaAnterior(String fecha) {
    String comparador = validarFecha(fecha);

    if (comparador.equals("Formato bien introducido")) {
      aux.add(Calendar.DATE, -1);
      return "Un dia mas a " + fecha + " es " + formatdate.format(aux.getTime());
    } else
      return comparador;
  }

  /**
   * Días hasta hoy: Muestra el número de días que hay entre la fecha introducida
   * y la fecha de hoy.
   * @param fecha
   * @return
   */
  public String diasHastaHoy(String fecha) {
    String comparador = validarFecha(fecha);
    Calendar hoy = GregorianCalendar.getInstance();
    int i = 0;

    if (comparador.equals("Formato bien introducido")) {

      if (fecha.equals(formatdate.format(hoy.getTime())))
        return "No hay diferencia de dias.";
      else if (aux.after(hoy)) {
        do {
          hoy.add(Calendar.DATE, 1);
          i++;
        } while (!(fecha.equals(formatdate.format(hoy.getTime()))));
        return "Dentro de " + i + " dias";
      } else {
        do {
          hoy.add(Calendar.DATE, -1);
          i++;
        } while (!(fecha.equals(formatdate.format(hoy.getTime()))));
        return "Hace " + i + " dias";
      }
    } else
      return comparador;

  }

}