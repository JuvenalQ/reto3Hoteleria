/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.ciclo3.reto.ProyectoH.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto.ProyectoH.Modelo.Client;
import usa.ciclo3.reto.ProyectoH.Repository.ClientRepository;

/**
 *
 * @author Andy
 */
@Service
public class ClientService {

  @Autowired
  private ClientRepository objClientRepository;

  //
  public List<Client> getClients() {
    return (List<Client>) objClientRepository.getClients();
  }

  //
  public Optional<Client> getId(int id) {
    return objClientRepository.getId(id);
  }

  //
  public Client saveClient(Client objC) {
    if (objC.getIdClient() == null) {
      return objClientRepository.saveClient(objC);
    } else {
      Optional<Client> auxClient = objClientRepository.getId(objC.getIdClient());

      if (auxClient.isEmpty()) {
        return objClientRepository.saveClient(objC);
      } else {
        return objC;
      }
    }
  }
}
