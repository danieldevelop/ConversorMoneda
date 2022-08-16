package cl.monedas;

/**
 * @author Daniel Gómez
 * Contacto: dgomez.informatica@gmail.com
 */

public class Conversion {
    
   Monedas moneda = new Monedas();
   
//   DE PESOS A DOLAR Y VICEBERSA
   public double PesosChilenosADolar(double pesos) {
       return (pesos / moneda.PRECIO_DOLAR);
   }
   
   public double DolarAPesosChilenos(double dolar) {
       
       return (dolar * moneda.PRECIO_DOLAR);
   }
   
   
//   DE PESOS A EURO Y VICEBERSA
   public double PesosChilenosAEuro(double pesos) {
       return (pesos / moneda.PRECIO_EURO);
   }
   
   public double EuroAPesosChilenos(double euro) {
       return (euro * moneda.PRECIO_EURO);
   }
   
   
//   DE PESOS A LIBRAS Y VICEBERSA
   public double PesosChilenosALibras(double pesos) {
       return (pesos / moneda.PRECIO_LIBRAS_ESTERLINAS);
   }
   
   public double LibrasAPesosChilenos(double libras) {
       
       return (libras * moneda.PRECIO_LIBRAS_ESTERLINAS);
   }
   
   
   //   DE PESOS A YEN Y VICEBERSA
   public double PesosChilenosAYen(double pesos) {
       return (pesos / moneda.PRECIO_YEN_JAPONES);
   }
   
   public double YenAPesosChilenos(double yen) {
       
       return (yen * moneda.PRECIO_YEN_JAPONES);
   }
   
   
    //   DE PESOS A WON Y VICEBERSA
   public double PesosChilenosAWon(double pesos) {
       return (pesos / moneda.PRECIO_WON_SURCOREANO);
   }
   
   public double WonAPesosChilenos(double won) {
       
       return (won * moneda.PRECIO_WON_SURCOREANO);
   }
   
}