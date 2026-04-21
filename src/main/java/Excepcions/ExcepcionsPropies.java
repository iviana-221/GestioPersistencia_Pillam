package Excepcions;

public class ExcepcionsPropies {
    //Tienen que ser static.


    public static class MetresInvalidsException extends RuntimeException{
        public MetresInvalidsException(int llargada){
            super(llargada + "No es una llargada valida");
        }
    }

    public static class DadaInvalidaException extends RuntimeException {
    public DadaInvalidaException(String mensaje) {
        super(mensaje);
        //Mensaje porque a la hora de poner la excepcion podremos especificar el mensaje
    }
}


}