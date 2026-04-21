package Excepcions;

public class ExcepcionsPropies {
    //Tienen que ser static.


    public static class MetresInvalidsException extends RuntimeException{
        public MetresInvalidsException(int llargada){
            super(llargada + "No es una llargada valida");
        }
    }
}
