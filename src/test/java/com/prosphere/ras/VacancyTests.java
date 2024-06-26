package com.prosphere.ras;
import java.util.List;
import org.junit.jupiter.api.*;
import com.prosphere.ras.models.*;
import com.prosphere.ras.services.*;

public class VacancyTests {
    private CompanyService CompanyService = new CompanyService();
    private PositionService PositionService = new PositionService();
    private SpecialityService SpecialityService = new SpecialityService();
    private VacancyService VacancyService = new VacancyService();

    @Test
    public void testVacancy() {
        Company Company =  CompanyService.findById(1);
        Position Position = PositionService.findById(2);
        Speciality Speciality = SpecialityService.findById(1);
        Vacancy Vacancy = new Vacancy(Company, Position, 100000, Speciality, 1);
        Assertions.assertEquals(Vacancy.getCompany(), Company);
        Assertions.assertEquals(Vacancy.getPosition(), Position);
        Assertions.assertEquals(Vacancy.getSalary(), 100000);
        Assertions.assertEquals(Vacancy.getReqSpec(), Speciality);
        Assertions.assertEquals(Vacancy.getReqExp(), 1);
    }

    @Test
    public void testFindByObj() {
        Vacancy Vacancy = VacancyService.findByObj(1, 1);
        Assertions.assertEquals(Vacancy.getCompany().getId(), 1);
        Assertions.assertEquals(Vacancy.getPosition().getId(), 1);
    }

    @Test
    public void testFindAll() {
        List<Vacancy> Vacancy = VacancyService.findAll();
        Assertions.assertEquals(Vacancy.size(), 20);
        Assertions.assertEquals(Vacancy.get(0).getCompany(), CompanyService.findById(1));
        Assertions.assertEquals(Vacancy.get(1).getCompany(), CompanyService.findById(1));
        Assertions.assertEquals(Vacancy.get(2).getCompany(), CompanyService.findById(1));
        Assertions.assertEquals(Vacancy.get(3).getCompany(), CompanyService.findById(1));
        Assertions.assertEquals(Vacancy.get(4).getCompany(), CompanyService.findById(1));
        Assertions.assertEquals(Vacancy.get(5).getCompany(), CompanyService.findById(2));
        Assertions.assertEquals(Vacancy.get(6).getCompany(), CompanyService.findById(2));
        Assertions.assertEquals(Vacancy.get(7).getCompany(), CompanyService.findById(2));
        Assertions.assertEquals(Vacancy.get(8).getCompany(), CompanyService.findById(2));
        Assertions.assertEquals(Vacancy.get(9).getCompany(), CompanyService.findById(2));
        Assertions.assertEquals(Vacancy.get(10).getCompany(), CompanyService.findById(2));
        Assertions.assertEquals(Vacancy.get(11).getCompany(), CompanyService.findById(2));
        Assertions.assertEquals(Vacancy.get(12).getCompany(), CompanyService.findById(3));
        Assertions.assertEquals(Vacancy.get(13).getCompany(), CompanyService.findById(3));
        Assertions.assertEquals(Vacancy.get(14).getCompany(), CompanyService.findById(3));
        Assertions.assertEquals(Vacancy.get(15).getCompany(), CompanyService.findById(4));
        Assertions.assertEquals(Vacancy.get(16).getCompany(), CompanyService.findById(4));
        Assertions.assertEquals(Vacancy.get(17).getCompany(), CompanyService.findById(4));
        Assertions.assertEquals(Vacancy.get(18).getCompany(), CompanyService.findById(4));
        Assertions.assertEquals(Vacancy.get(19).getCompany(), CompanyService.findById(4));
        Assertions.assertEquals(Vacancy.get(0).getPosition(), PositionService.findById(1));
        Assertions.assertEquals(Vacancy.get(1).getPosition(), PositionService.findById(3));
        Assertions.assertEquals(Vacancy.get(2).getPosition(), PositionService.findById(4));
        Assertions.assertEquals(Vacancy.get(3).getPosition(), PositionService.findById(5));
        Assertions.assertEquals(Vacancy.get(4).getPosition(), PositionService.findById(7));
        Assertions.assertEquals(Vacancy.get(5).getPosition(), PositionService.findById(1));
        Assertions.assertEquals(Vacancy.get(6).getPosition(), PositionService.findById(2));
        Assertions.assertEquals(Vacancy.get(7).getPosition(), PositionService.findById(3));
        Assertions.assertEquals(Vacancy.get(8).getPosition(), PositionService.findById(4));
        Assertions.assertEquals(Vacancy.get(9).getPosition(), PositionService.findById(5));
        Assertions.assertEquals(Vacancy.get(10).getPosition(), PositionService.findById(6));
        Assertions.assertEquals(Vacancy.get(11).getPosition(), PositionService.findById(7));
        Assertions.assertEquals(Vacancy.get(12).getPosition(), PositionService.findById(1));
        Assertions.assertEquals(Vacancy.get(13).getPosition(), PositionService.findById(3));
        Assertions.assertEquals(Vacancy.get(14).getPosition(), PositionService.findById(4));
        Assertions.assertEquals(Vacancy.get(15).getPosition(), PositionService.findById(1));
        Assertions.assertEquals(Vacancy.get(16).getPosition(), PositionService.findById(2));
        Assertions.assertEquals(Vacancy.get(17).getPosition(), PositionService.findById(3));
        Assertions.assertEquals(Vacancy.get(18).getPosition(), PositionService.findById(6));
        Assertions.assertEquals(Vacancy.get(19).getPosition(), PositionService.findById(7));
    }

