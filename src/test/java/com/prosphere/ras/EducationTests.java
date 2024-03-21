package com.prosphere.ras;
import com.prosphere.ras.models.*;
import com.prosphere.ras.services.*;
import org.junit.jupiter.api.*;
import java.util.List;

public class EducationTests {
    private ApplicantService ApplicantService = new ApplicantService();
    private UniversityService  UniversityService = new UniversityService();
    private SpecialityService SpecialityService = new SpecialityService();
    private EducationService EducationService = new EducationService();
    private Applicant Applicant = ApplicantService.findById(1);
    private University University =  UniversityService.findById(1);
    private Speciality Speciality = SpecialityService.findById(4);

    @Test
    public void testEducation() {
        Education Education = new Education(Applicant, University, Speciality);
        Assertions.assertEquals(Education.getApplicant(), Applicant);
        Assertions.assertEquals(Education.getUniversity(), University);
        Assertions.assertEquals(Education.getSpeciality(), Speciality);
    }

    @Test
    public void testFindByObj() {
        Education Education = EducationService.findByObj(Applicant, University, Speciality);
        Assertions.assertEquals(Education.getApplicant(), Applicant);
        Assertions.assertEquals(Education.getUniversity(), University);
        Assertions.assertEquals(Education.getSpeciality(), Speciality);
    }

    @Test
    public void testFindAll() {
        List<Education> Education = EducationService.findAll();
        Assertions.assertEquals(Education.size(), 17);
        Assertions.assertEquals(Education.get(0).getUniversity(), UniversityService.findById(1));
        Assertions.assertEquals(Education.get(1).getUniversity(), UniversityService.findById(2));
        Assertions.assertEquals(Education.get(2).getUniversity(), UniversityService.findById(3));
        Assertions.assertEquals(Education.get(3).getUniversity(), UniversityService.findById(3));
        Assertions.assertEquals(Education.get(4).getUniversity(), UniversityService.findById(3));
        Assertions.assertEquals(Education.get(5).getUniversity(), UniversityService.findById(2));
        Assertions.assertEquals(Education.get(6).getUniversity(), UniversityService.findById(1));
        Assertions.assertEquals(Education.get(7).getUniversity(), UniversityService.findById(3));
        Assertions.assertEquals(Education.get(8).getUniversity(), UniversityService.findById(1));
        Assertions.assertEquals(Education.get(9).getUniversity(), UniversityService.findById(3));
        Assertions.assertEquals(Education.get(10).getUniversity(), UniversityService.findById(3));
        Assertions.assertEquals(Education.get(11).getUniversity(), UniversityService.findById(1));
        Assertions.assertEquals(Education.get(12).getUniversity(), UniversityService.findById(3));
        Assertions.assertEquals(Education.get(13).getUniversity(), UniversityService.findById(3));
        Assertions.assertEquals(Education.get(14).getUniversity(), UniversityService.findById(3));
        Assertions.assertEquals(Education.get(15).getUniversity(), UniversityService.findById(1));
        Assertions.assertEquals(Education.get(16).getUniversity(), UniversityService.findById(2));
        Assertions.assertEquals(Education.get(0).getSpeciality(), SpecialityService.findById(4));
        Assertions.assertEquals(Education.get(1).getSpeciality(), SpecialityService.findById(4));
        Assertions.assertEquals(Education.get(2).getSpeciality(), SpecialityService.findById(7));
        Assertions.assertEquals(Education.get(3).getSpeciality(), SpecialityService.findById(5));
        Assertions.assertEquals(Education.get(4).getSpeciality(), SpecialityService.findById(5));
        Assertions.assertEquals(Education.get(5).getSpeciality(), SpecialityService.findById(4));
        Assertions.assertEquals(Education.get(6).getSpeciality(), SpecialityService.findById(5));
        Assertions.assertEquals(Education.get(7).getSpeciality(), SpecialityService.findById(1));
        Assertions.assertEquals(Education.get(8).getSpeciality(), SpecialityService.findById(2));
        Assertions.assertEquals(Education.get(9).getSpeciality(), SpecialityService.findById(2));
        Assertions.assertEquals(Education.get(10).getSpeciality(), SpecialityService.findById(2));
        Assertions.assertEquals(Education.get(11).getSpeciality(), SpecialityService.findById(5));
        Assertions.assertEquals(Education.get(12).getSpeciality(), SpecialityService.findById(5));
        Assertions.assertEquals(Education.get(13).getSpeciality(), SpecialityService.findById(3));
        Assertions.assertEquals(Education.get(14).getSpeciality(), SpecialityService.findById(6));
        Assertions.assertEquals(Education.get(15).getSpeciality(), SpecialityService.findById(4));
        Assertions.assertEquals(Education.get(16).getSpeciality(), SpecialityService.findById(4));
        Assertions.assertEquals(Education.get(0).getApplicant(), ApplicantService.findById(1));
        Assertions.assertEquals(Education.get(1).getApplicant(), ApplicantService.findById(2));
        Assertions.assertEquals(Education.get(2).getApplicant(), ApplicantService.findById(2));
        Assertions.assertEquals(Education.get(3).getApplicant(), ApplicantService.findById(3));
        Assertions.assertEquals(Education.get(4).getApplicant(), ApplicantService.findById(4));
        Assertions.assertEquals(Education.get(5).getApplicant(), ApplicantService.findById(4));
        Assertions.assertEquals(Education.get(6).getApplicant(), ApplicantService.findById(5));
        Assertions.assertEquals(Education.get(7).getApplicant(), ApplicantService.findById(5));
        Assertions.assertEquals(Education.get(8).getApplicant(), ApplicantService.findById(6));
        Assertions.assertEquals(Education.get(9).getApplicant(), ApplicantService.findById(6));
        Assertions.assertEquals(Education.get(10).getApplicant(), ApplicantService.findById(7));
        Assertions.assertEquals(Education.get(11).getApplicant(), ApplicantService.findById(8));
        Assertions.assertEquals(Education.get(12).getApplicant(), ApplicantService.findById(8));
        Assertions.assertEquals(Education.get(13).getApplicant(), ApplicantService.findById(9));
        Assertions.assertEquals(Education.get(14).getApplicant(), ApplicantService.findById(9));
        Assertions.assertEquals(Education.get(15).getApplicant(), ApplicantService.findById(10));
        Assertions.assertEquals(Education.get(16).getApplicant(), ApplicantService.findById(10));
    }

