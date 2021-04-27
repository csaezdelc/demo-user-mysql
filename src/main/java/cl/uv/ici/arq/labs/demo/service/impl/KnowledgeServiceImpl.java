package cl.uv.ici.arq.labs.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.uv.ici.arq.labs.demo.dtos.KnowledgeRequestDTO;
import cl.uv.ici.arq.labs.demo.entities.KnowledgeEntity;
import cl.uv.ici.arq.labs.demo.repository.KnowledgeRepository;
import cl.uv.ici.arq.labs.demo.service.KnowledgeService;

@Service("knowledgeService")
public class KnowledgeServiceImpl implements KnowledgeService {

	@Autowired
	private KnowledgeRepository repository;

	@Override
	public List<KnowledgeRequestDTO> getKnlowledge() {

		List<KnowledgeRequestDTO> list = new ArrayList<KnowledgeRequestDTO>();
		
		for (String uuid : repository.getUsersId()) {
			list.add(new KnowledgeRequestDTO(uuid.toString(), repository.getSkillsByUserId(uuid)));
		}

		return list;

	}

	@Override
	public KnowledgeRequestDTO updateUserSkills(KnowledgeRequestDTO request) {
		for (String id : request.getSkillList()) {
			repository.save(new KnowledgeEntity(id, request.getUserId()));
		}
		return request;
	}

}
