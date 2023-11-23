package noduesmanagementsystem_noduesmanagementsystem.departmentHOD;

import java.util.List;


public interface DepartmentHODService {
public static final DepartmentHODRepository departmentHODRepository = null;
    

    public default List<DepartmentHOD> getAllDepartmentHODs() {
        return departmentHODRepository.findAll();
    }

    public default DepartmentHOD getDepartmentHODById(Long registrationid) {
        return departmentHODRepository.findById(registrationid)
                .orElseThrow();
    }

    public default DepartmentHOD createDepartmentHOD(DepartmentHOD departmentHOD) {
        return departmentHODRepository.save(departmentHOD);
    }

    public default void deleteDepartmentHOD(Long registrationid) {
    	departmentHODRepository.deleteById(registrationid);
    }

	DepartmentHOD saveDepartmentHOD(DepartmentHOD departmentHOD);

	List<DepartmentHOD> getALLDepartmentHOD();

	DepartmentHOD getDepartmentHODById(long registrationid);

	DepartmentHOD updateDepartmentHOD(Long registrationid, DepartmentHOD updatedDepartmentHOD);

	DepartmentHOD save(DepartmentHOD departmentHOD);

}
