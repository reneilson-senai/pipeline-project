package projetoSA.escolaControle.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import projetoSA.escolaControle.model.entity.Turma;
import projetoSA.escolaControle.service.TurmaService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers=TurmaController.class)
class TurmaControllerTest {

	@MockBean
	TurmaService turmaService;
	
	@Autowired
	ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void cadastroTurma() throws JsonProcessingException, Exception {
		
		//Entradas
		Turma turma = new Turma();
		turma.setPeriodoTurma("matutino");
		
		when(turmaService.salvarTurma(any(Turma.class))).thenReturn(turma);
		
		mockMvc.perform(post("/turma")
				.content(mapper.writeValueAsString(turma))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.periodoTurma").value(turma.getPeriodoTurma()));
	}

}
