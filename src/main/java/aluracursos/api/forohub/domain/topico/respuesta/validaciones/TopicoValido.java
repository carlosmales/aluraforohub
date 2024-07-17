package aluracursos.api.forohub.domain.topico.respuesta.validaciones;

import aluracursos.api.forohub.domain.topico.TopicoRepository;
import aluracursos.api.forohub.domain.topico.respuesta.DatosCrearRespuesta;
import aluracursos.api.forohub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoValido implements ValidadorRespuesta {

    @Autowired
    TopicoRepository topicoRepository;

    @Override
    public void validar(DatosCrearRespuesta datos) {
        if (datos.idTopico() == null || !topicoRepository.existsById(datos.idTopico())) {
            throw new ValidacionDeIntegridad("Topico no encontrado");
        }
    }
}
