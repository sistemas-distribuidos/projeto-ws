package br.edu.unirn.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.jboss.logging.Logger;

import br.edu.unirn.Cadastro;
import br.edu.unirn.model.Pessoa;

@WebService(serviceName = "CadastroService")
public class CadastroImpl implements Cadastro{

	private static Logger LOG = Logger.getLogger(CadastroImpl.class);
	
	private static List<Pessoa> pessoas = new ArrayList<>();
	
	@Override
	public String work(String mensagem) {
		LOG.info("Mensagem: "+mensagem);
		return mensagem;
	}

	@Override
	public Pessoa cadastrar(Pessoa pessoa) {
		pessoas.add(pessoa);
		LOG.info("Add Pessoa: "+pessoa.getNome());
		return pessoa;
	}

	@Override
	public Pessoa recuperar(int pos) {
		LOG.info("Recuperar: "+pos);
		if(pos > pessoas.size()){
			return null;
		}
		return pessoas.get(pos);
	}

	@Override
	public List<Pessoa> listar() {
		LOG.info("Listar total: "+pessoas.size());
		return pessoas;
	}

}
