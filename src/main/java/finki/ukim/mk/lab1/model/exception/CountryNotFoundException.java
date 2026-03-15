package finki.ukim.mk.lab1.model.exception;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(Long id) {
        super(String.format("Country with id %d does not exist!", id));
    }
}
