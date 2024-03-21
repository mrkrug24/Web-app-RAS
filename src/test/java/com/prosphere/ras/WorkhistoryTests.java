package com.prosphere.ras;
import com.prosphere.ras.models.*;
import com.prosphere.ras.services.*;
import java.time.LocalDate;
import org.junit.jupiter.api.*;
import java.util.List;

public class WorkhistoryTests {
    private ApplicantService ApplicantService = new ApplicantService();
    private CompanyService CompanyService = new CompanyService();
    private PositionService PositionService = new PositionService();
    private WorkhistoryService WorkhistoryService = new WorkhistoryService();
    private Applicant Applicant = ApplicantService.findById(1);
    private Company Company =  CompanyService.findById(4);
    private Position Position = PositionService.findById(7);

    @Test
    public void testWorkhistory() {
        Workhistory Workhistory = new Workhistory(Applicant, Company, Position, 100000, LocalDate.of(2022, 5, 6));
        Assertions.assertEquals(Workhistory.getApplicant(), Applicant);
        Assertions.assertEquals(Workhistory.getCompany(), Company);
        Assertions.assertEquals(Workhistory.getPosition(), Position);
        Assertions.assertEquals(Workhistory.getSalary(), 100000);
        Assertions.assertEquals(Workhistory.getStartDate(), LocalDate.of(2022, 5, 6));
        Assertions.assertEquals(Workhistory.getEndDate(), null);
    }

    @Test
    public void testFindByObj() {
        Workhistory Workhistory = WorkhistoryService.findByObj(Applicant, Company, Position);
        Assertions.assertEquals(Workhistory.getApplicant(), Applicant);
        Assertions.assertEquals(Workhistory.getCompany(), Company);
        Assertions.assertEquals(Workhistory.getPosition(), Position);
    }

    @Test
    public void testFindAll() {
        List<Workhistory> Workhistory = WorkhistoryService.findAll();
        Assertions.assertEquals(Workhistory.size(), 16);
        Assertions.assertEquals(Workhistory.get(0).getApplicant(), ApplicantService.findById(1));
        Assertions.assertEquals(Workhistory.get(1).getApplicant(), ApplicantService.findById(1));
        Assertions.assertEquals(Workhistory.get(2).getApplicant(), ApplicantService.findById(2));
        Assertions.assertEquals(Workhistory.get(3).getApplicant(), ApplicantService.findById(2));
        Assertions.assertEquals(Workhistory.get(4).getApplicant(), ApplicantService.findById(2));
        Assertions.assertEquals(Workhistory.get(5).getApplicant(), ApplicantService.findById(3));
        Assertions.assertEquals(Workhistory.get(6).getApplicant(), ApplicantService.findById(4));
        Assertions.assertEquals(Workhistory.get(7).getApplicant(), ApplicantService.findById(4));
        Assertions.assertEquals(Workhistory.get(8).getApplicant(), ApplicantService.findById(5));
        Assertions.assertEquals(Workhistory.get(9).getApplicant(), ApplicantService.findById(6));
        Assertions.assertEquals(Workhistory.get(10).getApplicant(), ApplicantService.findById(6));
        Assertions.assertEquals(Workhistory.get(11).getApplicant(), ApplicantService.findById(7));
        Assertions.assertEquals(Workhistory.get(12).getApplicant(), ApplicantService.findById(8));
        Assertions.assertEquals(Workhistory.get(13).getApplicant(), ApplicantService.findById(9));
        Assertions.assertEquals(Workhistory.get(14).getApplicant(), ApplicantService.findById(10));
        Assertions.assertEquals(Workhistory.get(15).getApplicant(), ApplicantService.findById(10));
        Assertions.assertEquals(Workhistory.get(0).getCompany(), CompanyService.findById(4));
        Assertions.assertEquals(Workhistory.get(1).getCompany(), CompanyService.findById(2));
        Assertions.assertEquals(Workhistory.get(2).getCompany(), CompanyService.findById(1));
        Assertions.assertEquals(Workhistory.get(3).getCompany(), CompanyService.findById(4));
        Assertions.assertEquals(Workhistory.get(4).getCompany(), CompanyService.findById(3));
        Assertions.assertEquals(Workhistory.get(5).getCompany(), CompanyService.findById(1));
        Assertions.assertEquals(Workhistory.get(6).getCompany(), CompanyService.findById(3));
        Assertions.assertEquals(Workhistory.get(7).getCompany(), CompanyService.findById(1));
        Assertions.assertEquals(Workhistory.get(8).getCompany(), CompanyService.findById(2));
        Assertions.assertEquals(Workhistory.get(9).getCompany(), CompanyService.findById(1));
        Assertions.assertEquals(Workhistory.get(10).getCompany(), CompanyService.findById(3));
        Assertions.assertEquals(Workhistory.get(11).getCompany(), CompanyService.findById(4));
        Assertions.assertEquals(Workhistory.get(12).getCompany(), CompanyService.findById(4));
        Assertions.assertEquals(Workhistory.get(13).getCompany(), CompanyService.findById(1));
        Assertions.assertEquals(Workhistory.get(14).getCompany(), CompanyService.findById(2));
        Assertions.assertEquals(Workhistory.get(15).getCompany(), CompanyService.findById(4));
        Assertions.assertEquals(Workhistory.get(0).getPosition(), PositionService.findById(7));
        Assertions.assertEquals(Workhistory.get(1).getPosition(), PositionService.findById(1));
        Assertions.assertEquals(Workhistory.get(2).getPosition(), PositionService.findById(7));
        Assertions.assertEquals(Workhistory.get(3).getPosition(), PositionService.findById(7));
        Assertions.assertEquals(Workhistory.get(4).getPosition(), PositionService.findById(1));
        Assertions.assertEquals(Workhistory.get(5).getPosition(), PositionService.findById(2));
        Assertions.assertEquals(Workhistory.get(6).getPosition(), PositionService.findById(5));
        Assertions.assertEquals(Workhistory.get(7).getPosition(), PositionService.findById(2));
        Assertions.assertEquals(Workhistory.get(8).getPosition(), PositionService.findById(3));
        Assertions.assertEquals(Workhistory.get(9).getPosition(), PositionService.findById(4));
        Assertions.assertEquals(Workhistory.get(10).getPosition(), PositionService.findById(4));
        Assertions.assertEquals(Workhistory.get(11).getPosition(), PositionService.findById(4));
        Assertions.assertEquals(Workhistory.get(12).getPosition(), PositionService.findById(5));
        Assertions.assertEquals(Workhistory.get(13).getPosition(), PositionService.findById(6));
        Assertions.assertEquals(Workhistory.get(14).getPosition(), PositionService.findById(1));
        Assertions.assertEquals(Workhistory.get(15).getPosition(), PositionService.findById(7));
    }