    @Test
    public void testSaveUpdateDelete() {
        // Save
        Company Company =  CompanyService.findById(1);
        Position Position = PositionService.findById(2);
        Speciality Speciality = SpecialityService.findById(1);
        Vacancy Vacancy_1 = new Vacancy(Company, Position, 100000, Speciality, 1);
        VacancyService.update(Vacancy_1); // так как detached entity passed to persist
        Vacancy Vacancy_2 = VacancyService.findByObj(1, 2);
        Assertions.assertEquals(Vacancy_1, Vacancy_2);

        // Update
        Speciality = SpecialityService.findById(6);
        VacancyService.delete(Vacancy_1);
        Vacancy_1.setReqSpec(Speciality);
        VacancyService.update(Vacancy_1);
        Vacancy_2 = VacancyService.findByObj(1, 6);
        Assertions.assertEquals(Vacancy_1, Vacancy_2);

        // Delete
        VacancyService.delete(Vacancy_1);
        Vacancy_2 = VacancyService.findByObj(2, 6);
        Assertions.assertEquals(null, Vacancy_2);
    }

    @Test
    public void testDeleteByObj() {
        // Save
        Company Company =  CompanyService.findById(1);
        Position Position = PositionService.findById(2);
        Speciality Speciality = SpecialityService.findById(1);
        Vacancy Vacancy_1 = new Vacancy(Company, Position, 100000, Speciality, 1);
        VacancyService.update(Vacancy_1); // так как detached entity passed to persist
        Vacancy Vacancy_2 = VacancyService.findByObj(1, 2);
        Assertions.assertEquals(Vacancy_1, Vacancy_2);

        // DeleteById
        VacancyService.deleteByObj(1, 2);
        Vacancy_2 = VacancyService.findByObj(1, 2);
        Assertions.assertEquals(null, Vacancy_2);
        VacancyService.deleteByObj(null, null);
    }

    @Test
    public void testfindSuitableResumes() {
        Vacancy Vacancy = VacancyService.findByObj(1, 3);
        List<Applicant> Applicant = VacancyService.findSuitableResumes(Vacancy);
        Assertions.assertEquals(Applicant.size(), 1);
        Assertions.assertEquals(Applicant.get(0).getId(), 5);

        Vacancy = VacancyService.findByObj(4, 6);
        Applicant = VacancyService.findSuitableResumes(Vacancy);
        Assertions.assertEquals(Applicant.size(), 1);
        Assertions.assertEquals(Applicant.get(0).getId(), 9);
    }

