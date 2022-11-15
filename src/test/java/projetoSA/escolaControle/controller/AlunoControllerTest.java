package projetoSA.escolaControle.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

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

import projetoSA.escolaControle.model.entity.Aluno;
import projetoSA.escolaControle.model.entity.Relatorio;
import projetoSA.escolaControle.service.AlunoService;
import projetoSA.escolaControle.service.RelatorioService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers=AlunoController.class)
class AlunoControllerTest {

	@MockBean
	RelatorioService relatorioService;
	
	@MockBean
	AlunoService alunoService;

	@Autowired
	ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void cadastroAluno() throws JsonProcessingException, Exception {

		//Entradas
		Aluno aluno = new Aluno();
		aluno.setNomeAluno("pedro");
		
		when(alunoService.salvarAluno(any(Aluno.class))).thenReturn(aluno);
		
		mockMvc.perform(post("/aluno")
				.content(mapper.writeValueAsString(aluno))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.nomeAluno").value(aluno.getNomeAluno()));
	}
	
	@Test
	void cadastroRelatorio() throws JsonProcessingException, Exception{
		
		//Entradas
		Relatorio relatorio = new Relatorio();
		relatorio.setNomeAcompanhado("pedro");
		Optional<Aluno> aluno = Optional.of(new Aluno());
		
		when(alunoService.procurarAlunoPorIdParaRelatorio(any(Integer.class))).thenReturn(aluno);
	
		when(relatorioService.salvarRelatorio(any(Relatorio.class))).thenReturn(relatorio);
		
		mockMvc.perform(post("/aluno/1/relatorio")
				.content(mapper.writeValueAsString(relatorio))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.nomeAcompanhado").value(relatorio.getNomeAcompanhado()));
	}
	
}
