package it.fides.cinema.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.fides.cinema.dto.PostoDto;
import it.fides.cinema.entity.Posto;
import it.fides.cinema.repository.PostoRepository;
import it.fides.cinema.service.GestionePosto;

@Service
@Transactional
public class GestionePostoImpl implements GestionePosto {
    @Autowired
    private PostoRepository postoRepository;
    private DozerBeanMapper mapper;

    @Override
    public Set<PostoDto> findAll() {
    	mapper = new DozerBeanMapper();
        Set<PostoDto> setPostoDto = new HashSet<PostoDto>();
        postoRepository.findAll().forEach(posto -> {
        	PostoDto postoDto = new PostoDto();
        	postoDto = mapper.map(posto, PostoDto.class);
        	setPostoDto.add(postoDto);
        });
        return setPostoDto;
    }
    
    @Override
    public PostoDto findById(Long idPosto) throws Exception {
    	mapper = new DozerBeanMapper();
    	PostoDto postoDto = new PostoDto();
    	if(postoRepository.existsById(idPosto)) {
    		Posto posto = postoRepository.findById(idPosto).get();
    		postoDto = mapper.map(posto, PostoDto.class);
    	}
    	else throw new Exception("Il Posto con id "+idPosto+" non esiste!");
    	return postoDto;
    }
    
    @Override
    public void insertPosto (PostoDto postoDto) {
    	mapper = new DozerBeanMapper();
    	Posto posto= new Posto();
 
    		posto = mapper.map(postoDto, Posto.class);

    		
    		//System.out.println("*****************************************************************************************************"+posto.getSala().getNomeSala());
    		postoRepository.save(posto);
    	
    	
    }
    
    public Set<PostoDto> findPosto(){
    	mapper = new DozerBeanMapper();
    	Set<PostoDto> setPostoDto = new HashSet<>();
    	List<Posto> setPosto = new ArrayList<Posto>(); //criteria qui
    	setPosto = postoRepository.testPosto();
    	setPosto.forEach(posto -> {
    		//setPostoDto.add(mapper.map(posto, PostoDto.class));
    		PostoDto postoDto = new PostoDto();
    		postoDto = mapper.map(posto, PostoDto.class);
//    		postoDto.setSala(EntityInDto.salaEntityInDto(posto.getSala()));
    		setPostoDto.add(postoDto);
    	});
    	return setPostoDto;
    }

}