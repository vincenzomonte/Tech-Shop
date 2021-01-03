package testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import control.LoginVenditore;
import control.RemoveProd;
import manageraccouting.Venditore;
import managernegozio.Categoria;
import managernegozio.Negozio;
import managernegozio.Prodotto;
import model.CategoriaDAO;
import model.NegozioDAO;
import model.ProdottoDAO;
import model.VenditoreDAO;

/**
 * TestCase 9_0_Cancellazione_Prodotto
 * @author monte
 *
 */
class tc9_0_Cancellazione_Prodotto {

	RemoveProd myServlet;
	
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	HttpSession session;


	
	@BeforeEach
	public void setUp() throws SQLException{
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		myServlet = new RemoveProd();
		vend= new Venditore("Monte97","Saprisapri@97","Vincenzo","Montesano","vincenzomontesano@gmail.com","M","3482914912","Via santa domenica","Sapri","84073");
		model.addVenditore(vend);
		neg=new Negozio("TECH","Monte97","left","Blue","12345678909","2020-11-12","NUOVI SMARTPHONE","santa","76765","76765","images/favicon.ico");
		modeln.addNegozio(neg);
		cat=new Categoria( "TECH",  "iPad", "path/negozi/TECH/iPad.jfjf",  "iPad Air Potente,Attraente,Sorprendente");
		modelc.addCategoria(cat);
		prod= new Prodotto(142,"TECH","iPad","iPhone",22,"images/negozi/TECH/142.jpg",1200,27,10,"iPad Air Potente,Attraente,Sorprendente");
		modelp.addProdotto(prod);
		
	}
	

	@AfterEach
	public void tearDown() throws SQLException {
		model.deleteVenditore("Monte97");
	}
	
	
	@Test
	public void tc_9_0_1() throws IOException, ServletException, SQLException {
		StringWriter output=new StringWriter();
		PrintWriter out=new PrintWriter(output);
		
		int id= modelp.getIDProd("iPad","TECH","iPad 10");
		System.out.println(id);
		Collection<Prodotto>prodotti;
		prodotti=modelp.getAllProductBySellerCategory(vend.getUsername(), cat.getNomeCategoria());
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("prodotti")).thenReturn(prodotti);
		when(session.getAttribute("username-venditore")).thenReturn(vend.getUsername());
		when(session.getAttribute("categoria")).thenReturn(cat.getNomeCategoria());
		
	
		when(request.getParameter("ID")).thenReturn(String.valueOf(id));
		//when(request.getParameter("username-venditore")).thenReturn(vend.getUsername());
		//when(request.getParameter("categoria")).thenReturn(cat.getNomeCategoria());
		
		when(response.getWriter()).thenReturn(out);
		
		myServlet.doPost(request, response);
		System.out.println(output.toString());
		assertEquals("OK", output.toString());
		
	}
	
	
	VenditoreDAO model=new VenditoreDAO();
	NegozioDAO modeln=new NegozioDAO();
	ProdottoDAO modelp=new ProdottoDAO();
	CategoriaDAO modelc=new CategoriaDAO();
	Negozio neg;
	Venditore vend;
	Categoria cat;
	Prodotto prod;
}
