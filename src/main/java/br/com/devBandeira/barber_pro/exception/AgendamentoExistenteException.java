package br.com.devBandeira.barber_pro.exception;

public class AgendamentoExistenteException extends RuntimeException {
    public AgendamentoExistenteException(String message) {
        super(message);
    }
}