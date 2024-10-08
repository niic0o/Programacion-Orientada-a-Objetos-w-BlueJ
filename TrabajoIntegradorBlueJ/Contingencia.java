import java.util.*;

/**
 * Write a description of class Contingencia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Contingencia{
    public static void main (String [] args){
        Calendar fecha=new GregorianCalendar();
        fecha.set(2017,12,12);
        
        
        
        Libro libro1 = new Libro("SISTEMAS OPERATIVOS. Una vision aplicada", 1, "Mc Graw Hill", 2003);
        Libro libro2 = new Libro("Diseño Grafico", 1, "MP Ediciones", 2009);
        Libro libro3 = new Libro("JAVA. Como programar", 7, "Pearson", 2008);
        
        Estudiante estudiante1 = new Estudiante(36615567,"Diego Trangoni ",5,"Lic. en Sistemas de Informacion");
        Estudiante estudiante2 = new Estudiante(34255122,"Eric Ojeda",4, "Lic. en Sistemas de Informacion");
        Estudiante estudiante3 = new Estudiante(29388521,"Matias Villarreal",5,"Lic. en Sistemas de Informacion");
        
        Docente docente1 = new Docente(18634778, "Aldo Metinni", "Informatica");
        Docente docente2 = new Docente(14663770, "Mariela Burghardt  ", "Informatica");
        Docente docente3 = new Docente(19882654, "Cristina Greiner", "Informatica");
        
        Biblioteca biblioteca = new Biblioteca("9 DE JULIO");
        
         biblioteca.addLibro(libro1);
         biblioteca.addLibro(libro2);
         biblioteca.addLibro(libro3);
         
         biblioteca.addSocio(estudiante1);
         biblioteca.addSocio(estudiante2);
         biblioteca.addSocio(estudiante3);
         
         biblioteca.addSocio(docente1);
         biblioteca.addSocio(docente2);
         biblioteca.addSocio(docente3);

         biblioteca.prestarLibro(fecha,estudiante1,libro3);
         biblioteca.listaDeSocios();
         biblioteca.listaDeLibros();
         biblioteca.listaDeDocentesResponsables();
         biblioteca.prestarLibro(fecha,estudiante2,libro2);
         
         
        
    }
}
         

