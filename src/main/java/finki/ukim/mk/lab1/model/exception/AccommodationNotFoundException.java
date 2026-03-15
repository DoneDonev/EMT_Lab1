package finki.ukim.mk.lab1.model.exception;

public class AccommodationNotFoundException extends RuntimeException {
    public AccommodationNotFoundException(Long id){
        super(String.format("Accommodation with id %d does not exist!", id));
    }
}
