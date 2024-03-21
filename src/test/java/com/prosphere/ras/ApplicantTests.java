package com.prosphere.ras;
import com.prosphere.ras.models.*;
import com.prosphere.ras.services.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.*;

public class ApplicantTests {
    @Test
    public void testApplicant() {
        Applicant Applicant = new Applicant("Александр", "Сергеевич", "Пушкин", "Арбат", 53, 100);
        Assertions.assertEquals(Applicant.getFirstName(), "Александр");
        Assertions.assertEquals(Applicant.getMiddleName(), "Сергеевич");
        Assertions.assertEquals(Applicant.getLastName(), "Пушкин");
        Assertions.assertEquals(Applicant.getStreet(), "Арбат");
        Assertions.assertEquals(Applicant.getBuilding(), 53);
        Assertions.assertEquals(Applicant.getApartment(), 100);
        Assertions.assertEquals(Applicant.getSoughtPost(), null);
        Assertions.assertEquals(Applicant.getSoughtSalary(), null);
    }

    @Test
    public void testFindById() {
        ApplicantService ApplicantService = new ApplicantService();
        Applicant Applicant = ApplicantService.findById(1);
        Assertions.assertEquals(Applicant.getId(), 1);
    }

    @Test
    public void testFindAll() {
        ApplicantService ApplicantService = new ApplicantService();
        List<Applicant> Applicant = ApplicantService.findAll();
        Assertions.assertEquals(Applicant.size(), 10);
        Assertions.assertEquals(Applicant.get(0).getId(), 1);
        Assertions.assertEquals(Applicant.get(1).getId(), 2);
        Assertions.assertEquals(Applicant.get(2).getId(), 3);
        Assertions.assertEquals(Applicant.get(3).getId(), 4);
        Assertions.assertEquals(Applicant.get(4).getId(), 5);
        Assertions.assertEquals(Applicant.get(5).getId(), 6);
        Assertions.assertEquals(Applicant.get(6).getId(), 7);
        Assertions.assertEquals(Applicant.get(7).getId(), 8);
        Assertions.assertEquals(Applicant.get(8).getId(), 9);
        Assertions.assertEquals(Applicant.get(9).getId(), 10);
    }
    
    @Test
    public void testSaveUpdateDelete() {
        // Save
        ApplicantService ApplicantService = new ApplicantService();
        Applicant Applicant_1 = new Applicant("Александр", "Сергеевич", "Пушкин", "Арбат", 53, 100);
        ApplicantService.save(Applicant_1);
        Applicant Applicant_2 = ApplicantService.findById(Applicant_1.getId());
        Assertions.assertEquals(Applicant_1, Applicant_2);

        // Update
        Applicant_1.setFirstName("Николай");
        ApplicantService.update(Applicant_1);
        Applicant_2 = ApplicantService.findById(Applicant_1.getId());
        Assertions.assertEquals(Applicant_1.getFirstName(), Applicant_2.getFirstName());

        // Delete
        ApplicantService.delete(Applicant_1);
        Applicant_2 = ApplicantService.findById(Applicant_1.getId());
        Assertions.assertEquals(null, Applicant_2);
    }

    @Test
    public void testDeleteById() {
        // Save
        ApplicantService ApplicantService = new ApplicantService();
        Applicant Applicant_1 = new Applicant("Александр", "Сергеевич", "Пушкин", "Арбат", 53, 100);
        ApplicantService.save(Applicant_1);
        Applicant Applicant_2 = ApplicantService.findById(Applicant_1.getId());
        Assertions.assertEquals(Applicant_1, Applicant_2);

        // DeleteById
        ApplicantService.deleteById(Applicant_1.getId());
        Applicant_2 = ApplicantService.findById(Applicant_1.getId());
        Assertions.assertEquals(null, Applicant_2);
    }

    @Test
    public void testFindEducation() {
        ApplicantService ApplicantService = new ApplicantService();
        Applicant Applicant = ApplicantService.findById(2);
        List<Education> Education = ApplicantService.findEducation(Applicant);
        Assertions.assertEquals(Education.size(), 2);
        Assertions.assertEquals(Education.get(0).getApplicant().getId(), 2);
        Assertions.assertEquals(Education.get(1).getApplicant().getId(), 2);
        Assertions.assertEquals(Education.get(0).getUniversity().getId(), 2);
        Assertions.assertEquals(Education.get(1).getUniversity().getId(), 3);
        Assertions.assertEquals(Education.get(0).getSpeciality().getId(), 4);
        Assertions.assertEquals(Education.get(1).getSpeciality().getId(), 7);
    }