    @Test
    public void testSaveUpdateDelete() {
        // Save
        Position = PositionService.findById(1);
        Workhistory Workhistory_1 = new Workhistory(Applicant, Company, Position, 100000, LocalDate.of(2022, 1, 1), LocalDate.of(2024, 5, 6));
        WorkhistoryService.update(Workhistory_1); // так как detached entity passed to persist
        Workhistory Workhistory_2 = WorkhistoryService.findByObj(Applicant, Company, Position);
        Assertions.assertEquals(Workhistory_1, Workhistory_2);

        // Update
        Position = PositionService.findById(2);
        WorkhistoryService.delete(Workhistory_1);
        Workhistory_1.setPosition(Position);
        WorkhistoryService.update(Workhistory_1);
        Workhistory_2 = WorkhistoryService.findByObj(Applicant, Company, Position);
        Assertions.assertEquals(Workhistory_1, Workhistory_2);

        // Delete
        WorkhistoryService.delete(Workhistory_1);
        Workhistory_2 = WorkhistoryService.findByObj(Applicant, Company, Position);
        Assertions.assertEquals(null, Workhistory_2);
    }

    @Test
    public void testDeleteByObj() {
        // Save
        Position = PositionService.findById(1);
        Workhistory Workhistory_1 = new Workhistory(Applicant, Company, Position, 100000, LocalDate.of(2022, 1, 1), LocalDate.of(2024, 5, 6));
        WorkhistoryService.update(Workhistory_1); // так как detached entity passed to persist
        Workhistory Workhistory_2 = WorkhistoryService.findByObj(Applicant, Company, Position);
        Assertions.assertEquals(Workhistory_1, Workhistory_2);

        // DeleteById
        WorkhistoryService.deleteByObj(Applicant, Company, Position);
        Workhistory_2 = WorkhistoryService.findByObj(Applicant, Company, Position);
        Assertions.assertEquals(null, Workhistory_2);

        WorkhistoryService.deleteByObj(null, null, null);
        WorkhistoryService.deleteByObj(Applicant, Company, Position);
    }
}