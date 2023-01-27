package com.company.enoca.controller;

import com.company.enoca.dto.CompanyResponses;
import com.company.enoca.dto.EmployeeDto;
import com.company.enoca.dto.EmployeeResponses;
import com.company.enoca.service.IEmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    private final ModelMapper mapper;
    public EmployeeController(ModelMapper mapper) {
        this.mapper = mapper;
    }
    @PostMapping ("create")
        public ResponseEntity<EmployeeResponses> create(@RequestBody EmployeeDto employee){
        try {

            employeeService.create(employee);
            return ResponseEntity.status(201).body(new EmployeeResponses(201,"success",null));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(424).body(new EmployeeResponses(424,"fail",null));
        }

    }
    @PutMapping("update/{id}")
    public ResponseEntity<EmployeeResponses> update(@RequestBody EmployeeDto employeeDto, @PathVariable Long id){
        try {
            employeeService.update(employeeDto,id);
            return ResponseEntity.status(200).body(new EmployeeResponses(200,"succes",null));

        }catch (Exception e){
            return ResponseEntity.status(400).body(new EmployeeResponses(400,"fail",null));
        }

    }
    @GetMapping("employees")
    public ResponseEntity<EmployeeResponses> getAll(){

        /*for(int i=1;i<10;i++){
            Employee emp2=new Employee();

            emp2.setFirstName("baver"+i);
            emp2.setLastName("tt"+i);
            emp2.setPhoneNumber((i+"").repeat(11));

            employeeService.create(mapper.map(emp2,EmployeeDto.class));
        }*/
        if(employeeService.getAll().isEmpty())
            return ResponseEntity.status(404).body(new EmployeeResponses(404,"fail",null));
        return ResponseEntity.status(200).body(new EmployeeResponses(200,"success",employeeService.getAll()));

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<EmployeeResponses> delete(@PathVariable Long id)
    {
        try {
            employeeService.delete(id);
            return ResponseEntity.status(204).body(new EmployeeResponses(204,"success",null));
        }
        catch (Exception e){
            return ResponseEntity.status(400).body(new EmployeeResponses(400,"fail",null));
        }

    }
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResponseEntity<EmployeeResponses> getEmployeeById(@PathVariable  Long id){
        try {
            EmployeeDto e= employeeService.getEmployeeByid(id);
            return ResponseEntity.status(200).body(new EmployeeResponses(200,"success", List.of(e)));
        }catch (Exception e){
            return ResponseEntity.status(400).body(new EmployeeResponses(400,"fail",null));
        }
    }




}
