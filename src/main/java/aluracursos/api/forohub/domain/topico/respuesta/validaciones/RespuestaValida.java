package aluracursos.api.forohub.domain.topico.respuesta.validaciones;

import aluracursos.api.forohub.domain.topico.respuesta.DatosCrearRespuesta;
import aluracursos.api.forohub.domain.usuario.UsuarioRepository;
import aluracursos.api.forohub.domain.topico.TopicoRepository;
import aluracursos.api.forohub.domain.topico.respuesta.RespuestaRepository;
import aluracursos.api.forohub.infra.errores.ValidacionDeIntegridad;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespuestaValida implements ValidadorRespuesta {

    @Autowired
    RespuestaRepository respuestaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TopicoRepository topicoRepository;

    @Override
    public void validar(DatosCrearRespuesta datos) {
        if (datos.mensaje() == null) {
            throw new ValidacionDeIntegridad("mensaje no encontrado");
        }

        if (respuestaRepository.existsByTopicoAndMensajeAndAutorRespuesta(
                topicoRepository.getReferenceById(datos.idTopico()),
                datos.mensaje(),
                usuarioRepository.getReferenceById(datos.idAutor()))) {
            throw new ValidationException("Ya existe una respuesta igual para el topico");
        }
    }
}
