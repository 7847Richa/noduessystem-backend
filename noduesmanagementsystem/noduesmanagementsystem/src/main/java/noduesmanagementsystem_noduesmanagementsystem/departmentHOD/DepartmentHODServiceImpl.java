package noduesmanagementsystem_noduesmanagementsystem.departmentHOD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



	@Service
	public class DepartmentHODServiceImpl implements DepartmentHODService{
	    private DepartmentHODRepository departmentHODRepository;
		

	    @Autowired
	    public DepartmentHODServiceImpl(DepartmentHODRepository departmentHODRepository) {
	        this.departmentHODRepository = departmentHODRepository;
	    }

	    @Override
	    public DepartmentHOD saveDepartmentHOD(DepartmentHOD departmentHOD) {
	        return departmentHODRepository.save(departmentHOD);
	    }

	    @Override
	    public List<DepartmentHOD> getALLDepartmentHOD() {
	        return departmentHODRepository.findAll();
	    }

	    @Override
	    public DepartmentHOD getDepartmentHODById(long registrationid) {
	        return departmentHODRepository.findById(registrationid).orElseThrow(()-> new ResourceNotFoundException("DepartmentHOD not found with registrationid",registrationid," "));
	    }

		@Override
		public DepartmentHOD updateDepartmentHOD(Long registrationid, DepartmentHOD updatedDepartmentHOD) {
		
			return null;
			
		
		}

		@Override
		public DepartmentHOD save(DepartmentHOD departmentHOD) {
			// TODO Auto-generated method stub
			return null;
		}
	}
