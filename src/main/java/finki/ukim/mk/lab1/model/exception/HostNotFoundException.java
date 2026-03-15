package finki.ukim.mk.lab1.model.exception;

public class HostNotFoundException extends RuntimeException {
    public HostNotFoundException(Long id){
        super(String.format("Host with id %d does not exist!", id));
    }
}
