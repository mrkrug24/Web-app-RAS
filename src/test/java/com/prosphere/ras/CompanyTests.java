package com.prosphere.ras;
import com.prosphere.ras.models.*;
import com.prosphere.ras.services.*;
import org.junit.jupiter.api.*;
import java.util.List;

public class CompanyTests {
    @Test
    public void testCompany() {
        Company Company = new Company("Kaspersky");
        Assertions.assertEquals(Company.getName(), "Kaspersky");
    }

    @Test
    public void testFindById() {
        CompanyService CompanyService = new CompanyService();
        Company Company = CompanyService.findById(1);
        Assertions.assertEquals(Company.getId(), 1);
        Assertions.assertEquals(Company.getName(), "VK");
        Company = CompanyService.findById(10000);
        Assertions.assertEquals(Company, null);
    }

    @Test
    public void testFindAll() {
        CompanyService CompanyService = new CompanyService();
        List<Company> Company = CompanyService.findAll();
        Assertions.assertEquals(CompanyService.findAll().size(), 4);
        Assertions.assertEquals(Company.get(0).getId(), 1);
        Assertions.assertEquals(Company.get(1).getId(), 2);
        Assertions.assertEquals(Company.get(2).getId(), 3);
        Assertions.assertEquals(Company.get(3).getId(), 4);
        Assertions.assertEquals(Company.get(0).getName(), "VK");
        Assertions.assertEquals(Company.get(1).getName(), "Ozon");
        Assertions.assertEquals(Company.get(2).getName(), "Тинькофф");
        Assertions.assertEquals(Company.get(3).getName(), "Яндекс");
    }

    @Test
    public void testSaveUpdateDelete() {
        // Save
        CompanyService CompanyService = new CompanyService();
        Company Company_1 = new Company("Kaspersky");
        CompanyService.save(Company_1);
        Company Company_2 = CompanyService.findById(Company_1.getId());
        Assertions.assertEquals(Company_1, Company_2);

        // Update
        Company_1.setName("Сбер");
        CompanyService.update(Company_1);
        Company_2 = CompanyService.findById(Company_1.getId());
        Assertions.assertEquals(Company_1.getName(), Company_2.getName());

        // Delete
        CompanyService.delete(Company_1);
        Company_2 = CompanyService.findById(Company_1.getId());
        Assertions.assertEquals(null, Company_2);

        CompanyService.update(null);
        CompanyService.save(null);
        CompanyService.delete(null);
    }

    @Test
    public void testDeleteById() {
        // Save
        CompanyService CompanyService = new CompanyService();
        Company Company_1 = new Company("Kaspersky");
        CompanyService.save(Company_1);
        Company Company_2 = CompanyService.findById(Company_1.getId());
        Assertions.assertEquals(Company_1, Company_2);

        // DeleteById
        CompanyService.deleteById(Company_1.getId());
        Company_2 = CompanyService.findById(Company_1.getId());
        Assertions.assertEquals(null, Company_2);

        CompanyService.deleteById(1000);
    }

    @Test
    public void testFindVacancy() {
        CompanyService CompanyService = new CompanyService();
        Company Company = CompanyService.findById(1);
        List<Vacancy> Vacancy = CompanyService.findVacancy(Company);
        Assertions.assertEquals(Vacancy.size(), 5);
        Assertions.assertEquals(Vacancy.get(0).getCompany().getId(), 1);
        Assertions.assertEquals(Vacancy.get(1).getCompany().getId(), 1);
        Assertions.assertEquals(Vacancy.get(2).getCompany().getId(), 1);
        Assertions.assertEquals(Vacancy.get(3).getCompany().getId(), 1);
        Assertions.assertEquals(Vacancy.get(4).getCompany().getId(), 1);
        Assertions.assertEquals(Vacancy.get(0).getPosition().getId(), 1);
        Assertions.assertEquals(Vacancy.get(1).getPosition().getId(), 3);
        Assertions.assertEquals(Vacancy.get(2).getPosition().getId(), 4);
        Assertions.assertEquals(Vacancy.get(3).getPosition().getId(), 5);
        Assertions.assertEquals(Vacancy.get(4).getPosition().getId(), 7);
    }

    @Test
    public void testFindNewPositions() {
        CompanyService CompanyService = new CompanyService();
        Company company = CompanyService.findById(1);
        List<Position> pos = CompanyService.findNewPositions(company);

        for (Position p : pos) System.out.println(p.getId());
    }
}