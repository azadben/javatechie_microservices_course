package com.javatechie.repository;

import com.javatechie.bo.ProjectEngineerResponseBO;
import com.javatechie.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Integer> {


    @Query(value = "select new com.javatechie.bo.ProjectEngineerResponseBO(p.name as  project_name, p.project_code, e.name as engineer_name, e.email) from Project p join Engineer e on p.project_id = e.project_engineer_fk", nativeQuery = true)
    public List<ProjectEngineerResponseBO> getProjectSpecificInfoWithSQL();



    @Query(value = "SELECT new com.javatechie.bo.ProjectEngineerResponseBO(p.name , p.projectCode , e.name , e.email) FROM Project p JOIN p.engineers e")
    public List<ProjectEngineerResponseBO> getProjectSpecificInfoWithJPQL();
}
