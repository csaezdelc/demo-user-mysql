package cl.uv.ici.arq.labs.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.uv.ici.arq.labs.demo.dtos.KnowledgeResponseDTO;
import cl.uv.ici.arq.labs.demo.dtos.KnowledgeRequestDTO;
import cl.uv.ici.arq.labs.demo.service.KnowledgeService;
import cl.uv.ici.arq.labs.demo.service.SkillService;
import cl.uv.ici.arq.labs.demo.service.UserService;

@RestController
@RequestMapping("/knowledge")

public class KnowledgeController {

	
	@Autowired
	private KnowledgeService service;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SkillService skillService;

		
	@PutMapping
	public ResponseEntity<KnowledgeRequestDTO> save(@RequestBody KnowledgeRequestDTO request) {		
		
		return new ResponseEntity<>(service.updateUserSkills(request), HttpStatus.CREATED);
	}
	


	@GetMapping
	public ResponseEntity<List<KnowledgeResponseDTO>> findbyId() {
		
		List<KnowledgeResponseDTO> returnList= new ArrayList<KnowledgeResponseDTO>();
	
		for (KnowledgeRequestDTO know : service.getKnlowledge()) {
			
			
			returnList.add(new KnowledgeResponseDTO(userService.getUser(know.getUserId()),skillService.getSkills(know.getSkillList())));
			
		}
		return new ResponseEntity<>(returnList, HttpStatus.OK);
	}
	

}