    @Test
    public void testFindWorkhistory() {
        ApplicantService ApplicantService = new ApplicantService();
        Applicant Applicant = ApplicantService.findById(1);
        List<Workhistory> Workhistory = ApplicantService.findWorkhistory(Applicant);
        Assertions.assertEquals(Workhistory.size(), 2);
        Assertions.assertEquals(Workhistory.get(0).getApplicant().getId(), 1);
        Assertions.assertEquals(Workhistory.get(1).getApplicant().getId(), 1);
        Assertions.assertEquals(Workhistory.get(0).getCompany().getId(), 4);
        Assertions.assertEquals(Workhistory.get(1).getCompany().getId(), 2);
        Assertions.assertEquals(Workhistory.get(0).getPosition().getId(), 7);
        Assertions.assertEquals(Workhistory.get(1).getPosition().getId(), 1);
    }

    @Test
    public void testfindSuitableVacancy() {
        ApplicantService ApplicantService = new ApplicantService();
        Applicant Applicant = ApplicantService.findById(1);
        List<Vacancy> Vacancy = ApplicantService.findSuitableVacancy(Applicant);
        Assertions.assertEquals(Vacancy.size(), 2);
        Assertions.assertEquals(Vacancy.get(0).getCompany().getId(), 1);
        Assertions.assertEquals(Vacancy.get(1).getCompany().getId(), 4);
        Assertions.assertEquals(Vacancy.get(0).getPosition().getId(), 1);
        Assertions.assertEquals(Vacancy.get(1).getPosition().getId(), 1);
    }

    @Test
    public void testfilter() {
        SpecialityService SpecialityService = new SpecialityService();
        CompanyService CompanyService = new CompanyService();
        PositionService PositionService = new PositionService();
        ApplicantService ApplicantService = new ApplicantService();

        List<Speciality> Speciality = new ArrayList<>();
        Speciality.add(SpecialityService.findById(1));
        Speciality.add(SpecialityService.findById(2));

        List<Company> Company = new ArrayList<>();
        Company.add(CompanyService.findById(1));
        Company.add(CompanyService.findById(2));

        List<Position> Position = new ArrayList<>();
        Position.add(PositionService.findById(1));
        Position.add(PositionService.findById(2));

        // No filter
        List<Applicant> Applicant = ApplicantService.filter(null, null, null, null, null);
        Assertions.assertEquals(Applicant.size(), 10);

        // Speciality
        Applicant = ApplicantService.filter(Speciality, null, null, null, null);
        Assertions.assertEquals(Applicant.size(), 3);
        Assertions.assertEquals(Applicant.get(0).getId(), 5);
        Assertions.assertEquals(Applicant.get(1).getId(), 6);
        Assertions.assertEquals(Applicant.get(2).getId(), 7);


        // Company
        Applicant = ApplicantService.filter(null, Company, null, null, null);
        Assertions.assertEquals(Applicant.size(), 8);
        Assertions.assertEquals(Applicant.get(0).getId(), 5);
        Assertions.assertEquals(Applicant.get(1).getId(), 10);
        Assertions.assertEquals(Applicant.get(2).getId(), 1);
        Assertions.assertEquals(Applicant.get(3).getId(), 2);
        Assertions.assertEquals(Applicant.get(4).getId(), 3);
        Assertions.assertEquals(Applicant.get(5).getId(), 9);
        Assertions.assertEquals(Applicant.get(6).getId(), 6);
        Assertions.assertEquals(Applicant.get(7).getId(), 4);

        // Position
        Applicant = ApplicantService.filter(null, null, Position, null, null);
        Assertions.assertEquals(Applicant.size(), 5);
        Assertions.assertEquals(Applicant.get(0).getId(), 1);
        Assertions.assertEquals(Applicant.get(1).getId(), 2);
        Assertions.assertEquals(Applicant.get(2).getId(), 3);
        Assertions.assertEquals(Applicant.get(3).getId(), 4);
        Assertions.assertEquals(Applicant.get(4).getId(), 10);

        // Salary
        Applicant = ApplicantService.filter(null, null, null, 100000, 120000);
        Assertions.assertEquals(Applicant.size(), 5);
        Assertions.assertEquals(Applicant.get(0).getId(), 10);
        Assertions.assertEquals(Applicant.get(1).getId(), 8);
        Assertions.assertEquals(Applicant.get(2).getId(), 1);
        Assertions.assertEquals(Applicant.get(3).getId(), 4);
        Assertions.assertEquals(Applicant.get(4).getId(), 2);
    }
}