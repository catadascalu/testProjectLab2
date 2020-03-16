package testProjectLab2.src.Repository.MemoryRepository;

import testProjectLab2.src.Domain.Student;
import testProjectLab2.src.Validator.IValidator;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v){ super(v);
    }
}