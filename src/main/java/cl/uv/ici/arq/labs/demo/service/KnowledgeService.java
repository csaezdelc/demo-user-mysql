package cl.uv.ici.arq.labs.demo.service;

import java.util.List;

import cl.uv.ici.arq.labs.demo.dtos.KnowledgeRequestDTO;

public interface KnowledgeService {


	public KnowledgeRequestDTO updateUserSkills(KnowledgeRequestDTO request);
	public List<KnowledgeRequestDTO> getKnlowledge();
	
	

	
	

}
