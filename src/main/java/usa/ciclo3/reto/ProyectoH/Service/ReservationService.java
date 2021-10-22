/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto.ProyectoH.Modelo.Reservation;
import usa.ciclo3.reto.ProyectoH.Repository.ReservationRepository;

/**
 *
 * @author Andy
 */
@Service
public class ReservationService {

  @Autowired
  private ReservationRepository objRepository;

  //
  public List<Reservation> getRepositorys() {
    return (List<Reservation>) objRepository.getRepositorys();
  }

  public Optional<Reservation> getIdRep(int id) {
    return objRepository.getIdRep(id);
  }

  public Reservation saveRepository(Reservation objR) {

    if (objR.getIdReservation() == null) {
      return objRepository.saveRepository(objR);
    } else {

      Optional<Reservation> resAux = objRepository.getIdRep((objR.getIdReservation()));

      if (resAux.isEmpty()) {
        return objRepository.saveRepository(objR);

      } else {
        return objR;
      }
    }
  }
}
