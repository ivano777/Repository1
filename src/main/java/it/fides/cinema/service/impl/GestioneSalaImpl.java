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
import it.fides.cinema.dto.SalaDto;
import it.fides.cinema.dto.SearchSalaDto;
import it.fides.cinema.entity.Posto;
import it.fides.cinema.entity.Sala;
import it.fides.cinema.repository.PostoRepository;
import it.fides.cinema.repository.SalaRepository;
import it.fides.cinema.service.GestioneSala;

@Service 
@Transactional
public class GestioneSalaImpl implements GestioneSala {

	@Autowired 
	private SalaRepository salaRepository; 
	@Autowired
	private PostoRepository postoRepository;
	
	private DozerBeanMapper mapper;
	
	@Override
	public Set<SalaDto> findAll() {
		mapper = new DozerBeanMapper();
		Set<SalaDto> setSalaDto = new HashSet<SalaDto>();
		salaRepository.findAll().forEach(sala -> {
			SalaDto salaDto = new SalaDto();
			salaDto = mapper.map(sala, SalaDto.class);
			
			//inizio setto posto
			Set<PostoDto> setPostoDto = new HashSet<PostoDto>();
			sala.getPostoSet().forEach(posto -> {
				PostoDto postoDto = new PostoDto();
				postoDto = mapper.map(posto, PostoDto.class);
				setPostoDto.add(postoDto);
			});
			salaDto.setPostoSet(setPostoDto);
			//fine setto posto
			
			setSalaDto.add(salaDto);
			});
		 return setSalaDto;
	}
	@Override
	public SalaDto findById(Long idSala) throws Exception {
		mapper = new DozerBeanMapper();
		SalaDto salaDto = new SalaDto();
		if(salaRepository.existsById(idSala)) {
			Sala sala = salaRepository.findById(idSala).get();
			salaDto = mapper.map(sala, SalaDto.class);
			Set<PostoDto> setPostoDto = new HashSet<PostoDto>();
			sala.getPostoSet().forEach(posto ->{
				PostoDto postoDto = mapper.map(posto, PostoDto.class);
				setPostoDto.add(postoDto);
			});
			salaDto.setPostoSet(setPostoDto);
		}
		else {
			throw new Exception("La Sala con id "+idSala+" non esiste!");
		}
		return salaDto;
	}
	
	
	@Override
	public Sala createSala(String nomeSala, Long numeroPosti) {
		Sala sala = new Sala();
		Character fila = new Character('a');
		if(nomeSala!=null && !nomeSala.isEmpty()) {
			sala.setNomeSala(nomeSala);
			sala.setNumeroPosti(numeroPosti);
			salaRepository.save(sala);
			for(int i=0;i<numeroPosti;i++) {
				if(i>5) {
					fila++;
				}
				Posto posto = new Posto();
				posto.setFila(fila.toString());
				posto.setNumero((long) (i+1));
				posto.setSala(sala);
				postoRepository.save(posto);
			}
		}
		return sala;
	}
	
	
	@Override
	public void insertSala(SalaDto salaDto) throws Exception {
		

		
			mapper = new DozerBeanMapper();
			Sala sala = new Sala();
			Set<Posto> postiSet = new HashSet<Posto>();
			if(!salaRepository.existsById(salaDto.getId())) {
				sala = mapper.map(salaDto, Sala.class);
				salaDto.getPostoSet().forEach(postoDto ->{
					Posto posto = new Posto();
					posto = mapper.map(postoDto, Posto.class);
					//setto la foreign key nulla per evitare errori
					posto.setSala(null);
					postoRepository.save(posto);
					postiSet.add(posto);
				});
				sala.setPostoSet(postiSet);
				salaRepository.save(sala);
				
				//update posti della foreign key
				for (Posto posto : postiSet) {
					Posto postoTemp = new Posto();
					postoTemp.setId(posto.getId());
					postoTemp.setNumero(posto.getNumero());
					postoTemp.setFila(posto.getFila());
					postoTemp.setSala(sala);
					postoRepository.save(postoTemp);
				}
				
			}
			else {
				throw new Exception("La Sala con id "+salaDto.getId()+" già esiste!");
			}

	}
	@Override
	public void updateSala(SalaDto salaDto) {
		mapper = new DozerBeanMapper();
		Sala sala = new Sala();
		sala = salaRepository.findById(salaDto.getId()).get();
		sala.setNomeSala(salaDto.getNomeSala());
		sala.setNumeroPosti(salaDto.getNumeroPosti());
		//problema gestione update/insert posti 
//		Set<Posto> postoSet = new HashSet<Posto>();
//		salaDto.getPostoSet().forEach(postoDto -> {
//			Posto posto = new Posto();
//			posto = mapper.map(postoDto, Posto.class);
//			postoSet.add(posto);
//		});
	}
	@Override
	public String deleteSala(Long idSala) {
		salaRepository.deleteById(idSala);
		return "OK";
	}
	@Override
	public List<SalaDto> findByNomeSala(SearchSalaDto searchSalaDto) {
		mapper = new DozerBeanMapper();
		List<Sala> listaSala = salaRepository.findByNomeSalaLike(searchSalaDto.getNomeSala().toLowerCase());
		List<SalaDto> listaSalaDto = new ArrayList<SalaDto>();
		if(listaSala != null && !listaSala.isEmpty()) {
			listaSala.forEach(sala -> {
				SalaDto salaDto = new SalaDto();
//				salaDto = mapper.map(sala, SalaDto.class);
				salaDto.setId(sala.getId());
				salaDto.setNomeSala(sala.getNomeSala());
				salaDto.setNumeroPosti(sala.getNumeroPosti());
				//salaDto.setPostoSet(sala.getPostoSet());
				Set<PostoDto> setPostoDto = new HashSet<PostoDto>();
				sala.getPostoSet().forEach(posto ->{
					PostoDto postoDtoTemp = new PostoDto();
					postoDtoTemp = mapper.map(posto, PostoDto.class);
					setPostoDto.add(postoDtoTemp);
				});
				salaDto.setPostoSet(setPostoDto);
				listaSalaDto.add(salaDto);
			});
		}
		return listaSalaDto;
	}
	

}