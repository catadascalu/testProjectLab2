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


/**
 * Unit test for simple App.
 */
public class AppTest {

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
    }

    /**
     * Rigorous Test :-)
     * <p>
     * <p>
     * public void shouldAnswerWithTrue()
     * {
     * assertTrue( true );
     * }
     */

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
    public void testAddStudentWithException() {
        int length = studentRepository.getSize();
        String[] params = {"12", "Student_test", "0", "email_test@scs.ro", "prof_1"};
        try {
            service_student.add(params);
            Assert.fail("Grupa invalid\n");
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }

        assertTrue(studentRepository.getSize() == length);
    }

    @Test
    public void testAddStudent_3() {
        int length = studentRepository.getSize();
        String[] params = {"12", "Student_test", "gr", "email_test@scs.ro", "prof_1"};
        try {
            service_student.add(params);
            Assert.fail("Grupa invalid\n");
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }

        assertTrue(studentRepository.getSize() == length);
    }

    @Test
    public void testAddStudent_4() {
        int length = studentRepository.getSize();
        String[] params = {"", "Student_test", "932", "email_test@scs.ro", "prof_1"};
        try {
            service_student.add(params);
            Assert.fail("Id invalid\n");
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }

        assertTrue(studentRepository.getSize() == length);
    }


    @Test
    public void testAddStudent_5() {
        int length = studentRepository.getSize();
        String[] params = {"12", "Student_test", "932", "", "prof_1"};
        try {
            service_student.add(params);
            Assert.fail("Email invalid\n");
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }

        assertTrue(studentRepository.getSize() == length);
    }


    @Test
    public void testAddStudent_6() {
        int length = studentRepository.getSize();
        String[] params = {"12", "Student_test", "932", "email_test@scs.ro", ""};
        try {
            service_student.add(params);
            Assert.fail("Prof invalid\n");
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }

        assertTrue(studentRepository.getSize() == length);
    }

    @Test
    public void testAddStudent_7() { // group = -1
        int length = studentRepository.getSize();
        String[] params = {"12", "Student_test", "-1", "email_test@scs.ro", "prof_1"};
        try {
            service_student.add(params);
            Assert.fail("Grupa invalid\n");
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }

        assertTrue(studentRepository.getSize() == length);
    }

    @Test
    public void testAddStudent_8() { // group = 1
        int length = studentRepository.getSize();
        String[] params = {"12", "Student_test", "1", "email_test@scs.ro", "prof_1"};
        try {
            service_student.add(params);
        } catch (ValidatorException ex) {
            //System.out.println(ex.getMessage());
            Assert.fail();
        }
        assertTrue(studentRepository.getSize() == length + 1);
        assertEquals(studentRepository.findOne("12").getNume(), "Student_test");
    }

    @Test
    public void testAddStudent_9() { // id = 1
        int length = studentRepository.getSize();
        String[] params = {"1", "Student_test", "932", "email_test@scs.ro", "prof_1"};
        try {
            service_student.add(params);
        } catch (ValidatorException ex) {
            //System.out.println(ex.getMessage());
            Assert.fail();
        }
        assertTrue(studentRepository.getSize() == length + 1);
        assertEquals(studentRepository.findOne("1").getNume(), "Student_test");
    }

    @Test
    public void testAddStudent_10() { // email = e
        int length = studentRepository.getSize();
        String[] params = {"12", "Student_test", "932", "e", "prof_1"};
        try {
            service_student.add(params);
        } catch (ValidatorException ex) {
            //System.out.println(ex.getMessage());
            Assert.fail();
        }
        assertTrue(studentRepository.getSize() == length + 1);
        assertEquals(studentRepository.findOne("12").getNume(), "Student_test");
    }

    @Test
    public void testAddStudent_11() { // prof = p
        int length = studentRepository.getSize();
        String[] params = {"12", "Student_test", "932", "email_test@scs.ro", "p"};
        try {
            service_student.add(params);
        } catch (ValidatorException ex) {
            //System.out.println(ex.getMessage());
            Assert.fail();
        }
        assertTrue(studentRepository.getSize() == length + 1);
        assertEquals(studentRepository.findOne("12").getNume(), "Student_test");
    }


    @Test
    public void testAddAssignmentIdValid() { //all params valid
        int length = temaRepository.getSize();
        String[] params = {"11", "tema_test", "6", "6"};
        try {
            service_tema.add(params);
        } catch (ValidatorException ex) {
            //System.out.println(ex.getMessage());
            Assert.fail();
        }
        assertTrue(temaRepository.getSize() == length + 1);
        assertEquals(temaRepository.findOne(11).getDescriere(), "tema_test");
    }

    @Test
    public void testAddAssignmentIdNotValid() { //id = ""
        int length = temaRepository.getSize();
        String[] params = {"", "tema_noId", "5", "5"};
        try {
            service_tema.add(params);
            Assert.fail("Nr tema invalid\n");
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }

        assertTrue(temaRepository.getSize() == length);
    }

    @Test
    public void testAddAssignmentIdNotValid_3() { //id = null
        int length = temaRepository.getSize();
        String[] params = {null, "tema_noId", "5", "5"};
        try {
            service_tema.add(params);
            Assert.fail("Nr tema invalid\n");
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }

        assertTrue(temaRepository.getSize() == length);
    }

    @Test
    public void testAddAssignmentDescriptionNotValid_4() { //description = ""
        int length = temaRepository.getSize();
        String[] params = {"13", "", "5", "5"};
        try {
            service_tema.add(params);
            Assert.fail("Descriere tema invalida\n");
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }

        assertTrue(temaRepository.getSize() == length);
    }

    @Test
    public void testAddAssignmentDescriptionNotValid_5() { //description = null
        int length = temaRepository.getSize();
        String[] params = {"13", null, "5", "5"};
        try {
            service_tema.add(params);
            Assert.fail("Descriere tema invalida\n");
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }

        assertTrue(temaRepository.getSize() == length);
    }

    @Test
    public void testAddAssignmentWeekNotValid_6(){ //saptamanaPredarii = 0
        int length = temaRepository.getSize();
        String[] params = {"14", "tema_lab_sapt", "6", "0"};
        try{
            service_tema.add(params);
            Assert.fail("Saptamana predarii invalida\n");
        }
        catch(ValidatorException ex){
            System.out.println(ex.getMessage());
        }

        assertTrue(temaRepository.getSize() == length);
    }

    @Test
    public void testAddAssignmentWeekNotValid2_7(){ //saptamanaPredarii = 15
        int length = temaRepository.getSize();
        String[] params = {"14", "tema_lab_sapt", "6", "15"};
        try{
            service_tema.add(params);
            Assert.fail("Saptamana predarii invalida\n");
        }
        catch(ValidatorException ex){
            System.out.println(ex.getMessage());
        }

        assertTrue(temaRepository.getSize() == length);
    }

    @Test
    public void testAddAssignmentDeadlineNotValid_8(){ //termenLimita = 0
        int length = temaRepository.getSize();
        String[] params = {"14", "tema_lab_deadline", "0", "5"};
        try{
            service_tema.add(params);
            Assert.fail("Termen limita invalid\n");
        }
        catch(ValidatorException ex){
            System.out.println(ex.getMessage());
        }

        assertTrue(temaRepository.getSize() == length);
    }

    @Test
    public void testAddAssignmentDeadlineNotValid2_9(){ //termenLimita = 15
        int length = temaRepository.getSize();
        String[] params = {"14", "tema_lab_deadline", "15", "5"};
        try{
            service_tema.add(params);
            Assert.fail("Termen limita invalid\n");
        }
        catch(ValidatorException ex){
            System.out.println(ex.getMessage());
        }

        assertTrue(temaRepository.getSize() == length);
    }
}
