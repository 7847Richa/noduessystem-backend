package noduesmanagementsystem_noduesmanagementsystem.warden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardenServiceImpl implements WardenService {

    private final WardenRepository wardenRepository;

    @Autowired
    public WardenServiceImpl(WardenRepository wardenRepository) {
        this.wardenRepository = wardenRepository;
    }

    @Override
    public List<Warden> getAllWardens() {
        return wardenRepository.findAll();
    }

    @Override
    public Warden getWardenByEmail(String email) {
        return wardenRepository.findById(email).orElse(null);
    }

    @Override
    public void saveWarden(Warden warden) {
        wardenRepository.save(warden);
    }

    @Override
    public void updateWarden(Warden warden) {
        wardenRepository.save(warden);
    }

    @Override
    public void deleteWarden(String email) {
        wardenRepository.deleteById(email);
    }
}
