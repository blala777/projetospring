package com.aula.spring2.springboot2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.spring2.springboot2.entities.Usuario;
import com.aula.spring2.springboot2.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> procuraTodos(){
		return repository.findAll();
		
		}
	
	public Usuario procuraPorId(Integer id) {
		return repository.findById(id).get();
	}
	
	public String adicionaUsuario(Usuario usuario) {
		repository.save(usuario);
		return "Usuário adicionado com sucesso!";
	}
	
	public String editarUsuario(Integer id, Usuario usuario) {
		Usuario response = repository.findById(id).get();
		
		response.setNome(usuario.getNome());
		response.setSenha(usuario.getSenha());
		response.setEmail(usuario.getEmail());
		
		repository.save(response);
		return "Usuário editado com sucesso!";
	}
	
	
	public void excluirUsuario(Integer id) {
		Usuario response = repository.findById(id).get();
		repository.delete(response);
	}
	
	
	
	
}
