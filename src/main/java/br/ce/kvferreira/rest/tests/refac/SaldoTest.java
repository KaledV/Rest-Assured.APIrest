package br.ce.kvferreira.rest.tests.refac;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import br.ce.kvferreira.rest.core.BaseTest;
import br.ce.kvferreira.rest.utils.BarrigaUtils;

public class SaldoTest extends BaseTest {
	
	@Test
	public void deveCalcularSaldoContas() {
      BarrigaUtils.getIdContaPeloNome("Conta para saldo");
		
		 given()
		.when()
		   .get("/saldo")
		.then()
		   .statusCode(200)
        ;
    }
	
}
