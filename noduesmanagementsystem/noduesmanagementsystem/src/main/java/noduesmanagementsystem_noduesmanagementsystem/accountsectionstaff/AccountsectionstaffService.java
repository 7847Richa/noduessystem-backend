package noduesmanagementsystem_noduesmanagementsystem.accountsectionstaff;

import java.util.List;
public interface AccountsectionstaffService {
	
	
	public static final AccountsectionstaffRepository accountsectionstaffRepository = null;
    

    public default List<Accountsectionstaff> getAllAccountsectionstaffs() {
        return accountsectionstaffRepository.findAll();
    }

    public default Accountsectionstaff getAccountsectionstaffById(Long registrationid) {
        return accountsectionstaffRepository.findById(registrationid)
                .orElseThrow();
    }

    public default Accountsectionstaff createAccountsectionstaff(Accountsectionstaff accountsectionstaff) {
        return accountsectionstaffRepository.save(accountsectionstaff);
    }

    public default void deleteAccountsectionstaff(Long registrationid) {
    	accountsectionstaffRepository.deleteById(registrationid);
    }

	Accountsectionstaff save(Accountsectionstaff accountsectionstaff);

	Accountsectionstaff updateAccountsectionstaff(Long registrationid, Accountsectionstaff updatedAccountsectionstaff);

	Accountsectionstaff getAccountsectionstaffById(long registrationid);

	List<Accountsectionstaff> getALLAccountsectionstaff();

	Accountsectionstaff saveAccountsectionstaff(Accountsectionstaff accountsectionstaff);


}

	


