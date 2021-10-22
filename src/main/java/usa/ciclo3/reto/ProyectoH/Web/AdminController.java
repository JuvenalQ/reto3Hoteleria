/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import usa.ciclo3.reto.ProyectoH.Modelo.Admin;
import usa.ciclo3.reto.ProyectoH.Service.AdminService;

/**
 *
 * @author Andy
 */
@RestController
@RequestMapping("/api/Admin") // /api/Admin/save
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AdminController {
  
  @Autowired
  private AdminService objAdminService; 
  
  //
  @GetMapping("/all")
  public List<Admin> getAdmins (){
    return objAdminService.getAdmins(); 
  }
  
  //
  @GetMapping({"/id"})
  public Optional <Admin> getId (@PathVariable("id") int id){
    return objAdminService.getId(id); 
  }
  
  //
  @PostMapping("/save")
  @ResponseStatus(HttpStatus.CREATED)
  public Admin saveAdmin(@RequestBody Admin objA) {
    return objAdminService.saveAdmin(objA);
  }
}
