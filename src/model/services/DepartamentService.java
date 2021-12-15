package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Departamentos;

public class DepartamentService {
	
	public List<Departamentos> findAll(){
		List<Departamentos> list = new ArrayList<>();
		list.add(new Departamentos(1, "Livros"));
		list.add(new Departamentos(2, "Computadores"));
		list.add(new Departamentos(3, "Eletrônicos"));
		return list;
		
		
	}
	
}
