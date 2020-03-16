package testProjectLab2.src.Repository.MemoryRepository;

import testProjectLab2.src.Domain.Nota;
import testProjectLab2.src.Validator.IValidator;

public class NotaRepo extends AbstractCrudRepo<Integer,Nota > {
    public NotaRepo(IValidator<Nota> v){ super(v);
    }
}