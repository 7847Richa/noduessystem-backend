package noduesmanagementsystem_noduesmanagementsystem.incharger;

import java.util.List;


public interface HostelinchargerService {
	
	public static final HostelinchargerRepository hostelinchargerRepository = null;
    

    public default List<Hostelincharger> getAllHostelinchargers() {
        return hostelinchargerRepository.findAll();
    }

    public default Hostelincharger getHostelinchargerById(Long registrationid) {
        return hostelinchargerRepository.findById(registrationid)
                .orElseThrow();
    }

    public default Hostelincharger createHostelincharger(Hostelincharger hostelincharger) {
        return hostelinchargerRepository.save(hostelincharger);
    }

    public default void deleteHostelincharger(Long registrationid) {
    	hostelinchargerRepository.deleteById(registrationid);
    }

	Hostelincharger saveHostelincharger(Hostelincharger hostelincharger);

	List<Hostelincharger> getALLHostelincharger();

	Hostelincharger getHostelinchargerById(long registrationid);

	Hostelincharger updateHostelincharger(Long registrationid, Hostelincharger updatedHostelincharger);


}
