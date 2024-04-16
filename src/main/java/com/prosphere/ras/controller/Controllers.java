package com.prosphere.ras.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.prosphere.ras.models.*;
import com.prosphere.ras.services.*;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.time.LocalDate;

@Controller
public class Controllers {
    ApplicantService as = new ApplicantService();
    VacancyService vs = new VacancyService();
    CompanyService cs = new CompanyService();
    PositionService ps = new PositionService();
    SpecialityService ss = new SpecialityService();
    UniversityService us = new UniversityService();
    EducationService es = new EducationService();
    WorkhistoryService ws = new WorkhistoryService();

    @GetMapping(value = {"/", "/index"})
    public String home() {
        return "index";
    }

    @GetMapping(value = {"/resumes"})
    public String ApplicantsList2(@RequestParam(value="specialityRES", required=false) Integer specialityId,
                                @RequestParam(value="companyRES", required=false) Integer companyId,
                                @RequestParam(value="positionRES", required=false) Integer positionId,
                                @RequestParam(value="minSalaryRES", required=false) Integer minSalary,
                                @RequestParam(value="maxSalaryRES", required=false) Integer maxSalary,
                                Model model) {

        model.addAttribute("selectedSpecialityRES", specialityId);
        model.addAttribute("selectedCompanyRES", companyId);
        model.addAttribute("selectedPositionRES", positionId);
        model.addAttribute("minSalaryRES", minSalary);
        model.addAttribute("maxSalaryRES", maxSalary);
  
        model.addAttribute("allCompanies", cs.findAll());
        model.addAttribute("allPositions", ps.findAll());
        model.addAttribute("allSpecialities", ss.findAll());
        model.addAttribute("resumes", as.filter(specialityId, companyId, positionId, minSalary, maxSalary));

        return "resumes";
    }

    @GetMapping(value = {"/deleteresume"})
    public String deleteResume(@RequestParam(value="specialityRES", required=false) Integer specialityId,
                                @RequestParam(value="companyRES", required=false) Integer companyId,
                                @RequestParam(value="positionRES", required=false) Integer positionId,
                                @RequestParam(value="minSalaryRES", required=false) Integer minSalary,
                                @RequestParam(value="maxSalaryRES", required=false) Integer maxSalary,
                                @RequestParam(value="resumeId", required=false) Integer id,
                                Model model) {

        as.deleteById(id);

        model.addAttribute("selectedSpecialityRES", specialityId);
        model.addAttribute("selectedCompanyRES", companyId);
        model.addAttribute("selectedPositionRES", positionId);
        model.addAttribute("minSalaryRES", minSalary);
        model.addAttribute("maxSalaryRES", maxSalary);
  
        model.addAttribute("allCompanies", cs.findAll());
        model.addAttribute("allPositions", ps.findAll());
        model.addAttribute("allSpecialities", ss.findAll());
        model.addAttribute("resumes", as.filter(specialityId, companyId, positionId, minSalary, maxSalary));

        return "resumes";
    }


    @GetMapping("/resume")
    public String viewResume(@RequestParam(value = "resumeId", required=false) Integer id,
                            @RequestParam(value = "companyRES", required=false) Integer companyRES,
                            @RequestParam(value = "positionRES", required=false) Integer positionRES,
                            @RequestParam(value = "specialityRES", required=false) Integer specialityRES,
                            @RequestParam(value = "minSalaryRES", required=false) Integer minSalaryRES,
                            @RequestParam(value = "maxSalaryRES", required=false) Integer maxSalaryRES,
                            Model model) {
        Applicant app = as.findById(id);
        model.addAttribute("resume", app);

        model.addAttribute("companyRES", companyRES);
        model.addAttribute("positionRES", positionRES);
        model.addAttribute("specialityRES", specialityRES);
        model.addAttribute("minSalaryRES", minSalaryRES);
        model.addAttribute("maxSalaryRES", maxSalaryRES);
        model.addAttribute("vacancies", as.findSuitableVacancy(app));

        return "resume";
    }

