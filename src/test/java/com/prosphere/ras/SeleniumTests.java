package com.prosphere.ras;

import java.util.List;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SeleniumTests {
    WebDriver driver = new ChromeDriver();

    // Проверка перехода на главную страницу
    @Test
    public void testMainPage(){
        driver.get("http://localhost:8080/");
        assertEquals("PROSHERE", driver.getTitle());
        driver.quit();
    }

//_____________________________________________________________________________________________________

    // Проверка перехода на страницу списка всех вакансий
    @Test
    public void testVacancies() {
        driver.get("http://localhost:8080/");
        WebElement gotovacancies = driver.findElement(By.linkText("Вакансии"));
        gotovacancies.click();
        assertEquals("Вакансии", driver.getTitle());
        driver.quit();
    }

    // Проверка перехода со страницы всех вакансий на главную страницу
    @Test
    public void testFromVacanciesToMainPage() {
        driver.get("http://localhost:8080/vacancies");
        WebElement homeLink = driver.findElement(By.xpath("//img[@alt='Домой']"));
        homeLink.click();
        assertEquals("PROSHERE", driver.getTitle());
        driver.quit();
    }

    // Проверка перехода со страницы всех вакансий назад (на главную страницу)
    @Test
    public void testFromVacanciesBack() {
        driver.get("http://localhost:8080/vacancies");
        WebElement backLink = driver.findElement(By.xpath("//img[@alt='Назад']"));
        backLink.click();
        assertEquals("PROSHERE", driver.getTitle());
        driver.quit();
    }

    // Проверка списка всех вакансий
    @Test
    public void testVacanciesList() {
        driver.get("http://localhost:8080/vacancies");

        WebElement vacanciesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = vacanciesTable.findElements(By.tagName("td"));

        assertEquals("VK", items.get(0).getText());
        assertEquals("Аналитик данных", items.get(1).getText());
        assertEquals("150000", items.get(2).getText());

        assertEquals("VK", items.get(4).getText());
        assertEquals("Дизайнер пользовательских интерфейсов", items.get(5).getText());
        assertEquals("120000", items.get(6).getText());

        assertEquals("VK", items.get(8).getText());
        assertEquals("Специалист по информационной безопасности и защите данных", items.get(9).getText());
        assertEquals("160000", items.get(10).getText());

        assertEquals("VK", items.get(12).getText());
        assertEquals("Разработчик мобильных приложений", items.get(13).getText());
        assertEquals("120000", items.get(14).getText());

        assertEquals("VK", items.get(16).getText());
        assertEquals("Специалист по машинному обучению", items.get(17).getText());
        assertEquals("250000", items.get(18).getText());

        assertEquals("Ozon", items.get(20).getText());
        assertEquals("Аналитик данных", items.get(21).getText());
        assertEquals("160000", items.get(22).getText());

        assertEquals("Ozon", items.get(24).getText());
        assertEquals("Архитектор информационных систем", items.get(25).getText());
        assertEquals("200000", items.get(26).getText());

        assertEquals("Ozon", items.get(28).getText());
        assertEquals("Дизайнер пользовательских интерфейсов", items.get(29).getText());
        assertEquals("130000", items.get(30).getText());

        assertEquals("Ozon", items.get(32).getText());
        assertEquals("Специалист по информационной безопасности и защите данных", items.get(33).getText());
        assertEquals("170000", items.get(34).getText());

        assertEquals("Ozon", items.get(36).getText());
        assertEquals("Разработчик мобильных приложений", items.get(37).getText());
        assertEquals("130000", items.get(38).getText());

        assertEquals("Ozon", items.get(40).getText());
        assertEquals("Менеджер по развитию рекламных технологий", items.get(41).getText());
        assertEquals("110000", items.get(42).getText());

        assertEquals("Ozon", items.get(44).getText());
        assertEquals("Специалист по машинному обучению", items.get(45).getText());
        assertEquals("300000", items.get(46).getText());

        assertEquals("Тинькофф", items.get(48).getText());
        assertEquals("Аналитик данных", items.get(49).getText());
        assertEquals("140000", items.get(50).getText());

        assertEquals("Тинькофф", items.get(52).getText());
        assertEquals("Дизайнер пользовательских интерфейсов", items.get(53).getText());
        assertEquals("110000", items.get(54).getText());

        assertEquals("Тинькофф", items.get(56).getText());
        assertEquals("Специалист по информационной безопасности и защите данных", items.get(57).getText());
        assertEquals("150000", items.get(58).getText());

        assertEquals("Яндекс", items.get(60).getText());
        assertEquals("Аналитик данных", items.get(61).getText());
        assertEquals("150000", items.get(62).getText());

        assertEquals("Яндекс", items.get(64).getText());
        assertEquals("Архитектор информационных систем", items.get(65).getText());
        assertEquals("180000", items.get(66).getText());

        assertEquals("Яндекс", items.get(68).getText());
        assertEquals("Дизайнер пользовательских интерфейсов", items.get(69).getText());
        assertEquals("120000", items.get(70).getText());

        assertEquals("Яндекс", items.get(72).getText());
        assertEquals("Менеджер по развитию рекламных технологий", items.get(73).getText());
        assertEquals("", items.get(74).getText());

        assertEquals("Яндекс", items.get(76).getText());
        assertEquals("Специалист по машинному обучению", items.get(77).getText());
        assertEquals("250000", items.get(78).getText());

        assertEquals("VK", items.get(80).getText());
        assertEquals("Архитектор информационных систем", items.get(81).getText());
        assertEquals("100000", items.get(82).getText());

        assertEquals(84, items.size());

        driver.quit();
    }

    // Проверка фильтрации вакансий без заданных параметров
    @Test
    public void testVacanciesFilter() {
        driver.get("http://localhost:8080/vacancies");

        WebElement applyFilterButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']"));
        applyFilterButton.click();

        WebElement vacanciesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = vacanciesTable.findElements(By.tagName("td"));

        assertEquals("VK", items.get(0).getText());
        assertEquals("Аналитик данных", items.get(1).getText());
        assertEquals("150000", items.get(2).getText());

        assertEquals("VK", items.get(4).getText());
        assertEquals("Дизайнер пользовательских интерфейсов", items.get(5).getText());
        assertEquals("120000", items.get(6).getText());

        assertEquals("VK", items.get(8).getText());
        assertEquals("Специалист по информационной безопасности и защите данных", items.get(9).getText());
        assertEquals("160000", items.get(10).getText());

        assertEquals("VK", items.get(12).getText());
        assertEquals("Разработчик мобильных приложений", items.get(13).getText());
        assertEquals("120000", items.get(14).getText());

        assertEquals("VK", items.get(16).getText());
        assertEquals("Специалист по машинному обучению", items.get(17).getText());
        assertEquals("250000", items.get(18).getText());

        assertEquals("Ozon", items.get(20).getText());
        assertEquals("Аналитик данных", items.get(21).getText());
        assertEquals("160000", items.get(22).getText());

        assertEquals("Ozon", items.get(24).getText());
        assertEquals("Архитектор информационных систем", items.get(25).getText());
        assertEquals("200000", items.get(26).getText());

        assertEquals("Ozon", items.get(28).getText());
        assertEquals("Дизайнер пользовательских интерфейсов", items.get(29).getText());
        assertEquals("130000", items.get(30).getText());

        assertEquals("Ozon", items.get(32).getText());
        assertEquals("Специалист по информационной безопасности и защите данных", items.get(33).getText());
        assertEquals("170000", items.get(34).getText());

        assertEquals("Ozon", items.get(36).getText());
        assertEquals("Разработчик мобильных приложений", items.get(37).getText());
        assertEquals("130000", items.get(38).getText());

        assertEquals("Ozon", items.get(40).getText());
        assertEquals("Менеджер по развитию рекламных технологий", items.get(41).getText());
        assertEquals("110000", items.get(42).getText());

        assertEquals("Ozon", items.get(44).getText());
        assertEquals("Специалист по машинному обучению", items.get(45).getText());
        assertEquals("300000", items.get(46).getText());

        assertEquals("Тинькофф", items.get(48).getText());
        assertEquals("Аналитик данных", items.get(49).getText());
        assertEquals("140000", items.get(50).getText());

        assertEquals("Тинькофф", items.get(52).getText());
        assertEquals("Дизайнер пользовательских интерфейсов", items.get(53).getText());
        assertEquals("110000", items.get(54).getText());

        assertEquals("Тинькофф", items.get(56).getText());
        assertEquals("Специалист по информационной безопасности и защите данных", items.get(57).getText());
        assertEquals("150000", items.get(58).getText());

        assertEquals("Яндекс", items.get(60).getText());
        assertEquals("Аналитик данных", items.get(61).getText());
        assertEquals("150000", items.get(62).getText());

        assertEquals("Яндекс", items.get(64).getText());
        assertEquals("Архитектор информационных систем", items.get(65).getText());
        assertEquals("180000", items.get(66).getText());

        assertEquals("Яндекс", items.get(68).getText());
        assertEquals("Дизайнер пользовательских интерфейсов", items.get(69).getText());
        assertEquals("120000", items.get(70).getText());

        assertEquals("Яндекс", items.get(72).getText());
        assertEquals("Менеджер по развитию рекламных технологий", items.get(73).getText());
        assertEquals("", items.get(74).getText());

        assertEquals("Яндекс", items.get(76).getText());
        assertEquals("Специалист по машинному обучению", items.get(77).getText());
        assertEquals("250000", items.get(78).getText());

        assertEquals("VK", items.get(80).getText());
        assertEquals("Архитектор информационных систем", items.get(81).getText());
        assertEquals("100000", items.get(82).getText());

        assertEquals(84, items.size());

        driver.quit();
    }

    // Проверка фильтрации вакансий по компаниям
    @Test
    public void testVacanciesFilterByCompany() {
        driver.get("http://localhost:8080/vacancies");
        WebElement companyDropdownButton = driver.findElement(By.id("companyDropdownVAC"));
        companyDropdownButton.click();

        WebElement Option = driver.findElement(By.xpath("//a[@class='dropdown-item company-item' and text()='Яндекс']"));
        Option.click();

        WebElement applyFilterButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']"));
        applyFilterButton.click();

        WebElement vacanciesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = vacanciesTable.findElements(By.tagName("td"));

        assertEquals("Яндекс", items.get(0).getText());
        assertEquals("Аналитик данных", items.get(1).getText());
        assertEquals("150000", items.get(2).getText());

        assertEquals("Яндекс", items.get(4).getText());
        assertEquals("Архитектор информационных систем", items.get(5).getText());
        assertEquals("180000", items.get(6).getText());

        assertEquals("Яндекс", items.get(8).getText());
        assertEquals("Дизайнер пользовательских интерфейсов", items.get(9).getText());
        assertEquals("120000", items.get(10).getText());

        assertEquals("Яндекс", items.get(12).getText());
        assertEquals("Менеджер по развитию рекламных технологий", items.get(13).getText());
        assertEquals("", items.get(14).getText());

        assertEquals("Яндекс", items.get(16).getText());
        assertEquals("Специалист по машинному обучению", items.get(17).getText());
        assertEquals("250000", items.get(18).getText());

        assertEquals(20, items.size());

        driver.quit();
    }

    // Проверка фильтрации вакансий по должностям
    @Test
    public void testVacanciesFilterByPosition() {
        driver.get("http://localhost:8080/vacancies");
        WebElement companyDropdownButton = driver.findElement(By.id("positionDropdownVAC"));
        companyDropdownButton.click();

        WebElement Option = driver.findElement(By.xpath("//a[@class='dropdown-item position-item' and text()='Разработчик мобильных приложений']"));
        Option.click();

        WebElement applyFilterButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']"));
        applyFilterButton.click();

        WebElement vacanciesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = vacanciesTable.findElements(By.tagName("td"));

        assertEquals("VK", items.get(0).getText());
        assertEquals("Разработчик мобильных приложений", items.get(1).getText());
        assertEquals("120000", items.get(2).getText());

        assertEquals("Ozon", items.get(4).getText());
        assertEquals("Разработчик мобильных приложений", items.get(5).getText());
        assertEquals("130000", items.get(6).getText());

        assertEquals(8, items.size());

        driver.quit();
    }

    // Проверка фильтрации вакансий по минимальной зарплате
    @Test
    public void testVacanciesFilterByMinSalary() {
        driver.get("http://localhost:8080/vacancies");

        WebElement minSalaryInput = driver.findElement(By.id("minSalaryVAC"));
        minSalaryInput.sendKeys("200000");

        WebElement applyFilterButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']"));
        applyFilterButton.click();

        WebElement vacanciesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = vacanciesTable.findElements(By.tagName("td"));

        assertEquals("VK", items.get(0).getText());
        assertEquals("Специалист по машинному обучению", items.get(1).getText());
        assertEquals("250000", items.get(2).getText());

        assertEquals("Ozon", items.get(4).getText());
        assertEquals("Архитектор информационных систем", items.get(5).getText());
        assertEquals("200000", items.get(6).getText());

        assertEquals("Ozon", items.get(8).getText());
        assertEquals("Специалист по машинному обучению", items.get(9).getText());
        assertEquals("300000", items.get(10).getText());

        assertEquals("Яндекс", items.get(12).getText());
        assertEquals("Специалист по машинному обучению", items.get(13).getText());
        assertEquals("250000", items.get(14).getText());

        assertEquals(16, items.size());

        driver.quit();
    }

    // Проверка фильтрации вакансий по максимальной зарплате
    @Test
    public void testVacanciesFilterByMaxSalary() {
        driver.get("http://localhost:8080/vacancies");

        WebElement minSalaryInput = driver.findElement(By.id("maxSalaryVAC"));
        minSalaryInput.sendKeys("120000");

        WebElement applyFilterButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']"));
        applyFilterButton.click();

        WebElement vacanciesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = vacanciesTable.findElements(By.tagName("td"));

        assertEquals("VK", items.get(0).getText());
        assertEquals("Дизайнер пользовательских интерфейсов", items.get(1).getText());
        assertEquals("120000", items.get(2).getText());

        assertEquals("VK", items.get(4).getText());
        assertEquals("Разработчик мобильных приложений", items.get(5).getText());
        assertEquals("120000", items.get(6).getText());

        assertEquals("Ozon", items.get(8).getText());
        assertEquals("Менеджер по развитию рекламных технологий", items.get(9).getText());
        assertEquals("110000", items.get(10).getText());

        assertEquals("Тинькофф", items.get(12).getText());
        assertEquals("Дизайнер пользовательских интерфейсов", items.get(13).getText());
        assertEquals("110000", items.get(14).getText());

        assertEquals("Яндекс", items.get(16).getText());
        assertEquals("Дизайнер пользовательских интерфейсов", items.get(17).getText());
        assertEquals("120000", items.get(18).getText());

        assertEquals("VK", items.get(20).getText());
        assertEquals("Архитектор информационных систем", items.get(21).getText());
        assertEquals("100000", items.get(22).getText());

        assertEquals(24, items.size());

        driver.quit();
    }

    // Проверка перехода со страницы списка всех вакансий на страницу конкретной вакансии
    @Test
    public void testVacanciesChooseVacancy() {
        driver.get("http://localhost:8080/vacancies");

        WebElement vacanciesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = vacanciesTable.findElements(By.tagName("td"));

        assertEquals("VK", items.get(12).getText());
        assertEquals("Разработчик мобильных приложений", items.get(13).getText());
        assertEquals("120000", items.get(14).getText());

        WebElement detailsButton = driver.findElement(By.xpath("//table/tbody/tr[4]/td/form/button"));
        detailsButton.click();

        assertEquals("Информация о вакансии", driver.getTitle());

        WebElement companyElement = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals("VK", companyElement.getText());

        WebElement positionElement = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        assertEquals("Разработчик мобильных приложений", positionElement.getText());

        WebElement educationElement = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        assertEquals("Программная инженерия", educationElement.getText());

        WebElement experienceElement = driver.findElement(By.xpath("//table//tr[4]//td[2]"));
        assertEquals("", experienceElement.getText());

        WebElement salaryElement = driver.findElement(By.xpath("//table//tr[5]//td[2]"));
        assertEquals("120000", salaryElement.getText());
        driver.quit();
    }

    // Проверка перехода со страницы конкретной вакансии на главную страницу
    @Test
    public void testVacancMainPage() {
        driver.get("http://localhost:8080/vacancies");

        WebElement detailsButton = driver.findElement(By.xpath("//table/tbody/tr[4]/td/form/button"));
        detailsButton.click();
        assertEquals("Информация о вакансии", driver.getTitle());

        WebElement homeLink = driver.findElement(By.xpath("//img[@alt='Домой']"));
        homeLink.click();
        assertEquals("PROSHERE", driver.getTitle());

        driver.quit();
    }

    // Проверка перехода со страницы конкретной вакансии назад (на страницу списка вакансий)
    @Test
    public void testVacancyBack() {
        driver.get("http://localhost:8080/vacancies");

        WebElement detailsButton = driver.findElement(By.xpath("//table/tbody/tr[4]/td/form/button"));
        detailsButton.click();
        assertEquals("Информация о вакансии", driver.getTitle());

        WebElement backLink = driver.findElement(By.xpath("//img[@alt='Назад']"));
        backLink.click();
        assertEquals("Вакансии", driver.getTitle());

        driver.quit();
    }

    // Проверка перехода со страницы вакансии на страницу подходящего резюме
    @Test
    public void testVacancySuitableResumes() {
        driver.get("http://localhost:8080/vacancy?companyId=1&positionId=5");

        WebElement detailedButton = driver.findElement(By.tagName("button"));
        detailedButton.click();

        assertEquals("Информация о соискателе", driver.getTitle());
        WebElement lastname = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals("Морозов", lastname.getText());
        WebElement firstname = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        assertEquals("Артем", firstname.getText());
        WebElement middlename = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        assertEquals("Алексеевич", middlename.getText());

        driver.quit();
    }

    // Проверка перехода со страницы подходящего резюме на главную страницу
    @Test
    public void testVacancySuitableResumesMainPage() {
        driver.get("http://localhost:8080/vacancy?companyId=1&positionId=5");
        WebElement detailedButton = driver.findElement(By.tagName("button"));
        detailedButton.click();

        WebElement backLink = driver.findElement(By.xpath("//img[@alt='Домой']"));
        backLink.click();
        assertEquals("PROSHERE", driver.getTitle());

        driver.quit();
    }

    // Проверка перехода со страницы подходящего резюме назад (на страницу вакансии)
    @Test
    public void testVacancySuitableResumesBack() {
        driver.get("http://localhost:8080/vacancy?companyId=1&positionId=5");

        WebElement detailedButton = driver.findElement(By.tagName("button"));
        detailedButton.click();

        WebElement backLink = driver.findElement(By.xpath("//img[@alt='Назад']"));
        backLink.click();
        String title = driver.getTitle();
        assertEquals("Информация о вакансии", title);

        WebElement companyElement = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals("VK", companyElement.getText());

        WebElement positionElement = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        assertEquals("Разработчик мобильных приложений", positionElement.getText());

        WebElement educationElement = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        assertEquals("Программная инженерия", educationElement.getText());

        WebElement experienceElement = driver.findElement(By.xpath("//table//tr[4]//td[2]"));
        assertEquals("", experienceElement.getText());

        WebElement salaryElement = driver.findElement(By.xpath("//table//tr[5]//td[2]"));
        assertEquals("120000", salaryElement.getText());

        driver.quit();
    }

//_____________________________________________________________________________________________________


    // Проверка перехода на страницу списка всех компаний
    @Test
    public void testCompanies(){
        driver.get("http://localhost:8080/");
        WebElement gotovacancies = driver.findElement(By.linkText("Компании"));
        gotovacancies.click();
        assertEquals("Компании", driver.getTitle());
        driver.quit();
    }

    // Проверка перехода со страницы всех компаний на главную страницу
    @Test
    public void testFromCompaniesToMainPage() {
        driver.get("http://localhost:8080/companies");
        WebElement homeLink = driver.findElement(By.xpath("//img[@alt='Домой']"));
        homeLink.click();
        assertEquals("PROSHERE", driver.getTitle());
        driver.quit();
    }

    // Проверка перехода со страницы всех компаний назад (на главную страницу)
    @Test
    public void testFromCompaniesBack() {
        driver.get("http://localhost:8080/companies");
        WebElement backLink = driver.findElement(By.xpath("//img[@alt='Назад']"));
        backLink.click();
        assertEquals("PROSHERE", driver.getTitle());
        driver.quit();
    }

    // Проверка добавления компании с пустым названием
    @Test
    public void testAddCompany() {
        driver.get("http://localhost:8080/companies");

        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Добавить')]"));
        addButton.click();
        assertEquals("Добавление компании", driver.getTitle());

        WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'Сохранить')]"));
        saveButton.click();

        // Получсаем уведомление и остаемся на странице добавления
        assertEquals("Добавление компании", driver.getTitle());
        
        driver.quit();
    }

    // Проверка добавления компании с названием, уже имеющимся в базе данных
    @Test
    public void testAddCompany2() {
        driver.get("http://localhost:8080/companies");

        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Добавить')]"));
        addButton.click();
        assertEquals("Добавление компании", driver.getTitle());

        
        WebElement nameInput = driver.findElement(By.id("name"));
        nameInput.sendKeys("VK");

        WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'Сохранить')]"));
        saveButton.click();

        // Уведомление об ошибке
        WebElement errorButton = driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
        errorButton.click();

        assertEquals("Добавление компании", driver.getTitle());
        
        driver.quit();
    }

    // Проверка перехода со страницы добавления компании на главную страницу
    @Test
    public void testFromAddCompanyToMainPage() {
        driver.get("http://localhost:8080/addcompany");
        WebElement homeLink = driver.findElement(By.xpath("//img[@alt='Домой']"));
        homeLink.click();
        assertEquals("PROSHERE", driver.getTitle());
        driver.quit();
    }

    // Проверка перехода со страницы добавления компании назад (на страницу списка компаний)
    @Test
    public void testFromAddCompanyBack() {
        driver.get("http://localhost:8080/addcompany");
        WebElement backLink = driver.findElement(By.xpath("//img[@alt='Назад']"));
        backLink.click();
        assertEquals("Компании", driver.getTitle());
        driver.quit();
    }

    // Проверка списка всех компаний
    @Test
    public void testCompaniesList() {
        driver.get("http://localhost:8080/companies");

        assertEquals("Компании", driver.getTitle());

        WebElement companiesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = companiesTable.findElements(By.tagName("td"));

        assertEquals("VK", items.get(0).getText());
        assertEquals("Ozon", items.get(2).getText());
        assertEquals("Тинькофф", items.get(4).getText());
        assertEquals("Яндекс", items.get(6).getText());

        assertEquals(8, items.size());

        driver.quit();
    }

    // Проверка перехода со страницы списка всех компаних на страницу конкретной компании
    @Test
    public void testCompany() {
        driver.get("http://localhost:8080/companies");

        assertEquals("Компании", driver.getTitle());
        WebElement detailsButton = driver.findElement(By.xpath("//table/tbody/tr[4]/td/form/button"));
        detailsButton.click();
        assertEquals("Информация о компании", driver.getTitle());

        driver.quit();
    }

    // Проверка списка всех вакансий компании
    @Test
    public void testCompanyVacancies() {
        driver.get("http://localhost:8080/company?companyId=4");

        assertEquals("Информация о компании", driver.getTitle());

        WebElement vacanciesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = vacanciesTable.findElements(By.tagName("td"));

        assertEquals("Аналитик данных", items.get(0).getText());
        assertEquals("150000", items.get(1).getText());

        assertEquals("Архитектор информационных систем", items.get(3).getText());
        assertEquals("180000", items.get(4).getText());

        assertEquals("Дизайнер пользовательских интерфейсов", items.get(6).getText());
        assertEquals("120000", items.get(7).getText());

        assertEquals("Менеджер по развитию рекламных технологий", items.get(9).getText());
        assertEquals("", items.get(10).getText());

        assertEquals("Специалист по машинному обучению", items.get(12).getText());
        assertEquals("250000", items.get(13).getText());

        assertEquals(15, items.size());

        driver.quit();
    }

    // Проверка перехода со страницы компании на главную страницу
    @Test
    public void testFromCompanyToMainPage() {
        driver.get("http://localhost:8080/company?companyId=4");
        WebElement homeLink = driver.findElement(By.xpath("//img[@alt='Домой']"));
        homeLink.click();
        assertEquals("PROSHERE", driver.getTitle());
        driver.quit();
    }

    // Проверка перехода со страницы компании назад (на страницу списка компаний)
    @Test
    public void testFromCompanyBack() {
        driver.get("http://localhost:8080/company?companyId=4");
        WebElement backLink = driver.findElement(By.xpath("//img[@alt='Назад']"));
        backLink.click();
        assertEquals("Компании", driver.getTitle());
        driver.quit();
    }

    // Проверка корректного добавления и удаления компании
    @Test
    public void testAddDeleteCompany() {
        driver.get("http://localhost:8080/companies");

        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Добавить')]"));
        addButton.click();
        assertEquals("Добавление компании", driver.getTitle());

        WebElement nameInput = driver.findElement(By.id("name"));
        nameInput.sendKeys("Сбер");

        WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'Сохранить')]"));
        saveButton.click();

        WebElement companiesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = companiesTable.findElements(By.tagName("td"));
        assertEquals("Компании", driver.getTitle());
        assertEquals("VK", items.get(0).getText());
        assertEquals("Ozon", items.get(2).getText());
        assertEquals("Тинькофф", items.get(4).getText());
        assertEquals("Яндекс", items.get(6).getText());
        assertEquals("Сбер", items.get(8).getText());
        assertEquals(10, items.size());

        WebElement detailsButton = driver.findElement(By.xpath("//table/tbody/tr[5]/td/form/button"));
        detailsButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(text(),'Удалить компанию')]"));
        deleteButton.click();

        assertEquals("Компании", driver.getTitle());
        companiesTable = driver.findElement(By.tagName("table"));
        items = companiesTable.findElements(By.tagName("td"));
        assertEquals("Компании", driver.getTitle());
        assertEquals(items.size(), 8);
        assertEquals("VK", items.get(0).getText());
        assertEquals("Ozon", items.get(2).getText());
        assertEquals("Тинькофф", items.get(4).getText());
        assertEquals("Яндекс", items.get(6).getText());
        assertEquals(8, items.size());

        driver.quit();
    }

    // Проверка некорректного и корректного добавления вакансии
    @Test
    public void testAddVacancy() {
        driver.get("http://localhost:8080/companies");

        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Добавить')]"));
        addButton.click();
        assertEquals("Добавление компании", driver.getTitle());

        WebElement nameInput = driver.findElement(By.id("name"));
        nameInput.sendKeys("Сбер");

        WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'Сохранить')]"));
        saveButton.click();

        WebElement companiesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = companiesTable.findElements(By.tagName("td"));
        assertEquals("Компании", driver.getTitle());
        assertEquals("VK", items.get(0).getText());
        assertEquals("Ozon", items.get(2).getText());
        assertEquals("Тинькофф", items.get(4).getText());
        assertEquals("Яндекс", items.get(6).getText());
        assertEquals("Сбер", items.get(8).getText());
        assertEquals(10, items.size() );

        WebElement detailsButton = driver.findElement(By.xpath("//table/tbody/tr[5]/td/form/button"));
        detailsButton.click();

        WebElement addButton2 = driver.findElement(By.xpath("//button[contains(text(),'Добавить вакансию')]"));
        addButton2.click();

        assertEquals("Добавление вакансии", driver.getTitle());

        // Пустая форма
        WebElement saveButton2 = driver.findElement(By.xpath("//button[contains(text(),'Сохранить')]"));
        saveButton2.click();
        // Получаем уведомление об ошибке
        WebElement errorButton = driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
        errorButton.click();

        // Указание должности
        WebElement positionDropdownButton = driver.findElement(By.id("positionDropdownADD"));
        positionDropdownButton.click();
        WebElement Option = driver.findElement(By.xpath("//a[@class='dropdown-item position-item' and text()='Аналитик данных']"));
        Option.click();

        // Указание специальности
        WebElement specialtyDropdownButton = driver.findElement(By.id("specialtyDropdownADD"));
        specialtyDropdownButton.click();
        Option = driver.findElement(By.xpath("//a[@class='dropdown-item specialty-item' and text()='Прикладная математика и информатика']"));
        Option.click();

        // Указание стажа
        WebElement expInput = driver.findElement(By.id("exp"));
        expInput.sendKeys("1");

        // Указание зарплаты
        WebElement salaryInput = driver.findElement(By.id("salary"));
        salaryInput.sendKeys("150000");

        saveButton2.click();

        assertEquals("Информация о компании", driver.getTitle());
        WebElement vacanciesTable = driver.findElement(By.tagName("table"));
        items = vacanciesTable.findElements(By.tagName("td"));

        assertEquals("Аналитик данных", items.get(0).getText());
        assertEquals("150000", items.get(1).getText());
        assertEquals(3, items.size());

        driver.quit();
    }

    // Проверка перехода со страницы добавления вакансии на главную страницу
    @Test
    public void testFromAddVacancyToMainPage() {
        driver.get("http://localhost:8080/companies");

        assertEquals("Компании", driver.getTitle());
        WebElement detailsButton = driver.findElement(By.xpath("//table/tbody/tr[5]/td/form/button"));
        detailsButton.click();
        assertEquals("Информация о компании", driver.getTitle());

        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Добавить')]"));
        addButton.click();
        assertEquals("Добавление вакансии", driver.getTitle());

        WebElement homeLink = driver.findElement(By.xpath("//img[@alt='Домой']"));
        homeLink.click();
        assertEquals("PROSHERE", driver.getTitle());
        driver.quit();
    }

    // Проверка перехода со страницы добавления вакансии назад (на страницу компании)
    @Test
    public void testFromAddVacancyBack() {
        driver.get("http://localhost:8080/companies");

        assertEquals("Компании", driver.getTitle());

        WebElement detailsButton = driver.findElement(By.xpath("//table/tbody/tr[5]/td/form/button"));
        detailsButton.click();
        assertEquals("Информация о компании", driver.getTitle());


        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Добавить')]"));
        addButton.click();
        assertEquals("Добавление вакансии", driver.getTitle());

        WebElement backLink = driver.findElement(By.xpath("//img[@alt='Назад']"));
        backLink.click();
        assertEquals("Информация о компании", driver.getTitle());

        WebElement vacanciesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = vacanciesTable.findElements(By.tagName("td"));

        assertEquals("Аналитик данных", items.get(0).getText());
        assertEquals("150000", items.get(1).getText());
        driver.quit();
    }


    // Проверка перехода со страницы компании на страницу вакансии
    @Test
    public void testFromCompanyToVacancy() {
        driver.get("http://localhost:8080/companies");

        assertEquals("Компании", driver.getTitle());
        WebElement detailsButton = driver.findElement(By.xpath("//table/tbody/tr[5]/td/form/button"));
        detailsButton.click();

        assertEquals("Информация о компании", driver.getTitle());
        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Подробнее')]"));
        addButton.click();

        assertEquals("Информация о вакансии", driver.getTitle());
        WebElement companyElement = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals("Сбер", companyElement.getText());
        WebElement positionElement = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        assertEquals("Аналитик данных", positionElement.getText());
        WebElement educationElement = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        assertEquals("Прикладная математика и информатика", educationElement.getText());
        WebElement experienceElement = driver.findElement(By.xpath("//table//tr[4]//td[2]"));
        assertEquals("1", experienceElement.getText());
        WebElement salaryElement = driver.findElement(By.xpath("//table//tr[5]//td[2]"));
        assertEquals("150000", salaryElement.getText());

        driver.quit();
    }

    // Проверка редактирования вакансии
    @Test
    public void testEditVacancy() {
        driver.get("http://localhost:8080/companies");

        assertEquals("Компании", driver.getTitle());

        WebElement detailsButton = driver.findElement(By.xpath("//table/tbody/tr[5]/td/form/button"));
        detailsButton.click();
        assertEquals("Информация о компании", driver.getTitle());
        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Подробнее')]"));
        addButton.click();

        assertEquals("Информация о вакансии", driver.getTitle());
        WebElement companyElement = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals("Сбер", companyElement.getText());
        WebElement positionElement = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        assertEquals("Аналитик данных", positionElement.getText());
        WebElement educationElement = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        assertEquals("Прикладная математика и информатика", educationElement.getText());
        WebElement experienceElement = driver.findElement(By.xpath("//table//tr[4]//td[2]"));
        assertEquals("1", experienceElement.getText());
        WebElement salaryElement = driver.findElement(By.xpath("//table//tr[5]//td[2]"));
        assertEquals("150000", salaryElement.getText());

        WebElement editButton = driver.findElement(By.xpath("//button[contains(text(),'Редактировать')]"));
        editButton.click();
        assertEquals("Редактирование вакансии", driver.getTitle());
        WebElement expInput = driver.findElement(By.id("newExperienceInput"));
        expInput.clear();
        expInput.sendKeys("2");
        WebElement salaryInput = driver.findElement(By.id("newSalaryInput"));
        salaryInput.clear();
        salaryInput.sendKeys("140000");
        WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'Сохранить')]"));
        saveButton.click();

        assertEquals("Информация о вакансии", driver.getTitle());
        companyElement = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals("Сбер", companyElement.getText());
        positionElement = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        assertEquals("Аналитик данных", positionElement.getText());
        educationElement = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        assertEquals("Прикладная математика и информатика", educationElement.getText());
        experienceElement = driver.findElement(By.xpath("//table//tr[4]//td[2]"));
        assertEquals("2", experienceElement.getText());
        salaryElement = driver.findElement(By.xpath("//table//tr[5]//td[2]"));
        assertEquals("140000", salaryElement.getText());

        driver.quit();
    }

    // Проверка перехода со страницы вакансии на страницу подходящего резюме
    @Test
    public void testSuitableResume() {
        driver.get("http://localhost:8080/companies");

        assertEquals("Компании", driver.getTitle());
        WebElement detailsButton = driver.findElement(By.xpath("//table/tbody/tr[5]/td/form/button"));
        detailsButton.click();
        assertEquals("Информация о компании", driver.getTitle());
        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Подробнее')]"));
        addButton.click();

        assertEquals("Информация о вакансии", driver.getTitle());
        WebElement companyElement = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals("Сбер", companyElement.getText());
        WebElement positionElement = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        assertEquals("Аналитик данных", positionElement.getText());
        WebElement educationElement = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        assertEquals("Прикладная математика и информатика", educationElement.getText());
        WebElement experienceElement = driver.findElement(By.xpath("//table//tr[4]//td[2]"));
        assertEquals("2", experienceElement.getText());
        WebElement salaryElement = driver.findElement(By.xpath("//table//tr[5]//td[2]"));
        assertEquals("140000", salaryElement.getText());

        WebElement suitableResume = driver.findElement(By.xpath("//button[contains(text(),'Подробнее')]"));
        suitableResume.click();

        assertEquals("Информация о соискателе", driver.getTitle());
        WebElement lastname = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals("Иванова", lastname.getText());
        WebElement firstname = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        assertEquals("Анна", firstname.getText());
        WebElement middlename = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        assertEquals("Сергеевна", middlename.getText());

        driver.quit();
    }

    // Проверка перехода со страницы подходящего резюме на главную страницу
    @Test
    public void testFromSuitableResumeToMainPage() {
        driver.get("http://localhost:8080/companies");

        assertEquals("Компании", driver.getTitle());
        WebElement detailsButton = driver.findElement(By.xpath("//table/tbody/tr[5]/td/form/button"));
        detailsButton.click();
        assertEquals("Информация о компании", driver.getTitle());
        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Подробнее')]"));
        addButton.click();

        assertEquals("Информация о вакансии", driver.getTitle());
        WebElement companyElement = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals("Сбер", companyElement.getText());
        WebElement positionElement = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        assertEquals("Аналитик данных", positionElement.getText());
        WebElement educationElement = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        assertEquals("Прикладная математика и информатика", educationElement.getText());
        WebElement experienceElement = driver.findElement(By.xpath("//table//tr[4]//td[2]"));
        assertEquals("2", experienceElement.getText());
        WebElement salaryElement = driver.findElement(By.xpath("//table//tr[5]//td[2]"));
        assertEquals("140000", salaryElement.getText());

        WebElement suitableResume = driver.findElement(By.xpath("//button[contains(text(),'Подробнее')]"));
        suitableResume.click();

        assertEquals("Информация о соискателе", driver.getTitle());
        WebElement lastname = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals("Иванова", lastname.getText());
        WebElement firstname = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        assertEquals("Анна", firstname.getText());
        WebElement middlename = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        assertEquals("Сергеевна", middlename.getText());

        WebElement homeLink = driver.findElement(By.xpath("//img[@alt='Домой']"));
        homeLink.click();
        assertEquals("PROSHERE", driver.getTitle());

        driver.quit();
    }

    // Проверка перехода со страницы подходящего резюме назад (на страницу вакансии)
    @Test
    public void testFromSuitableResumeBack() {
        driver.get("http://localhost:8080/companies");

        assertEquals("Компании", driver.getTitle());
        WebElement detailsButton = driver.findElement(By.xpath("//table/tbody/tr[5]/td/form/button"));
        detailsButton.click();
        assertEquals("Информация о компании", driver.getTitle());
        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Подробнее')]"));
        addButton.click();

        assertEquals("Информация о вакансии", driver.getTitle());
        WebElement companyElement = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals("Сбер", companyElement.getText());
        WebElement positionElement = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        assertEquals("Аналитик данных", positionElement.getText());
        WebElement educationElement = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        assertEquals("Прикладная математика и информатика", educationElement.getText());
        WebElement experienceElement = driver.findElement(By.xpath("//table//tr[4]//td[2]"));
        assertEquals("2", experienceElement.getText());
        WebElement salaryElement = driver.findElement(By.xpath("//table//tr[5]//td[2]"));
        assertEquals("140000", salaryElement.getText());

        WebElement suitableResume = driver.findElement(By.xpath("//button[contains(text(),'Подробнее')]"));
        suitableResume.click();

        assertEquals("Информация о соискателе", driver.getTitle());
        WebElement lastname = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals("Иванова", lastname.getText());
        WebElement firstname = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        assertEquals("Анна", firstname.getText());
        WebElement middlename = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        assertEquals("Сергеевна", middlename.getText());

        WebElement backLink = driver.findElement(By.xpath("//img[@alt='Назад']"));
        backLink.click();
        assertEquals("Информация о вакансии", driver.getTitle());

        companyElement = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals("Сбер", companyElement.getText());
        positionElement = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        assertEquals("Аналитик данных", positionElement.getText());
        educationElement = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        assertEquals("Прикладная математика и информатика", educationElement.getText());
        experienceElement = driver.findElement(By.xpath("//table//tr[4]//td[2]"));
        assertEquals("2", experienceElement.getText());
        salaryElement = driver.findElement(By.xpath("//table//tr[5]//td[2]"));
        assertEquals("140000", salaryElement.getText());

        driver.quit();
    }

    // Проверка перехода со страницы редактирования вакансии на главную
    @Test
    public void testFromEditVacancyToMainPage() {
        driver.get("http://localhost:8080/companies");

        assertEquals("Компании", driver.getTitle());

        WebElement detailsButton = driver.findElement(By.xpath("//table/tbody/tr[5]/td/form/button"));
        detailsButton.click();
        assertEquals("Информация о компании", driver.getTitle());
        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Подробнее')]"));
        addButton.click();

        assertEquals("Информация о вакансии", driver.getTitle());
        WebElement companyElement = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals("Сбер", companyElement.getText());
        WebElement positionElement = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        assertEquals("Аналитик данных", positionElement.getText());
        WebElement educationElement = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        assertEquals("Прикладная математика и информатика", educationElement.getText());
        WebElement experienceElement = driver.findElement(By.xpath("//table//tr[4]//td[2]"));
        assertEquals("2", experienceElement.getText());
        WebElement salaryElement = driver.findElement(By.xpath("//table//tr[5]//td[2]"));
        assertEquals("140000", salaryElement.getText());

        WebElement editButton = driver.findElement(By.xpath("//button[contains(text(),'Редактировать')]"));
        editButton.click();
        assertEquals("Редактирование вакансии", driver.getTitle());

        WebElement homeLink = driver.findElement(By.xpath("//img[@alt='Домой']"));
        homeLink.click();
        assertEquals("PROSHERE", driver.getTitle());
        
        driver.quit();
    }

    // Проверка перехода со страницы редактирования вакансии назад (на страницу вакансии)
    @Test
    public void testFromEditVacancyBack() {
        driver.get("http://localhost:8080/companies");

        assertEquals("Компании", driver.getTitle());

        WebElement detailsButton = driver.findElement(By.xpath("//table/tbody/tr[5]/td/form/button"));
        detailsButton.click();
        assertEquals("Информация о компании", driver.getTitle());
        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Подробнее')]"));
        addButton.click();

        assertEquals("Информация о вакансии", driver.getTitle());
        WebElement companyElement = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals("Сбер", companyElement.getText());
        WebElement positionElement = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        assertEquals("Аналитик данных", positionElement.getText());
        WebElement educationElement = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        assertEquals("Прикладная математика и информатика", educationElement.getText());
        WebElement experienceElement = driver.findElement(By.xpath("//table//tr[4]//td[2]"));
        assertEquals("2", experienceElement.getText());
        WebElement salaryElement = driver.findElement(By.xpath("//table//tr[5]//td[2]"));
        assertEquals("140000", salaryElement.getText());

        WebElement editButton = driver.findElement(By.xpath("//button[contains(text(),'Редактировать')]"));
        editButton.click();
        assertEquals("Редактирование вакансии", driver.getTitle());

        WebElement homeLink = driver.findElement(By.xpath("//img[@alt='Назад']"));
        homeLink.click();
        companyElement = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals("Сбер", companyElement.getText());
        positionElement = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        assertEquals("Аналитик данных", positionElement.getText());
        educationElement = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        assertEquals("Прикладная математика и информатика", educationElement.getText());
        experienceElement = driver.findElement(By.xpath("//table//tr[4]//td[2]"));
        assertEquals("2", experienceElement.getText());
        salaryElement = driver.findElement(By.xpath("//table//tr[5]//td[2]"));
        assertEquals("140000", salaryElement.getText());
        
        driver.quit();
    }

    // Проверка удаления вакансии и компании
    @Test
    public void testDeleteVacancy() {
        driver.get("http://localhost:8080/companies");

        assertEquals("Компании", driver.getTitle());

        WebElement detailsButton = driver.findElement(By.xpath("//table/tbody/tr[5]/td/form/button"));
        detailsButton.click();
        assertEquals("Информация о компании", driver.getTitle());
        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Подробнее')]"));
        addButton.click();

        assertEquals("Информация о вакансии", driver.getTitle());
        WebElement companyElement = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals("Сбер", companyElement.getText());
        WebElement positionElement = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        assertEquals("Аналитик данных", positionElement.getText());
        WebElement educationElement = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        assertEquals("Прикладная математика и информатика", educationElement.getText());
        WebElement experienceElement = driver.findElement(By.xpath("//table//tr[4]//td[2]"));
        assertEquals("2", experienceElement.getText());
        WebElement salaryElement = driver.findElement(By.xpath("//table//tr[5]//td[2]"));
        assertEquals("140000", salaryElement.getText());

        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(text(),'Удалить')]"));
        deleteButton.click();
        assertEquals("Информация о компании", driver.getTitle());

        WebElement vacanciesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = vacanciesTable.findElements(By.tagName("td"));
        assertEquals(0, items.size());

        deleteButton = driver.findElement(By.xpath("//button[contains(text(),'Удалить')]"));
        deleteButton.click();

        driver.quit();
    }

