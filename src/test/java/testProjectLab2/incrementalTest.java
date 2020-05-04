package testProjectLab2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testProjectLab2.src.Exceptions.ValidatorException;
import testProjectLab2.src.Repository.XMLFileRepository.NotaXMLRepo;
import testProjectLab2.src.Repository.XMLFileRepository.StudentXMLRepo;
import testProjectLab2.src.Repository.XMLFileRepository.TemaLabXMLRepo;
import testProjectLab2.src.Service.XMLFileService.NotaXMLService;
import testProjectLab2.src.Service.XMLFileService.StudentXMLService;
import testProjectLab2.src.Service.XMLFileService.TemaLabXMLService;
import testProjectLab2.src.Validator.NotaValidator;
import testProjectLab2.src.Validator.StudentValidator;
import testProjectLab2.src.Validator.TemaLabValidator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class incrementalTest {
    StudentXMLService service_student;
    TemaLabXMLService service_tema;
    NotaXMLService service_nota;
    StudentXMLRepo studentRepository;
    TemaLabXMLRepo temaRepository;
    NotaXMLRepo notaRepository;

    @Before
    public void initData() {

        StudentValidator studentValidator = new StudentValidator();
        studentRepository = new StudentXMLRepo(studentValidator, "StudentiXML.xml");
        service_student = new StudentXMLService(studentRepository);

        NotaValidator notaValidator = new NotaValidator();
        notaRepository = new NotaXMLRepo(notaValidator, "NotaXML.xml");
        service_nota = new NotaXMLService(notaRepository);

        TemaLabValidator temaLabValidator = new TemaLabValidator();
        temaRepository = new TemaLabXMLRepo(temaLabValidator, "TemaLaboratorXML.xml");
        service_tema = new TemaLabXMLService(temaRepository);

        // add mock data
        String[] params = {"1", "Student_test", "932", "email_test@scs.ro", "prof_1"};
        try {
            service_student.add(params);
        } catch (ValidatorException e) {
            e.printStackTrace();
        }

        String[] params1 = {"1", "tema_test", "2", "2"};
        try {
            service_tema.add(params1);
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }

    }


    @Test
    public void testAddStudentToRepository() {
        int length = studentRepository.getSize();
        String[] params = {"11", "Student_test", "932", "email_test@scs.ro", "prof_1"};
        try {
            service_student.add(params);
        } catch (ValidatorException ex) {
            //System.out.println(ex.getMessage());
            Assert.fail();
        }
        assertTrue(studentRepository.getSize() == length + 1);
        assertEquals(studentRepository.findOne("11").getNume(), "Student_test");
    }


    @Test
    public void testAddAssignmentIntegration() { //all params valid
        int length = studentRepository.getSize();
        String[] params = {"12", "Student_test2", "932", "email_test2@scs.ro", "prof_2"};
        try {
            service_student.add(params);
        } catch (ValidatorException ex) {
            //System.out.println(ex.getMessage());
            Assert.fail();
        }
        assertTrue(studentRepository.getSize() == length + 1);
        assertEquals(studentRepository.findOne("12").getNume(), "Student_test2");
         length = temaRepository.getSize();
        String[] params1 = {"7", "tema_test", "6", "6"};
        try {
            service_tema.add(params1);
        } catch (ValidatorException ex) {
            //System.out.println(ex.getMessage());
            Assert.fail();
        }
        assertTrue(temaRepository.getSize() == length + 1);
        assertEquals(temaRepository.findOne(7).getDescriere(), "tema_test");
    }

    @Test
    public void testAddGradeIntegration() { //all params valid
        int length = studentRepository.getSize();
        String[] params = {"13", "Student_test2", "932", "email_test2@scs.ro", "prof_2"};
        try {
            service_student.add(params);
        } catch (ValidatorException ex) {
            //System.out.println(ex.getMessage());
            Assert.fail();
        }
        assertTrue(studentRepository.getSize() == length + 1);
        assertEquals(studentRepository.findOne("13").getNume(), "Student_test2");
        length = temaRepository.getSize();
        String[] params1 = {"8", "tema_test", "6", "6"};
        try {
            service_tema.add(params1);
        } catch (ValidatorException ex) {
            //System.out.println(ex.getMessage());
            Assert.fail();
        }
        assertTrue(temaRepository.getSize() == length + 1);
        assertEquals(temaRepository.findOne(8).getDescriere(), "tema_test");
        length = notaRepository.getSize();
        String[] params2 = {"1", "13", "8", "7","2001-07-04T12:08:56.235"}; // idNota, idStudent, idTema, valoare, data
        try {
            service_nota.add(params2);
        } catch (ValidatorException ex) {
            //System.out.println(ex.getMessage());
            Assert.fail();
        }
        assertTrue(notaRepository.getSize() == length + 1);
        assertEquals(notaRepository.findOne(1).getValoare(), 7.0, 1e-8 );
    }

}
