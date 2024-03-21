package com.prosphere.ras;
import com.prosphere.ras.models.*;
import com.prosphere.ras.services.*;
import org.junit.jupiter.api.*;
import java.util.List;

public class SpecialityTests {
    @Test
    public void testSpeciality() {
        Speciality Speciality = new Speciality("Математика");
        Assertions.assertEquals(Speciality.getName(), "Математика");
    }

    @Test
    public void testFindById() {
        SpecialityService SpecialityService = new SpecialityService();
        Speciality Speciality = SpecialityService.findById(1);
        Assertions.assertEquals(Speciality.getId(), 1);
        Assertions.assertEquals(Speciality.getName(), "Дизайн");
    }

    @Test
    public void testFindAll() {
        SpecialityService SpecialityService = new SpecialityService();
        List<Speciality> Speciality = SpecialityService.findAll();
        Assertions.assertEquals(SpecialityService.findAll().size(), 7);
        Assertions.assertEquals(Speciality.get(0).getId(), 1);
        Assertions.assertEquals(Speciality.get(1).getId(), 2);
        Assertions.assertEquals(Speciality.get(2).getId(), 3);
        Assertions.assertEquals(Speciality.get(3).getId(), 4);
        Assertions.assertEquals(Speciality.get(4).getId(), 5);
        Assertions.assertEquals(Speciality.get(5).getId(), 6);
        Assertions.assertEquals(Speciality.get(6).getId(), 7);
        Assertions.assertEquals(Speciality.get(0).getName(), "Дизайн");
        Assertions.assertEquals(Speciality.get(1).getName(), "Информационная безопасность");
        Assertions.assertEquals(Speciality.get(2).getName(), "Менеджмент");
        Assertions.assertEquals(Speciality.get(3).getName(), "Прикладная математика и информатика");
        Assertions.assertEquals(Speciality.get(4).getName(), "Программная инженерия");
        Assertions.assertEquals(Speciality.get(5).getName(), "Реклама и связи с общественностью");
        Assertions.assertEquals(Speciality.get(6).getName(), "Экономика");
    }

    @Test
    public void testSaveUpdateDelete() {
        // Save
        SpecialityService SpecialityService = new SpecialityService();
        Speciality Speciality_1 = new Speciality("Математика");
        SpecialityService.save(Speciality_1);
        System.out.println(Speciality_1);
        Speciality Speciality_2 = SpecialityService.findById(Speciality_1.getId());
        Assertions.assertEquals(Speciality_1, Speciality_2);

        // Update
        Speciality_1.setName("Физика");
        SpecialityService.update(Speciality_1);
        Speciality_2 = SpecialityService.findById(Speciality_1.getId());
        Assertions.assertEquals(Speciality_1.getName(), Speciality_2.getName());

        // Delete
        SpecialityService.delete(Speciality_1);
        Speciality_2 = SpecialityService.findById(Speciality_1.getId());
        Assertions.assertEquals(null, Speciality_2);
    }

    @Test
    public void testDeleteById() {
        // Save
        SpecialityService SpecialityService = new SpecialityService();
        Speciality Speciality_1 = new Speciality("Математика");
        SpecialityService.save(Speciality_1);
        Speciality Speciality_2 = SpecialityService.findById(Speciality_1.getId());
        Assertions.assertEquals(Speciality_1, Speciality_2);

        // DeleteById
        SpecialityService.deleteById(Speciality_1.getId());
        Speciality_2 = SpecialityService.findById(Speciality_1.getId());
        Assertions.assertEquals(null, Speciality_2);
    }
}