//_____________________________________________________________________________________________________



    // Проверка перехода на страницу списка всех резюме
    @Test
    public void testResumes(){
        driver.get("http://localhost:8080/");
        WebElement gotovacancies = driver.findElement(By.linkText("Резюме"));
        gotovacancies.click();
        String title = driver.getTitle();
        assertEquals("Резюме", title);
        driver.quit();
    }

    // Проверка перехода со страницы всех резюме на главную страницу
    @Test
    public void testFromResumesToMainPage() {
        driver.get("http://localhost:8080/resumes");
        WebElement homeLink = driver.findElement(By.xpath("//img[@alt='Домой']"));
        homeLink.click();
        assertEquals("PROSHERE", driver.getTitle());
        driver.quit();
    }

    // Проверка перехода со страницы всех вакансий назад (на главную страницу)
    @Test
    public void testFromResumesBack() {
        driver.get("http://localhost:8080/resumes");
        WebElement backLink = driver.findElement(By.xpath("//img[@alt='Назад']"));
        backLink.click();
        assertEquals("PROSHERE", driver.getTitle());
        driver.quit();
    }

    // Проверка списка всех резюме
    @Test
    public void testResumesList() {
        driver.get("http://localhost:8080/resumes");

        WebElement resumesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = resumesTable.findElements(By.tagName("td"));

        assertEquals("Ковалев", items.get(0).getText());
        assertEquals("Андрей", items.get(1).getText());
        assertEquals("Специалист по машинному обучению", items.get(2).getText());
        assertEquals("", items.get(3).getText());

        assertEquals("Смирнова", items.get(5).getText());
        assertEquals("Елена", items.get(6).getText());
        assertEquals("Архитектор информационных систем", items.get(7).getText());
        assertEquals("", items.get(8).getText());

        assertEquals("Соколов", items.get(10).getText());
        assertEquals("Алексей", items.get(11).getText());
        assertEquals("Специалист по информационной безопасности и защите данных", items.get(12).getText());
        assertEquals("", items.get(13).getText());

        assertEquals("Козлов", items.get(15).getText());
        assertEquals("Иван", items.get(16).getText());
        assertEquals("Архитектор информационных систем", items.get(17).getText());
        assertEquals("200000", items.get(18).getText());

        assertEquals("Новикова", items.get(20).getText());
        assertEquals("Ольга", items.get(21).getText());
        assertEquals("Специалист по информационной безопасности и защите данных", items.get(22).getText());
        assertEquals("140000", items.get(23).getText());

        assertEquals("Петров", items.get(25).getText());
        assertEquals("Дмитрий", items.get(26).getText());
        assertEquals("Аналитик данных", items.get(27).getText());
        assertEquals("150000", items.get(28).getText());

        assertEquals("Федорова", items.get(30).getText());
        assertEquals("Мария", items.get(31).getText());
        assertEquals("Дизайнер пользовательских интерфейсов", items.get(32).getText());
        assertEquals("100000", items.get(33).getText());

        assertEquals("Морозов", items.get(35).getText());
        assertEquals("Артем", items.get(36).getText());
        assertEquals("Разработчик мобильных приложений", items.get(37).getText());
        assertEquals("120000", items.get(38).getText());

        assertEquals("Васильева", items.get(40).getText());
        assertEquals("Светлана", items.get(41).getText());
        assertEquals("Менеджер по развитию рекламных технологий", items.get(42).getText());
        assertEquals("100000", items.get(43).getText());

        assertEquals("Иванова", items.get(45).getText());
        assertEquals("Анна", items.get(46).getText());
        assertEquals("Аналитик данных", items.get(47).getText());
        assertEquals("120000", items.get(48).getText());

        assertEquals(50, items.size());

        driver.quit();
    }

    // Проверка фильтрации резюме без заданных параметров
    @Test
    public void testResumesFilter() {
        driver.get("http://localhost:8080/resumes");

        WebElement applyFilterButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']"));
        applyFilterButton.click();

        WebElement resumesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = resumesTable.findElements(By.tagName("td"));

        assertEquals("Ковалев", items.get(0).getText());
        assertEquals("Андрей", items.get(1).getText());
        assertEquals("Специалист по машинному обучению", items.get(2).getText());
        assertEquals("", items.get(3).getText());

        assertEquals("Смирнова", items.get(5).getText());
        assertEquals("Елена", items.get(6).getText());
        assertEquals("Архитектор информационных систем", items.get(7).getText());
        assertEquals("", items.get(8).getText());

        assertEquals("Соколов", items.get(10).getText());
        assertEquals("Алексей", items.get(11).getText());
        assertEquals("Специалист по информационной безопасности и защите данных", items.get(12).getText());
        assertEquals("", items.get(13).getText());

        assertEquals("Козлов", items.get(15).getText());
        assertEquals("Иван", items.get(16).getText());
        assertEquals("Архитектор информационных систем", items.get(17).getText());
        assertEquals("200000", items.get(18).getText());

        assertEquals("Новикова", items.get(20).getText());
        assertEquals("Ольга", items.get(21).getText());
        assertEquals("Специалист по информационной безопасности и защите данных", items.get(22).getText());
        assertEquals("140000", items.get(23).getText());

        assertEquals("Петров", items.get(25).getText());
        assertEquals("Дмитрий", items.get(26).getText());
        assertEquals("Аналитик данных", items.get(27).getText());
        assertEquals("150000", items.get(28).getText());

        assertEquals("Федорова", items.get(30).getText());
        assertEquals("Мария", items.get(31).getText());
        assertEquals("Дизайнер пользовательских интерфейсов", items.get(32).getText());
        assertEquals("100000", items.get(33).getText());

        assertEquals("Морозов", items.get(35).getText());
        assertEquals("Артем", items.get(36).getText());
        assertEquals("Разработчик мобильных приложений", items.get(37).getText());
        assertEquals("120000", items.get(38).getText());

        assertEquals("Васильева", items.get(40).getText());
        assertEquals("Светлана", items.get(41).getText());
        assertEquals("Менеджер по развитию рекламных технологий", items.get(42).getText());
        assertEquals("100000", items.get(43).getText());

        assertEquals("Иванова", items.get(45).getText());
        assertEquals("Анна", items.get(46).getText());
        assertEquals("Аналитик данных", items.get(47).getText());
        assertEquals("120000", items.get(48).getText());

        assertEquals(50, items.size());

        driver.quit();
    }

    // Проверка фильтрации резюме по компаниям
    @Test
    public void testResumesFilterByCompany() {
        driver.get("http://localhost:8080/resumes");

        WebElement companyDropdownButton = driver.findElement(By.id("companyDropdownRES"));
        companyDropdownButton.click();

        WebElement Option = driver.findElement(By.xpath("//a[@class='dropdown-item company-item' and text()='Яндекс']"));
        Option.click();

        WebElement applyFilterButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']"));
        applyFilterButton.click();

        WebElement resumesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = resumesTable.findElements(By.tagName("td"));

        assertEquals("Иванова", items.get(0).getText());
        assertEquals("Анна", items.get(1).getText());
        assertEquals("Аналитик данных", items.get(2).getText());
        assertEquals("120000", items.get(3).getText());

        assertEquals("Петров", items.get(5).getText());
        assertEquals("Дмитрий", items.get(6).getText());
        assertEquals("Аналитик данных", items.get(7).getText());
        assertEquals("150000", items.get(8).getText());

        assertEquals("Новикова", items.get(10).getText());
        assertEquals("Ольга", items.get(11).getText());
        assertEquals("Специалист по информационной безопасности и защите данных", items.get(12).getText());
        assertEquals("140000", items.get(13).getText());

        assertEquals("Морозов", items.get(15).getText());
        assertEquals("Артем", items.get(16).getText());
        assertEquals("Разработчик мобильных приложений", items.get(17).getText());
        assertEquals("120000", items.get(18).getText());

        assertEquals("Ковалев", items.get(20).getText());
        assertEquals("Андрей", items.get(21).getText());
        assertEquals("Специалист по машинному обучению", items.get(22).getText());
        assertEquals("", items.get(23).getText());

        assertEquals(25, items.size());

        driver.quit();
    }

    // Проверка фильтрации резюме по должностям
    @Test
    public void testResumesFilterByPositions() {
        driver.get("http://localhost:8080/resumes");

        WebElement positionDropdownButton = driver.findElement(By.id("positionDropdownRES"));
        positionDropdownButton.click();

        WebElement Option = driver.findElement(By.xpath("//a[@class='dropdown-item position-item' and text()='Архитектор информационных систем']"));
        Option.click();

        WebElement applyFilterButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']"));
        applyFilterButton.click();

        WebElement resumesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = resumesTable.findElements(By.tagName("td"));

        assertEquals("Смирнова", items.get(0).getText());
        assertEquals("Елена", items.get(1).getText());
        assertEquals("Архитектор информационных систем", items.get(2).getText());
        assertEquals("", items.get(3).getText());

        assertEquals("Козлов", items.get(5).getText());
        assertEquals("Иван", items.get(6).getText());
        assertEquals("Архитектор информационных систем", items.get(7).getText());
        assertEquals("200000", items.get(8).getText());

        assertEquals(10, items.size());

        driver.quit();
    }

    // Проверка фильтрации резюме по специальностям
    @Test
    public void testResumesFilterBySpecialities() {
        driver.get("http://localhost:8080/resumes");

        WebElement positionDropdownButton = driver.findElement(By.id("specialtyDropdownRES"));
        positionDropdownButton.click();

        WebElement Option = driver.findElement(By.xpath("//a[@class='dropdown-item specialty-item' and text()='Прикладная математика и информатика']"));
        Option.click();

        WebElement applyFilterButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']"));
        applyFilterButton.click();

        WebElement resumesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = resumesTable.findElements(By.tagName("td"));

        assertEquals("Иванова", items.get(0).getText());
        assertEquals("Анна", items.get(1).getText());
        assertEquals("Аналитик данных", items.get(2).getText());
        assertEquals("120000", items.get(3).getText());

        assertEquals("Петров", items.get(5).getText());
        assertEquals("Дмитрий", items.get(6).getText());
        assertEquals("Аналитик данных", items.get(7).getText());
        assertEquals("150000", items.get(8).getText());

        assertEquals("Козлов", items.get(10).getText());
        assertEquals("Иван", items.get(11).getText());
        assertEquals("Архитектор информационных систем", items.get(12).getText());
        assertEquals("200000", items.get(13).getText());

        assertEquals("Ковалев", items.get(15).getText());
        assertEquals("Андрей", items.get(16).getText());
        assertEquals("Специалист по машинному обучению", items.get(17).getText());
        assertEquals("", items.get(18).getText());

        assertEquals(20, items.size());

        driver.quit();
    }

    // Проверка фильтрации резюме по минимальной зарплате
    @Test
    public void testResumesFilterByMinSalary() {
        driver.get("http://localhost:8080/resumes");

        WebElement minSalaryInput = driver.findElement(By.id("minSalaryRES"));
        minSalaryInput.sendKeys("150000");

        WebElement applyFilterButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']"));
        applyFilterButton.click();

        WebElement resumesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = resumesTable.findElements(By.tagName("td"));

        assertEquals("Козлов", items.get(0).getText());
        assertEquals("Иван", items.get(1).getText());
        assertEquals("Архитектор информационных систем", items.get(2).getText());
        assertEquals("200000", items.get(3).getText());

        assertEquals("Петров", items.get(5).getText());
        assertEquals("Дмитрий", items.get(6).getText());
        assertEquals("Аналитик данных", items.get(7).getText());
        assertEquals("150000", items.get(8).getText());

        assertEquals(10, items.size());

        driver.quit();
    }

    // Проверка фильтрации резюме по минимальной зарплате
    @Test
    public void testResumesFilterByMaxSalary() {
        driver.get("http://localhost:8080/resumes");

        WebElement minSalaryInput = driver.findElement(By.id("maxSalaryRES"));
        minSalaryInput.sendKeys("120000");

        WebElement applyFilterButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']"));
        applyFilterButton.click();

        WebElement resumesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = resumesTable.findElements(By.tagName("td"));

        assertEquals("Федорова", items.get(0).getText());
        assertEquals("Мария", items.get(1).getText());
        assertEquals("Дизайнер пользовательских интерфейсов", items.get(2).getText());
        assertEquals("100000", items.get(3).getText());

        assertEquals("Морозов", items.get(5).getText());
        assertEquals("Артем", items.get(6).getText());
        assertEquals("Разработчик мобильных приложений", items.get(7).getText());
        assertEquals("120000", items.get(8).getText());

        assertEquals("Васильева", items.get(10).getText());
        assertEquals("Светлана", items.get(11).getText());
        assertEquals("Менеджер по развитию рекламных технологий", items.get(12).getText());
        assertEquals("100000", items.get(13).getText());

        assertEquals("Иванова", items.get(15).getText());
        assertEquals("Анна", items.get(16).getText());
        assertEquals("Аналитик данных", items.get(17).getText());
        assertEquals("120000", items.get(18).getText());

        assertEquals(20, items.size());

        driver.quit();
    }

    // Проверка перехода со страницы добавления резюме на главную страницу
    @Test
    public void testFromAddResumeToMainPage() {
        driver.get("http://localhost:8080/resumes");

        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Добавить')]"));
        addButton.click();
        assertEquals("Добавление резюме", driver.getTitle());

        WebElement homeLink = driver.findElement(By.xpath("//img[@alt='Домой']"));
        homeLink.click();
        assertEquals("PROSHERE", driver.getTitle());
        driver.quit();
    }

    // Проверка перехода со страницы добавления резюме назад (на страницу списка резюме)
    @Test
    public void testFromAddResumeBack() {
        driver.get("http://localhost:8080/resumes");

        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Добавить')]"));
        addButton.click();
        assertEquals("Добавление резюме", driver.getTitle());

        WebElement homeLink = driver.findElement(By.xpath("//img[@alt='Назад']"));
        homeLink.click();
        assertEquals("Резюме", driver.getTitle());
        driver.quit();
    }

    // Проверка некорректного и корректного добавления резюме
    @Test
    public void testAddDeleteResume() {
        driver.get("http://localhost:8080/resumes");

        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Добавить')]"));
        addButton.click();
        assertEquals("Добавление резюме", driver.getTitle());

        // Получение уведомления об ошибке - необходимо указать ФИО, адрес и должность
        WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'Сохранить')]"));
        saveButton.click();
        assertEquals("Добавление резюме", driver.getTitle());

        WebElement Input;
        Input = driver.findElement(By.id("lastname"));
        Input.sendKeys("Пушкин");
        Input = driver.findElement(By.id("firstname"));
        Input.sendKeys("Александр");
        Input = driver.findElement(By.id("middlename"));
        Input.sendKeys("Сергеевич");
        Input = driver.findElement(By.id("street"));
        Input.sendKeys("Арбат");
        Input = driver.findElement(By.id("building"));
        Input.sendKeys("10");
        Input = driver.findElement(By.id("apartment"));
        Input.sendKeys("5");
        Input = driver.findElement(By.id("salary"));
        Input.sendKeys("100000");

        // Необходимо еще указать должность
        saveButton.click();
        WebElement errorButton = driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
        errorButton.click();

        WebElement positionDropdownButton = driver.findElement(By.id("positionDropdown"));
        positionDropdownButton.click();
        WebElement Option = driver.findElement(By.xpath("//a[@class='dropdown-item position-item' and text()='Дизайнер пользовательских интерфейсов']"));
        Option.click();

        saveButton.click();
        assertEquals("Резюме", driver.getTitle());

        WebElement resumesTable = driver.findElement(By.tagName("table"));
        List<WebElement> items = resumesTable.findElements(By.tagName("td"));

        Integer added = 0;
        Integer n = items.size();

        for (int i = 0; i < n; i += 5) {
            if (items.get(i).getText().equals("Пушкин") && 
                items.get(i + 1).getText().equals("Александр") && 
                items.get(i + 2).getText().equals("Дизайнер пользовательских интерфейсов") && 
                items.get(i + 3).getText().equals("100000")) {
                added = 1;
                break;
            }
        }

        assertEquals(1, added);
    
        driver.quit();
    }

    // Проверка перехода со страницы списка резюме на страницу конкретного резюме
    @Test
    public void testChooseResume() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Арбат, 10, 5", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        driver.quit();
    }

    // Проверка перехода со страницы резюме на главную страницу
    @Test
    public void testFromResumeToMainPage() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Арбат, 10, 5", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement homeLink = driver.findElement(By.xpath("//img[@alt='Домой']"));
        homeLink.click();
        assertEquals("PROSHERE", driver.getTitle());

        driver.quit();
    }

    // Проверка перехода со страницы резюме назад (на страницу списка резюме)
    @Test
    public void testFromResumeBack() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Арбат, 10, 5", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement backLink = driver.findElement(By.xpath("//img[@alt='Назад']"));
        backLink.click();
        assertEquals("Резюме", driver.getTitle());

        driver.quit();
    }

    // Проверка редактирования личных данных резюме
    @Test
    public void testEditResume() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Арбат, 10, 5", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement editButton = driver.findElement(By.xpath("//button[contains(text(),'Редактировать личные данные')]"));
        editButton.click();

        assertEquals("Редактирование резюме", driver.getTitle());
        WebElement Input;

        Input = driver.findElement(By.id("street"));
        Input.clear();
        Input.sendKeys("Тверская");
        Input = driver.findElement(By.id("building"));
        Input.clear();
        Input.sendKeys("30");
        Input = driver.findElement(By.id("apartment"));
        Input.clear();
        Input.sendKeys("20");

        WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'Сохранить')]"));
        saveButton.click();

        assertEquals("Информация о соискателе", driver.getTitle());

        lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        driver.quit();
    }

    // Проверка перехода со страницы редактирования резюме на главную страницу
    @Test
    public void testFromEditResumeToMainPage() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement editButton = driver.findElement(By.xpath("//button[contains(text(),'Редактировать личные данные')]"));
        editButton.click();

        assertEquals("Редактирование резюме", driver.getTitle());

        WebElement homeLink = driver.findElement(By.xpath("//img[@alt='Домой']"));
        homeLink.click();
        assertEquals("PROSHERE", driver.getTitle());
        
        driver.quit();
    }

    // Проверка перехода со страницы редактирования резюме назад (на страницу резюме)
    @Test
    public void testFromEditResumeBack() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement editButton = driver.findElement(By.xpath("//button[contains(text(),'Редактировать личные данные')]"));
        editButton.click();

        assertEquals("Редактирование резюме", driver.getTitle());

        WebElement backLink = driver.findElement(By.xpath("//img[@alt='Назад']"));
        backLink.click();
        assertEquals("Информация о соискателе", driver.getTitle());

        lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());
        
        driver.quit();
    }

    // Проверка некорректного и корректного добавления образования
    @Test
    public void testAddEducation() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement editButton = driver.findElement(By.xpath("//button[contains(text(),'Добавить образование')]"));
        editButton.click();
        assertEquals("Добавление образования", driver.getTitle());

        WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'Сохранить')]"));
        saveButton.click();

        // Уведомление об ошибке - необходимо указать ВУЗ и специальность
        WebElement errorButton = driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
        errorButton.click();

        WebElement universityDropdownButton = driver.findElement(By.id("universityDropdown"));
        universityDropdownButton.click();
        WebElement Option = driver.findElement(By.xpath("//a[@class='dropdown-item university-item' and text()='МГУ имени М.В. Ломоносова']"));
        Option.click();

        WebElement specialityDropdownButton = driver.findElement(By.id("specialityDropdown"));
        specialityDropdownButton.click();
        Option = driver.findElement(By.xpath("//a[@class='dropdown-item speciality-item' and text()='Дизайн']"));
        Option.click();

        saveButton.click();

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement educationTable = driver.findElement(By.xpath("(//table)[2]"));
        WebElement universityElement = educationTable.findElement(By.xpath(".//tbody/tr[1]/td[1]"));
        WebElement specialityElement = educationTable.findElement(By.xpath(".//tbody/tr[1]/td[2]"));

        assertEquals("МГУ имени М.В. Ломоносова", universityElement.getText());
        assertEquals("Дизайн", specialityElement.getText());
   
        driver.quit();
    }

    // Проверка перехода со страницы добавления образования на главную страницу
    @Test
    public void testFromAddEducationToMainPage() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement editButton = driver.findElement(By.xpath("//button[contains(text(),'Добавить образование')]"));
        editButton.click();
        assertEquals("Добавление образования", driver.getTitle());

        WebElement homeLink = driver.findElement(By.xpath("//img[@alt='Домой']"));
        homeLink.click();
        assertEquals("PROSHERE", driver.getTitle());

        driver.quit();
    }

    // Проверка перехода со страницы добавления образования назад (на страницу резюме)
    @Test
    public void testFromAddEducationBack() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement editButton = driver.findElement(By.xpath("//button[contains(text(),'Добавить образование')]"));
        editButton.click();
        assertEquals("Добавление образования", driver.getTitle());

        WebElement backLink = driver.findElement(By.xpath("//img[@alt='Назад']"));
        backLink.click();

        assertEquals("Информация о соискателе", driver.getTitle());

        lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        driver.quit();
    }

    // Проверка удаления образования
    @Test
    public void testDeleteEducation() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement educationTable = driver.findElement(By.xpath("(//table)[2]"));
        WebElement deleteButton = educationTable.findElement(By.xpath(".//tbody/tr[1]/td[3]"));
        deleteButton.click();

        assertEquals("Информация о соискателе", driver.getTitle());

        lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        educationTable = driver.findElement(By.xpath("(//table)[2]"));
        java.util.List<WebElement> rows = educationTable.findElements(By.tagName("tr"));
        assertEquals(0, rows.size() - 1); // -1 так как посчитали заголовки

        driver.quit();
    }

    // Проверка некорректного и корректного добавления образования
    @Test
    public void testAddEducation2() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement editButton = driver.findElement(By.xpath("//button[contains(text(),'Добавить образование')]"));
        editButton.click();
        assertEquals("Добавление образования", driver.getTitle());

        WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'Сохранить')]"));
        saveButton.click();

        // Уведомление об ошибке - необходимо указать ВУЗ и специальность
        WebElement errorButton = driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
        errorButton.click();

        WebElement universityDropdownButton = driver.findElement(By.id("universityDropdown"));
        universityDropdownButton.click();
        WebElement Option = driver.findElement(By.xpath("//a[@class='dropdown-item university-item' and text()='МГУ имени М.В. Ломоносова']"));
        Option.click();

        WebElement specialityDropdownButton = driver.findElement(By.id("specialityDropdown"));
        specialityDropdownButton.click();
        Option = driver.findElement(By.xpath("//a[@class='dropdown-item speciality-item' and text()='Дизайн']"));
        Option.click();

        saveButton.click();

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement educationTable = driver.findElement(By.xpath("(//table)[2]"));
        WebElement universityElement = educationTable.findElement(By.xpath(".//tbody/tr[1]/td[1]"));
        WebElement specialityElement = educationTable.findElement(By.xpath(".//tbody/tr[1]/td[2]"));

        assertEquals("МГУ имени М.В. Ломоносова", universityElement.getText());
        assertEquals("Дизайн", specialityElement.getText());
   
        driver.quit();
    }


    // Проверка некорректного и корректного добавления трудоустройства
    @Test
    public void testAddWorkHistory() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement editButton = driver.findElement(By.xpath("//button[contains(text(),'Добавить трудоустройство')]"));
        editButton.click();
        assertEquals("Добавление трудоустройства", driver.getTitle());

        // Уведомление об ошибке - необходимо указать компанию, должность, зарплату, дату приема
        WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'Сохранить')]"));
        saveButton.click();

        WebElement salaryInput = driver.findElement(By.id("salary"));
        salaryInput.sendKeys("90000");

        WebElement startDateInput = driver.findElement(By.id("startDate"));
        startDateInput.sendKeys("2020-07-08");

        // Уведомление об ошибке - необходимо указать компанию и должность
        saveButton.click();
        WebElement errorButton = driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
        errorButton.click();

        WebElement companyDropdownButton = driver.findElement(By.id("companyDropdown"));
        companyDropdownButton.click();
        WebElement Option = driver.findElement(By.xpath("//a[@class='dropdown-item company-item' and text()='Тинькофф']"));
        Option.click();

        WebElement positionDropdownButton = driver.findElement(By.id("positionDropdown"));
        positionDropdownButton.click();
        Option = driver.findElement(By.xpath("//a[@class='dropdown-item position-item' and text()='Дизайнер пользовательских интерфейсов']"));
        Option.click();

        saveButton.click();

        assertEquals("Информация о соискателе", driver.getTitle());
        WebElement workTable = driver.findElement(By.xpath("(//table)[3]"));
        WebElement companyElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[1]"));
        WebElement positionElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[2]"));
        WebElement salaryElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[3]"));
        WebElement startDateElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[4]"));
        WebElement endDateElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[5]"));

        assertEquals("Тинькофф", companyElement1.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement1.getText());
        assertEquals("90000", salaryElement1.getText());
        assertEquals("2020-07-08", startDateElement1.getText());
        assertEquals("", endDateElement1.getText());
   
        driver.quit();
    }

    // Проверка перехода со страницы добавления трудоустройства на главную страницу
    @Test
    public void testFromAddWorkToMainPage() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement editButton = driver.findElement(By.xpath("//button[contains(text(),'Добавить трудоустройство')]"));
        editButton.click();
        assertEquals("Добавление трудоустройства", driver.getTitle());

        WebElement homeLink = driver.findElement(By.xpath("//img[@alt='Домой']"));
        homeLink.click();
        assertEquals("PROSHERE", driver.getTitle());

        driver.quit();
    }

    // Проверка перехода со страницы добавления образования назад (на страницу резюме)
    @Test
    public void testFromAddWorkBack() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement editButton = driver.findElement(By.xpath("//button[contains(text(),'Добавить трудоустройство')]"));
        editButton.click();
        assertEquals("Добавление трудоустройства", driver.getTitle());

        WebElement backLink = driver.findElement(By.xpath("//img[@alt='Назад']"));
        backLink.click();

        assertEquals("Информация о соискателе", driver.getTitle());

        lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        driver.quit();
    }

    // Проверка редактирования трудоустройства
    @Test
    public void testEditWorkHistory() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        assertEquals("Информация о соискателе", driver.getTitle());
        WebElement workTable = driver.findElement(By.xpath("(//table)[3]"));
        WebElement companyElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[1]"));
        WebElement positionElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[2]"));
        WebElement salaryElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[3]"));
        WebElement startDateElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[4]"));
        WebElement endDateElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[5]"));

        assertEquals("Тинькофф", companyElement1.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement1.getText());
        assertEquals("90000", salaryElement1.getText());
        assertEquals("2020-07-08", startDateElement1.getText());
        assertEquals("", endDateElement1.getText());

        WebElement editButton = workTable.findElement(By.xpath(".//tbody/tr[1]/td[6]"));
        editButton.click();

        assertEquals("Редактирование трудоустройства", driver.getTitle());

        WebElement salaryInput = driver.findElement(By.id("newSalary"));
        salaryInput.clear();
        salaryInput.sendKeys("95000");

        WebElement startDateInput = driver.findElement(By.id("endDate"));
        startDateInput.sendKeys("2024-04-15");

        WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'Сохранить')]"));
        saveButton.click();

        assertEquals("Информация о соискателе", driver.getTitle());
        workTable = driver.findElement(By.xpath("(//table)[3]"));
        companyElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[1]"));
        positionElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[2]"));
        salaryElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[3]"));
        startDateElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[4]"));
        endDateElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[5]"));

        assertEquals("Тинькофф", companyElement1.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement1.getText());
        assertEquals("95000", salaryElement1.getText());
        assertEquals("2020-07-08", startDateElement1.getText());
        assertEquals("2024-04-15", endDateElement1.getText());

        driver.quit();
    }

    // Проверка перехода со страницы редактирования трудоустройства на главную страницу
    @Test
    public void testFromEditWorkHistoryToMainPage() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        assertEquals("Информация о соискателе", driver.getTitle());
        WebElement workTable = driver.findElement(By.xpath("(//table)[3]"));
        WebElement companyElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[1]"));
        WebElement positionElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[2]"));
        WebElement salaryElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[3]"));
        WebElement startDateElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[4]"));
        WebElement endDateElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[5]"));

        assertEquals("Тинькофф", companyElement1.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement1.getText());
        assertEquals("90000", salaryElement1.getText());
        assertEquals("2020-07-08", startDateElement1.getText());
        assertEquals("", endDateElement1.getText());

        WebElement editButton = workTable.findElement(By.xpath(".//tbody/tr[1]/td[6]"));
        editButton.click();

        assertEquals("Редактирование трудоустройства", driver.getTitle());

        WebElement homeLink = driver.findElement(By.xpath("//img[@alt='Домой']"));
        homeLink.click();
        assertEquals("PROSHERE", driver.getTitle());

        driver.quit();
    }

    // Проверка перехода со страницы редактирования трудоустройства назад (на страницу резюме)
    @Test
    public void testFromEditWorkHistoryBack() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        assertEquals("Информация о соискателе", driver.getTitle());
        WebElement workTable = driver.findElement(By.xpath("(//table)[3]"));
        WebElement companyElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[1]"));
        WebElement positionElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[2]"));
        WebElement salaryElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[3]"));
        WebElement startDateElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[4]"));
        WebElement endDateElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[5]"));

        assertEquals("Тинькофф", companyElement1.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement1.getText());
        assertEquals("90000", salaryElement1.getText());
        assertEquals("2020-07-08", startDateElement1.getText());
        assertEquals("", endDateElement1.getText());

        WebElement editButton = workTable.findElement(By.xpath(".//tbody/tr[1]/td[6]"));
        editButton.click();

        assertEquals("Редактирование трудоустройства", driver.getTitle());

        WebElement backLink = driver.findElement(By.xpath("//img[@alt='Назад']"));
        backLink.click();

        assertEquals("Информация о соискателе", driver.getTitle());

        lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        driver.quit();
    }

    // Проверка удаления трудоустройства
    @Test
    public void testDeleteWorkHistory() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        assertEquals("Информация о соискателе", driver.getTitle());
        WebElement workTable = driver.findElement(By.xpath("(//table)[3]"));
        WebElement companyElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[1]"));
        WebElement positionElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[2]"));
        WebElement salaryElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[3]"));
        WebElement startDateElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[4]"));
        WebElement endDateElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[5]"));

        assertEquals("Тинькофф", companyElement1.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement1.getText());
        assertEquals("95000", salaryElement1.getText());
        assertEquals("2020-07-08", startDateElement1.getText());
        assertEquals("2024-04-15", endDateElement1.getText());

        WebElement deleteButton = workTable.findElement(By.xpath(".//tbody/tr[1]/td[7]"));
        deleteButton.click();

        assertEquals("Информация о соискателе", driver.getTitle());
        workTable = driver.findElement(By.xpath("(//table)[3]"));
        java.util.List<WebElement> rows = workTable.findElements(By.tagName("tr"));
        assertEquals(0, rows.size() - 1); // -1 так как посчитали заголовки

        driver.quit();
    }

    // Проверка некорректного и корректного добавления трудоустройства
    @Test
    public void testAddWorkHistory2() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement editButton = driver.findElement(By.xpath("//button[contains(text(),'Добавить трудоустройство')]"));
        editButton.click();
        assertEquals("Добавление трудоустройства", driver.getTitle());

        // Уведомление об ошибке - необходимо указать компанию, должность, зарплату, дату приема
        WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'Сохранить')]"));
        saveButton.click();

        WebElement salaryInput = driver.findElement(By.id("salary"));
        salaryInput.sendKeys("90000");

        WebElement startDateInput = driver.findElement(By.id("startDate"));
        startDateInput.sendKeys("2020-07-08");

        // Уведомление об ошибке - необходимо указать компанию и должность
        saveButton.click();
        WebElement errorButton = driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
        errorButton.click();

        WebElement companyDropdownButton = driver.findElement(By.id("companyDropdown"));
        companyDropdownButton.click();
        WebElement Option = driver.findElement(By.xpath("//a[@class='dropdown-item company-item' and text()='Тинькофф']"));
        Option.click();

        WebElement positionDropdownButton = driver.findElement(By.id("positionDropdown"));
        positionDropdownButton.click();
        Option = driver.findElement(By.xpath("//a[@class='dropdown-item position-item' and text()='Дизайнер пользовательских интерфейсов']"));
        Option.click();

        saveButton.click();

        assertEquals("Информация о соискателе", driver.getTitle());
        WebElement workTable = driver.findElement(By.xpath("(//table)[3]"));
        WebElement companyElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[1]"));
        WebElement positionElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[2]"));
        WebElement salaryElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[3]"));
        WebElement startDateElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[4]"));
        WebElement endDateElement1 = workTable.findElement(By.xpath(".//tbody/tr[1]/td[5]"));

        assertEquals("Тинькофф", companyElement1.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement1.getText());
        assertEquals("90000", salaryElement1.getText());
        assertEquals("2020-07-08", startDateElement1.getText());
        assertEquals("", endDateElement1.getText());
   
        driver.quit();
    }


    // Проверка списка подходящих вакансий
    @Test
    public void testSuitableResumes() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement suitableVacanciesTable = driver.findElement(By.xpath("(//table)[4]"));
        WebElement companyElement1 = suitableVacanciesTable.findElement(By.xpath(".//tbody/tr[1]/td[1]"));
        WebElement salaryElement1 = suitableVacanciesTable.findElement(By.xpath(".//tbody/tr[1]/td[2]"));
        WebElement companyElement2 = suitableVacanciesTable.findElement(By.xpath(".//tbody/tr[2]/td[1]"));
        WebElement salaryElement2 = suitableVacanciesTable.findElement(By.xpath(".//tbody/tr[2]/td[2]"));
        WebElement companyElement3 = suitableVacanciesTable.findElement(By.xpath(".//tbody/tr[3]/td[1]"));
        WebElement salaryElement3 = suitableVacanciesTable.findElement(By.xpath(".//tbody/tr[3]/td[2]"));
        WebElement companyElement4 = suitableVacanciesTable.findElement(By.xpath(".//tbody/tr[4]/td[1]"));
        WebElement salaryElement4 = suitableVacanciesTable.findElement(By.xpath(".//tbody/tr[4]/td[2]"));

        assertEquals("VK", companyElement1.getText());
        assertEquals("120000", salaryElement1.getText());
        assertEquals("Ozon", companyElement2.getText());
        assertEquals("130000", salaryElement2.getText());
        assertEquals("Тинькофф", companyElement3.getText());
        assertEquals("110000", salaryElement3.getText());
        assertEquals("Яндекс", companyElement4.getText());
        assertEquals("120000", salaryElement4.getText());

        assertEquals("Информация о соискателе", driver.getTitle());
        suitableVacanciesTable = driver.findElement(By.xpath("(//table)[4]"));
        java.util.List<WebElement> rows = suitableVacanciesTable.findElements(By.tagName("tr"));
        assertEquals(4, rows.size() - 1);
    
        driver.quit();
    }

    // Проверка перехода со страницы резюме на страницу подходящей вакансии
    @Test
    public void testSuitableRes() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement suitableVacanciesTable = driver.findElement(By.xpath("(//table)[4]"));
        WebElement companyElement1 = suitableVacanciesTable.findElement(By.xpath(".//tbody/tr[1]/td[1]"));
        WebElement salaryElement1 = suitableVacanciesTable.findElement(By.xpath(".//tbody/tr[1]/td[2]"));
        WebElement resButton = suitableVacanciesTable.findElement(By.xpath(".//tbody/tr[1]/td[3]/form/button"));

        assertEquals("VK", companyElement1.getText());
        assertEquals("120000", salaryElement1.getText());

        resButton.click();

        assertEquals("Информация о вакансии", driver.getTitle());
        WebElement companyElement = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals("VK", companyElement.getText());
        positionElement = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        WebElement educationElement = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        assertEquals("Дизайн", educationElement.getText());
        WebElement experienceElement = driver.findElement(By.xpath("//table//tr[4]//td[2]"));
        assertEquals("1", experienceElement.getText());
        salaryElement = driver.findElement(By.xpath("//table//tr[5]//td[2]"));
        assertEquals("120000", salaryElement.getText());
    
        driver.quit();
    }

    // Проверка перехода со страницы подходящей вакансии на главную страницу
    @Test
    public void testFromSuitableResToMainPage() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement suitableVacanciesTable = driver.findElement(By.xpath("(//table)[4]"));
        WebElement companyElement1 = suitableVacanciesTable.findElement(By.xpath(".//tbody/tr[1]/td[1]"));
        WebElement salaryElement1 = suitableVacanciesTable.findElement(By.xpath(".//tbody/tr[1]/td[2]"));
        WebElement resButton = suitableVacanciesTable.findElement(By.xpath(".//tbody/tr[1]/td[3]/form/button"));

        assertEquals("VK", companyElement1.getText());
        assertEquals("120000", salaryElement1.getText());

        resButton.click();

        assertEquals("Информация о вакансии", driver.getTitle());

        WebElement homeLink = driver.findElement(By.xpath("//img[@alt='Домой']"));
        homeLink.click();
        assertEquals("PROSHERE", driver.getTitle());
        
        driver.quit();
    }

    // Проверка перехода со страницы подходящей вакансии назад (на страницу резюме)
    @Test
    public void testFromSuitableResBack() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement suitableVacanciesTable = driver.findElement(By.xpath("(//table)[4]"));
        WebElement companyElement1 = suitableVacanciesTable.findElement(By.xpath(".//tbody/tr[1]/td[1]"));
        WebElement salaryElement1 = suitableVacanciesTable.findElement(By.xpath(".//tbody/tr[1]/td[2]"));
        WebElement resButton = suitableVacanciesTable.findElement(By.xpath(".//tbody/tr[1]/td[3]/form/button"));

        assertEquals("VK", companyElement1.getText());
        assertEquals("120000", salaryElement1.getText());

        resButton.click();

        assertEquals("Информация о вакансии", driver.getTitle());

        WebElement backLink = driver.findElement(By.xpath("//img[@alt='Назад']"));
        backLink.click();

        assertEquals("Информация о соискателе", driver.getTitle());

        lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());
        
        driver.quit();
    }

    // Проверка удаления резюме
    @Test
    public void testDeleteResume() {
        driver.get("http://localhost:8080/resumes");
        assertEquals("Резюме", driver.getTitle());

        List<WebElement> resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                WebElement detailsButton = row.findElement(By.xpath("./td[5]/form/button"));
                detailsButton.click();
                break;
            }
        }

        assertEquals("Информация о соискателе", driver.getTitle());

        WebElement lastNameElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement firstNameElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        WebElement middleNameElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        WebElement streerElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        WebElement positionElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        WebElement salaryElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]"));

        assertEquals("Пушкин", lastNameElement.getText());
        assertEquals("Александр", firstNameElement.getText());
        assertEquals("Сергеевич", middleNameElement.getText());
        assertEquals("Тверская, 30, 20", streerElement.getText());
        assertEquals("Дизайнер пользовательских интерфейсов", positionElement.getText());
        assertEquals("100000", salaryElement.getText());

        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(text(),'Удалить резюме')]"));
        deleteButton.click();

        assertEquals("Резюме", driver.getTitle());

        resumeRows = driver.findElements(By.xpath("//table/tbody/tr"));

        Integer deleted = 1;

        for (WebElement row : resumeRows) {
            WebElement lastNameCell = row.findElement(By.xpath("./td[1]"));
            if (lastNameCell.getText().equals("Пушкин")) {
                deleted = 0;
                break;
            }
        }

        assertEquals(1, deleted);
        assertEquals(10, resumeRows.size());

        driver.quit();
    }
}