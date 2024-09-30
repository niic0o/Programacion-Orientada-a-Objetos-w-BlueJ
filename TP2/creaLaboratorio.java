public class creaLaboratorio
{
    public static void main (String [] args)
    {
        Laboratorio unLab = new Laboratorio("Colgate S.A","Junin 5204","54-11-4239-8447");
        unLab.mostrar();
        System.out.println("-\t-\t-\t-\t-");
        Laboratorio dosLab = new Laboratorio("Colgate S.A","Belgrano 888","54-0800-0000",2,5);
        dosLab.mostrar();
    }
}