    @GetMapping("/resumebyvacancy")
    public String viewResumeByVacancy(@RequestParam(value = "resumeId", required=false) Integer id, Model model) {
        Applicant app = as.findById(id);
        model.addAttribute("resume", app);
        model.addAttribute("vacancies", as.findSuitableVacancy(app));
        return "resumebyvacancy";
    }

    @GetMapping("/addresume")
    public String addResume(@RequestParam(value="specialityRES", required=false) Integer specialityId,
                            @RequestParam(value="companyRES", required=false) Integer companyId,
                            @RequestParam(value="positionRES", required=false) Integer positionId,
                            @RequestParam(value="minSalaryRES", required=false) Integer minSalary,
                            @RequestParam(value="maxSalaryRES", required=false) Integer maxSalary,
                            Model model) {

        model.addAttribute("companyRES", companyId);
        model.addAttribute("positionRES", positionId);
        model.addAttribute("specialityRES", specialityId);
        model.addAttribute("minSalaryRES", minSalary);
        model.addAttribute("maxSalaryRES", maxSalary);
                                
        model.addAttribute("Positions", ps.findAll());
        model.addAttribute("Specialities", ss.findAll());
        model.addAttribute("Universities", us.findAll());
        return "addresume";
    }

    @PostMapping("/saveresume")
    public String saveResume(
                                @RequestParam(value = "lastname", required=false) String lastname,
                                @RequestParam(value = "firstname", required=false) String firstname,
                                @RequestParam(value = "middlename", required=false) String middlename,
                                @RequestParam(value = "street", required=false) String street,
                                @RequestParam(value = "building", required=false) Integer building,
                                @RequestParam(value = "apartment", required=false) Integer apartment,
                                @RequestParam(value = "position", required=false) Integer position,
                                @RequestParam(value = "salary", required=false) Integer salary,

                                @RequestParam(value="specialityRES", required=false) Integer specialityId,
                                @RequestParam(value="companyRES", required=false) Integer companyId,
                                @RequestParam(value="positionRES", required=false) Integer positionId,
                                @RequestParam(value="minSalaryRES", required=false) Integer minSalary,
                                @RequestParam(value="maxSalaryRES", required=false) Integer maxSalary,
                                
                                Model model) {
        Position pos = ps.findById(position);
        Applicant app = new Applicant(firstname, middlename, lastname, street, building, apartment, pos, salary);
        as.save(app);

        model.addAttribute("selectedSpecialityRES", specialityId);
        model.addAttribute("selectedCompanyRES", companyId);
        model.addAttribute("selectedPositionRES", positionId);
        model.addAttribute("minSalaryRES", minSalary);
        model.addAttribute("maxSalaryRES", maxSalary);
  
        model.addAttribute("allCompanies", cs.findAll());
        model.addAttribute("allPositions", ps.findAll());
        model.addAttribute("allSpecialities", ss.findAll());
        model.addAttribute("resumes", as.filter(specialityId, companyId, positionId, minSalary, maxSalary));

        return "resumes";
    }

    @GetMapping("/editresume")
    public String editResume(@RequestParam(value="resumeId", required=false) Integer resumeId,
                                @RequestParam(value="companyRES", required=false) Integer companyRES,
                                @RequestParam(value="positionRES", required=false) Integer positionRES,
                                @RequestParam(value="specialityRES", required=false) Integer specialityRES,
                                @RequestParam(value="minSalaryRES", required=false) Integer minSalaryRES,
                                @RequestParam(value="maxSalaryRES", required=false) Integer maxSalaryRES,
                                Model model) {
        model.addAttribute("resume", as.findById(resumeId));
        model.addAttribute("resumeId", resumeId);
        model.addAttribute("companyRES", companyRES);
        model.addAttribute("positionRES", positionRES);
        model.addAttribute("specialityRES", specialityRES);
        model.addAttribute("minSalaryRES", minSalaryRES);
        model.addAttribute("maxSalaryRES", maxSalaryRES);
        model.addAttribute("Positions", ps.findAll());
        Applicant app = as.findById(resumeId);
        model.addAttribute("vacancies", as.findSuitableVacancy(app));

        return "editresume";
    }

