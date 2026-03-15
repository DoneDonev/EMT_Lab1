package finki.ukim.mk.lab1.initializer;

import finki.ukim.mk.lab1.model.domain.Accommodation;
import finki.ukim.mk.lab1.model.domain.Country;
import finki.ukim.mk.lab1.model.domain.Host;
import finki.ukim.mk.lab1.model.enums.Category;
import finki.ukim.mk.lab1.model.enums.State;
import finki.ukim.mk.lab1.repository.AccommodationRepository;
import finki.ukim.mk.lab1.repository.CountryRepository;
import finki.ukim.mk.lab1.repository.HostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

    private final CountryRepository countryRepository;
    private final HostRepository hostRepository;
    private final AccommodationRepository accommodationRepository;

    public DataInitializer(CountryRepository countryRepository,
                           HostRepository hostRepository,
                           AccommodationRepository accommodationRepository) {
        this.countryRepository = countryRepository;
        this.hostRepository = hostRepository;
        this.accommodationRepository = accommodationRepository;
    }

    @PostConstruct
    public void init() {
        if (countryRepository.count() > 0) {
            return;
        }

        Country brazil = new Country();
        brazil.setName("Brazil");
        brazil.setContinent("South America");

        Country france = new Country();
        france.setName("France");
        france.setContinent("Europe");

        Country southAfrica = new Country();
        southAfrica.setName("South Africa");
        southAfrica.setContinent("Africa");

        Country newZealand = new Country();
        newZealand.setName("New Zealand");
        newZealand.setContinent("Oceania");

        Country india = new Country();
        india.setName("India");
        india.setContinent("Asia");

        Country mexico = new Country();
        mexico.setName("Mexico");
        mexico.setContinent("North America");

        Country italy = new Country();
        italy.setName("Italy");
        italy.setContinent("Europe");

        Country egypt = new Country();
        egypt.setName("Egypt");
        egypt.setContinent("Africa");

        List<Country> countries = List.of(brazil, france, southAfrica, newZealand, india, mexico, italy, egypt);
        countryRepository.saveAll(countries);

        Host maria = new Host();
        maria.setName("Maria");
        maria.setSurname("Garcia");
        maria.setCountry(brazil);

        Host pierre = new Host();
        pierre.setName("Pierre");
        pierre.setSurname("Dubois");
        pierre.setCountry(france);

        Host sipho = new Host();
        sipho.setName("Sipho");
        sipho.setSurname("Ndlovu");
        sipho.setCountry(southAfrica);

        Host emma = new Host();
        emma.setName("Emma");
        emma.setSurname("Smith");
        emma.setCountry(newZealand);

        Host rahul = new Host();
        rahul.setName("Rahul");
        rahul.setSurname("Sharma");
        rahul.setCountry(india);

        Host carlos = new Host();
        carlos.setName("Carlos");
        carlos.setSurname("Ruiz");
        carlos.setCountry(mexico);

        Host giulia = new Host();
        giulia.setName("Giulia");
        giulia.setSurname("Bianchi");
        giulia.setCountry(italy);

        Host amira = new Host();
        amira.setName("Amira");
        amira.setSurname("Hassan");
        amira.setCountry(egypt);

        List<Host> hosts = List.of(maria, pierre, sipho, emma, rahul, carlos, giulia, amira);
        hostRepository.saveAll(hosts);

        Accommodation acc1 = new Accommodation();
        acc1.setName("Amazonia Lodge");
        acc1.setCategory(Category.HOUSE);
        acc1.setHost(maria);
        acc1.setState(State.GOOD);
        acc1.setNumRooms(5);
        acc1.setRented(false);

        Accommodation acc2 = new Accommodation();
        acc2.setName("Parisian Chic Studio");
        acc2.setCategory(Category.FLAT);
        acc2.setHost(pierre);
        acc2.setState(State.GOOD);
        acc2.setNumRooms(1);
        acc2.setRented(true);

        Accommodation acc3 = new Accommodation();
        acc3.setName("Safari View Resort");
        acc3.setCategory(Category.HOTEL);
        acc3.setHost(sipho);
        acc3.setState(State.GOOD);
        acc3.setNumRooms(45);
        acc3.setRented(false);

        Accommodation acc4 = new Accommodation();
        acc4.setName("Kiwi Breeze Motel");
        acc4.setCategory(Category.MOTEL);
        acc4.setHost(emma);
        acc4.setState(State.BAD);
        acc4.setNumRooms(15);
        acc4.setRented(true);

        Accommodation acc5 = new Accommodation();
        acc5.setName("Taj Gateway");
        acc5.setCategory(Category.ROOM);
        acc5.setHost(rahul);
        acc5.setState(State.GOOD);
        acc5.setNumRooms(2);
        acc5.setRented(false);

        Accommodation acc6 = new Accommodation();
        acc6.setName("Cabo Ocean Villa");
        acc6.setCategory(Category.HOUSE);
        acc6.setHost(carlos);
        acc6.setState(State.GOOD);
        acc6.setNumRooms(6);
        acc6.setRented(true);

        Accommodation acc7 = new Accommodation();
        acc7.setName("Roman Holiday Flat");
        acc7.setCategory(Category.APARTMENT);
        acc7.setHost(giulia);
        acc7.setState(State.BAD);
        acc7.setNumRooms(3);
        acc7.setRented(false);

        Accommodation acc8 = new Accommodation();
        acc8.setName("Nile Delta Room");
        acc8.setCategory(Category.ROOM);
        acc8.setHost(amira);
        acc8.setState(State.GOOD);
        acc8.setNumRooms(1);
        acc8.setRented(true);

        List<Accommodation> accommodations = List.of(acc1, acc2, acc3, acc4, acc5, acc6, acc7, acc8);
        accommodationRepository.saveAll(accommodations);
    }
}