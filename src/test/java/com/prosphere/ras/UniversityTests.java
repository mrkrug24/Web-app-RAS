package com.prosphere.ras;
import com.prosphere.ras.models.*;
import com.prosphere.ras.services.*;
import org.junit.jupiter.api.*;
import java.util.List;

public class UniversityTests {
    @Test
    public void testUniversity() {
        University University = new University("РУДН");
        Assertions.assertEquals(University.getName(), "РУДН");
    }

    @Test
    public void testFindById() {
        UniversityService UniversityService = new UniversityService();
        University University = UniversityService.findById(1);
        Assertions.assertEquals(University.getId(), 1);
        Assertions.assertEquals(University.getName(), "Московский государственный университет имени М.В. Ломоносова");
    }

    @Test
    public void testFindAll() {
        UniversityService UniversityService = new UniversityService();
        List<University> University = UniversityService.findAll();
        Assertions.assertEquals(UniversityService.findAll().size(), 3);
        Assertions.assertEquals(University.get(0).getId(), 1);
        Assertions.assertEquals(University.get(1).getId(), 2);
        Assertions.assertEquals(University.get(2).getId(), 3);
        Assertions.assertEquals(University.get(0).getName(), "Московский государственный университет имени М.В. Ломоносова");
        Assertions.assertEquals(University.get(1).getName(), "Московский физико-технический институт");
        Assertions.assertEquals(University.get(2).getName(), "Национальный исследовательский университет «Высшая школа экономики»");
    }

    @Test
    public void testSaveUpdateDelete() {
        // Save
        UniversityService UniversityService = new UniversityService();
        University University_1 = new University("РУДН");
        UniversityService.save(University_1);
        University University_2 = UniversityService.findById(University_1.getId());
        Assertions.assertEquals(University_1, University_2);

        // Update
        University_1.setName("МИСИС");
        UniversityService.update(University_1);
        University_2 = UniversityService.findById(University_1.getId());
        Assertions.assertEquals(University_1.getName(), University_2.getName());

        // Delete
        UniversityService.delete(University_1);
        University_2 = UniversityService.findById(University_1.getId());
        Assertions.assertEquals(null, University_2);
    }

    @Test
    public void testDeleteById() {
        // Save
        UniversityService UniversityService = new UniversityService();
        University University_1 = new University("РУДН");
        UniversityService.save(University_1);
        University University_2 = UniversityService.findById(University_1.getId());
        Assertions.assertEquals(University_1, University_2);

        // DeleteById
        UniversityService.deleteById(University_1.getId());
        University_2 = UniversityService.findById(University_1.getId());
        Assertions.assertEquals(null, University_2);
    }
}