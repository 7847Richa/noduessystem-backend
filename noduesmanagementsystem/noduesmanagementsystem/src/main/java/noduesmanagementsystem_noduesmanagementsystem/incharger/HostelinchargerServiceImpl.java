package noduesmanagementsystem_noduesmanagementsystem.incharger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



	
	
	@Service
	public class HostelinchargerServiceImpl implements HostelinchargerService {
	    private HostelinchargerRepository hostelinchargerRepository;
		

	    @Autowired
	    public HostelinchargerServiceImpl(HostelinchargerRepository hostelinchargerRepository) {
	        this.hostelinchargerRepository = hostelinchargerRepository;
	    }

	    @Override
	    public Hostelincharger saveHostelincharger(Hostelincharger hostelincharger) {
	        return hostelinchargerRepository.save(hostelincharger);
	    }

	    @Override
	    public List<Hostelincharger> getALLHostelincharger() {
	        return hostelinchargerRepository.findAll();
	    }

	    @Override
	    public  Hostelincharger getHostelinchargerById(long registrationid) {
	        return hostelinchargerRepository.findById(registrationid).orElseThrow(()-> new ResourceNotFoundException("Hostelincharger not found with registrationid",registrationid," "));
	    }

		@Override
		public Hostelincharger updateHostelincharger(Long registrationid, Hostelincharger updatedHostelincharger) {
			// TODO Auto-generated method stub
			return null;
			
		}
		
		}

	
