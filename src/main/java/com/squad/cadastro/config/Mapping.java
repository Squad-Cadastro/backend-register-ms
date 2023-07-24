package com.squad.cadastro.config;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Configuration
public class Mapping {
  private static final ModelMapper mapper = new ModelMapper();

  /**
   * O ModelMapper garante que os seus objetos de domínio interno não sejam vistos pelas camadas de apresentação ou por
   * consumidores externos. Ele também pode ajudar a mapear os seus objetos de domínio para chamadas externas de API’s
   * e vice-versa.
   * Em outras palavras, ao invés de você expor as entidades JPA, por exemplo, o que tornaria indiretamente públicas
   * informações da sua base de dados, cria um POJO similar às suas entidades JPA, contudo sem as anotações,
   * e expõe esse POJO para os clientes da sua aplicação. Entre o POJO exposto e a entidade JPA poderia utilizar
   * um framework como o ModelMapper e parsear dados das suas entidades JPA para o POJO exposto e vice-versa, encapsulando
   * informações importantes da sua aplicação.
   *
   * @author Thonwelling
   * */

    public static <Origin, Destination> Destination parseObject(Origin origin, Class<Destination> destination) {
      return mapper.map(origin, destination);
    }
    public static <Origin, Destination> List<Destination> parseListObjects(List<Origin> origin, Class<Destination> destination) {
      List<Destination> destinationObjects = new ArrayList<Destination>();
      for (Origin o : origin) {
        destinationObjects.add(mapper.map(o, destination));
      }
      return destinationObjects;
    }
}
