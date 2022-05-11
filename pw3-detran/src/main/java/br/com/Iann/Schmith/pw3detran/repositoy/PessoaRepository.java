package br.com.Iann.Schmith.pw3detran.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Iann.Schmith.pw3detran.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
