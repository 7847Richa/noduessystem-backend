package noduesmanagementsystem_noduesmanagementsystem.incharger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	
	@Entity
	@Table(name = "Hostelinchargers")
	public class Hostelincharger {
		
		@Column(name = "registrationid", insertable = false, updatable = false)
	    private long Registrationid;
	   
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public  void setEmail(String email) {
			this.email = email;
		}
		
		public String getPassword() {
	        return Password();
	    }


		private String Password() {
			// TODO Auto-generated method stub
			return password;
		}

		public void setPassword(String password) {
	        this.password = password;
		}
	    
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long registrationid;

	    @Column(name = "first_name", nullable = false)
	    private String firstName;

	    @Column(name = "last_name", nullable = false)
	    private String lastName;

	    @Column(name = "email")
	    private String email;
	    
	    @Column(length = 15, nullable = false)
	    private String password;

		@Override
		public String toString() {
			return "Hostelincharger [registrationid=" + registrationid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ " \", password='\" + password + '\\'' + ]";
		}

			public long getRegistrationid() {
			return Registrationid;
		}

		public void setRegestrationid(long registrationid) {
			Registrationid = registrationid;

			
		}}



