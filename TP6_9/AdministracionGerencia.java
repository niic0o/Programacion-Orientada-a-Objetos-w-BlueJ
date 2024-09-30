
/**
 * Write a description of class AdministracionGerencia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AdministracionGerencia
{
    public static void main (String [] args){
        Gerencia unaGerencia = new Gerencia("Los Arroyos");
        Hotel unHotel = new Hotel("Hotel Guarani",90,7,"single");
        Cabaña unaCabaña = new Cabaña("La Alondra",210,5,3);
        Servicio unServicio = new Servicio("Internet",5);
        Servicio dosServicio = new Servicio("Lavanderia",100);
        Servicio tresServicio = new Servicio("Alquiler de auto",100);
        unHotel.agregarServicio(unServicio);
        unHotel.agregarServicio(dosServicio);
        unaCabaña.agregarServicio(dosServicio);
        unaCabaña.agregarServicio(tresServicio);
        unaGerencia.agregarAlojamiento(unHotel);
        unaGerencia.agregarAlojamiento(unaCabaña);
        unaGerencia.mostrarLiquidacion();
        System.out.println("---------"+"\n");
        System.out.println("---------"+"\n");
        unHotel.quitarServicio(dosServicio);
        unaGerencia.mostrarLiquidacion();
        System.out.println("---------"+"\n");
        System.out.println("---------"+"\n");
        unaGerencia.quitarAlojamiento(unaCabaña);
        unaGerencia.mostrarLiquidacion();
    }
}
