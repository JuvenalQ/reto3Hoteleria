/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto.ProyectoH.Modelo.Score;
import usa.ciclo3.reto.ProyectoH.Repository.ScoreRepository;

/**
 *
 * @author Andy
 */
@Service
public class ScoreService {

  @Autowired
  private ScoreRepository objRepository;

  //Obtiene los registro de la tabla 
  public List<Score> getScores() {
    return (List<Score>) objRepository.getScores();
  }

  //obtiene el id seleccionado 
  public Optional<Score> getId(int id) {
    return objRepository.getId(id);
  }

  //guardas 
  public Score saveScore(Score objS) {

    if (objS.getId() == null) {
      return objRepository.saveScore(objS);
    } else {
      Optional<Score> auxScore = objRepository.getId(objS.getId());

      if (auxScore.isEmpty()) {
        return objRepository.saveScore(objS);
      } else {
        return objS;
      }
    }
  }
}
