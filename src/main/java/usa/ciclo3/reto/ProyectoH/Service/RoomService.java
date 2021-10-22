/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto.ProyectoH.Modelo.Room;
import usa.ciclo3.reto.ProyectoH.Repository.RoomRepository;

/**
 *
 * @author Andy
 */
@Service
public class RoomService {

  //Instancia de repositrio
  @Autowired
  private RoomRepository objRepository;

  //obtiene todos los registros 
  public List<Room> getRooms() {
    return objRepository.getRooms();
  }
  
  //obtiene el registro seleccionado 
  public Optional<Room> getid(int id) {
    return objRepository.getId(id);
  }

  //
  public Room saveRoom(Room objR) {

    if (objR.getId() == null) {
      return objRepository.saveRoom(objR);
    } else {
      Optional<Room> auxRoom = objRepository.getId(objR.getId());

      if (auxRoom.isEmpty()) {
        return objRepository.saveRoom(objR);
      } else {
        return objR;
      }
    }
  }
}
