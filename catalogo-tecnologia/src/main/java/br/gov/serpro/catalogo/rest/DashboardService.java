package br.gov.serpro.catalogo.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.resteasy.spi.validation.ValidateRequest;

import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.serpro.catalogo.bussiness.FaseBC;
import br.gov.serpro.catalogo.entity.Fase;
import br.gov.serpro.catalogo.entity.FaseInteressado;
import br.gov.serpro.catalogo.entity.FaseMembro;
import br.gov.serpro.catalogo.entity.User;
import br.gov.serpro.catalogo.persistence.FaseProdutoDAO;

@ValidateRequest
@Path("dashboard")
@Produces(APPLICATION_JSON)
public class DashboardService {

	@Inject
	private FaseBC faseBC;
	
    @Inject
    private SecurityContext securityContext;
    
    @Inject
    FaseProdutoDAO faseProdutoDAO;
	
    @GET
	@Path("/versoesProdutoPorNomeProduto/{nomeProduto}")
    public Map<String,Object> versoesDosProdutosPorNomeProduto(@PathParam("nomeProduto") String nomeProduto) {
			return faseProdutoDAO.versoesDosProdutosPorNomeProduto(nomeProduto);
    }
    
	@GET
	@Path("minhasDemandas")
	public List<DemandaDTO> minhasDemandas() {
		User usuario = (User)securityContext.getUser();
		List<DemandaDTO> lista = new ArrayList<DashboardService.DemandaDTO>();
		List<FaseMembro> membros = faseBC.obterFasesDoUsuarioComoMembro(usuario);
		List<FaseInteressado> interessados = faseBC.obterFasesDoUsuarioComoInteressado(usuario);
		for (FaseMembro f : membros) lista.add(new DemandaDTO("M", f.getFase()));
		for (FaseInteressado f : interessados) lista.add(new DemandaDTO("I", f.getFase()));	
		
		Collections.sort(lista);
		
		return lista;
	}
	
	public class DemandaDTO implements Comparable<DemandaDTO>{
		
		private String tipo;
		private Fase fase;
		
		public DemandaDTO(String string, Fase fase) {
			this.tipo = string;
			this.fase = fase;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public Fase getFase() {
			return fase;
		}
		public void setFase(Fase fase) {
			this.fase = fase;
		}
		
		@Override
		public int compareTo(DemandaDTO d) {
			return (int)(d.getFase().getId() - this.getFase().getId());
		}
		
		
	}
	
	
}
