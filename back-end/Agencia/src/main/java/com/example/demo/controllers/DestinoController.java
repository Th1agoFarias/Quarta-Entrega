	package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResourceNotFoundException;
import com.example.demo.entities.Cliente;
import com.example.demo.entities.Destino;
import com.example.demo.repositorys.ClienteRepository;
import com.example.demo.repositorys.DestinoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DestinoController {

	
	
	@Autowired
	private DestinoRepository destinoRepository;
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
	@GetMapping("/destinos")
	public List<Destino> getAllDestinos(){
		return destinoRepository.findAll();
	}
	
	
	
	
	@GetMapping("/destinos/{id}")
	public ResponseEntity<Destino> getDestinoById(@PathVariable Long id) {
		Destino destino = destinoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Destino inexistente"));
		 return ResponseEntity.ok(destino);
	}
	
	
	
	// Create - ok \o/ :)
	@PostMapping("/destinos")
	public Destino createDestino(@RequestBody Destino destino) {
		return destinoRepository.save(destino);
	}
	
	
	
	// Atualizar 
	@PutMapping("destinos/{id}")
	public ResponseEntity<Destino> updateDestino(@PathVariable Long id, @RequestBody Destino destinosDetails){
		
		Destino destino = destinoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Destino nao encontrado"));
		Cliente cliente = clienteRepository.findById(destinosDetails.getCliente().getId()).get();
		
		destino.setEstado(destinosDetails.getEstado());
		destino.setCidade(destinosDetails.getCidade());
		destino.setIda(destinosDetails.getIda());
		destino.setVolta(destinosDetails.getVolta());
		destino.setCliente(cliente);
		
		
		
	    Destino newDestino = destinoRepository.save(destino);
		
		return ResponseEntity.ok(newDestino); 
		}
	
	
	
	
	
	//DELETE Funciona, por favor !
	@DeleteMapping("/destinos/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDestino(@PathVariable Long id){
		
		Destino destino = destinoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Destino Não encontrado"));
		
		destinoRepository.delete(destino);
		Map<String, Boolean> response = new HashMap<>();
		response.put(" deletado", Boolean.TRUE);
		return ResponseEntity.ok(response);
	
	
	
	}
	
}
	

	
	
	
	
	
	

