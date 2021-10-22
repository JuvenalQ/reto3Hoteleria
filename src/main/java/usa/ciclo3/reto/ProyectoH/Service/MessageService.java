/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto.ProyectoH.Modelo.Message;
import usa.ciclo3.reto.ProyectoH.Repository.MessageRepository;

/**
 *
 * @author Andy
 */
@Service
public class MessageService {

  @Autowired
  private MessageRepository objMessageRepository;

  //
  public List<Message> getMessages() {
    return objMessageRepository.getMessages();
  }

  public Optional<Message> getId(int id) {
    return objMessageRepository.getId(id);
  }

  //
  public Message saveMesage(Message objM) {
    if (objM.getIdMessage()== null) {
      return objMessageRepository.saveMessage(objM);
    } else {
      Optional<Message> auxMes = objMessageRepository.getId(objM.getIdMessage());

      if (auxMes.isEmpty()) {
        return objMessageRepository.saveMessage(objM);
      } else {
        return objM;
      }
    }
  }
}
