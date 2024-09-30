
/**
 * Write a description of class Administracion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Administracion{
    public static void main (String [] args){
        //Jardin
        Jardin unJardin = new Jardin("Bichito de Luz");
        //Circulo
        Punto unPunto = new Punto(18.5,19.4);
        Circulo unCirculo = new Circulo(2.5,unPunto);
        unJardin.agregarFigura(unCirculo);
        //Cuadrado
        Punto dosPunto = new Punto(19.1,20.1);
        Cuadrado unCuadrado = new Cuadrado(dosPunto,1.28);
        unJardin.agregarFigura(unCuadrado);
        //Rectangulo
        Punto tresPunto = new Punto(0.0,0.0);
        Rectangulo unRectangulo = new Rectangulo(tresPunto,5,10);
        unJardin.agregarFigura(unRectangulo);
        //Elipse
        Punto cuatroPunto = new Punto(9.0,9.5);
        Elipse unaElipse = new Elipse(3.5,1.2,cuatroPunto);
        unJardin.agregarFigura(unaElipse);
        //Triangulo
        Punto cincoPunto = new Punto(0.0,0.0);
        Triangulo unTriangulo = new Triangulo(cincoPunto, 0.5,1.0);
        unJardin.agregarFigura(unTriangulo);
        unJardin.detalleFiguras();
    }
}