    @PostMapping("/updateresume")
    public String updateResume(@RequestParam(value="resumeId", required=false) Integer resumeId,
                                @RequestParam(value="companyRES", required=false) Integer companyRES,
                                @RequestParam(value="positionRES", required=false) Integer positionRES,
                                @RequestParam(value="specialityRES", required=false) Integer specialityRES,
                                @RequestParam(value="minSalaryRES", required=false) Integer minSalaryRES,
                                @RequestParam(value="maxSalaryRES", required=false) Integer maxSalaryRES,

                                @RequestParam(value="lastname", required=false) String lastname,
                                @RequestParam(value="firstname", required=false) String firstname,
                                @RequestParam(value="middlename", required=false) String middlename,
                                @RequestParam(value="street", required=false) String street,
                                @RequestParam(value="building", required=false) Integer building,
                                @RequestParam(value="apartment", required=false) Integer apartment,
                                @RequestParam(value="position", required=false) Integer position,
                                @RequestParam(value="salary", required=false) Integer salary,
                                Model model) {

        Position pos = ps.findById(position);
        Applicant app = as.findById(resumeId);
        
        app.setFirstName(firstname);
        app.setMiddleName(middlename);
        app.setLastName(lastname);
        app.setStreet(street);
        app.setBuilding(building);
        app.setApartment(apartment);
        app.setSoughtPost(pos);
        app.setSoughtSalary(salary);

        as.update(app);

        model.addAttribute("resume", app);
        model.addAttribute("vacancies", as.findSuitableVacancy(app));
        model.addAttribute("resumeId", app.getId());
        model.addAttribute("companyRES", companyRES);
        model.addAttribute("positionRES", positionRES);
        model.addAttribute("specialityRES", specialityRES);
        model.addAttribute("minSalaryRES", minSalaryRES);
        model.addAttribute("maxSalaryRES", maxSalaryRES);
        
        return "resume";
    }

    @GetMapping("/addeducation")
    public String addEducation(@RequestParam(value="resumeId", required=false) Integer resumeId,
                                @RequestParam(value="companyRES", required=false) Integer companyRES,
                                @RequestParam(value="positionRES", required=false) Integer positionRES,
                                @RequestParam(value="specialityRES", required=false) Integer specialityRES,
                                @RequestParam(value="minSalaryRES", required=false) Integer minSalaryRES,
                                @RequestParam(value="maxSalaryRES", required=false) Integer maxSalaryRES,
                                Model model) {
        model.addAttribute("resume", as.findById(resumeId));
        model.addAttribute("resumeId", resumeId);
        model.addAttribute("companyRES", companyRES);
        model.addAttribute("positionRES", positionRES);
        model.addAttribute("specialityRES", specialityRES);
        model.addAttribute("minSalaryRES", minSalaryRES);
        model.addAttribute("maxSalaryRES", maxSalaryRES);
        model.addAttribute("Universities", us.findAll());
        model.addAttribute("Specialities", ss.findAll());
        Applicant app = as.findById(resumeId);
        model.addAttribute("vacancies", as.findSuitableVacancy(app));

        return "addeducation";
    }

    @PostMapping("/saveeducation")
    public String saveEducation(@RequestParam(value="resumeId", required=false) Integer resumeId,
                                @RequestParam(value="companyRES", required=false) Integer companyRES,
                                @RequestParam(value="positionRES", required=false) Integer positionRES,
                                @RequestParam(value="specialityRES", required=false) Integer specialityRES,
                                @RequestParam(value="minSalaryRES", required=false) Integer minSalaryRES,
                                @RequestParam(value="maxSalaryRES", required=false) Integer maxSalaryRES,

                                @RequestParam(value="university", required=false) Integer universityId,
                                @RequestParam(value="speciality", required=false) Integer specialityId,
                                Model model) {

  
        Education ed = new Education(as.findById(resumeId), us.findById(universityId), ss.findById(specialityId));
        es.update(ed);

        Applicant app = as.findById(resumeId);

        model.addAttribute("resume", app);
        model.addAttribute("vacancies", as.findSuitableVacancy(app));
        model.addAttribute("resumeId", app.getId());
        model.addAttribute("companyRES", companyRES);
        model.addAttribute("positionRES", positionRES);
        model.addAttribute("specialityRES", specialityRES);
        model.addAttribute("minSalaryRES", minSalaryRES);
        model.addAttribute("maxSalaryRES", maxSalaryRES);
        
        return "resume";
    }

