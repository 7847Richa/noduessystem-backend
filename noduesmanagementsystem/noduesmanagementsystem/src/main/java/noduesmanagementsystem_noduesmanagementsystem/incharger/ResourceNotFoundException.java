package noduesmanagementsystem_noduesmanagementsystem.incharger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException {
    private static final long serialVersionUID=1L;
    private String resourceName;
    private long fieldName;
    private String fieldValue;
    public ResourceNotFoundException(String resourceName,long fieldName , String fieldValue) {
        super(String.format("%s not found with %s : %s invalid ",resourceName, fieldName ,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
    public ResourceNotFoundException(String resourceName, long fieldName) {
		// TODO Auto-generated constructor stub
	}
	public ResourceNotFoundException(String fieldValue) {
		// TODO Auto-generated constructor stub
	}
	
	public String getResourceName() {
        return resourceName;
    }
    public long getFieldName() {
        return fieldName;
    }
    public String getFieldValue() {
        return fieldValue;
    

    }

}
