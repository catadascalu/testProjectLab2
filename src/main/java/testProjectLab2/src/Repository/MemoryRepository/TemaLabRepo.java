package testProjectLab2.src.Repository.MemoryRepository;

import testProjectLab2.src.Domain.TemaLab;
import testProjectLab2.src.Validator.IValidator;

public class TemaLabRepo extends AbstractCrudRepo<Integer,TemaLab> {

    public TemaLabRepo(IValidator<TemaLab> v){

        super(v);
    }

    public void prelungireTermenLimita(TemaLab t,int saptCurenta){
        if(saptCurenta<=t.getSaptamanaPredarii()){
            t.setTermenLimita(t.getTermenLimita()+1);
            update(t);
        }
    }

}