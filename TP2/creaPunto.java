import java.util.*;
public class creaPunto
{
        public static void main (String [] args)
            {
                double x, y;
                String op, op2;
                Scanner teclado = new Scanner(System.in);
                teclado.useDelimiter("\n");
                System.out.println("------ Bienvenido -----"+"\n");
                Punto inicializarPunto = new Punto();
                do{
                    System.out.println("Ingrese las coordenadas: ");
                    System.out.print("Punto X: ");
                    x = teclado.nextDouble();
                    System.out.print("Punto Y: ");
                    y = teclado.nextDouble();
                    Punto unPunto = new Punto(x,y);
                    System.out.println("\n"+"Variables ingresadas: ");
                    unPunto.mostrar();
                    System.out.println("\n"+"Las cordenadas xy son: "+unPunto.coordenadas());
                    System.out.println("Desea desplazar el punto? presione 'si' o cualquier letra para salir");
                    op2 = teclado.next();
                    if (op2.equals("si"))
                        {
                            System.out.print("Punto X: ");
                            x = teclado.nextDouble();
                            System.out.print("Punto Y: ");
                            y = teclado.nextDouble();
                            unPunto.desplazar(x,y);
                            System.out.println("\n"+"Las cordenadas xy son: "+unPunto.coordenadas());
                        }
                    System.out.println("Desea ingresar otro punto? presione 'si' o cualquier letra para salir");
                    op = teclado.next();
                }while(op.equals("si"));
            }
                    
                    
}
