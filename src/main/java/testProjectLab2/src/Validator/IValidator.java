package testProjectLab2.src.Validator;
import testProjectLab2.src.Exceptions.ValidatorException;

public interface IValidator<E> {
    void validate(E entity) throws ValidatorException;
}