    @PostMapping("/deleteeducation")
    public String deleteEducation(@RequestParam(value="resumeId", required=false) Integer resumeId,
                                @RequestParam(value="companyRES", required=false) Integer companyRES,
                                @RequestParam(value="positionRES", required=false) Integer positionRES,
                                @RequestParam(value="specialityRES", required=false) Integer specialityRES,
                                @RequestParam(value="minSalaryRES", required=false) Integer minSalaryRES,
                                @RequestParam(value="maxSalaryRES", required=false) Integer maxSalaryRES,
                                @RequestParam(value="universityId", required=false) Integer universityId,
                                @RequestParam(value="specialityId", required=false) Integer specialityId,
                                Model model) {

        es.deleteByObj(as.findById(resumeId), us.findById(universityId), ss.findById(specialityId));

        Applicant app = as.findById(resumeId);
        model.addAttribute("resume", app);
        model.addAttribute("vacancies", as.findSuitableVacancy(app));
        model.addAttribute("resumeId", app.getId());
        model.addAttribute("companyRES", companyRES);
        model.addAttribute("positionRES", positionRES);
        model.addAttribute("specialityRES", specialityRES);
        model.addAttribute("minSalaryRES", minSalaryRES);
        model.addAttribute("maxSalaryRES", maxSalaryRES);
        
        return "resume";
    }

    @GetMapping("/addworkhistory")
    public String addWorkHistory(@RequestParam(value="resumeId", required=false) Integer resumeId,
                                @RequestParam(value="companyRES", required=false) Integer companyRES,
                                @RequestParam(value="positionRES", required=false) Integer positionRES,
                                @RequestParam(value="specialityRES", required=false) Integer specialityRES,
                                @RequestParam(value="minSalaryRES", required=false) Integer minSalaryRES,
                                @RequestParam(value="maxSalaryRES", required=false) Integer maxSalaryRES,
                                Model model) {
        model.addAttribute("resume", as.findById(resumeId));
        model.addAttribute("resumeId", resumeId);
        model.addAttribute("companyRES", companyRES);
        model.addAttribute("positionRES", positionRES);
        model.addAttribute("specialityRES", specialityRES);
        model.addAttribute("minSalaryRES", minSalaryRES);
        model.addAttribute("maxSalaryRES", maxSalaryRES);
        model.addAttribute("Companies", cs.findAll());
        model.addAttribute("Positions", ps.findAll());
        Applicant app = as.findById(resumeId);
        model.addAttribute("vacancies", as.findSuitableVacancy(app));

        return "addworkhistory";
    }

    @PostMapping("/saveworkhistory")
    public String saveWorkhistory(@RequestParam(value="resumeId", required=false) Integer resumeId,
                                @RequestParam(value="companyRES", required=false) Integer companyRES,
                                @RequestParam(value="positionRES", required=false) Integer positionRES,
                                @RequestParam(value="specialityRES", required=false) Integer specialityRES,
                                @RequestParam(value="minSalaryRES", required=false) Integer minSalaryRES,
                                @RequestParam(value="maxSalaryRES", required=false) Integer maxSalaryRES,

                                @RequestParam(value="company", required=false) Integer companyId,
                                @RequestParam(value="position", required=false) Integer positionId,
                                @RequestParam(value="salary", required=false) Integer salary,
                                @RequestParam(value="startDate", required=false) String startDate,
                                @RequestParam(value="endDate", required=false) String endDate,
                                Model model) {
                     
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = null;
        if (endDate != "") end = LocalDate.parse(endDate);
  
        Workhistory wh = new Workhistory(as.findById(resumeId), cs.findById(companyId), ps.findById(positionId), salary, start, end);
        ws.update(wh);

        Applicant app = as.findById(resumeId);

        model.addAttribute("resume", app);
        model.addAttribute("vacancies", as.findSuitableVacancy(app));
        model.addAttribute("resumeId", app.getId());
        model.addAttribute("companyRES", companyRES);
        model.addAttribute("positionRES", positionRES);
        model.addAttribute("specialityRES", specialityRES);
        model.addAttribute("minSalaryRES", minSalaryRES);
        model.addAttribute("maxSalaryRES", maxSalaryRES);
        
        return "resume";
    }

