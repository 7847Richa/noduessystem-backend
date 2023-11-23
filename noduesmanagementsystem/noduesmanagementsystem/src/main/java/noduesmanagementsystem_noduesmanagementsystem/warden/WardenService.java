package noduesmanagementsystem_noduesmanagementsystem.warden;

import java.util.List;


public interface WardenService {
    void saveWarden(Warden warden);
    void updateWarden(Warden warden);
    void deleteWarden(String email);
	List<Warden> getAllWardens();
	Warden getWardenByEmail(String email);
}
