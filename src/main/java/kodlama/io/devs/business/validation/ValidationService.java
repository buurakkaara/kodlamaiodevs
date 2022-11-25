package kodlama.io.devs.business.validation;

public interface ValidationService{

	void validateNameIfEmpty(String name) throws Exception ;

	void validateNameIfExist(String name) throws Exception ;

	void validateIdIfExist(int id) throws Exception ;

	void validateIdIfNotExist(int id) throws Exception ;

	
}
