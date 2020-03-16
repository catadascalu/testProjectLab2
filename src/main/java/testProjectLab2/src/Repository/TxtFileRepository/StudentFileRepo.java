package testProjectLab2.src.Repository.TxtFileRepository;

import testProjectLab2.src.Domain.HasId;
import testProjectLab2.src.Domain.Student;
import testProjectLab2.src.Validator.StudentValidator;

import java.io.IOException;

public class StudentFileRepo extends AbstractFileRepository {
    public StudentFileRepo(String filename, StudentValidator val) throws IOException {
        super(val, filename);
    }


    @Override
    public HasId extractEntity(String[] info) {
        String id = info[0];
        String nume = info[1];
        int grup = Integer.parseInt(info[2]);
        String email = info[3];
        String indrumator = info[4];
        Student s = new Student(id, nume, grup, email, indrumator);
        return s;

    }
}