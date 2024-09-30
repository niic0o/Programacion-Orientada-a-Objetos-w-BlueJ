//Atencion: Desactivar "Clear Screen" en la maquina virtual para visualizar mas de un objeto en pantalla.
public class creaCliente
{
    public static void main (String [] args)
        {
            int dni = Integer.parseInt(args [0]);
            String apellido = (args [1]);
            String nombre = (args [2]);
            double saldo = Double.parseDouble(args[3]);
            Cliente unCliente = new Cliente(dni,apellido,nombre,saldo);
            System.out.println("Resumen de cuenta");
            unCliente.mostrar();
            System.out.println("Saldo actualizado: $250.545"+"\n"+"Saldo "+unCliente.agregaSaldo(250.545)+"\n");
            System.out.println("Saldo establecido en 2000"+"\n"+"Saldo neto: "+unCliente.nuevoSaldo(2000.00)+"\n");
            unCliente.mostrar();
        }
}
