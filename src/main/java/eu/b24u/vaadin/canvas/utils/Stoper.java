package eu.b24u.vaadin.canvas.utils;

/**
 * Prosty stoper
 */
public class Stoper {
 // pola prywatne klasy 
 // czas startu stopera
 private long start;
 // czas stopu stopera
 private long stop;
 // nazwa stopera
 private String nazwa;

 /**
  *  konstruktor bezparametrowy
  */
 public Stoper() {
  // przypisujemy pusty łańcuch do pola nazwa
  // wywołując konstruktor jednoparametrowy z naszej klasy
  this("");
 }
  
 /**
  *  konstruktor z jednym parametrem - nazwa stopera
  * @param nazwa to nazwa stopera
  */
 public Stoper(String nazwa) {
  // przypisujemy do pola nazwa przekazany łańcuch tekstowy
  this.nazwa = nazwa;
 }
 
 /**
  *  metoda uruchamiana przy starcie stopera
  */
 public void start(){
  // pobieramy aktualny czas - start stopera
  start = System.currentTimeMillis();
 }
 
 /**
  *  metoda zatrzymująca nasz stoper
  */
 public void stop(){
  // pobieramy aktualny czas - stop stopera
  stop = System.currentTimeMillis();
 } 
  
 /**
  *  metoda zwraca w sekundach czas pomiędzy uruchomieniem, a zatrzymaniem stopera
  * @return
  */
 public double pobierzWynik(){
  // zamiana milisekund na sekundy
  return (stop - start) / 1000.0;
 } 
 
 /**
  *  przesłonięta metoda toString()
  */
 public String toString(){
  // zwracamy w formie tekstowej informacje o naszym stoperze  
  return nazwa + ": " + this.pobierzWynik() + " s."; 
 }
 
 /**
  *  Czas stopera
  */
 public String wypiszCzas(){
  return toString(); 
 }
}
