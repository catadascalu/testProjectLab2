package testProjectLab2.src.Repository.MemoryRepository;

import testProjectLab2.src.Domain.HasId;
import testProjectLab2.src.Exceptions.ValidatorException;
import testProjectLab2.src.Repository.Repo;
import testProjectLab2.src.Validator.IValidator;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCrudRepo<ID,E extends HasId<ID>> implements Repo<ID,E> {
    Map<ID,E> entityes;
    IValidator<E> validator;
    public AbstractCrudRepo(IValidator v){
        entityes=new HashMap<ID,E>();
        validator=v;
    }
    @Override
    public E findOne(ID id){
        if (entityes.get(id)==null){
            return null;
        }else{
            if(id==null){
                throw new IllegalArgumentException();
            }else{
                return entityes.get(id);
            }
        }

    }

    @Override
    public Iterable<E> findAll(){
        return entityes.values();
    }
    @Override
    public E save(E entity) throws ValidatorException {
        if(entity==null){
            throw new IllegalArgumentException("Entity can not be null!\n");
        }
        try{
            validator.validate(entity);
            return entityes.putIfAbsent(entity.getId(),entity);
        }catch(ValidatorException ex){
            throw new ValidatorException(ex.getMessage());
        }
    }
    @Override
    public E delete(ID id){
        return entityes.remove(id);
    }
    @Override
    public E update(E entity) {
        try {
            if (entity == null) {
                throw new IllegalArgumentException("Entity can not be null!\n");
            } else {
                validator.validate(entity);
                return entityes.replace(entity.getId(), entity);
            }
        }catch(ValidatorException e){
            return null;
        }
    }
    //@Override
    public long size(){
        return entityes.size();
    }

}