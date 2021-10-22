/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto.ProyectoH.Modelo.Admin;
import usa.ciclo3.reto.ProyectoH.Repository.AdminRepository;

/**
 *
 * @author Andy
 */
@Service
public class AdminService {

  @Autowired
  private AdminRepository objAdminRepository;

  public List<Admin> getAdmins() {
    return objAdminRepository.getAdmins();
  }

  public Optional<Admin> getId(int id) {
    return objAdminRepository.getId(id);
  }

  public Admin saveAdmin(Admin objA) {
    if (objA.getId() == null) {
      return objAdminRepository.SaveAdmin(objA);
    } else {
      Optional auxAd = objAdminRepository.getId(objA.getId());
      if (auxAd.isEmpty()) {
        return objAdminRepository.SaveAdmin(objA);
      } else {
        return objA;
      }
    }
  }
}