    @Test
    public void testSaveUpdateDelete() {
        // Save
        Speciality = SpecialityService.findById(1);
        Education Education_1 = new Education(Applicant, University, Speciality);
        EducationService.update(Education_1);     // так как detached entity passed to persist
        Education Education_2 = EducationService.findByObj(Applicant, University, Speciality);
        Assertions.assertEquals(Education_1, Education_2);

        // Update
        Speciality = SpecialityService.findById(2);
        EducationService.delete(Education_1);
        Education_1.setSpeciality(Speciality);
        EducationService.update(Education_1);
        Education_2 = EducationService.findByObj(Applicant, University, Speciality);
        Assertions.assertEquals(Education_1, Education_2);

        // Delete
        EducationService.delete(Education_1);
        Education_2 = EducationService.findByObj(Applicant, University, Speciality);
        Assertions.assertEquals(null, Education_2);

        EducationService.update(null);
        EducationService.delete(null);
    }

    @Test
    public void testDeleteByObj() {
        // Save
        Speciality = SpecialityService.findById(1);
        Education Education_1 = new Education(Applicant, University, Speciality);
        EducationService.update(Education_1);     // так как detached entity passed to persist
        Education Education_2 = EducationService.findByObj(Applicant, University, Speciality);
        Assertions.assertEquals(Education_1, Education_2);

        // DeleteById
        EducationService.deleteByObj(Applicant, University, Speciality);
        Education_2 = EducationService.findByObj(Applicant, University, Speciality);
        Assertions.assertEquals(null, Education_2);

        EducationService.deleteByObj(Applicant, University, Speciality);
    }
}