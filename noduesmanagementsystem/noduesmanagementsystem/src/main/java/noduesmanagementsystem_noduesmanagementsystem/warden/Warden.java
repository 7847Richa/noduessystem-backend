package noduesmanagementsystem_noduesmanagementsystem.warden;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "wardens")
public class Warden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (columnDefinition = "VARCHAR(255)")

    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String password;
    
    public String getEmail() {
    	return email;
    }

    public  void setEmail(String email) {
    	this.email = email;
    }
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

public String getPassword() {
    return Password();
}

private String Password() {
	
	return password;
}

public void setPassword(String password) {
    this.password = password;
}}