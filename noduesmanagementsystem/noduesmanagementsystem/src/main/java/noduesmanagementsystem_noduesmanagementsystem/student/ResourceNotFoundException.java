package noduesmanagementsystem_noduesmanagementsystem.student;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String resourceName;
    private Long fieldName;
    private String fieldValue;
    public ResourceNotFoundException(String resourceName,Long fieldName, String fieldValue ) {
        super(String.format("%s not found with %s : %s invalid ",resourceName, fieldName ,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
   
	
	public ResourceNotFoundException(String resourceName2, String emailid, String fieldValue2) {
		// TODO Auto-generated constructor stub
	}
	public String getResourceName() {
        return resourceName;
    }
    public Long getFieldName() {
        return fieldName;
    }
    public String getFieldValue() {
        return fieldValue;
    }
} 

