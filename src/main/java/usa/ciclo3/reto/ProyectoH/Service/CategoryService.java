/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto.ProyectoH.Modelo.Category;
import usa.ciclo3.reto.ProyectoH.Repository.CategoryRepository;

/**
 *
 * @author Andy
 */
@Service
public class CategoryService {

  @Autowired
  private CategoryRepository objCategoryRepository;

  public List<Category> getCategory() {
    return objCategoryRepository.getCategory();
  }

  public Optional<Category> getIdCat(int id) {
    return objCategoryRepository.getIdCat(id);
  }

  public Category saveCategory(Category objC) {
    if (objC.getId() == null) {
      return objCategoryRepository.saveCategory(objC);
    } else {
      Optional<Category> catAux = objCategoryRepository.getIdCat(objC.getId());

      if (catAux.isEmpty()) {
        return objCategoryRepository.saveCategory(objC);
      } else {
        return objC;
      }
    }
  }
}