    @PostMapping("/deleteworkhistory")
    public String deleteWorkhistory(@RequestParam(value="resumeId", required=false) Integer resumeId,
                                @RequestParam(value="companyId", required=false) Integer companyId,
                                @RequestParam(value="positionId", required=false) Integer positionId,
                                @RequestParam(value="companyRES", required=false) Integer companyRES,
                                @RequestParam(value="positionRES", required=false) Integer positionRES,
                                @RequestParam(value="specialityRES", required=false) Integer specialityRES,
                                @RequestParam(value="minSalaryRES", required=false) Integer minSalaryRES,
                                @RequestParam(value="maxSalaryRES", required=false) Integer maxSalaryRES,
                                Model model) {

        ws.deleteByObj(as.findById(resumeId), cs.findById(companyId), ps.findById(positionId));

        Applicant app = as.findById(resumeId);
        System.out.println(app);
        model.addAttribute("resume", app);
        model.addAttribute("vacancies", as.findSuitableVacancy(app));
        model.addAttribute("resumeId", app.getId());
        model.addAttribute("companyRES", companyRES);
        model.addAttribute("positionRES", positionRES);
        model.addAttribute("specialityRES", specialityRES);
        model.addAttribute("minSalaryRES", minSalaryRES);
        model.addAttribute("maxSalaryRES", maxSalaryRES);
        
        return "resume";
    }

    @GetMapping("/editworkhistory")
    public String editWorkhistory(@RequestParam(value="resumeId", required=false) Integer resumeId,
                                @RequestParam(value="companyId", required=false) Integer companyId,
                                @RequestParam(value="positionId", required=false) Integer positionId,
                                @RequestParam(value="companyRES", required=false) Integer companyRES,
                                @RequestParam(value="positionRES", required=false) Integer positionRES,
                                @RequestParam(value="specialityRES", required=false) Integer specialityRES,
                                @RequestParam(value="minSalaryRES", required=false) Integer minSalaryRES,
                                @RequestParam(value="maxSalaryRES", required=false) Integer maxSalaryRES,
                                Model model) {
        Applicant app = as.findById(resumeId);
        model.addAttribute("resume", app);
        model.addAttribute("workhist", ws.findByObj(app, cs.findById(companyId), ps.findById(positionId)));

        model.addAttribute("resumeId", resumeId);
        model.addAttribute("companyRES", companyRES);
        model.addAttribute("positionRES", positionRES);
        model.addAttribute("specialityRES", specialityRES);
        model.addAttribute("minSalaryRES", minSalaryRES);
        model.addAttribute("maxSalaryRES", maxSalaryRES);
        model.addAttribute("vacancies", as.findSuitableVacancy(app));

        return "editworkhistory";
    }




