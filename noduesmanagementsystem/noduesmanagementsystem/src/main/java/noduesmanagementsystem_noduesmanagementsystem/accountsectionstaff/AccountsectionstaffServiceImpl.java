package noduesmanagementsystem_noduesmanagementsystem.accountsectionstaff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



public class AccountsectionstaffServiceImpl implements AccountsectionstaffService {
	    
		private AccountsectionstaffRepository accountsectionstaffRepository;
		

	    @Autowired
	    public AccountsectionstaffServiceImpl(AccountsectionstaffRepository accountsectionstaffRepository) {
	        this.accountsectionstaffRepository = accountsectionstaffRepository;
	    }

	    @Override
	    public Accountsectionstaff saveAccountsectionstaff(Accountsectionstaff accountsectionstaff) {
	        return accountsectionstaffRepository.save(accountsectionstaff);
	    }

	    @Override
	    public List<Accountsectionstaff> getALLAccountsectionstaff() {
	        return accountsectionstaffRepository.findAll();
	    }

	    @Override
	    public  Accountsectionstaff getAccountsectionstaffById(long registrationid) {
	        return accountsectionstaffRepository.findById(registrationid).orElseThrow(()-> new ResourceNotFoundException("student not found with registrationid",registrationid," "));
	    }

		@Override
		public Accountsectionstaff updateAccountsectionstaff(Long registrationid, Accountsectionstaff updatedAccountsectionstaff) {
			// TODO Auto-generated method stub
			return null;
			
		
		}

		@Override
		public Accountsectionstaff save(Accountsectionstaff accountsectionstaff) {
			// TODO Auto-generated method stub
			return null;
		}
		}

		