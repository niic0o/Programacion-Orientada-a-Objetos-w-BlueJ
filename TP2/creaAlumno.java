//Desactivar "clear screen" en la salida para visualizar mas de un objeto
public class creaAlumno
{
    public static void main (String [] args)
        {
            int lu = Integer.parseInt(args[0]);
            String nombre = (args[1]);
            String apellido = (args[2]);
            double nota1 = Double.parseDouble(args [3]);
            double nota2 = Double.parseDouble(args [4]);

            //objeto instanciado
            Alumno unAlumno = new Alumno(lu,nombre,apellido);
            //envio de notas como mensaje del objeto
            unAlumno.setNota1(nota1);
            unAlumno.setNota2(nota2);
            //visualizar
            unAlumno.mostrar();         
        }
}