    @PostMapping("/updateworkhistory")
    public String updateWorkhistory(@RequestParam(value="resumeId", required=false) Integer resumeId,
                                @RequestParam(value="companyRES", required=false) Integer companyRES,
                                @RequestParam(value="positionRES", required=false) Integer positionRES,
                                @RequestParam(value="specialityRES", required=false) Integer specialityRES,
                                @RequestParam(value="minSalaryRES", required=false) Integer minSalaryRES,
                                @RequestParam(value="maxSalaryRES", required=false) Integer maxSalaryRES,
                                @RequestParam(value="companyId", required=false) Integer companyId,
                                @RequestParam(value="positionId", required=false) Integer positionId,
                                @RequestParam(value="newSalary", required=false) Integer salary,
                                @RequestParam(value="endDate", required=false) String endDate,
                                Model model) {
        Applicant app = as.findById(resumeId);
        model.addAttribute("resume", app);

        LocalDate end = null;
        if (endDate != "") end = LocalDate.parse(endDate);

        for (Workhistory work : app.getAppWork()) {
            if (work.getCompany().getId() == companyId && work.getPosition().getId() == positionId) {
                work.setSalary(salary);
                work.setEndDate(end);
                break;
            }
        }

        Workhistory wh = ws.findByObj(app, cs.findById(companyId), ps.findById(positionId));
        if (endDate != "") end = LocalDate.parse(endDate);
        
        wh.setSalary(salary);
        wh.setEndDate(end);
        ws.update(wh);

        model.addAttribute("resume", app);
        model.addAttribute("vacancies", as.findSuitableVacancy(app));
        model.addAttribute("resumeId", app.getId());
        model.addAttribute("companyRES", companyRES);
        model.addAttribute("positionRES", positionRES);
        model.addAttribute("specialityRES", specialityRES);
        model.addAttribute("minSalaryRES", minSalaryRES);
        model.addAttribute("maxSalaryRES", maxSalaryRES);
        
        return "resume";
    }

    @GetMapping(value = {"/vacancies"})
    public String VacanciesList(@RequestParam(value="companyVAC", required=false) Integer companyId,
                                @RequestParam(value="positionVAC", required=false) Integer positionId,
                                @RequestParam(value="minSalaryVAC", required=false) Integer minSalary,
                                @RequestParam(value="maxSalaryVAC", required=false) Integer maxSalary,
                                Model model) {

        model.addAttribute("selectedCompanyVAC", companyId);
        model.addAttribute("selectedPositionVAC", positionId);
        model.addAttribute("minSalaryVAC", minSalary);
        model.addAttribute("maxSalaryVAC", maxSalary);
  
        model.addAttribute("allCompanies", cs.findAll());
        model.addAttribute("allPositions", ps.findAll());
        model.addAttribute("allSpecialities", ss.findAll());
        model.addAttribute("vacancies", vs.filter(companyId, positionId, minSalary, maxSalary));

        return "vacancies";
    }

    @GetMapping("/vacancy")
    public String viewVacancy(@RequestParam(value="companyId", required=false) Integer companyid,
                                @RequestParam(value="positionId", required=false) Integer positionId,
                                Model model) {
        Vacancy vac = vs.findByObj(companyid, positionId);
        model.addAttribute("vacancy", vac);
        model.addAttribute("resumes", vs.findSuitableResumes(vac));
        return "vacancy";
    }

    @GetMapping("/suitablevacancy")
    public String viewSuitableVacancy(@RequestParam(value="companyId", required=false) Integer companyid,
                                @RequestParam(value="positionId", required=false) Integer positionId,
                                Model model) {
        Vacancy vac = vs.findByObj(companyid, positionId);
        model.addAttribute("vacancy", vac);
        model.addAttribute("resumes", vs.findSuitableResumes(vac));
        return "suitablevacancy";
    }

    @GetMapping("/vacancybycompany")
    public String viewVacancybyCompany(@RequestParam(value="companyId", required=false) Integer companyid,
                                        @RequestParam(value="positionId", required=false) Integer positionId,
                                        Model model) {
        Vacancy vac = vs.findByObj(companyid, positionId);
        model.addAttribute("vacancy", vac);
        model.addAttribute("resumes", vs.findSuitableResumes(vac));
        return "vacancybycompany";
    }

    @PostMapping("/deleteVacancy")
    public String deleteVacancy(@RequestParam("companyId") Integer companyId, @RequestParam("positionId") Integer positionId, Model model) {
        vs.deleteByObj(companyId, positionId);
        Company comp = cs.findById(companyId);
        model.addAttribute("companyId", companyId);
        model.addAttribute("company", comp);
        return "company";
    }

