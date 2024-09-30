
/**
 * Write a description of class AplicacionFacultad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AplicacionFacultad
{
    public static void main (String [] args){
        // crear 3 cargos //
        Cargo unCargo = new Cargo("Tutoria De Como No Dejar Todo Para Ultimo Momento",
        15000,2016,10);
        Profesor unProfesor = new Profesor(38236635,"Nicolas Airel","Sena",1995,"Casi Lic. en Sistemas",unCargo);
        Facultad laFacultad = new Facultad("FACENA",unProfesor);
        
        
        //
        Exclusivo unExclusivo = new Exclusivo("Programacion Orientada a Objetos",17752,2010,5,3,2);
        Profesor dosProfesor = new Profesor(20555111,"Aldo","Mettini",1975,"Lic en Sistemas",unExclusivo);
        laFacultad.agregarProfesor(dosProfesor);
        //
        SemiExclusivo unSemiExclusivo = new SemiExclusivo("Sistemas Operativos",18500,1995,10,10);
        Profesor tresProfesor = new Profesor(9845842,"David","La Red",1960,"Experto en Data Center",unSemiExclusivo);
        laFacultad.agregarProfesor(tresProfesor);
        
        laFacultad.listarProfesorCargos();
        laFacultad.nominaProfesores();
        
    }
}