    @Test
    public void testfilter() {
        // No filter
        List<Vacancy> Vacancy = VacancyService.filter(null, null, null, null);
        Assertions.assertEquals(Vacancy.size(), 20);

        // Company
        Vacancy = VacancyService.filter(1, null, null, null);
        Assertions.assertEquals(Vacancy.size(), 12);
        Assertions.assertEquals(Vacancy.get(0).getCompany().getId(), 1);
        Assertions.assertEquals(Vacancy.get(1).getCompany().getId(), 1);
        Assertions.assertEquals(Vacancy.get(2).getCompany().getId(), 1);
        Assertions.assertEquals(Vacancy.get(3).getCompany().getId(), 1);
        Assertions.assertEquals(Vacancy.get(4).getCompany().getId(), 1);
        Assertions.assertEquals(Vacancy.get(5).getCompany().getId(), 2);
        Assertions.assertEquals(Vacancy.get(6).getCompany().getId(), 2);
        Assertions.assertEquals(Vacancy.get(7).getCompany().getId(), 2);
        Assertions.assertEquals(Vacancy.get(8).getCompany().getId(), 2);
        Assertions.assertEquals(Vacancy.get(9).getCompany().getId(), 2);
        Assertions.assertEquals(Vacancy.get(10).getCompany().getId(), 2);
        Assertions.assertEquals(Vacancy.get(11).getCompany().getId(), 2);
        Assertions.assertEquals(Vacancy.get(0).getPosition().getId(), 1);
        Assertions.assertEquals(Vacancy.get(1).getPosition().getId(), 3);
        Assertions.assertEquals(Vacancy.get(2).getPosition().getId(), 4);
        Assertions.assertEquals(Vacancy.get(3).getPosition().getId(), 5);
        Assertions.assertEquals(Vacancy.get(4).getPosition().getId(), 7);
        Assertions.assertEquals(Vacancy.get(5).getPosition().getId(), 1);
        Assertions.assertEquals(Vacancy.get(6).getPosition().getId(), 2);
        Assertions.assertEquals(Vacancy.get(7).getPosition().getId(), 3);
        Assertions.assertEquals(Vacancy.get(8).getPosition().getId(), 4);
        Assertions.assertEquals(Vacancy.get(9).getPosition().getId(), 5);
        Assertions.assertEquals(Vacancy.get(10).getPosition().getId(), 6);
        Assertions.assertEquals(Vacancy.get(11).getPosition().getId(), 7);

        // Position
        Vacancy = VacancyService.filter(null, 2, null, null);
        Assertions.assertEquals(Vacancy.size(), 6);
        Assertions.assertEquals(Vacancy.get(0).getCompany().getId(), 1);
        Assertions.assertEquals(Vacancy.get(1).getCompany().getId(), 2);
        Assertions.assertEquals(Vacancy.get(2).getCompany().getId(), 2);
        Assertions.assertEquals(Vacancy.get(3).getCompany().getId(), 3);
        Assertions.assertEquals(Vacancy.get(4).getCompany().getId(), 4);
        Assertions.assertEquals(Vacancy.get(5).getCompany().getId(), 4);
        Assertions.assertEquals(Vacancy.get(0).getPosition().getId(), 1);
        Assertions.assertEquals(Vacancy.get(1).getPosition().getId(), 1);
        Assertions.assertEquals(Vacancy.get(2).getPosition().getId(), 2);
        Assertions.assertEquals(Vacancy.get(3).getPosition().getId(), 1);
        Assertions.assertEquals(Vacancy.get(4).getPosition().getId(), 1);
        Assertions.assertEquals(Vacancy.get(5).getPosition().getId(), 2);
        
        // Salary
        Vacancy = VacancyService.filter(null, 2, 100000, 150000);
        Assertions.assertEquals(Vacancy.size(), 3);
        Assertions.assertEquals(Vacancy.get(0).getCompany().getId(), 1);
        Assertions.assertEquals(Vacancy.get(1).getCompany().getId(), 3);
        Assertions.assertEquals(Vacancy.get(2).getCompany().getId(), 4);
        Assertions.assertEquals(Vacancy.get(0).getPosition().getId(), 1);
        Assertions.assertEquals(Vacancy.get(1).getPosition().getId(), 1);
        Assertions.assertEquals(Vacancy.get(2).getPosition().getId(), 1);

        Vacancy = VacancyService.filter(null, null, null, null);
        Assertions.assertEquals(Vacancy.size(), 20);
        Vacancy = VacancyService.filter(null, null, null, null);
        Assertions.assertEquals(Vacancy.size(), 20);
    }
}