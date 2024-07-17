package aluracursos.api.forohub.domain.curso;

import aluracursos.api.forohub.domain.topico.DatosTopico;
import org.springframework.data.domain.Page;

public record DatosCursoTopicos(DatosCurso curso, Page<DatosTopico> topicos) {

}
