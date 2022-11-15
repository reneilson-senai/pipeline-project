package projetoSA.escolaControle.test.controller;

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

import projetoSA.escolaControle.controller.AlunoController;
import projetoSA.escolaControle.model.DTO.AlunoDTO;
import projetoSA.escolaControle.model.entity.Aluno;
import projetoSA.escolaControle.service.AlunoService;

@ExtendWith(SpringExtension.class)
// @ActiveProfiles("test")
@WebMvcTest(controllers=AlunoController.class)
class alunoControllerTest{
	
	@MockBean
	AlunoService alunoService;
	
	@Autowired
	ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void cadastroAluno() throws JsonProcessingException, Exception {
		
		//Entradas
		AlunoDTO alunoDTO = new AlunoDTO(null, "Pedro", "mae - 9914", true, "não", 1);
		Aluno aluno = new Aluno();
		aluno.setNomeAluno("pedro");
		
		when(alunoService.salvarAlunoDTO(any(AlunoDTO.class))).thenReturn(aluno);
		
		mockMvc.perform(post("/aluno")
				.content(mapper.writeValueAsString(alunoDTO))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.nomeAluno").value(alunoDTO.getNomeAluno()));
	}
}