package br.com.curso.listavip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.curso.listavip.model.Convidado;
import br.com.curso.listavip.repository.ConvidadoRepository;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoRepository repository;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {
		Iterable<Convidado> convidados = repository.findAll();
		model.addAttribute("listaconvidados", convidados);
		System.out.println("Listou todos os convidados");
		return "listaconvidados";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model) {

		Convidado novoConvidado = new Convidado(nome, email, telefone);
		
		repository.save(novoConvidado);

		Iterable<Convidado> convidados = repository.findAll();
		
		model.addAttribute("listaconvidados", convidados);
		
		System.out.println("Salvou o convidado " + novoConvidado.getNome() + " e listou os outros convidados");
		return "listaconvidados";
	}
}