
/**
 * Gestiona datos del paciente de un Hospital.
 * 
 * @author Nicolas Ariel Sena
 * @version 1.0 - 14/09/2017
 */
public class GestionHospital
{
   public static void main (String [] args)
   {
       Hospital unHospital = new Hospital("Garrahan","Leonardo Ruiz");
       Localidad nacioEn = new Localidad("Curuzu Cuatia","Corrientes");
       Localidad viveEn = new Localidad("Monte Caseros", "Corrientes");
       Paciente unPaciente = new Paciente(578669, "Juan Manuel Ortigoza", "3 de Abril", nacioEn, viveEn);
       System.out.println("---- Gestion Hospital ----"+"\n");
       System.out.println("Datos del paciente");
       unPaciente.mostrarDatosPantalla();
       System.out.println("Nacido en: "+nacioEn.mostrar());
       System.out.println("\n"+"Datos filiatorios");
       unHospital.consultaDatosFiliatorios(unPaciente);
       System.out.println("\n"+"\n"+"Enviar correo a ");
       System.out.println(unPaciente.cadenaDeDatos());
       
       
   }
}
