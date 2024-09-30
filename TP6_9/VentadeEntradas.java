import java.util.*;
/**
 * Write a description of class VentadeEntradas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VentadeEntradas
{
   public static void main (String [] args){
       Calendar fechaVisita = new GregorianCalendar(22,10,2016);//- 1 el mes
       Zoologico unZoologico = new Zoologico("El Caribu");
       Persona unaPersona = new Persona(35425444,"Juan","Sanchez",1992);
       Persona dosPersona = new Persona(30200000,"Mario","Delgado",1989);
       Persona tresPersona = new Persona(5000222, "Ernestino","Gardel",1932);
       Individuo unIndividuo = new Individuo(unaPersona.getNombre(),fechaVisita,unaPersona);
       Individuo dosIndividuo = new Individuo(dosPersona.getNombre(),fechaVisita,dosPersona);
       Individuo tresIndividuo = new Individuo(tresPersona.getNombre(),fechaVisita,tresPersona);
       Delegacion unaDelegacion = new Delegacion("PAMI",fechaVisita,dosIndividuo);
       unaDelegacion.inscribirIndividuo(tresIndividuo);
       unZoologico.nuevoVisitante(unIndividuo);
       unZoologico.nuevoVisitante(unaDelegacion);
       unZoologico.listaVisitantePorFecha(fechaVisita);
       Calendar fechaDesde = new GregorianCalendar(01,10,2016);
       Calendar fechaHasta = new GregorianCalendar(30,10,2016);
       System.out.println("\n"+"La Recaudacion es: $"+unZoologico.recaudacion(fechaDesde,fechaHasta)+"\n");
       unZoologico.listaTipoVisitantePorFecha(fechaVisita,"DELEGACION");
   }
}