    @GetMapping("/addvacancy")
    public String addVacancy(@RequestParam("companyId") Integer companyId, Model model) {
        Company company = cs.findById(companyId);
        List<Position> newpos = cs.findNewPositions(company);

        if (newpos == null || newpos.isEmpty()) {
            model.addAttribute("company", company);
            return "company";
        }

        model.addAttribute("company", company);
        model.addAttribute("companyId", companyId);
        model.addAttribute("allSpecialities", ss.findAll());
        model.addAttribute("newPositions", newpos);
        return "addvacancy";
    }

    @PostMapping("/saveVacancy")
    public String saveVacancy(@RequestParam(value="companyId", required=false) Integer companyId,
                                @RequestParam(value="positionADD", required=false) Integer positionId,
                                @RequestParam(value="specialityADD", required=false) Integer specialityId,
                                @RequestParam(value="exp", required=false) Integer exp,
                                @RequestParam(value="salary", required=false) Integer salary,
                                Model model) {

        Company company = cs.findById(companyId);
        Position position = ps.findById(positionId);
        Speciality speciality = (specialityId != null) ? ss.findById(specialityId) : null;
        Vacancy vacancy = new Vacancy(company, position, salary, speciality, exp);

        List<Vacancy> comp_vac = company.getCompVac();
        comp_vac.add(vacancy);
        company.setCompVac(comp_vac);
        cs.update(company);

        model.addAttribute("companyId", companyId);
        model.addAttribute("company", company);

        return "company";
    }

    @GetMapping("/editvacancy")
    public String updateVacancy(@RequestParam("companyId") Integer companyId,
                                @RequestParam("positionId") Integer positionId,
                                Model model) {
    
        model.addAttribute("vacancy", vs.findByObj(companyId, positionId));
        model.addAttribute("allSpecialities", ss.findAll());
        
        return "editvacancy";
    }

    @PostMapping("/updatevacancy")
    public String updateVacancy(@RequestParam(value="companyId", required=false) Integer companyId,
                                @RequestParam(value="positionId", required=false) Integer positionId,
                                @RequestParam(value="newSpeciality", required=false) Integer specialityId,
                                @RequestParam(value="newSalary", required=false) Integer salary,
                                @RequestParam(value="newExperience", required=false) Integer exp,
                                Model model) {


        Speciality speciality = (specialityId != null) ? ss.findById(specialityId) : null;
 
        Vacancy vacancy = vs.findByObj(companyId, positionId);
        vacancy.setSalary(salary);
        vacancy.setReqSpec(speciality);
        vacancy.setReqExp(exp);

        vs.update(vacancy);

        model.addAttribute("companyId", companyId);
        model.addAttribute("positionId", positionId);

        model.addAttribute("vacancy", vacancy);
        model.addAttribute("resumes", vs.findSuitableResumes(vacancy));
        
        return "vacancybycompany";
    }

    @GetMapping(value = {"/companies"})
    public String СompaniesList(Model model) {
        model.addAttribute("companies", cs.findAll());
        return "companies";
    }

    @GetMapping("/company")
    public String viewCompany(@RequestParam("companyId") Integer companyId, Model model) {
        Company comp = cs.findById(companyId);
        List<Position> newpos = cs.findNewPositions(comp);

        if (newpos == null || newpos.isEmpty()) model.addAttribute("allpositions", 777);
        model.addAttribute("company", comp);

        return "company";
    }

    @PostMapping("/deleteCompany")
    public String deleteCompany(@RequestParam("companyId") Integer id) {
        cs.deleteById(id);
        return "redirect:/companies";
    }

    @GetMapping("/addcompany")
    public String showAddCompanyPage(@RequestParam(value = "error", required = false) String error, Model model) {
        if ("exists".equals(error)) {
            model.addAttribute("errorMessage", "Компания с таким названием уже есть в базе данных, укажите другое название");
        }
        return "addcompany";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@RequestParam("name") String companyName, Model model) {
        Company check_comp = cs.findByName(companyName);

        if (check_comp != null) return "redirect:/addcompany?error=exists";

        Company comp = new Company(companyName);
        cs.save(comp);
        return "redirect:/companies";
    }
}