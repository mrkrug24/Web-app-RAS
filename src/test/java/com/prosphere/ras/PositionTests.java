package com.prosphere.ras;
import com.prosphere.ras.models.*;
import com.prosphere.ras.services.*;
import org.junit.jupiter.api.*;
import java.util.List;

public class PositionTests {
    @Test
    public void testPosition() {
        Position Position = new Position("Data Science");
        Assertions.assertEquals(Position.getName(), "Data Science");
    }

    @Test
    public void testFindById() {
        PositionService PositionService = new PositionService();
        Position Position = PositionService.findById(1);
        Assertions.assertEquals(Position.getId(), 1);
        Assertions.assertEquals(Position.getName(), "Аналитик данных");
    }

    @Test
    public void testFindAll() {
        PositionService PositionService = new PositionService();
        List<Position> Position = PositionService.findAll();
        Assertions.assertEquals(PositionService.findAll().size(), 7);
        Assertions.assertEquals(Position.get(0).getId(), 1);
        Assertions.assertEquals(Position.get(1).getId(), 2);
        Assertions.assertEquals(Position.get(2).getId(), 3);
        Assertions.assertEquals(Position.get(3).getId(), 4);
        Assertions.assertEquals(Position.get(4).getId(), 5);
        Assertions.assertEquals(Position.get(5).getId(), 6);
        Assertions.assertEquals(Position.get(6).getId(), 7);
        Assertions.assertEquals(Position.get(0).getName(), "Аналитик данных");
        Assertions.assertEquals(Position.get(1).getName(), "Архитектор информационных систем");
        Assertions.assertEquals(Position.get(2).getName(), "Дизайнер пользовательских интерфейсов");
        Assertions.assertEquals(Position.get(3).getName(), "Специалист по информационной безопасности и защите данных");
        Assertions.assertEquals(Position.get(4).getName(), "Разработчик мобильных приложений");
        Assertions.assertEquals(Position.get(5).getName(), "Менеджер по развитию рекламных технологий");
        Assertions.assertEquals(Position.get(6).getName(), "Специалист по машинному обучению");
    }

    @Test
    public void testSaveUpdateDelete() {
        // Save
        PositionService PositionService = new PositionService();
        Position Position_1 = new Position("Системный аналитик");
        PositionService.save(Position_1);
        Position Position_2 = PositionService.findById(Position_1.getId());
        Assertions.assertEquals(Position_1, Position_2);

        // Update
        Position_1.setName("Data Science");
        PositionService.update(Position_1);
        Position_2 = PositionService.findById(Position_1.getId());
        Assertions.assertEquals(Position_1.getName(), Position_2.getName());

        // Delete
        PositionService.delete(Position_1);
        Position_2 = PositionService.findById(Position_1.getId());
        Assertions.assertEquals(null, Position_2);
    }

    @Test
    public void testDeleteById() {
        // Save
        PositionService PositionService = new PositionService();
        Position Position_1 = new Position("Системный аналитик");
        PositionService.save(Position_1);
        Position Position_2 = PositionService.findById(Position_1.getId());
        Assertions.assertEquals(Position_1, Position_2);

        // DeleteById
        PositionService.deleteById(Position_1.getId());
        Position_2 = PositionService.findById(Position_1.getId());
        Assertions.assertEquals(null, Position_2);
    }
}